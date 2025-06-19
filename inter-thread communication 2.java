package thread;


class Theater
{
	int availableSeat = 10;
	
	synchronized void bookSeats(int seat) throws InterruptedException
	{
		System.out.println(Thread.currentThread().getName() + " is booking process");

		if(availableSeat >= seat)
		{
			System.out.println(Thread.currentThread().getName() + " before booking "+ this.availableSeat);
			availableSeat -= seat;
			System.out.println(Thread.currentThread().getName() + " after booking "+ this.availableSeat);
		}
		
		else
		{
			System.err.println(Thread.currentThread().getName() + " - your booking is waiting..");
			wait();
			bookSeats(seat);
		}
		
	}
	
	
	synchronized void cancelSeat(int seat)
	{
		availableSeat += seat;
		notify();
	}
	
	
	
	void getSeatAvailable()
	{
		System.out.println("available Seat :" + availableSeat);
	}
	
}

class Person01 extends Thread
{
	Theater obj;
	int seat;

	public Person01(Theater obj, int seat)
	{
		this.obj = obj;
		this.seat = seat;
	}

	@Override
	public void run()
	{
		try {
			obj.bookSeats(seat);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


class Person02 extends Thread
{
	Theater obj;
	int seat;

	public Person02(Theater obj, int seat)
	{
		this.obj = obj;
		this.seat = seat;
	}

	@Override
	public void run()
	{
		try 
		{
			obj.bookSeats(seat);			
		} 
		
		catch (InterruptedException e) {}
	}
}


class Person03 extends Thread
{
	Theater obj;
	int seat;

	public Person03(Theater obj, int seat)
	{
		this.obj = obj;
		this.seat = seat;
	}

	@Override
	public void run()
	{
		try 
		{
			obj.bookSeats(seat);
			
			Thread.sleep(2000);
			
			obj.cancelSeat(seat);
		} 
		
		catch (InterruptedException e) {}
	}
}


public class Program03 
{
	public static void main(String[] args) throws InterruptedException 
	{
		Theater theater = new Theater();
		theater.getSeatAvailable();
		
		Person01 ashok = new Person01(theater, 5);
		Person02 kumar = new Person02(theater, 3);
		Person03 deepak = new Person03(theater, 5);
		
		ashok.setName("ashok");
		kumar.setName("kumar");
		deepak.setName("deepak");
	
		ashok.start();
		kumar.start();
		deepak.start();
		
		ashok.join();
		kumar.join();
		deepak.join();
		
		theater.getSeatAvailable();
	}
}