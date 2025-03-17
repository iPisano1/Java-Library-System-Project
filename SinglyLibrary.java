public class SinglyLibrary{

   SinglyNode head, tail;
   int size = 0;
   
   public SinglyLibrary(){
      this.head = null;
      this.tail = null;   
   }
   
   public SinglyLibrary(SinglyNode head, SinglyNode tail){
      this.head = head;
      this.tail = tail;
   }
   
   public boolean isEmpty(){
      if(head == null){
         return true;
      }else{
         return false;
      }
   }
   
   public void addBook(int BookID, String Title, String Author){
      SinglyNode newNode = new SinglyNode(BookID, Title, Author);
      if(isEmpty()){
         head = tail = newNode;
      }else{
         newNode.next = head;
         head = newNode;
      }
      size++;
   }
   
   public void searchTitle(String searchedTitle){
      if(isEmpty()){
         System.out.println("Library is Empty.");
         return;
      }else{
         SinglyNode current = head;
         while(current != null){
            if(searchedTitle.equals(current.Title)){
               System.out.println("Book Title Found!");
               System.out.println("--------- Book ---------");
               System.out.println("Book ID: " + current.BookID);
               System.out.println("Book Title: " + current.Title);
               System.out.println("Book Author: " + current.Author);
               return;
            }
            current = current.next;
         }
         System.out.println("Book Title Not Found!");
      }
   }
   
   public void displayBooks(){
      if(isEmpty()){
         System.out.println("Library is Empty.");
         return;
      }else{
         SinglyNode current = head;
         int num = 1;
         while(current != null){
            System.out.println("---------Book " + num + "-----------");
            System.out.println("Book ID: " + current.BookID);
            System.out.println("Book Title: " + current.Title);
            System.out.println("Book Author: " + current.Author);
            num++;
            current = current.next;
         }
      }
   }
}