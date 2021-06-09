import java.util.Scanner;

public class Password{

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        String bn;
        String pwd;
        System.out.println("Bitte Benutzernahmen eingeben: ");
        bn = input.nextLine();

        System.out.println("Bitte Passwort eingeben: ");
        pwd = input.nextLine();

        if(bn.equals("admin") && pwd.equals("geheim")){
            System.out.println("Herzlich Willkommen");
        } else {
            System.out.println("Ihre Daten sind inkorrekt");
            input.close();
            System.exit(0);         
        }    
    }
}