import java.util.*;

public class Library{
   
   static Scanner input = new Scanner(System.in);
   
   public static void main(String[] args){
      
      // Initialize Objects
      SinglyLibrary SinglyList = new SinglyLibrary();
      DoublyLibrary DoublyList = new DoublyLibrary();
      StackLibrary StackList = new StackLibrary();
      
      System.out.println("==========================================================");
      System.out.println("============= Welcome to Java Library System =============");
      System.out.println("==========================================================");
      
      while(true){
         try{
            System.out.println("======================== Library =========================");
            
            // Prompt User to Select What to do in the System
            System.out.println("Select Option:");
            System.out.println("1. Add Book");
            System.out.println("2. Display Available Book");
            System.out.println("3. Search Book Title");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Display Borrowed Book");
            System.out.println("7. Display Borrowed Book History");
            System.out.println("8. Exit");
            System.out.print("Input: ");
            int choice = input.nextInt(); 
            input.nextLine();
            
            switch(choice){
               // Add book to available list
               case 1:
                  System.out.println("================ Add Book ================");
                  System.out.print("Enter ID: ");
                  int id = input.nextInt();
                  input.nextLine();
                  System.out.print("Enter Title: ");
                  String title = input.nextLine();
                  System.out.print("Enter Author: ");
                  String author = input.nextLine();
                  SinglyList.addBook(id, title, author);
                  break;
               // Display all books from the available list
               case 2:
                  System.out.println("================ Display Available Books =================");
                  SinglyList.displayBooks();
                  break;
               // Search book by book title from available list
               case 3:
                  System.out.println("======================= Search Book ======================");
                  if(SinglyList.isEmpty()){
                     System.out.println("No Available Books!");
                     break;
                  }
                  System.out.print("Search Title: ");
                  String search = input.nextLine();
                  SinglyList.searchBook(search, 1);
                  break;
               // Borrow books from available list and transfer it to borrowed List
               case 4:
                  System.out.println("======================= Borrow Book ======================");
                  if(SinglyList.isEmpty()){
                     System.out.println("No Available Books to Borrow!");
                     break;
                  }
                  System.out.print("Enter Borrower Name: ");
                  String borrowerName = input.nextLine();
                  System.out.print("Enter Book Title: ");
                  String borrow = input.nextLine();
                  
                  SinglyNode borrowBookSearch = SinglyList.searchBook(borrow, 2);
                  if(borrowBookSearch != null){
                     DoublyList.borrowBook(borrowBookSearch);
                     StackList.storeBookHistory(borrowBookSearch, borrowerName);
                     SinglyList.removeBook(borrow);
                  }
                  break;
               // Return book from borrowed list and transfer it back to available list
               case 5:
                  System.out.println("====================== Return Book =======================");
                  if(DoublyList.isEmpty()){
                     System.out.println("No Borrowed Books!");
                     break;
                  }
                  System.out.print("Enter Book Title: ");
                  String returnTitle = input.nextLine();
                  
                  DoublyNode returnBook = DoublyList.searchBook(returnTitle, 2);
                  if(returnBook != null){
                     SinglyList.addBook(returnBook.BookID, returnBook.Title, returnBook.Author);
                     DoublyList.removeBook(returnTitle);
                  }
                  break;
               // Display all books from borrowed List
               case 6:
                  System.out.println("================= Display Borrowed Books =================");
                  DoublyList.displayBorrowedBook();
                  break;
               // Display all borrowed list history
               case 7:
                  System.out.println("============= Display Borrowed Books History =============");
                  StackList.displayHistory();
                  break;
               // Exit the Program
               case 8:
                  System.out.println("==========================================================");
                  System.out.println("Exiting....");
                  System.exit(0);
                  break;
               default:
                  System.out.println("Invalid Input!");
            } 
         }catch(InputMismatchException e){
            System.out.println("Invalid Input!"); // Print if the User Entered a invalid input
            input.nextLine();
         }  
      }
   }
}