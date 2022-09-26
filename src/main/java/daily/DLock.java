package daily;

/**
 * 手写死锁
 */
public class DLock {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        new Thread(new RunnTest(o1, o2)).start();
        new Thread(new RunnTest(o2, o1)).start();
    }

}

class RunnTest implements Runnable{
    private Object o1;
    private Object o2;
    public RunnTest(Object o1, Object o2){
        this.o1 = o1;
        this.o2 = o2;
    }
    @Override
    public void run() {
        synchronized (o1){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o2){

            }
        }

    }
}

