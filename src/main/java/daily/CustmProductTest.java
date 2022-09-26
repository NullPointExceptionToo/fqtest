package daily;

import java.util.LinkedList;
import java.util.Queue;

public class CustmProductTest {
    public static void main(String[] rags) {
        Queue<Integer> queue = new LinkedList<>();
        new Thread(new Producter("生产者一号", queue, 10)).start();
        new Thread(new Producter("生产者二号", queue, 10)).start();
        new Thread(new Producter("生产者三号", queue, 10)).start();
        new Thread(new Consumer(queue, "消费者一号")).start();
        new Thread(new Consumer(queue, "消费者二号")).start();
        new Thread(new Consumer(queue, "消费者三号")).start();

    }
}

class Consumer implements Runnable{
    private Queue<Integer> queue;
    public String name;
    public Consumer(Queue<Integer> queue, String name){
        this.queue = queue;
        this.name = name;
    }
    public void run() {
        while(true) {
            synchronized (queue){
                while(queue.isEmpty()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(500);
                    queue.poll();
                    System.out.println("线程"+name+"消费了一条消息    当前消息总量为"+queue.size());
                    queue.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Producter implements Runnable{
    private String name;
    private Queue<Integer> queue;
    private int capital;
    public Producter(String name, Queue<Integer> queue, int capital) {
        this.name = name;
        this.queue = queue;
        this.capital = capital;
    }
    public void run() {
        while(true) {
            synchronized (queue) {
                while(capital == queue.size()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(500);
                    queue.offer(0);
                    System.out.println("线程"+name+"生产了一条消息   当前消息总量为"+queue.size());
                    queue.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}