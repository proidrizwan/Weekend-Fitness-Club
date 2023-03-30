/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package weekendfitnessclub;

/**
 *
 * @author Sc
 */
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author Sc
 */
public class ClubController {
    
    /**
     * Scanner object to take input
     */
    private final Scanner keyBoard;
     /**
     * Weekend Object to operate
     * the whole program.
     */
    private Weekends weekends;
   
    
     private void showMenu() {
        System.out.println("\nPlease select your choice from these options");
        System.out.println("[Enter 1] Add Customer");
        System.out.println("[Enter 2] Show All Customers");
        System.out.println("[Enter 3] Exit");
        System.out.print("\nYour choice (1-3): ");
    }
     
    public ClubController(){
        keyBoard = new Scanner(System.in);
        this.readObject();
        body();
        
      
    }
    
     /**
     * This method reads
     * data from file. Deserialization
     */
    public void readObject() {
        try {
            //Creating stream to read the object
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.txt"));
            weekends = (Weekends) in.readObject();
            //closing the stream
            in.close();
        } catch (Exception e) {
            // When the file is empty
            // it auto generates data.
            weekends = new Weekends();
            
        }
    }
    /**
     * This method takes
     * input from the user.
     *
     * @return user input
     */
    public int takeInput() {
        int input;
        try {
            input = Integer.parseInt(keyBoard.nextLine());
        } catch (NumberFormatException e) {
            System.out.print("\nInvalid Input!!! Please Try Again : ");
            input = takeInput();
        }
        return input;
    }
    
    /**
     * This method adds
     * customer to the program.
     */
    public void addCustomer() {
        System.out.print("\nEnter Customer Name : ");
        String name = keyBoard.nextLine().trim();

        if (weekends.isCustomerExists(name)) {
            System.out.println("\nError!!! Customer Name Already Exists!!!");
            return;
        }

        System.out.print("Enter Customer Address : ");
        String address = keyBoard.nextLine();

        System.out.print("Enter Customer Mobile Number : ");
        String mobile = keyBoard.nextLine();

        weekends.addCustomer(new Customer(name, address, mobile));
        System.out.println("\nCustomer " + name + " added successfully.");
    }


      /**
     * This method shows
     * a list of customers
     */
    public void showCustomer() {
        
        weekends.showAllCustomers();
    }
     /**
     * This method saves
     * the data to file and
     * stops the program.
     */
    public void saveAndExit() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.txt"));
            out.writeObject(weekends);
            out.close();
        } catch (IOException i) {
            System.out.println("File Not Found!");
        }
        System.out.println("\nThanks for using Weekend Fitness Club Application!!!");
        System.exit(0);
    }
    
   
    
    private void body(){
       // ClubController cc = new ClubController();
       
          System.out.println("*** Welcome to Weekend Fitness Club (WFC) Application ***");
            
        // Performing while loop
        // until user wants to stop.
        while (true) {
            this.showMenu();
            int choice = this.takeInput();
            switch (choice) {
                case 1:
                     this.addCustomer();
                    break;
               case 2:
                      this.showCustomer();
                      break;
              case 3:
                      this.saveAndExit();
                default:
                    System.out.println("\nOption not Valid!!! Please Try Again");
            }
        }
    }
}