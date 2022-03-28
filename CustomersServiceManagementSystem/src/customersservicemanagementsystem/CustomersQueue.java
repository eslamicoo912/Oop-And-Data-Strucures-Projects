package customersservicemanagementsystem;

import java.util.Scanner;

public class CustomersQueue {
    class Node {
        User data;
        Node next;
    }
    
    Node front = null;
    Node rear = null;
    
    public void newCustomer(){
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.print("New Cutomer ? : ");
            String answer = in.next();
            if(answer.equals("y")){
                User u = new User();
                Node newUser = new Node();
                newUser.data = u;
                if(front==null){
                    front = newUser;
                    rear = newUser;
                }
                else{
                    rear.next = newUser;
                    rear = newUser;
                }
                newUser.next = null;
            }
            else
                break;
        }
    }
    
    public void cutomerFinished(){
        if(front==rear){
            front = null;
            rear = null;
            System.gc();
            return;
        }
        front = front.next;
        System.gc();
    }
}
