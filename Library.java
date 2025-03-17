import java.util.*;

public class Library{
   
   static Scanner input = new Scanner(System.in);
   
   public static void main(String[] args){
      
      SinglyLibrary list = new SinglyLibrary();
      
      System.out.println("========================================");
      System.out.println("==== Welcome to Java Library System ====");
      
      while(true){
         try{
            System.out.println("========================================");
               
            System.out.println("Select Option:");
            System.out.println("1. Add Book");
            System.out.println("2. Display Book");
            System.out.println("3. Search Book Title");
            System.out.println("4. Exit");
            System.out.print("Input: ");
            int choice = input.nextInt();
            input.nextLine();
            
            System.out.println("========================================");
         
            switch(choice){
               case 1:
                  System.out.print("Enter ID: ");
                  int id = input.nextInt();
                  input.nextLine();
                  System.out.print("Enter Title: ");
                  String title = input.nextLine();
                  System.out.print("Enter Author: ");
                  String author = input.nextLine();
                  list.addBook(id, title, author);
                  break;
               case 2:
                  list.displayBooks();
                  break;
               case 3:
                  System.out.print("Search Title: ");
                  String search = input.nextLine();
                  list.searchTitle(search);
                  break;
               case 4:
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