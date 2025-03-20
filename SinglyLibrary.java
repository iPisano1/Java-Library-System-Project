public class SinglyLibrary{

   SinglyNode head, tail;
   int size = 0;
   
   public SinglyLibrary(){
      this.head = null;
      this.tail = null;   
   }
   
   // Method for checking if the list is empty
   public boolean isEmpty(){
      if(head == null){
         return true; // return true if the head is empty
      }
      else{
         return false; // return false if the head has values
      }
   }
   
   // Method for adding a book to the available list
   public void addBook(int BookID, String Title, String Author){
      SinglyNode newNode = new SinglyNode(BookID, Title, Author);
      if(isEmpty()){
         head = tail = newNode; // set the newNode as head and tail
      }
      else{
         newNode.next = head; // set the head to newNode's next Node
         head = newNode; // set newNode as head
      }
      System.out.println("Book Successfully Added!");
      size++; // Increment size
   }
   
   // Method for removing a book from available list
   public void removeBook(String searchedTitle){
      if(isEmpty()){
         System.out.println("Library is Empty!"); // Print if the list is empty
         return;
      }
      if(head.Title.equalsIgnoreCase(searchedTitle)){
         head = head.next; // set the node after the head as head
         if(head == null){
            tail = null; // set tail as null if the head is empty 
         }
         size--;
         return;
      }
      SinglyNode current = head;
      while(current.next != null){
         if(current.next.Title.equalsIgnoreCase(searchedTitle)){
            if(current.next == tail){
               tail = current;  
            }
            current.next = current.next.next;
            size--;
            return;
         }  
         current = current.next;
      }
      System.out.println("Book not Found!");
   }
   
   public SinglyNode searchBook(String searchedTitle, int option){
      SinglyNode current = head;
      while(current != null){
         if(option == 2 && searchedTitle.equalsIgnoreCase(current.Title)){
            return current;
         }
         if(option == 1 && searchedTitle.equalsIgnoreCase(current.Title)){
            System.out.println();
            System.out.println("\t\t\t\t\tBook Title Found!");
            System.out.println("\t\t\t\t--------- Book ---------");
            System.out.println("\t\t\t\t\tBook ID: " + current.BookID);
            System.out.println("\t\t\t\t\tBook Title: " + current.Title);
            System.out.println("\t\t\t\t\tBook Author: " + current.Author);
            System.out.println();
            return null;
         }
         current = current.next;
      }
      System.out.println("Book Title Not Found or Available!");
      return null;
   }
   
   public void displayBooks(){
      if(isEmpty()){
         System.out.println("Library is Empty!");
         return;
      }else{
         SinglyNode current = head;
         int num = 1;
         while(current != null){
            System.out.println("\t\t\t\t--------- Book " + num + " -----------");
            System.out.println("\t\t\t\t\tBook ID: " + current.BookID);
            System.out.println("\t\t\t\t\tBook Title: " + current.Title);
            System.out.println("\t\t\t\t\tBook Author: " + current.Author);
            num++;
            current = current.next;
         }
      }
   }
}