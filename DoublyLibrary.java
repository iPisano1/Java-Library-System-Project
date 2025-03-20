public class DoublyLibrary{
   
   DoublyNode head, tail;
   int size = 0;
   
   public DoublyLibrary(){
      this.head = null;
      this.tail = null;   
   }
   
   public boolean isEmpty(){
      if(head == null){
         return true;
      }else{
         return false;
      }
   }
   
   public void borrowBook(SinglyNode singlyNode){
      DoublyNode newNode = new DoublyNode(null, singlyNode.BookID, singlyNode.Title, singlyNode.Author, head);
      if(isEmpty()){
         head = tail = newNode;
      }else{
         newNode.next = head;
         head.prev = newNode;
         head = newNode;   
      }
      System.out.println("Book Successfully Borrowed!");
      size++;
   }
   
   public void removeBook(String searchedTitle){
      if(head.Title.equalsIgnoreCase(searchedTitle)){
         head = head.next;
         if(head == null){
            tail = null;
         }
         size--;
         return;
      }
      
      DoublyNode current = head;
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
   
   public DoublyNode searchBook(String searchedTitle, int option){
      if(isEmpty()){
         System.out.println("No Borrowed Books!");
         return null;
      }
      else{
         DoublyNode current = head;
         while(current != null){
            if(option == 2 && searchedTitle.equalsIgnoreCase(current.Title)){
               return current;
            }
            if(option == 1 && searchedTitle.equalsIgnoreCase(current.Title)){
               System.out.println("Book Title Found!");
               System.out.println("--------- Book ---------");
               System.out.println("Book ID: " + current.BookID);
               System.out.println("Book Title: " + current.Title);
               System.out.println("Book Author: " + current.Author);
               return null;
            }
               current = current.next;
            }
            System.out.println("Book Title Not Found or Available!");
            return null;
      }
   }
   
   public void displayBorrowedBook(){
      if(isEmpty()){
         System.out.println("No Borrowed Books!");
         return;
      }else{
         DoublyNode current = head;
         int num = 1;
         while(current != null){
            System.out.println("\t\t\t\t--------- Borrowed Book " + num + " -----------");
            System.out.println("\t\t\t\t\tBook ID: " + current.BookID);
            System.out.println("\t\t\t\t\tBook Title: " + current.Title);
            System.out.println("\t\t\t\t\tBook Author: " + current.Author);
            num++;
            current = current.next;
         }
      }
   }
   
}