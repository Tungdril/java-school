import java.util.Scanner;

public class Password{

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String bn, pwd;
       
        for(int i = 3; i != 0; i--){

        System.out.println("Sie können es noch "+ i + " mal versuchen\n");    

        System.out.println("Bitte Benutzernahmen eingeben: ");
        bn = input.nextLine();

        System.out.println("Bitte Passwort eingeben: ");
        pwd = input.nextLine();

        if(bn.equals("admin") && pwd.equals("geheim")){
            System.out.println("Herzlich Willkommen");
            input.close();
            System.exit(0);  
        } else {
            System.out.println("Ihre Daten sind inkorrekt\n");
            }   
        } 
        System.out.println("Keine weiteren Versuche möglich! \n Bitte wenden Sie sich an einen Administrator."); 
        System.exit(0);     
    }
}
