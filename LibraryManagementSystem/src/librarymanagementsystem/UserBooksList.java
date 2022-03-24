package librarymanagementsystem;

public class UserBooksList {
    class Node{
        Book data;
        Node next;
    }
    
    Node head = null;
    
    public void addBookToUser(Book b){
        Node newBook = new Node();
        newBook.data = b;
        if(head==null)
            head = newBook;
        else{
            Node ptr = head;
            while(ptr.next!=null){
                ptr = ptr.next;
            }
            ptr.next = newBook;
        }
        newBook.next = null;
    }
    
    public void displayUserBooks(){
        Node ptr = head;
        while(ptr!=null){
            ptr.data.displayBookData();
            ptr = ptr.next;
        }
    }
    
    public boolean searchBook(int bookId){
        Node ptr = head;
        while(ptr.next!=null){
            if(ptr.data.bookId==bookId)
                return true;
        }
        return false;
    }
    
    public void removeBook(int bookId){
        Node pre = head , ptr = head;
        while(ptr.data.bookId!=bookId){
            pre = ptr;
            ptr = ptr.next;
        }
        pre.next = ptr.next;
        System.gc();
    }
}
