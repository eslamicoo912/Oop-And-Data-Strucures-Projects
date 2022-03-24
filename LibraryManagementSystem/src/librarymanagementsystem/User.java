package librarymanagementsystem;

import java.util.Scanner;

public class User extends PersonalInformation {
    private int userId;
    private UserBooksList myBooksList;
    private UserBooksList myBorrowedList;
    private int balance;
    
    User(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your data");
        
        System.out.print("Name : ");
        this.name = in.next();
        
        System.out.print("Password : ");
        this.password = in.next();
        
        System.out.print("Enter your balance : ");
        balance = in.nextInt();
        
        userId = ++PersonalInformation.id;
        System.out.println("Registered Successfully , Your Id is " + userId);
        
        this.myBooksList = new UserBooksList();
        this.myBorrowedList = new UserBooksList();
    }
    
    public void displayUserData(){
        System.out.println("******************");
        System.out.println("Name : "+this.name);
        System.out.println("Id : "+this.userId);
        System.out.println("Balance : "+this.balance);
        System.out.println("Books History :-");
        myBooksList.displayUserBooks();
        System.out.println("Borrowed Books :-");
        myBorrowedList.displayUserBooks();
    }
    
    public void buyBook(int bookId,BooksList booksList){
        Book bookToBuy = booksList.searchBook(bookId);
        if(bookToBuy==null)
            System.out.println("Not Found");
        else{
            if(this.balance<bookToBuy.price)
                System.out.println("You don't have enough balance");
            else{
                if(bookToBuy.copies>0){
                    this.balance -= bookToBuy.price;
                    booksList.searchBook(bookId).copies --;
                    this.myBooksList.addBookToUser(bookToBuy);
                    System.out.println("Bought Successfully");
                    if(bookToBuy.copies==0)
                        booksList.notAvailableBooks.add(bookToBuy);
                }
                else{
                    System.out.println("Sorry , this book is not available for now");
                }
            }
        }
    }
    
    public boolean loginUser(int id , String pass){
        return this.userId==id && this.password.equals(pass);
    }
    
    public void borrowBook(int bookId , BooksList booksList){
        Book bookToBorrow = booksList.searchBook(bookId);
        if(bookToBorrow==null){
            System.out.println("Not Found");
        }
        else{
            if(bookToBorrow.copies>0){
                booksList.searchBook(bookId).copies--;
                this.balance -= bookToBorrow.price * (15/100);
                this.myBorrowedList.addBookToUser(bookToBorrow);
                System.out.println("Borrowed Successfully");
                if(booksList.searchBook(bookId).copies==0)
                    booksList.notAvailableBooks.add(bookToBorrow);
            }
            else
                System.out.println("Sorry , this book is not available for now");
        }
    }
    
    public void returnBook(int bookId , BooksList booksList){
        if(myBorrowedList.searchBook(bookId)){
            myBooksList.removeBook(bookId);
            System.out.println("Thank you!");
            booksList.searchBook(bookId).copies++;
        }
        else
            System.out.println("Not found");
    }
}
