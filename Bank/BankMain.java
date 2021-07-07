package Bank;

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class BankMain {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        System.out.println("Möchten sie ein neues Konto erstellen? [1]\n Oder sich anmelden? [2]");
        int choice0 = s.nextInt();

        switch (choice0) {
            case 1:
                createAccount();
                break;
        
            case 2:
                login();
                break;
        }
    }

    public static void createAccount(){
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

        saveLogin();

        ATM newAccount = new ATM(userName,IBAN,moneyAmount,maxOverdraw,pin);
    }
    
    public static void login(){
        ATM login = new login();
    }

    private void saveLogin(String userName,String IBAN, double moneyAmount, double maxOverdraw,int pin){
            Scanner n = new Scanner(System.in);
            String name = n.nextLine();
            
            try(  FileWriter fw = new FileWriter("BankInfo.txt", true);
                  BufferedWriter saveWriter = new BufferedWriter(fw);
                  PrintWriter out = new PrintWriter(saveWriter))
                  { 
                    out.println(userName+IBAN+moneyAmount+maxOverdraw+pin);}
      
                saveWriter.close();
                System.out.println("Saving successful!");
                
                }catch (Exception e) {
                System.out.println("Error while saving!");
        }
}
