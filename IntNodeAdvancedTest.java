
public class IntNodeAdvancedTest extends IntNode 
{

	public static void main(String[] args)
	{
		System.out.println("Lab 4 \"IntNode\" tests. By Omar Navarro.\n");
		IntNode nodeOne = new IntNode(); // Create new node using default constructor
		nodeOne.setData(25); // set node data to 25
		nodeOne.addNodeAfterThis(45); //add node after 25 with content 45
		System.out.println("Add node with content 45 after node containing 25.");
		System.out.println(" " + nodeOne.toString()); // test toString method. Output should be 25->45
		nodeOne.addNodeAfterThis(4); // add node after 25
		System.out.println("Add node with content 4 after node with content 25.");
		System.out.println(" " + nodeOne.toString()); // Correct output should be 25->4->45
		nodeOne.addNodeAfterThis(17); // add node with content 17 after node with content 25
		nodeOne.addNodeAfterThis(99); // add node with content 99 after node with content 25
		System.out.println("Add node with content 17 then 99 after node with content 25.");
		System.out.println(" " + nodeOne.toString());// Correct output should be 25->99->17->4->45
		nodeOne.removeAfterThis(); // Should remove node after node with content 25 (99 in this case)
		System.out.println("Remove node after node with content 25.");
		System.out.println(" " + nodeOne.toString()); // Correct output should be 25->17->4->45
		System.out.println("Does a node containing 25 exist in nodeOne?");
		System.out.println(" " + search(nodeOne, 25)); // Searches for 45 in all nodes starting from head: True
		System.out.println("Does a node containing 75 exist in nodeOne?");
		System.out.println(" " + search(nodeOne, 76)); // Search for 76 in all nodes starting from head: False
		System.out.println("What is the length of nodeOne?");
		System.out.println(" " + listLength(nodeOne)); // Determines the length of nodeOne: 4
		System.out.println("How many even numbers are in linked list nodeOne?");
		System.out.println(" " + listEvenNumber(nodeOne));
		nodeOne.addNodeAfterThis(12); // Add another even number
		System.out.println("How many even numbers are in linked list nodeOne?");
		System.out.println(" " + listEvenNumber(nodeOne)); // Test listEvenNumber method. Should return 2
		System.out.println("Current existing nodes in nodeOne:");
		System.out.println(" " + nodeOne.toString());
		System.out.println("What is the sum of the last 2 nodes in nodeOne? (45 + 4 = 49)");
		System.out.println(" " + sumLast(nodeOne, 2));
		System.out.println("Test to check the case when num > nodeOne length. (25 + 12 + 17 + 4 + 45 = 103)");
		System.out.println(" " + sumLast(nodeOne, 10));
		System.out.println("Is the given linked list cyclic?");
		System.out.println(" " + hasCycle(nodeOne));
		nodeOne.addToEnd(55); //Add 55 to end
		System.out.println("Linked list after adding node with content 55 to end of linked list.");
		System.out.println(" " + nodeOne.toString());
		nodeOne.addNodeAfterThis(4);
		System.out.println("Add node with content 4 to linked list.");
		System.out.println(" " + nodeOne.toString());
		removeAll(nodeOne, 4);
		System.out.println("Remove all content 4 nodes.");
		System.out.println(" " + nodeOne.toString());
		reverse(nodeOne);
		System.out.println("Reversed linked list.");
		System.out.println(" " + nodeOne.toString());
		System.out.println("Copy all odd elements");
		System.out.println(" " + copyOdd(nodeOne).toString());
		nodeOne.getLink().getLink().getLink().setLink(nodeOne); // make nodeOne cyclic
		System.out.println("Is nodeOne cyclic?");
		System.out.println(" " + hasCycle(nodeOne)); // Should return true
	}
}
