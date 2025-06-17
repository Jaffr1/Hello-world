package MultiThread;
/*
wait and notify always inside synchronized method or block
otherwise thrown IllegalMonitorStateException
wait - wait for update another thread
notify - after update notify to another thread
 */
class Shop{
    int availableStock=100;
    int stockUpload;
    int stockDownload;
    public synchronized void produceStock(int stockUpload){
        this.stockUpload=stockUpload;
            if (availableStock<=0 || availableStock<stockDownload){
                //upload stock
                System.out.println(Thread.currentThread().getName()+" upload "+stockUpload+" stocks");
                availableStock=availableStock+stockUpload;
                notify();
            }else {
                System.out.println(Thread.currentThread().getName()+" not upload "+stockUpload+" stocks");
                System.out.println("consume then produce");
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
            //notify
    }
    public synchronized void consumeStock(int stockDownload){
        this.availableStock=availableStock+stockUpload;
        this.stockDownload=stockDownload;
        //if stock available consume
        if (stockDownload>0 && stockDownload<=availableStock){
            System.out.println("Before Consume Stock availability "+availableStock);
            System.out.println(Thread.currentThread().getName()+" download "+stockDownload+" stocks");
            availableStock=availableStock-stockDownload;
            System.out.println("Current Stock availability "+availableStock);
            notify();
        }
        //if stock not available add stock
        else{
            System.out.println("Current Stock availability "+availableStock);
            System.out.println(Thread.currentThread().getName()+" is waiting....");
            try {wait();} catch (InterruptedException e) {System.out.println(e);}
            System.out.println(Thread.currentThread().getName()+" download "+stockDownload+" stocks");
            if (stockDownload<=availableStock){
                availableStock=availableStock-stockDownload;
                System.out.println("Current Stock availability "+availableStock);
            }else {
                System.out.println("Stock not available to consume");
            }
        }
    }
}
class ProduceStock extends Thread{
    Shop s;
    int stockQty;
    public ProduceStock(Shop s,String name,int stockQty) {
        super(name);
        this.s = s;
        this.stockQty=stockQty;
    }
    public void run(){
            s.produceStock(stockQty);
    }
}
class ConsumeStock extends Thread{
    Shop s;
    int stockQty;
    public ConsumeStock(Shop s,String name,int stockQty) {
        super(name);
        this.s = s;
        this.stockQty=stockQty;
    }
    public void run(){
            s.consumeStock(stockQty);
    }
}

public class Customer {
    public static void main(String[] args) {
        Shop s = new Shop();
        ProduceStock pro = new ProduceStock(s,"pro",15);
        ConsumeStock cons = new ConsumeStock(s,"cons",110);
        cons.start();
        pro.start();
    }
}