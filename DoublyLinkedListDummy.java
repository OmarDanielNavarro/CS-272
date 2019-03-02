
/**
 * @author Omar Navarro
 */

public class DoublyLinkedListDummy 
{
	private DIntNode head; // Dummy node that points to the first usable node in the linked list.
	private DIntNode tail; // Dummy node that the last usable node points to in the linked list.
	
	/**
	 * No argument constructor with "dummy" head and tail.
	 */
	public DoublyLinkedListDummy()
	{
		head = new DIntNode();
		tail = new DIntNode();
		head.setNext(tail);
		tail.setPrev(head);
	}
	
	/**
	 * Accessor method for instance variable "head".
	 * @return returns the node that represents the starting point of a given doubly linked list.
	 */
	public DIntNode getHead()
	{
		return head;
	}
	
	/**
	 * Accessor method for instance variable "tail".
	 * @return returns the node that represents the end point of a given doubly linked list.
	 */
	public DIntNode getTail()
	{
		return tail;
	}
	
	/**
	 *  Mutator method for instance variable "head".
	 * @param node: Sets node as a starting point for a given doubly linked list.
	 */
	public void setHead(DIntNode node)
	{
		head = node;
	}
	
	/**
	 * Mutator method for instance variable "tail".
	 * @param node: Sets node as the end of a given doubly linked list.
	 */
	public void setTail(DIntNode node)
	{
		tail = node;
	}
	
	
	/**
	 * Add a new node to the end of the linked list just before the "dummy" tail.
	 * @param element: The data that will be associated with newly added node.
	 */
	public void addEnd(int element)
	{
		addAfter(tail.getPrev(), element);
	}
	
	// removeFromHead() is O(1) which calls remove() which is O(n). Highest complexity is O(n).
	/**
	 * Removes the first actual node (the node that the "dummy" head points to).
	 */
	public void removeFromHead()
	{
		remove(head.getNext().getData());
	}
	
	/**
	 * Prints calling object in forward and backward sequence.
	 */
	public String toString()
	{
		String stringReturn = "(Forward)  ";
		DIntNode cursor = head.getNext();
		
		stringReturn = stringReturn + cursor.getData();
		
		while (cursor.getNext() != tail)
		{
			cursor = cursor.getNext();
			stringReturn = stringReturn + "<->";
			stringReturn = stringReturn + cursor.getData();
		}
		
		stringReturn = stringReturn + "\n\n(Backward) " + cursor.getData()  ;
		
		while (cursor.getPrev() != head)
		{
			cursor = cursor.getPrev();
			stringReturn = stringReturn + "<->";
			stringReturn = stringReturn + cursor.getData();
		}
		
		return stringReturn;
	}
	
	// countOccurrence() is O(n) complexity.
	/**
	 * @param e: Data that will be checked for occurrences in a given doubly linked list.
	 * @return Returns an integer that represents how many times "e" occurs in linked list.
	 */
	public int countOccurence(int e)
	{
		DIntNode cursor = head.getNext();
		int counter = 0;
		
		while (cursor != tail)
		{
			if (cursor.getData() == e)
			{
				counter++;
			}
			
			cursor = cursor.getNext();
		}
		
		return counter;
	}
	
	/**
	 * Removes first occurrence of the passed integer "e" from a given linked list.
	 * @param e: The value that will be removed.
	 * @return Returns true if "e" was found and removed; else returns false.
	 */
	public boolean remove(int e)
	{
		DIntNode cursor = head.getNext();
		
		while (cursor != tail)
		{
			if (cursor.getData() == e)
			{
				cursor.getPrev().setNext(cursor.getNext());
				cursor.getNext().setPrev(cursor.getPrev());
				
				return true;
			}
			
			cursor = cursor.getNext();
		}
		
		return false;	
	}
	
	// removeAll() is O(n) complexity but calls remove which is also O(n) complexity. n*n = n^2; therefore  removeAll() is O(n^2) complexity.
	/**
	 * @param e: Data that each node will be compared to and removed if present in a given doubly linked list.
	 * @return returns true if "e" was found and removed a given doubly linked list.
	 */
	public boolean removeAll(int e)
	{
		DIntNode cursor = head;
		boolean allWasRemoved = false;
		
		while (cursor != tail)
		{
			if (cursor.getData() == e)
			{
				remove(cursor.getData());
				cursor = cursor.getNext();
				allWasRemoved = true;
			}
			else
			{
				cursor = cursor.getNext();
			}
		}
		
		return allWasRemoved;
	}
	
	/**
	 * @param node: Node for which the new  node will be placed after.
	 * @param element: Data that will be associated with new node.
	 */
	public void addAfter(DIntNode node, int element)
	{
		DIntNode newNode = new DIntNode(element, null, null);
		newNode.setPrev(node);
		DIntNode nodeNext = node.getNext();
		newNode.setNext(node.getNext());
		nodeNext.setPrev(newNode);
		node.setNext(newNode);
	}
	
	// subList() is O(n) complexity.
	/**
	 * Copies a portion of of a linked list between the specified beginning and ending index. 
	 * @param beginIdx: The beginning index which will be copied into new list (inclusive).
	 * @param endIdx: The ending index which will be copied into new list (exclusive).
	 * @return Returns the "dummy" head of the new linked list.
	 * @precondition: beginIdx > 0 
	 */
	public DoublyLinkedListDummy subList(int beginIdx, int endIdx)
	{
		if (beginIdx < 0)
		{
			throw new IllegalArgumentException("Argument \"beginIdx\" must be greater than zero.");
		}
		
		if (beginIdx > this.listLength())
		{
			throw new IllegalArgumentException("Argument \"endIdx\" must be less than or equal to linked list length.");
		}
		
		if ((endIdx - beginIdx) > (this.listLength() - beginIdx)) 
		{
			throw new IllegalArgumentException("\"endIdx - \"beginIdx must be in linked list bounds.");
		}
		
		if (beginIdx > endIdx)
		{
			throw new IllegalArgumentException("beginIdx must be less than endIndx.");
		}
		
		DIntNode cursor = head.getNext();
		
		for (int i = 0; i < beginIdx; i++)
		{
			cursor = cursor.getNext();
		}
		
		DoublyLinkedListDummy newList = new DoublyLinkedListDummy();
				
		for (int i = beginIdx; i < endIdx; i++)
		{
			newList.addEnd(cursor.getData());
			cursor = cursor.getNext();
		}
		
		return newList;
	}
	
	/**
	 * @return Returns an integer representing the amount of nodes in the doubly linked list.
	 */
	public int listLength()
	{
		DIntNode cursor = head.getNext();
		int counter = 0;
		
		while (cursor != tail)
		{
			cursor = cursor.getNext();
			counter++;
		}
		
		return counter;
	}
	
	public void printStatistics()
	{
		System.out.printf("%-10s%10s", "Number", "Occurrence\n");
		
		DIntNode cursor = head.getNext(), precursor = head.getNext();
		
		while (cursor != tail)
		{
			while (precursor != cursor)
			{
				if (precursor.getData() == cursor.getData())
				{
					break;
				}
				
				precursor = precursor.getNext();
			}
			
			if (cursor == precursor)
			{
				System.out.printf("%-6d%5d\n", cursor.getData(), this.countOccurence(cursor.getData()));
			}
			
			cursor = cursor.getNext();
			precursor = head.getNext();
		}
	}
}
