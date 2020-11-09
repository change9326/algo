package concurrencydemo;

/**
 * @author yujiaqi
 * @date 2020-11-04 11:32
 * @description:两个线程交替打印奇偶数
 * https://www.cnblogs.com/grey-wolf/p/11217164.html#_label1
 */
public class OddEvenThread {

    private static volatile Integer counter = 0;
    private static Object monitor = new Object();

    public static void main(String[] args) {
        // 奇数线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    synchronized (monitor){
                        if(counter%2!=0){
                         continue;
                        }
                        int i=++counter;
                        if(i>100){
                            return;
                        }
                        System.out.println("奇数线程："+i);
                        try {
                            // 唤醒等待monitor对象锁的线程
                            monitor.notify();
                            // 让当前线程等待，加入等待集合中
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
        // 偶数线程
        new Thread(new Runnable() {
            @Override
            public void run() {
              while (true){
                  synchronized (monitor){
                      if(counter%2==0){
                          continue;
                      }
                      int i=++counter;
                      if(i>100){
                          return;
                      }
                      System.out.println("偶数线程："+i);
                      try {
                          monitor.notify();
                          monitor.wait();
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                  }
              }
            }
        }).start();
    }
}


