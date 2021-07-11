package Bank;
import java.util.Scanner;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ATM {
   
    private static String path;
    private String userName;
    private String IBAN;
    private double moneyAmount, maxOverdraw;
    private static boolean locked = false;
    private int pin;
    

    ATM(){

        //login successfull (starts login)
        if(login() == true){

            //initialize variables from file
            try {
                this.userName = Files.readAllLines(Paths.get(path)).get(0);
                this.IBAN = Files.readAllLines(Paths.get(path)).get(1);
                //converts String to Double
                this.moneyAmount = Double.valueOf(Files.readAllLines(Paths.get(path)).get(2));
                this.maxOverdraw = Double.valueOf(Files.readAllLines(Paths.get(path)).get(3));
                //converts String to int
                this.pin = Integer.parseInt(Files.readAllLines(Paths.get(path)).get(4));
            } catch (Exception e) {
                System.out.println(e);
            }
            
            menu();          
        }else{
           System.exit(1);
        }
    }

    public void menu(){

        //main menu, user is always returned here (after login)
        System.out.println("\n-------- Hauptmenü --------\n");
            System.out.println("[1] Kontostand einsehen\n[2] Geld einzahlen\n[3] Geld auszahlen\n[4] Geld überweisen\n[5] Beenden\n");

            Scanner s = new Scanner(System.in);
            int c = s.nextInt();

            switch (c) {
                case 1:
                    displayAmount();
                    break;

                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;

                case 4:
                    transfer();
                    break;

                case 5:
                    System.exit(2);
                    break;
            
                default:
                System.out.println("Ungültige Eingabe!");
                menu();
            }
    }

    public static boolean login(){

            System.out.println("---------- Bankonto ----------\n");
            System.out.println("Geben Sie Ihren Benutzernamen ein:");

            //gets user input for userName
            Scanner s = new Scanner(System.in);
            String userNameInput = s.nextLine();

            //creates the file path
            path = ("Bank/BankInfo_" + userNameInput);

            //checks if the account exits
            File check = new File(path);
            if(!check.exists()){
                System.out.println("Dieser Account existiert nicht!\n");
                login();
            }

        try {

            //checks if the account is locked
            String lockedCompare = Files.readAllLines(Paths.get(path)).get(5);

            if(lockedCompare.equals("true")){
                System.out.println("Dieser Account wurde gesperrt!");
                System.exit(-1);
            }

            File info = new File(path);
            Scanner readInfo = new Scanner(info);

            //checks if user input and line 0 (userName) & line 4 (pin) match
            String pinCompare = Files.readAllLines(Paths.get(path)).get(4);
            readInfo.close();

            //3 tries to get pin right, otherwise account is locked
            for(int tries = 3; tries != 0; tries--){

                System.out.println("Geben Sie Ihre PIN ein:");
                String userPinInput = s.nextLine();

                if (userPinInput.equals(pinCompare)) {
                    return true;
                } else if (!userPinInput.equals(pinCompare) && tries > 1){
                    System.out.println("Falsche PIN!\nSie können es noch "+ (tries - 1) + " mal versuchen!");
                    } 
                }
                locked = true;
                return false;
      
        } catch (Exception e) {
            //System.out.println("Error while logging in!"); 
        }
            return false;    
    }

    public void deposit(){

        System.out.println("Geben Sie den Betrag ein, den Sie einzahlen möchten:");
        Scanner s = new Scanner(System.in);

        double depositAmount = s.nextDouble();

        //if depositAmount is positive, write that to the account file
        if(depositAmount > 0){
          this.moneyAmount = this.moneyAmount + depositAmount;  
          updateFile(this.moneyAmount);
          
          try {
            System.out.println("[Enter] Zurück zum Hauptmenü");
            System.in.read();
            menu();
          } catch (Exception e) {
              System.out.println(e);
          }
          
        }else{
            System.out.println("Ungültige Eingabe!");
            menu();
        }   
    }
    
    public void withdraw(){

        System.out.println("Geben Sie den Betrag ein, den Sie auszahlen möchten:");
        Scanner s = new Scanner(System.in);

        double withdrawAmount = s.nextDouble();

        ////if withdrawAmount is positive or not higher than maxOverdraw, write that to the account file
        if(withdrawAmount <= (this.moneyAmount + this.maxOverdraw)){
          this.moneyAmount = this.moneyAmount - withdrawAmount;  
          updateFile(this.moneyAmount);
          
          try {
            System.out.println("[Enter] Zurück zum Hauptmenü");
            System.in.read();
            menu();
          } catch (Exception e) {
              System.out.println(e);
          }
          
        }else{
            System.out.println("Eingabe übersteigt das Dispo-Limit!");
            menu();
        }

    }

    public void displayAmount(){

    //needs to be in try_catch for System.in.read()
    try {
        System.out.println("Kontostand: " + this.moneyAmount + "€");

        //return to menu
        System.out.println("[Enter] Zurück zum Hauptmenü");
        System.in.read();
        menu();

        }catch (Exception e) {
            System.out.println("Error while reading file");
        }     
    }

    public void transfer(){
        Scanner s = new Scanner(System.in);

        //user input
        System.out.println("Geben Sie die IBAN ein, an die sie überweisen möchten:");
        String sendToIban = s.nextLine();

        System.out.println("Geben Sie den Namen des Empfägers ein:");
        String sendToName = s.nextLine();

        System.out.println("Geben Sie den Betrag ein, den Sie senden möchten:");
        Double sendAmount = s.nextDouble();

        //if sendAmount is positive or not higher than maxOverdraw AND transferWriter() returned true, write that to user file
        if(sendAmount <= (this.moneyAmount + this.maxOverdraw) && transferWriter(sendToIban, sendToName, sendAmount) == true){
            this.moneyAmount = this.moneyAmount - sendAmount;  
            updateFile(this.moneyAmount); 
          }else if(sendAmount <= (this.moneyAmount + this.maxOverdraw) && transferWriter(sendToIban, sendToName, sendAmount) == true){
              System.out.println("Eingabe übersteigt das Dispo-Limit!");
              menu();
          }else if(transferWriter(sendToIban, sendToName, sendAmount) == false){
             System.out.println("Empfänger und IBAN stimmen nicht überein!");
             menu();
          }

          try {
            System.out.println("[Enter] Zurück zum Hauptmenü");
            System.in.read();
            menu();
          } catch (Exception e) {
              System.out.println(e);
          }
    }

    public void updateFile(double moneyAmount){

        //updates the current acount if values changed (needs to rewrite everything, can't adress only one line)
        try(  
                  FileWriter fw = new FileWriter(path);
                  BufferedWriter saveWriter = new BufferedWriter(fw);
                  PrintWriter out = new PrintWriter(saveWriter))
                  { 
                    out.println(this.userName + "\n" + this.IBAN + "\n" + moneyAmount + "\n" + this.maxOverdraw + "\n" +this.pin + "\n" + locked);
                    saveWriter.close();
                }catch (Exception e) {
                    System.out.println("Error while writing to file!");
        }
    }

    public boolean transferWriter(String sendToIban, String sendToName, Double sendMoneyAmount){
   
        try{   

            //gets all the info from the account that is being transfered to
            String receiver = ("Bank/BankInfo_" + sendToName);
        
            String ibanCompare = Files.readAllLines(Paths.get(receiver)).get(1);
            Double moneyCompare = Double.valueOf(Files.readAllLines(Paths.get(receiver)).get(2));

            //calculates the new balance
            Double rewriteMoney = moneyCompare + sendMoneyAmount;
    
            //needed to rewrite all lines later, otherwise these would be wiped
            String rewriteName = Files.readAllLines(Paths.get(receiver)).get(0);
            String rewriteOverdraw = Files.readAllLines(Paths.get(receiver)).get(3);
            String rewritePin = Files.readAllLines(Paths.get(receiver)).get(4);
            String rewriteLocked = Files.readAllLines(Paths.get(receiver)).get(5);
    
            //if the IBAN given matches the one in the file AND the name given matches the one in the file, write that to the file
            if(sendToIban.equals(ibanCompare) && sendToName.equals(rewriteName)){

                FileWriter fw = new FileWriter(receiver);
                BufferedWriter saveWriter = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(saveWriter);
                  
                out.println(rewriteName + "\n" + ibanCompare + "\n" + rewriteMoney + "\n" + rewriteOverdraw + "\n" +rewritePin + "\n" + rewriteLocked);
                saveWriter.close();

                return true;
            }else{
                return false;
            }

            }catch (Exception e) {
                    //System.out.println("Error while writing to file!");
                }
            return false;
    }
}