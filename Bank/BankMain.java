package Bank;

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;

//TODO implement txt, solve static reference error, get the rest working


public class BankMain {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        System.out.println("Möchten sie ein neues Konto erstellen? [1]\nOder sich anmelden? [2]");
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

    public static void initialize(String userName,String IBAN, double moneyAmount, double maxOverdraw,int pin){
        ATM newAccount = new ATM(userName,IBAN,moneyAmount,maxOverdraw,pin);
    }

    public static void createAccount(){

        //clears BankInfo.txt
        PrintWriter pw;
        try {
            pw = new PrintWriter("BankInfo.txt"); 
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
       
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

        saveLogin(userName, IBAN, moneyAmount, maxOverdraw, pin); 
    }
    
    public static void login(){
        //ATM login = new ATM();

    }

    public static void saveLogin(String userName,String IBAN, double moneyAmount, double maxOverdraw,int pin){

            try(  FileWriter fw = new FileWriter("BankInfo.txt", true);
                  BufferedWriter saveWriter = new BufferedWriter(fw);
                  PrintWriter out = new PrintWriter(saveWriter))
                  { 
                    out.println(userName + "\n" + IBAN + "\n" + moneyAmount + "\n" + maxOverdraw + "\n" + pin);
                    saveWriter.close();

                System.out.println("Account successfully created!");

                }catch (Exception e) {
                System.out.println("Error while creating account!"); 

                initialize(userName, IBAN, moneyAmount, maxOverdraw, pin); 
        }
    }
}



