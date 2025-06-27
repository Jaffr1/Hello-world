package collection;

import java.util.Arrays;

public class MyArrayList<T> 
{
	private final static int defaultCapacity = 10;
	int capacity = defaultCapacity;
	private Object arr[];
	int index = 0;
	
	public MyArrayList()
	{
		arr = new Object[defaultCapacity];
	}
	
	void add(T x)
	{
		if(index == capacity)
		{
			grow();
			
			arr[index] = x;
			index++;
		}
		else
		{
			arr[index] = x;
			index++;
		}
		
		shrinking();
	}
	
	
	// get 
	// add -> index
	// set 
	// indexOf
	// remove -> inedx
	
	
	void grow()
	{
		int newCapacity = (defaultCapacity/2) + capacity;
		Object arr2[] = Arrays.copyOf(arr,  newCapacity);
		capacity = newCapacity;
		arr = arr2;
	}
	
	
	void shrinking()
	{
		Object arr2[] = Arrays.copyOf(arr,index);
		arr = arr2;
	}
	
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder("[ ");
		for(int i=0;i<=arr.length-1;i++)
		{
			if(i != arr.length-1)
			{
				sb.append(arr[i]).append(" , ");
			}
			else{
				sb.append(arr[i]).append(" ]");
			}
		}
		
		return sb.toString();
		
		
	}
	
	
	
	
	
}