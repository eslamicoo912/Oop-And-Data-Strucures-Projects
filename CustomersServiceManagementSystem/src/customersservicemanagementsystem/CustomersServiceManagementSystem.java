package customersservicemanagementsystem;

import java.util.Scanner;

public class CustomersServiceManagementSystem {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Company c = new Company();
        CustomersQueue customersList = new CustomersQueue();
        customersList.newCustomer();
        while (true) {
            while (true) {
                displayMessage();
                System.out.print("Enter your choise : ");
                int choise = in.nextInt();
                User currentUser = customersList.front.data;
                switch (choise) {
                    case 1 -> {
                        c.displayCompanyServices();
                        break;
                    }
                    case 2 -> {
                        System.out.print("Enter the id of the needed sevice : ");
                        int servID = in.nextInt();
                        if (currentUser.buyService(servID)) {
                            System.out.println("Done");
                        } else {
                            System.out.println("Failed , please enter valid id");
                        }
                        break;
                    }
                    case 3 -> {
                        currentUser.displayCusomerData();
                        break;
                    }
                }
                System.out.print("Finished ? : ");
                String finishAnswer = in.next();
                if (finishAnswer.equals("y")) {
                    customersList.cutomerFinished();
                    System.out.println("Thanks For Your Visit !");
                    break;
                }
            }
        }
    }

    static void displayMessage() {
        System.out.println("*** Hello ***");
        System.out.println("1- DISPLAY SERVICES");
        System.out.println("2- BUY A SERVICE");
        System.out.println("3- DISPLAY MY DATA");
    }

}
