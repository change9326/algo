package concurrencydemo.producterandconsumer;


import java.util.LinkedList;

/**
 * @author yujiaqi
 * @date 2020-11-04 10:49
 * @description
 */
public class WaitDemo {


    public static void main(String[] args) {
        MyBlockingQueue storage=new MyBlockingQueue(10);
        Producer producer = new Producer(storage);
        Consumer consumer = new Consumer(storage);
        new Thread(producer).start();
        new Thread(consumer).start();

    }
}
class Producer implements Runnable{

    private MyBlockingQueue storage;


    public Producer(MyBlockingQueue storage) {
        this.storage=storage;
    }

    @Override
    public void run() {
        for(int i=1;i<=100;i++){
            try {
                storage.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable{

    private MyBlockingQueue storage;

    public Consumer(MyBlockingQueue storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for(int i=1;i<=100;i++){
            try {
                storage.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyBlockingQueue {
    private int maxSize;
    private LinkedList storage;

    public MyBlockingQueue(int maxSize) {
        this.maxSize = maxSize;
        this.storage = new LinkedList();
    }

    public synchronized void put(int i) throws InterruptedException {
        while (storage.size()==maxSize){
                wait();
        }
        storage.add(i);
        System.out.println("生产一个对象:"+i);
        notifyAll();
    }

    public synchronized void take() throws InterruptedException {
        while (storage.size()==0){
                wait();
        }
        System.out.println("消费一个对象:"+storage.remove());
        notifyAll();
    }
}
