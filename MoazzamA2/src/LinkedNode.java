import java.util.Random;

/*
Usman Moazzam, CSDS 233, Assignment #2: Reverse Linked List
LinkedNode is a custom written class for storing nodes containing a data field and a next field.
This class contains the method reverse, which reverses given Linked Lists (built from chained
LinkedNodes) without the use of an extra list. This is allows the list to be reversed using O(1)
space rather than O(n) space, which would be the case when using an extra list.
*/

public class LinkedNode {

   // stores node data
   public int data;
   // stores reference to next node
   public LinkedNode next;

   // initializes stand-alone node with desired data
   public LinkedNode(int data) {
      this(data, null);
   }

   // initializes node with desired data and next reference
   public LinkedNode(int data, LinkedNode next) {
      this.data = data;
      this.next = next;
   }

   // ReverseLinkedList Demo:
   // creates list of randomly generated nodes
   // compares original and reversed list
   public static void main(String[] args) {
      System.out.println("ReverseLinkedList Demo");

      // size of test list established
      int numElements = 10;
      System.out.println("Size of List: " + numElements);
      System.out.println();

      // adds random number of random nodes to the list
      Random rand = new Random();
      LinkedNode list = new LinkedNode(rand.nextInt(100));
      LinkedNode currNode = list;
      for (int i = 1; i < numElements; i++) {
         currNode.next = new LinkedNode(rand.nextInt(100));
         currNode = currNode.next;
      }

      // prints list before reversal
      System.out.println("List before reversal: ");
      printList(list);
      System.out.println();

      // prints list after reversal
      System.out.println("List after reversal: ");
      list = reverse(list);
      printList(list);
   }

   // prints list of LinkedNodes using "[data1 data2 ...]" format
   private static void printList(LinkedNode list) {
      String print = "[";
      while (list != null) {
         print += list.data + " ";
         list = list.next;
      }
      print = print.substring(0, print.length() - 1) + "]";
      System.out.println(print);
   }

   // reverses list of LinkedNodes and returns reference to the starting node
   private static LinkedNode reverse(LinkedNode toReverse) {
      // nodes for traversing through toReverse nodes
      // prevNode will end up as starting node, currNode as next, nextNode as next.next
      LinkedNode prevNode = null;
      LinkedNode currNode = toReverse;
      LinkedNode nextNode = null;

      // shifts traversal nodes down the list while reversing the order of previous nodes
      while (currNode != null) {
         nextNode = currNode.next;
         currNode.next = prevNode;
         prevNode = currNode;
         currNode = nextNode;
      }

      // return new starter node
      return prevNode;
   }

}
