package librarymanagementsystem;

public class Author extends PersonalInformation {
    private String nationality;
    
    public Author(String n , String nat){
        this.name = n;
        this.nationality = nat;
    }
    
    public void displayAuthorData(){
        System.out.println("******************");
        System.out.println("Name : "+this.name);
        System.out.println("Nationality : "+this.nationality);
    }
}
