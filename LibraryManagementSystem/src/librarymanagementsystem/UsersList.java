package librarymanagementsystem;

public class UsersList {
    class Node{
        User data;
        Node next;
    }
    
    Node head = null;
    
    public void RegisterNewUser(User u){
        Node newUser = new Node();
        newUser.data = u;
        if(head==null){
            head = newUser;
        }
        else{
            Node ptr = head;
            while(ptr.next!=null){
                ptr = ptr.next;
            }
            ptr.next = newUser;
        }
        newUser.next = null;
    }
    
     public void displayUsersList(){
         Node ptr = head;
         while(ptr!=null){
             ptr.data.displayUserData();
             ptr = ptr.next;
         }
     }
     
     public User searchForUser(int id){
         Node ptr = head;
         while(ptr.data.getId()!=id){
             ptr = ptr.next;
         }
         return ptr.data;
     }
}
