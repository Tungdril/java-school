import java.util.Scanner;
public class SchaltjahrAB {
    public static void main(String[] args) {
        int jahr;
        Scanner eingabe = new Scanner(System.in);

        do {
            System.out.print("Geben Sie das Jahr ein: ");
            jahr = eingabe.nextInt();
            if(jahr == 0 )  {
                System.out.println("Programm Ende!");
                System.exit(0);
            }
            if (istSchaltjahr(jahr)) {
                System.out.println(jahr + " ist ein Schaltjahr!");
            } else {
                System.out.println(jahr + " ist kein Schaltjahr!");
            }
        } while(jahr != 0);
    }

    
    public static boolean istSchaltjahr(int jahr)  {
        boolean back = false;
        if(jahr % 4 == 0)  back = true;
        if(jahr % 100 == 0) back = false;
        if(jahr % 400 == 0) back = true;
        return back;
    }
}

/*
    1. Benötigt um die Scanner-Funktion verwenden zu können
    2. int für das Jahr und boolean um festzustellen ob istSchaljahr wahr oder falsch ist
    3. "==" vergleicht zwei werte und trifft zu wenn sie gleich sind, "!=" vergleicht zwei werte und trifft zu wenn sie ungleich sind
    4. Um zu prüfen ob das jahr durch den nachfolgenden wert teilbar ist oder nicht

*/