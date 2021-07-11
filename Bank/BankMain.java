package Bank;

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.PrintWriter;

public class BankMain {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        //main choice interface
        System.out.println("---------- ATM ----------\n");

        System.out.println("[1] Neues Konto erstellen\n[2] Anmelden\n[3] Beenden");
        int choice0 = s.nextInt();

        switch (choice0) {
            case 1:
                createAccount();
                break;
        
            case 2:
                new ATM();
                break;

            case 3:
                System.exit(0);
                break;
            default:
            System.out.println("Ungültige Eingabe!");
        }
    }

    public static void createAccount(){

        //gets user input for account creation
        Scanner s = new Scanner(System.in);
        System.out.println("---------- Konto erstellen ----------\n");

        System.out.println("Geben Sie den gewünschten Benutzernamen ein: ");
        String userName = s.nextLine();

        System.out.println("Geben Sie Ihre IBAN ein: ");
        String IBAN = s.nextLine();

        System.out.println("Geben Sie Ihre gewünschte PIN ein: ");
        int pin = s.nextInt();

        System.out.println("Wir schenken Ihnen zusätzlich 500€ Startguthaben!\n");
        double moneyAmount = 500.0;
        System.out.println("Sie dürfen Ihr Konto um maximal 1000€ überziehen!\n");
        double maxOverdraw = 1000.0;

        //gives the initialized values to saveLogin
        saveLogin(userName, IBAN, moneyAmount, maxOverdraw, pin); 
    }
    
    public static void saveLogin(String userName,String IBAN, double moneyAmount, double maxOverdraw,int pin){
            //creates the file path and appends the userName
            String path = ("Bank/BankInfo_" + userName);

            //checks if the file/account already exists
            File check = new File(path);
            if(check.exists()){
                System.out.println("Dieser account existiert bereits!\n");
                main(null);
            }

            //writes all the account info to a .txt file (one for each account)
            try(  
                  FileWriter fw = new FileWriter(path);
                  BufferedWriter saveWriter = new BufferedWriter(fw);
                  PrintWriter out = new PrintWriter(saveWriter))
                  { 
                    out.println(userName + "\n" + IBAN + "\n" + moneyAmount + "\n" + maxOverdraw + "\n" + pin + "\n" + "false");
                    saveWriter.close();

                //System.out.println("Account successfully created!");
                main(null);

                }catch (Exception e) {
                System.out.println("Error while creating account!");       
        }
    }
}