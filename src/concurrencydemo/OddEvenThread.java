package concurrencydemo;

/**
 * @author yujiaqi
 * @date 2020-11-04 11:32
 * @description:两个线程交替打印奇偶数
 * https://www.cnblogs.com/grey-wolf/p/11217164.html#_label1
 */
public class OddEvenThread {
    /**
     * 1.notify() 和 wait() 它们都是Object的方法，任何对象都可以调用这两个方法。
     * 2.wait() ：导致当前线程等待，直到另一个线程调用该对象的notify()或者notifyAll()方法；
     */

    private static volatile Integer counter = 0;
    /**
     * monitor
     *  entrySet      :
     *  monitor_owner :thread1 唤醒
     *  monitor_count :0
     *  waitSet       :thread2
     */
    private static Object monitor = new Object();


    public static void main(String[] args) {
        // 奇数线程
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (monitor) {
                        if (counter % 2 != 0) {
                            continue;
                        }
                        int i = ++counter;
                        if (i > 100) {
                            return;
                        }
                        System.out.println("奇数线程：" + i);
                        try {
                            // 从monitor对象的等待队列中随机唤醒一个线程，但是目前的monitor对象的等待队列中
                            // 只有一个打印偶数的线程，所以它就被唤醒了。
                            monitor.notify();
                            // 让当前线程等待，加入到monitor对象的等待队列中,直到其他线程调用monitor对象的notify()或者notifyAll()方法，
                            // 当前线程就可能会被唤醒，因为该唤醒是从等待队列中随机抽取一个线程进行唤醒，不公平唤醒。
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        thread1.start();
        // 偶数线程
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (monitor) {
                        if (counter % 2 == 0) {
                            continue;
                        }
                        int i = ++counter;
                        if (i > 100) {
                            return;
                        }
                        System.out.println("偶数线程：" + i);
                        try {
                            monitor.notify();
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        thread2.start();
    }
}


