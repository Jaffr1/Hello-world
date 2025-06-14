package multi;

class Increment extends Thread{
    int count=0;
    public synchronized void run(){
        for (int i = 1; i <=100000 ; i++) {
            count++;
        }
        System.out.println(count);
    }
}

public class CounterClass {
    public static void main(String[] args) {
        Increment i = new Increment();
        System.out.println(i.count);
        Thread t1 = new Thread(i,"T1");
        t1.start();
        Thread t2 = new Thread(i,"T1");
        t2.start();
        System.out.println(i.count);
    }
}