/**
 * @author Omar Navarro
 */

public class IntNode 
{
	// Instance Variables
	private int data; 
	private IntNode link;
	
	// Default Constructor
	public IntNode()
	{
		data = 0;
		link = null;
	}
	
	/**
	 * @precondition initial link points to head of object and of type integer
	 * @postcondition creates new node with integer data that points to initial link
	 * @param initialData data you wish to shove in  the newly created node
	 * @param initialLink node that newly created node points to
	 */
	// Constructor with two parameters
	public IntNode(int initialData, IntNode initialLink)
	{
		setData(initialData);
		setLink(initialLink);
	}
	
	// Access method for data
	public int getData()
	{
		return data;
	}
	
	// Access method for link
	public IntNode getLink()
	{
		return link;
	}
	
	// Modifier method for data
	public void setData(int _data)
	{
		data = _data;
	}
	
	// Modifier method for link
	public void setLink(IntNode _link)
	{
		link = _link;
	}
	
	// Method returns length of linked list
	/**
	 * @param head starting point of linked list
	 * @return an integer value that represents how many nodes in linked list
	 */
	public static int listLength(IntNode head)
	{
		IntNode cursor = head;
		int counter = 0;
		
		while (cursor != null)
		{
			cursor = cursor.getLink();
			counter++;
		}
		
		return counter;
	}
	
	// Method to add node after calling objects current node
	/**
	 * 
	 * @param e the data that will be associated with newly created node
	 */
	public void addNodeAfterThis(int e)
	{
		IntNode tmp = new IntNode(e, this.getLink());
		this.setLink(tmp);
	}
	
	// Method to remove node after calling objects current node
	public void removeAfterThis() 
	{
		this.setLink(getLink().getLink());
	}
	
	// Method returns true if parameter data matches any data in all nodes starting from head
	/**
	 * @param head starting point of the search
	 * @param data what the method will search for
	 * @return returns true if data was found in linked list. false if not
	 */
	public static boolean search(IntNode head, int data)
	{
		IntNode cursor = head;
		while (cursor != null)
		{
			if (cursor.getData() == data)
			{
				return true;
			}
			cursor = cursor.getLink();
		}
		return false;
	}
	
	// Prints calling object nodes
	public String toString()
	{
		IntNode cursor = this.getLink();
		String nodeString = String.format("%s", this.getData());
		while (cursor != null)
		{
			nodeString = nodeString + "->" + cursor.getData();
			cursor = cursor.getLink();
		}
		
		return nodeString;
	}
	/**
	 * @param head
	 * Starting point of linked list
	 * @return
	 * Returns the number of even numbers in a given linked list
	 */
	public static int listEvenNumber(IntNode head)
	{
		IntNode cursor = head;
		int counter = 0;
		
		while (cursor != null)
		{
			if (cursor.getData() % 2 == 0)
			{
				counter++;
			}
			
			cursor = cursor.getLink();
		}
		
		return counter;
	}
	/**
	 * @precondition 
	 * num must be positive. If num is greater than the number of nodes in the given linked list; return sum of all nodes
	 * @param head
	 * Reference variable that points to the first node.
	 * @param num
	 * Number of nodes to sum starting from the last node.
	 * @return
	 * Returns summation of elements in the last "num" nodes in a given linked list.
	 */
	public static int sumLast(IntNode head, int num)
	{
		IntNode cursor = head;
		int sum = 0;
		
		if (listLength(head) < num)
		{
			while (cursor != null)
			{
				sum = sum + cursor.getData();
				cursor = cursor.getLink();
			}
		}
		else
		{
			for (int i = 0; i < listLength(head) - num; i++)
			{
				cursor = cursor.getLink();
			}
			
			while (cursor != null)
			{
				sum = sum + cursor.getData();
				cursor = cursor.getLink();
			}
		}
		
		return sum;
	}
	
	// Since precursor is moving faster than cursor, cursor should never equal precursor unless it was cyclic. 
	// Prove that x and y meet up if linked list is cyclic
	/*
	 * Meeting point M = x + y
	 * 2(x + y) = M + kL where k is scalar for loop length l
	 * x + y = kL
	 * x kL - y
	 */
	/**
	 * 
	 * @param head
	 * starting point of linked list
	 * @return
	 * returns boolean value "true" if is cyclic and false otherwise
	 */
	public static boolean hasCycle(IntNode head)
	{	
		IntNode cursor = head;
		IntNode precursor = head;
		
		while (true)
		{
			if (cursor == null)
			{
				return false;
			}
			
			cursor = cursor.getLink();
			
			if (cursor == null)
			{
				return false;
			}
			
			cursor = cursor.getLink();
			precursor = precursor.getLink();
			
			if (cursor == precursor)
			{
				return true;
			}
		}
	}
	/**
	 * 
	 * @param newData
	 * data must be an int. Will be added to end of linked list
	 */
	public void addToEnd(int newData)
	{
		IntNode cursor = this;
		
		while (cursor.getLink() != null)
		{
			cursor = cursor.getLink();
		}
		
		IntNode tmp = new IntNode(newData, cursor.getLink());
		cursor.setLink(tmp);
	}
	
	/**
	 * 
	 * @param head
	 * starting point of linked list
	 * @return
	 * will return the head of a new linked list with all the odd elements copied
	 */
	public static IntNode copyOdd(IntNode head)
	{
		IntNode cursor = head;
		
		IntNode tmp = new IntNode();
		
		while (cursor != null)
		{
			if (cursor.getData() % 2 != 0) 
			{
				tmp.addToEnd(cursor.getData());
			}
			
			cursor = cursor.getLink();
		}
		
		return tmp.link;
	}
	
	/**
	 * 
	 * @param head
	 * starting point for linked list
	 * @param e
	 * value that will be removed from linked list
	 */
	public static void removeAll(IntNode head, int e)
	{
		if (head.getData() == e)
		{
			head = head.getLink().getLink();
		}
		
		IntNode precursor = head;
		IntNode cursor = head.getLink();
		
		while (cursor != null)
		{
			if (cursor.getData() == e)
			{
				precursor.setLink(precursor.getLink().getLink());
				precursor = cursor;
				cursor = cursor.getLink();
			}
			else
			{
				cursor = cursor.getLink();
				precursor = precursor.getLink();
			}
		}
	}
	
	/**
	 * 
	 * @param head
	 * starting point for linked list
	 * @return
	 * will return the head of the reversed linked list
	 */
	public static IntNode reverse(IntNode head) 
	{
		if (head == null)
		{
			return null;
		}
		
		int values[] = new int[listLength(head)];
		IntNode cursor = head;
		int tmp;
		
		for (int i = 0; i < values.length; i++)
		{
			values[i] = cursor.getData();
			cursor = cursor.getLink();
		}
		
		for (int i = 0; i < values.length / 2; i++)
		{
			tmp = values[i];
			values[i] = values[values.length - i - 1];
			values[values.length - i - 1] = tmp;
		}
		
		cursor = head;
		
		for (int i = 0; i < values.length; i++)
		{
			cursor.data = values[i];
			cursor = cursor.getLink();
		}
	
		return cursor;
	}
}
