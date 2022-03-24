package librarymanagementsystem;

import java.util.ArrayList;

public class BooksList {
    public String categoryName;
    public ArrayList<Book> notAvailableBooks ;
    
    BooksList(){
        notAvailableBooks = new ArrayList();
        categoryName = "category";
    }
    
    class Node{
        Book data;
        Node next;
    }
    
    Node head = null;
    
    public void addBookToBooksList(Book b){
        Node newBook = new Node();
        newBook.data = b;
        if(head==null)
            head = newBook;
        else{
            Node ptr =  head;
            while(ptr.next!=null){
                ptr = ptr.next;
            }
            ptr.next = newBook;
        }
        newBook.next = null;
    }
    
    public void displayAllBooks(){
        Node ptr = head;
        while(ptr!=null){
            System.out.println("Category Name : "+this.categoryName);
            ptr.data.displayBookData();
            ptr = ptr.next;
        }
        if(!notAvailableBooks.isEmpty()){
            System.out.println("**************");
            System.out.println("Not Available Books :-");
            for(Book b : notAvailableBooks)
                b.displayBookData();
        }
    }
    
    public Book searchBook(int bookId){
        Node ptr = head;
        boolean isFound = false;
        while(ptr!=null){
           if(ptr.data.getBookId()==bookId){
               isFound = true;
               break;
           }
           else
               ptr = ptr.next;
        }
        if(isFound)
            return ptr.data;
        else
            return null;
    }
}
