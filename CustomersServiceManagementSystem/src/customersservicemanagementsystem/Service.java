package customersservicemanagementsystem;

import java.util.Scanner;

public class Service {
    int serviceId;
    String name;
    boolean isAvailable;;
    double price;
    int sells = 0;
    
    Service(){
        setServiceData();
    }
    
    public void setServiceData(){
        Scanner in = new Scanner(System.in);
        System.out.println("ID , NAME , AVAILABILITY , PRICE");
        this.serviceId = in.nextInt();
        this.name = in.next();
        this.isAvailable = in.nextBoolean();
        this.price = in.nextDouble();
    }
    
    public void displayServiceData(){
        System.out.println("*** Service Data ***");
        System.out.println("ID : "+this.serviceId);
        System.out.println("NAME : "+this.name);
        System.out.println("AVAILABLE : "+this.isAvailable);
        System.out.println("PRICE : "+this.price);
        System.out.println("SELLS : "+this.sells);
    }
}
