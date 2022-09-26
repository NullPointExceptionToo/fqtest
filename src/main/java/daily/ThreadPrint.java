package daily;

/**
 * 3个线程循环打印
 */
public class ThreadPrint {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable2(0));
        Thread t2 = new Thread(new MyRunnable2(1));
        Thread t3 = new Thread(new MyRunnable2(2));
        t1.start();
        t2.start();
        t3.start();
    }


}
//class MyRunn implements Runnable{
//    private int mark;
//    private  static int count = 0;
//    private static Object lock= new Object();
//    public MyRunn(int mark){
//        this.mark = mark;
//    }
//    public void run() {
//        while(true) {
//            synchronized (lock){
//                if(count > 100) {
//                    break;
//                }
//                if(count%3 == mark) {
//                    System.out.println("线程"+mark+"->"+count);
//                    count++;
//                    lock.notifyAll();
//                }else{
//                    try {
//                        lock.wait();
//                    }catch(InterruptedException e) {
//
//                    }
//                }
////                lock.notifyAll();
//            }
//        }
//    }
//}


//class MyRunnable implements Runnable{
////    private int mark;
////    private static int count = 1;
////    private static Object lock = new Object();
////    public MyRunnable(int mark){
////        this.mark = mark;
////    }
////    public void run() {
////        while(true) {
////            synchronized (lock){
////                if(count > 100) {
////                    break;
////                }
////                if(count%3 == mark) {
////                    System.out.println("thread"+mark+" pint "+count);
////                    count++;
////                    lock.notifyAll();
////                }else{
////                    try {
////                        lock.wait();
////                    } catch (InterruptedException e) {
////                        e.printStackTrace();
////                    }
////                }
////            }
////        }
////
////    }
////}
////
////
////
////class MyRunnable2 implements Runnable {
////    private int index;
////    private static Object lock = new Object();
////    private static int count = 1;
////    public MyRunnable2(int index){
////        this.index = index;
////    }
////
////    @Override
////    public void run() {
////        while(true) {
////            synchronized (lock){
////                if(count > 100) {
////                    break;
////                }
////                if(index == count%3) {
////                    System.out.println("线程"+index+"------->"+(char)('A'+index));
////                    count++;
////                    lock.notifyAll();
////                }else{
////                    try {
////                        lock.wait();
////                    } catch (InterruptedException e) {
////                        e.printStackTrace();
////                    }
////                }
////            }
////        }
////    }
////}

class MyRunnable2 implements Runnable{
    private int number;
    private static int count = 1;
    public MyRunnable2 (int number){
        this.number = number;
    }
    @Override
    public void run() {
        while(true) {
            synchronized (MyRunnable2.class) {
                if(count%3 == number){
                    System.out.println(number+"号线程打印"+(char)('A'+number));
                    count++;
                    MyRunnable2.class.notifyAll();
                }else{
                    try {
                        MyRunnable2.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
