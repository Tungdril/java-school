import java.util.Scanner;

public class Schaltjahr {
    public static void main(String[] args){
        //visual stuff
        System.out.println("\n-------------------------");
        System.out.println("    Schaltjahrrechner");
        System.out.println("-------------------------\n");
        System.out.print("Bitte gib das gewünschte Jahr ein: ");

        //get user input
        Scanner year = new Scanner(System.in);
        int yearInput = year.nextInt();

        //ends the program if the user inputs 0 as yearInput
        if(yearInput == 0){
            System.out.println("\nJahr 0 ist ungültig!");
            System.exit(0);
        }

        //if get calc()'s return value and run the if-block
        if(calc(yearInput) == true){
            System.out.println("\n" + yearInput + " ist ein Schaltjahr!");        
        }else {
            System.out.println("\n" + yearInput + " ist kein Schaltjahr!");
        }
        main(null);
    }
  
    //calculate leapYear and returns true if yearInput is: divisible by 4 AND NOT divisible by 100 OR divisible by 400
    public static boolean calc(int yearInput){
        if(yearInput % 4 == 0 && yearInput % 100 != 0 || yearInput % 400 == 0){
            return true;

        }else{
            return false;
        }
    }
}