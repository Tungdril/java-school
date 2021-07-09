package Bank;
import java.util.Scanner;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ATM {
    
    private static String userName;
    private static String IBAN;
    private double moneyAmount, maxOverdraw;
    private int pin, tries;
    private boolean locked = false;


    ATM(String userName, String IBAN, double moneyAmount, double maxOverdraw, int pin){
        this.userName = userName;
        this.IBAN = IBAN;
        this.moneyAmount = moneyAmount;
        this.maxOverdraw = maxOverdraw;
        this.pin = pin;

        login();
    }

    public static boolean login(){
        
        try {
            Scanner s = new Scanner(System.in);
            File info = new File("Bank/BankInfo.txt");
            Scanner readInfo = new Scanner(info);

            String userNameCompare = Files.readAllLines(Paths.get("Bank/BankInfo.txt")).get(0);
            readInfo.close();
            System.out.println("------ Bankonto ------\n");
            System.out.println("Geben Sie Ihren Benutzernamen ein:");

            String userNameInput = s.nextLine();

            if(userNameInput.equals(userNameCompare)){
                System.out.println("Login successful!");  
            return true;
            } else{
                System.out.println("Login unsuccessful!");   
            return false;}
        } catch (Exception e) {
        }
            return false;    
    }
    

    public double getAmount(int pin){
        if(pin == this.pin){
            tries = 0;
            return this.moneyAmount;
        }else{
            System.out.println("Falsche Pin, versuchen Sie es erneut");
            tries++;
            if (tries == 3){locked = true;}
            return 0.0;
        }
        
    }

    public boolean deposit(double depositAmount){
        if(depositAmount > 0.0){
            this.moneyAmount = this.moneyAmount + depositAmount;
            return true;
        }else{
            return false;
        }     
    }
    
    public boolean withdraw(double withdrawAmount, int inputPin){
        if(inputPin == this.pin){
            tries = 0;
            if(withdrawAmount <= this.moneyAmount){
            moneyAmount = moneyAmount - withdrawAmount;

            return true;
        } else{
            return false;
        }
        }else{
            tries++;
            if (tries == 3){locked = true;}
            return false;
        }
        
    }

    public void displayAmount(int inputPin){
        if(inputPin == this.pin){
            tries = 0;
            System.out.println("Kontostand: " + moneyAmount);
        }else{
            tries++;
            if (tries == 3){locked = true;}
        }
        
    }
}
