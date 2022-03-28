package customersservicemanagementsystem;

import java.util.Scanner;

public class User {
    String name;
    static int id=0;
    double balance;
    
    User(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your name , balance : ");
        this.name = in.next();
        this.balance = in.nextDouble();
        User.id++;
    }
    
    public double getBalance(){return this.balance;}
    
    public boolean buyService(int servID){
        for(Service ser : Company.companyServices){
            if(servID==ser.serviceId){
                if(ser.isAvailable){
                    if(this.balance>=ser.price){
                        this.balance -= ser.price;
                        ser.sells++;
                        System.out.println("Done");
                        return true;
                    }
                    else{
                        System.out.println("Balance is not enough");
                        return false;
                    }
                }
                else{
                    System.out.println("Sorry , not available for now");
                    return false;
                }
            }
        }
        return false;
    }
    
    public void displayCusomerData(){
        System.out.println("*** Customer Data ***");
        System.out.println("ID : "+this.id);
        System.out.println("NAME : "+this.name);
        System.out.println("BALANCE : "+this.balance);
    }
}
