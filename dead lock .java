package thread;



class Class0A
{
	synchronized void add(Class0B obj)
	{
		System.out.println("add From ClassA");
		obj.sub();
	}
	
	synchronized void sub()
	{
		System.out.println("From ClassA");
	}
	
	
}

class Class0B
{
	synchronized void add(Class0A obj)
	{
		obj.sub();
	}
	
	synchronized void sub()
	{
		System.out.println("from ClassB");
	}
	
}

class ThreadA extends Thread
{
	
	Class0A obj1;
	Class0B obj2;
	
	public ThreadA(Class0A obj1, Class0B obj2) 
	{
		this.obj1 = obj1;
		this.obj2 = obj2;
	}

	public void run()
	{
		obj1.add(obj2);
	}
}


class ThreadB extends Thread
{
	Class0A obj1;
	Class0B obj2;
	
	public ThreadB(Class0A obj1, Class0B obj2) 
	{
		this.obj1 = obj1;
		this.obj2 = obj2;
	}

	public void run()
	{
		obj2.add(obj1);
	}
}

public class Program10 
{
	public static void main(String[] args) 
	{
		Class0A obj1 = new Class0A();
		Class0B obj2 = new Class0B();
		
		ThreadA t1 = new ThreadA(obj1,obj2);
		ThreadB t2 = new ThreadB(obj1,obj2);
		
	
		t1.start();
		t2.start();
		
	}
}