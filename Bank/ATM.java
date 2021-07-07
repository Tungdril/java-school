package Bank;
import java.util.Scanner;

public class ATM {
    
    private String userName, IBAN;
    private double moneyAmount, maxOverdraw;
    private int pin, tries;
    private boolean locked = false;


    public ATM(String userName, String IBAN, double moneyAmount, double maxOverdraw, int pin){
        this.userName = userName;
        this.IBAN = IBAN;
        this.moneyAmount = moneyAmount;
        this.maxOverdraw = maxOverdraw;
        this.pin = pin;

        login();
    }

    public boolean login(){
        Scanner s = new Scanner(System.in);

        System.out.println("------ Bankonto ------");

        System.out.println("Geben Sie Ihren Benutzernamen oder Ihre IBAN ein.");

        String userNameInput = s.next();

        if(userNameInput.equals(userName) || userNameInput.equals(IBAN)){
            return true;
        } else{
            return false;
        }
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
        if(pin == this.pin){
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

    public void displayAmount(int InputPin){
        if(pin == this.pin){
            tries = 0;
            System.out.println("Kontostand: " + moneyAmount);
        }else{
            tries++;
            if (tries == 3){locked = true;}
        }
        
    }
}
