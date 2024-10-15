package midtermpractice;

import java.util.Scanner;

public class Midtermpractice {

    public void addNames(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        
        System.out.print("Enter First Name: ");
        String sam_fname = sc.next();
        System.out.print("Enter Last Name: ");
        String sam_lname = sc.next();

        String sql = "INSERT INTO sample (sam_fname, sam_lname) VALUES (?, ?)";

        conf.addRecord(sql, sam_fname, sam_lname);

    }
    
    private void viewNames() {
        String query = "SELECT * FROM sample";
        String[] headers = {"ID", "Firstname", "Lastname"};
        String[] columns = {"sam_id", "sam_fname", "sam_lname"};

        config conf = new config();
        conf.viewRecords(query, headers, columns);
    }
    
    
    private void updateNames(){
    
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();
        
        System.out.print("Enter new First Name: ");
        String sam_fname = sc.next();
        System.out.print("Enter new Last Name: ");
        String sam_lname = sc.next();
        
        String query = "UPDATE sample SET sam_fname = ?, sam_lname = ? WHERE sam_id = ?";
        
        config conf = new config();
        conf.updateRecord(query, sam_fname, sam_lname, id);
        
    }
    
    private void deleteNames(){
    
        Scanner sc = new Scanner (System.in);
        
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();
        
        String query = "Delete FROM sample WHERE sam_id = ?";
       
        config conf = new config();
        conf.deleteRecord(query, id);

    }
    

    public static void main(String[] args) {
        
        Midtermpractice test = new Midtermpractice();
        Scanner input = new Scanner(System.in);
        String response;
        
        do{    
            System.out.println("1. ADD");
            System.out.println("2. VIEW");
            System.out.println("3. UPDATE");
            System.out.println("4. DELETE");
            System.out.println("5. EXIT");

            System.out.print("Enter Action: ");
            int action = input.nextInt();

            switch(action){
                case 1:
                    test.addNames();
                break; 
                case 2:
                    test.viewNames();
                break;
                case 3:
                    test.viewNames();
                    test.updateNames();
                    break;
                case 4:
                    test.viewNames();
                    test.deleteNames();
                    test.viewNames();
                break;
            }
            
            System.out.print("Do you want to CONTINUE? ");
            response = input.next();
            
        }while(response.equalsIgnoreCase("yes"));
            System.out.println("Thank You!");
            
    }
     
}
