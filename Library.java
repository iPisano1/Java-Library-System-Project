import java.util.*;

public class Library{
   
   static Scanner input = new Scanner(System.in);
   
   public static void main(String[] args){
      
      SinglyLibrary SinglyList = new SinglyLibrary();
      DoublyLibrary DoublyList = new DoublyLibrary();
      
      System.out.println("==============================================");
      System.out.println("======= Welcome to Java Library System =======");
      
      while(true){
         try{
            System.out.println("==============================================");
               
            System.out.println("Select Option:");
            System.out.println("1. Add Book");
            System.out.println("2. Display Available Book");
            System.out.println("3. Search Book Title");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Display Borrowed Book");
            System.out.println("7. Exit");
            System.out.print("Input: ");
            int choice = input.nextInt();
            input.nextLine();
            
            switch(choice){
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
               case 2:
                  System.out.println("=============== Available Books ===============");
                  SinglyList.displayBooks();
                  break;
               case 3:
                  System.out.println("=============== Search Book ===============");
                  System.out.print("Search Title: ");
                  String search = input.nextLine();
                  SinglyList.searchBook(search, 1);
                  break;
               case 4:
                  System.out.println("================ Borrow Book ================");
                  System.out.print("Enter Book Title: ");
                  String borrow = input.nextLine();
                  
                  SinglyNode borrowBook = SinglyList.searchBook(borrow, 2);
                  if(borrowBook != null){
                     DoublyList.borrowBook(borrowBook);
                     SinglyList.removeBook(borrow);
                  }
                  break;
               case 5:
                  System.out.println("================ Return Book ================");
                  System.out.print("Enter Book Title: ");
                  String returnTitle = input.nextLine();
                  
                  DoublyNode returnBook = DoublyList.searchBook(returnTitle, 2);
                  if(returnBook != null){
                     SinglyList.addBook(returnBook.BookID, returnBook.Title, returnBook.Author);
                     DoublyList.removeBook(returnTitle);
                  }
                  break;
               case 6:
                  System.out.println("=============== Borrowed Books ===============");
                  DoublyList.displayBorrowedBook();
                  break;
               case 7:
                  System.exit(0);
                  break;
            } 
         }catch(InputMismatchException e){
            System.out.println("Invalid Input.");
            input.nextLine();
         }  
      }
   }
}