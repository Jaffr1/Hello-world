package muitithreading;



public class ObjectLock {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Bank banu=new Bank();
        Gpay thread0 = new Gpay(bank, "Gpay");
        Thread thread1 = new Atm(bank, "Atm");
        thread1.start();
        thread0.start();

    }
}

class Bank extends Thread {
    long balance = 10000;

    public synchronized void withdraw(long amountWithDraw) {
        if (balance >= amountWithDraw) {
            balance -= amountWithDraw;
        }
        System.out.println(balance);
    }

    public synchronized void deposit(long amountDeposit) {
        balance += amountDeposit;
        System.out.println(balance);
    }

}

class Atm extends Thread {
    Bank bank;

    public Atm(Bank bank, String name) {
        super(name);
        this.bank = bank;
    }

    public void run() {
        bank.withdraw(5000);
    }

}

class Gpay extends Thread {
    Bank bank;

    public Gpay(Bank bank, String name) {
        super(name);
        this.bank = bank;
    }

    public void run() {
        bank.deposit(15000);
    }

}