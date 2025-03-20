import java.time.*;

public class StackLibrary{
   
   StackNode head, tail;
   int size = 0;
   
   public boolean isEmpty(){
      if(head == null){
         return true;
      }
      else{
         return false;
      }
   }
   
   public void storeBookHistory(SinglyNode singlyNode, String borrowerName){
      LocalDate date = LocalDate.now();
      StackNode newNode = new StackNode(null, singlyNode.BookID, singlyNode.Title, borrowerName, date, head);
      if(isEmpty()){
         head = tail = newNode;
      }
      else{
         newNode.next = head;
         head.prev = newNode;
         head = newNode;
      }
      size++;
   }
   
   public void displayHistory(){
      if(isEmpty()){
         System.out.println("No Borrowed Books History!");
         return;
      }
      else{
         StackNode current = head;
         int num = 1;
         while(current != null){
            System.out.println("\t\t\t\t-------------- Book " + num + " --------------");
            System.out.println("\t\t\t\t\tBookID: " + current.BookID);
            System.out.println("\t\t\t\t\tBook Title: " + current.Title);
            System.out.println("\t\t\t\t\tBorrower Name: " + current.BorrowerName);
            System.out.println("\t\t\t\t\tDate Borrowed: " + current.date);
            num++;
            current = current.next;
         }
      }
   }
   
}