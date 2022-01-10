package realestate;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import realestate.model.RealEstate;


/**
 *
 * @author todo
 */
public class Main {

    //ATTRIBUTES
    private List<String> menu;
    private RealEstate mymodel;
    private boolean exit;
  

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main ap = new Main();
        ap.run();
    }

    /**
     * Run application
     * 
     */
    private void run() {
        //Instantiate Model
        this.mymodel = new RealEstate();
        //Init main menu
        this.menu = new ArrayList<>();
        generateMenu();
        exit = false;
        do {
            System.out.println("\n**** Real State ****");
            int choice = displaySelector(menu);
            switch (choice) {
                case 0 ->
                    exitApp();
                case 1 ->
                    listAll();
                case 2 ->
                    listHouses();
                case 3 ->
                    listPremises();
            }
        } while (!exit);
    }

    /**
     *  Creates app main menu
     */
    private void generateMenu() {
        menu.add("Exit.");
        menu.add("List All.");
        menu.add("List Houses.");
        menu.add("List Premises.");
    }

    //CONTROL METHODS
    /**
     * 
     */
    private void exitApp() {
        System.out.println("GOOD BYE!\n");
        exit = true;
    }

    /**
     * TODO
     */
    private void listAll() {
        alert("List all...");     
    }

    /**
     * TODO
     */
    private void listHouses() {
       alert("List all Houses...");    
    }

    /**
     * TODO
     */
    private void listPremises() {
        alert("List all Premises...");    
    }

    //VIEW METHODS 
    /**
     * 
     * display menu to select an option to do at hotel.
     *
     * @param options is List of options of menu
     * @return the number of the option selected by user or -1 in case of error
     */
    private int displaySelector(List<String> options) {
        Scanner sc = new Scanner (System.in);
        int option;
        for (int i = 0; i < options.size(); i++) {
            System.out.format("%d. %s \n", i, options.get(i));
        }
        System.out.print("Select an option: ");
        try {
            option = sc.nextInt();
        } catch (InputMismatchException ime) {
            option = -1;
        }
        return option;
    }

    private void alert(String msg) {
        System.out.println(msg);
    }
}
