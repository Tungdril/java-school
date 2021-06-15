import java.util.Scanner;
public class Loops {
    
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            System.out.println(i);
        } System.out.println("\n---------------------\n");

        String text = "";

        while (text.length()<10){
            text = text + "a";
            System.out.println(text);
        } 

        do{ 
            text = text.substring(0, text.length()-1);
            System.out.println(text);
        }while (text.length() > 0);

        subtract();
    }

    static void subtract(){
        for (int i = 1000; i >= 0; i = i-5){
            System.out.println(i + " Euro");
        }
        System.out.println("\n---------------------\n");
        saveMoney();
    }

    static void saveMoney(){
        double cap, interest;
        int years;

        Scanner input = new Scanner(System.in);

        System.out.println("Wie viel Geld möchten Sie einzahlen?");
        cap = input.nextDouble();

        System.out.println("Ihre anlegezeit in jahren?");
        years = input.nextInt();

        System.out.println("Zu welchem Zinssatz?");
        interest = input.nextDouble();

        for (int i = 0; i < years; i++){
            cap = cap * (1+ interest/100);
        }
        
        System.out.printf("Endsumme in €: "+"%2.2f", cap);
        input.close();
        System.exit(0);
    }
}