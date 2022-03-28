package customersservicemanagementsystem;

public class UserServices {
    class Node{
        Service data;
        Node next;
    }
    
    Node head = null;
    
    public void addService(Service s){
        Node newService = new Node();
        newService.data = s;
        if(head==null)
            head = newService;
        else{
            Node ptr = head;
            while(ptr.next!=null)
                ptr = ptr.next;
            ptr.next = newService;
        }
        newService.next = null;
    }
    
    public void displayMyServices(){
        System.out.println("*** My Services ***");
        Node ptr = head;
        while(ptr!=null)
            ptr.data.displayServiceData();
        System.out.println();
    }
}
