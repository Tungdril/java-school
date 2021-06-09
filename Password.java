import java.util.Scanner;

public class Password{

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        String bn, pwd;
       
        for(int i = 3; i != 0; i--){

        System.out.println("Noch "+ i + " versuche\n");    

        System.out.println("Bitte Benutzernahmen eingeben: ");
        bn = input.nextLine();

        System.out.println("Bitte Passwort eingeben: ");
        pwd = input.nextLine();

        if(bn.equals("admin") && pwd.equals("geheim")){
            System.out.println("Herzlich Willkommen");
            input.close();
            System.exit(0);  
        } else {
            System.out.println("Ihre Daten sind inkorrekt");
            }   
        } 
        System.out.println("Keine weiteren versuche möglich!"); 
        System.exit(0);     
    }
}
