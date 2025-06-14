package multi;

class Sample extends Thread {
//   final private Object lock = new Object();
    //    public synchronized void run(){
//        for (int i = 1; i <=10 ; i++) {
//            System.out.println(Thread.currentThread().getName()+" "+i);
//        }
//    }
    public void run() {
        System.out.println("b4 sync " + Thread.currentThread().getName());
//        synchronized (lock) {
        synchronized (this) {
        for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }
        System.out.println("after sync " + Thread.currentThread().getName());
    }
}

public class ThreadLockObject {
    public static void main(String[] args) {
        obj1();
    }

    private static void obj1() {
        Sample s1 = new Sample();
        Thread t1 = new Thread(s1, "T1");
        Thread t2 = new Thread(s1, "T2");
        Thread t3 = new Thread(s1, "T3");
        Thread t4 = new Thread(s1, "T4");
        Sample s2 = new Sample();
        Thread t5 = new Thread(s2, "T5");
        Thread t6 = new Thread(s2, "T6");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}