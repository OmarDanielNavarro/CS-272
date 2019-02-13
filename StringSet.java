/*
 * @author Omar Navarro
 * @version February 2, 2019
 */

import java.util.Arrays;

public class StringSet 
{
	public static void main(String args[])
	{
		StringSet bagOne = new StringSet();
		System.out.println(bagOne.getCapacity());
		System.out.println(bagOne.getSize());
		bagOne.add("a");
		System.out.println(bagOne.getSize());
		bagOne.add("b");
		System.out.println(bagOne.getSize());
		bagOne.add("c");
		System.out.println(bagOne.getCapacity());
		System.out.println(bagOne.getSize());
		bagOne.printTest();
		bagOne.ensureCapacity(20);
		System.out.println(bagOne.getCapacity());
		System.out.println(bagOne.getSize());
		bagOne.add("d");
		bagOne.printTest();
		bagOne.addOrdered("e");
		bagOne.printTest();
		bagOne.remove("c"); 
		bagOne.printTest();
		StringSet bagTwo = new StringSet(bagOne);
		bagTwo.printTest();
		System.out.println(bagTwo.contains("a"));
		System.out.println(bagTwo.contains("f"));
		
	}
	
	private int capacity;
	private String[] data;
	private int size;
	
	public StringSet()
	{
		capacity = 2;
		data = new String[capacity];
	}
	
	public StringSet(int _capacity)
	{
		if (_capacity > 0)
		{
			capacity = _capacity;
			data = new String[capacity];
		}
	}
	
	public StringSet(Object obj)
	{
		/** @precondition object should not be null and be an instance of StringSet class
		 * 
		 */
		if (obj == null)
		{
			return;
		}
		
		if (!(obj instanceof StringSet))
		{
			return;
		}

		capacity = ((StringSet) obj).getCapacity();
		size = ((StringSet) obj).getSize();
		data = ((StringSet)obj).data; //data
	}
	
	public int getSize()
	{
		size = 0;
		
		for (int i = 0; i < capacity; i++)
		{
			if (data[i] != null)
			{
				size++;
			}
		}
		
		return size;
	}
	
	public int getCapacity()
	{
		capacity = data.length;
		return capacity;
	}
	
	public void add(String a)
	{
		if (a == null)
		{
			return;
		}
		
		if (size < capacity)
		{
			data[size] = a;
			size++;
		}
		else
		{
			ensureCapacity(getCapacity() * 2);
			data[getSize()] = a;
		}
	}
	
	private void ensureCapacity(int minimumCapacity)
	{
		if (minimumCapacity < 0)
		{
			return;
		}
		
		if (capacity <= minimumCapacity)
		{
			String tmp[] = new String[minimumCapacity];
			
			for (int i = 0; i < size; i++)
			{
				tmp[i] = data[i];
			}
			data = tmp;
			capacity = capacity * 2;
		}
	}
	
	public boolean contains(String a)
	{
		for (int i = 0; i < size; i++)
		{
			if (data[i].equals(a))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public boolean remove(String a)
	{
		if (a == null)
		{
			return false;
		}
		
		for (int i = 0; i < size; i++)
		{
			if (data[i].equals(a))
			{
				data[i] = data[size - 1];
				data[size - 1] = null;
				return true;
			}
		}
		return false;
	}
	
	public void addOrdered(String a)
	{
		if (a == null)
		{
			return;
		}
		
		if (size >= getCapacity())
		{
			ensureCapacity(getCapacity() * 2);
		}
		
		/*int i = 0;
		while (a.compareTo(data[i]) > 0)
		{
			i++;
		}
		for (int j = size; j > i; j--)
		{
			data[j] = data[j];
		}
		data[i] = a;*/
		//I cannot seem to find out what is wrong. 
	}
	
	public void printTest() 
	{
		for (int i = 0; i < size; i++)
		{
			if (data[i] != null)
			{
				System.out.print(data[i] + " ");
			}
		}
		System.out.println();
	}
}// end class
