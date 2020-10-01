import java.util.LinkedList;
import java.util.Random;

public class ReverseLinkedList {

   public static void main(String[] args) {
      System.out.println("ReverseLinkedList Demo");
      LinkedList<Integer> list1 = new LinkedList<>();
      Random rand = new Random(100);

      int numElements = rand.nextInt();
      System.out.println("Size of List: " + numElements);
      System.out.println();

      for (int i = 0; i < numElements; i++) {
         list1.add(rand.nextInt());
      }

      System.out.println("List before reversal:");
      System.out.println(list1);
      System.out.println();

      list1 = reverse(list1);
      System.out.println("List after reversal:");
      System.out.println(list1);
   }

   public static LinkedList<Integer> reverse(LinkedList list) {


      return list;
   }

}
