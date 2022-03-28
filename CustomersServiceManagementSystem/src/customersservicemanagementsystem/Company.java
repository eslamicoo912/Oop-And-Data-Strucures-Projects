package customersservicemanagementsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Company {
    final String companyName = "ESLAMICOO COMPANY";
    final String location = "Egypt , Cairo";
    static ArrayList<Service> companyServices;
    double rate = 0;
    
    Company(){
        Scanner in = new Scanner(System.in);
        companyServices = new ArrayList();
        while(true){
            System.out.print("New Service ? : ");
            String ans = in.next();
            if(ans.equals("y"))
                companyServices.add(new Service());
            else
                break;
        }
    }
    
    public void setRate(double r){
        rate += r;
    }
    
    public double getAvgRate(){
        int sellsSum = 0;
        for(Service ser : companyServices)
            sellsSum += ser.sells;
        return rate / sellsSum;
    }
    
    public void displayCompanyServices(){
        for(Service ser : companyServices)
            ser.displayServiceData();
    }
}
