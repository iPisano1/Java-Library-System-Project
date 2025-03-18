public class DoublyNode {
    
    DoublyNode prev, next;
    int BookID;
    String Title, Author;

    public DoublyNode(DoublyNode prev, int BookID, String Title, String Author, DoublyNode next){
        this.prev = null;
        this.BookID = BookID;
        this.Title = Title;
        this.Author = Author;
        this.next = null;
    }

}
