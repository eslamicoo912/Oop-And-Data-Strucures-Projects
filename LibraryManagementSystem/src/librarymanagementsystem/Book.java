package librarymanagementsystem;

import java.util.Scanner;

public class Book {
    public int bookId;
    public String bookName;
    public int copies;
    public int price;
    public Author author;
    
    Book(Author auth){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Book Data");
        System.out.print("Book Name : ");
        bookName = in.nextLine();
        System.out.print("Copies : ");
        copies = in.nextInt();
        System.out.print("Price : ");
        price = in.nextInt();
        author = auth;
        bookId = LibraryManagementSystem.BOOKID++;
    }
    
    public int getBookId(){return this.bookId;}
    public Author getAuthor(){return this.author;}
    
    public void displayBookData(){
        System.out.println("******************");
        System.out.println("Book Name : "+bookName);
        System.out.println("Book Id : "+bookId);
        System.out.println("Price : "+price);
        System.out.println("Copies : "+copies);
        System.out.println("Author Data :-");
        author.displayAuthorData();
    }
}
