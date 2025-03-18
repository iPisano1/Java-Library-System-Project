public class SinglyLibrary{

   SinglyNode head, tail;
   int size = 0;
   
   public SinglyLibrary(){
      this.head = null;
      this.tail = null;   
   }
   
   public boolean isEmpty(){
      if(head == null){
         return true;
      }
      else{
         return false;
      }
   }
   
   public void addBook(int BookID, String Title, String Author){
      SinglyNode newNode = new SinglyNode(BookID, Title, Author);
      if(isEmpty()){
         head = tail = newNode;
      }
      else{
         newNode.next = head;
         head = newNode;
      }
      System.out.println("Book Successfully Added!");
      size++;
   }
   
   public void removeBook(String searchedTitle){
      if(isEmpty()){
         System.out.println("Library is Empty!");
         return;
      }
      if(head.Title.equalsIgnoreCase(searchedTitle)){
         head = head.next;
         if(head == tail){
            tail = null;
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
      if(isEmpty()){
         System.out.println("Library is Empty!");
         return null;
      }
      else{
         SinglyNode current = head;
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
   
   public void displayBooks(){
      if(isEmpty()){
         System.out.println("Library is Empty!");
         return;
      }else{
         SinglyNode current = head;
         int num = 1;
         while(current != null){
            System.out.println("--------- Book " + num + " -----------");
            System.out.println("Book ID: " + current.BookID);
            System.out.println("Book Title: " + current.Title);
            System.out.println("Book Author: " + current.Author);
            num++;
            current = current.next;
         }
      }
   }
}