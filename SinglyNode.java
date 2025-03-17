public class SinglyNode{

   SinglyNode next;
   int BookID;
   String Title, Author;

   public SinglyNode(int BookID, String Title, String Author){
      this.BookID = BookID;
      this.Title = Title;
      this.Author = Author;
      next = null;
   }

}