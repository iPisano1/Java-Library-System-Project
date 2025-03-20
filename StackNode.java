import java.time.*;

public class StackNode{

   StackNode prev, next;
   int BookID;
   String Title, BorrowerName;
   LocalDate date;
   
   public StackNode(StackNode prev, int BookID, String Title, String BorrowerName, LocalDate date, StackNode next){
      this.prev = null;
      this.BookID = BookID;
      this.Title = Title;
      this.BorrowerName = BorrowerName;
      this.date = date;
      this.next = null;
   }

}