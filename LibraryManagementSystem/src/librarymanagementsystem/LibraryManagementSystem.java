package librarymanagementsystem;

import java.util.Scanner;

public class LibraryManagementSystem {
static int BOOKID = 1;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        BooksList life = new BooksList();
        BooksList sport = new BooksList();
        BooksList tech = new BooksList();
        UsersList usersList = new UsersList();
        
        User u = new User();
        usersList.RegisterNewUser(u);
        boolean isLogin = false;
        while(true){
            displayMenu();
            System.out.println("Enter your choise");
            int choise = in.nextInt();
            switch(choise){
                case 2:
                    System.out.print("Enter your id , password by order : ");
                    int id = in.nextInt();
                    String password = in.next();
                    if(u.loginUser(id, password)){
                        isLogin = true;
                        System.out.println("Hello , "+u.name);
                    }
                    else
                        System.out.println("Wrong id or password");
                    break;
                case 3:
                    if(isLogin){
                        System.out.println("Enter category name : ");
                        String cat = in.next();
                        System.out.print("Enter book id : ");
                        int bookId = in.nextInt();
                        if(cat.equals("life")){
                            u.buyBook(bookId, life);
                        }
                        else if(cat.equals("sport")){
                            u.buyBook(bookId, sport);
                        }
                        else if(cat.equals("tech")){
                            u.buyBook(bookId, tech);
                        }
                    }
                    else{
                        System.out.println("Please Login First");
                    }
                    break;
                case 4:
                    System.out.println("Enter category name : ");
                    String catB = in.next();
                    System.out.print("Enter book id : ");
                    int bookIdB= in.nextInt();
                    if(catB.equals("life")){
                        u.borrowBook(bookIdB, life);
                    }
                    else if(catB.equals("sport")){
                        u.borrowBook(bookIdB, sport);
                    }
                    else if(catB.equals("tech")){
                        u.borrowBook(bookIdB, tech);
                    }
                    break;
                case 5:
                    life.displayAllBooks();
                    sport.displayAllBooks();
                    tech.displayAllBooks();
                    break;
                case 6:
                    break;
                case 7:
                    System.out.println("Enter Category Name : ");
                    String catNameToAdd = in.next();
                    Author auth = new Author("Naguib Mahfouz","Egypt");
                    Book b = new Book(auth);
                    switch(catNameToAdd){
                        case "life" ->{
                            life.addBookToBooksList(b);
                            break;
                        }
                        case "sport" ->{
                            sport.addBookToBooksList(b);
                            break;
                        }
                        case "tech" ->{
                            tech.addBookToBooksList(b);
                            break;
                        }
                    }
                    break;

                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    usersList.displayUsersList();
                    break;
            }
        }
    }
    
    static void displayMenu(){
        System.out.println("**** Menu ****");
        System.out.println("For Users :");
        System.out.println("1- Register");
        System.out.println("2- Login");
        System.out.println("3- Buy Book");
        System.out.println("4- Borrow Book");
        System.out.println("5- Display All Books");
        System.out.println("---------------");
        System.out.println("For Admins :");
        System.out.println("7- Add New Book");
        System.out.println("8- Remove Book");
        System.out.println("9- Remove User");
        System.out.println("10- Display All Users");
    }
    
}
