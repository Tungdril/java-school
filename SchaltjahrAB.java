import java.util.Scanner;
import java.time.*;
public class SchaltjahrAB {
    public static void main(String[] args) {
        int jahr;
        Scanner eingabe = new Scanner(System.in);

        do {
            System.out.print("Geben Sie das Jahr ein: ");
            jahr = eingabe.nextInt();
            if(jahr == 0 )  {
                System.out.println("Programm Ende!");
                eingabe.close();
                System.exit(0);
            }
            if (istSchaltjahr(jahr) == true && isPast(jahr) == false) {
                System.out.println(jahr + " ist ein Schaltjahr!");

            } else if (istSchaltjahr(jahr) == false && isPast(jahr) == false){
                System.out.println(jahr + " ist kein Schaltjahr!");

            } else if ((istSchaltjahr(jahr) == true && isPast(jahr) == true)){
                System.out.println(jahr + " war ein Schaltjahr!");

            } else if (istSchaltjahr(jahr) == false && isPast(jahr) == true){
                System.out.println(jahr + " war kein Schaltjahr!");
            } 
        } while(jahr != 0);
    }

    // I hate this, see Schaltjahr.java for a better implementation
    public static boolean istSchaltjahr(int jahr)  {
        boolean back = false;
        if(jahr % 4 == 0)  back = true;
        if(jahr % 100 == 0) back = false;
        if(jahr % 400 == 0) back = true;
        return back;
    }

//code above, with the exception of the implementation of isPast was provided by the teacher and I can't change it
public static boolean isPast(int jahr){
    int currentYear = Year.now().getValue();
    if(jahr < currentYear){
        return true;
    }else {
        return false;
    }
    }
}