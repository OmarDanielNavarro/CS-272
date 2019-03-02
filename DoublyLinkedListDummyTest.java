
public class DoublyLinkedListDummyTest extends DoublyLinkedListDummy
{

	public static void main(String[] args) 
	{
		// Create a new list using the default constructor.
		System.out.println("Testing Accessor and Mutator methods when DoublyLinkedListDummy default constructor was used:");
		DoublyLinkedListDummy listOne = new DoublyLinkedListDummy(); 
		System.out.println("   Head " + listOne.getHead() + "   Tail " + listOne.getTail());
		
		// Make a new list using mutator methods.
		DIntNode nodeHead = new DIntNode(); 
		DIntNode nodeTail = new DIntNode();
		
		// Test accessor methods in main()
		listOne.setHead(nodeHead);
		listOne.setTail(nodeTail);
		listOne.getHead().setNext(listOne.getTail());
		listOne.getTail().setPrev(listOne.getHead());
		System.out.println("Testing Accessor and Mutator methods when Accessor and Mutator methods  was used in driver program:");
		System.out.println("   Head " + listOne.getHead() + "   Tail " + listOne.getTail()); // Should print the same output as default constructor.
		System.out.println();
		
		// Add node elements
		listOne.addEnd(0); // Add 0 to first node to test special case when head value = first node value.
		listOne.addEnd(23);
		listOne.addEnd(46);
		listOne.addEnd(4);
		listOne.addEnd(4);
		listOne.addEnd(4);
		listOne.addEnd(65);
		listOne.addEnd(65);
		listOne.addEnd(3);
		listOne.addEnd(0); // Add 0 to last node to test special case when tail value = first node value.
		
		// Test remove methods
		System.out.println("Testing toString() method:");
		System.out.println(listOne.toString() + "\n"); // toString implementation before remove methods.
		listOne.removeFromHead();
		System.out.println("Testing removeFromHead() method:");
		System.out.println(listOne.toString() + "\n"); // toString implementation after remove methods.
		System.out.println("Testing the case when we remove data that is equal to the tail's data:");
		listOne.remove(0);
		System.out.println(listOne.toString() + "\n");
		System.out.println("Testing removeAll() method by removing all occurrences of \"4\":");
		listOne.removeAll(4);
		System.out.println(listOne.toString() + "\n");
		
		// Test countOccurence method
		System.out.println("Testing countOccurence() method:");
		System.out.println("Amount of 65\'s in the list: " + listOne.countOccurence(65)); // Should return 2
		System.out.println("Amount of 0\'s in the list:  " + listOne.countOccurence(0)); // Test if method checks head and tail data. Should return 0
		System.out.println("Amount of 7\'s in the list:  " + listOne.countOccurence(7)); // Random number not in list. Should return 0
		System.out.println();
		
		// Test subList method
		System.out.println("Current doubly linked list:");
		System.out.println(listOne.toString() + "\n");
		System.out.println("Testing subList() starting at index to and ending at index 5:");
		System.out.println(listOne.subList(2, 5).toString() + "\n");
		
		System.out.println("Testing printStatistics() method:");
		listOne.printStatistics();
	}

}
