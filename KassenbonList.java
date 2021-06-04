import java.util.Scanner;
import java.util.ArrayList;

public class KassenbonList {
    //creates 2 new lists for items and amount, items are always parallel e.g. [item5;amount5], [item10;amount10]...
    static ArrayList<String> items = new ArrayList<>(); 
    static ArrayList<Integer> amounts = new ArrayList<>();
    
    //initializes two variables which are needed later
    static int amount=0;
    static double totalPrice = 0.0; 
    
    public static void main(String[] args){
        boolean breakLoop = false;

        while(breakLoop==false){
            System.out.println("\nMöchten Sie ein Lebensmittel hinzufügen oder den Kauf abschließen? \n");
            System.out.println("1: Lebensmittel hinzufügen\n2: Kauf abschließen");
            Scanner a = new Scanner(System.in);
            int itemAdd = a.nextInt();  //1 or 2?

            switch(itemAdd){
                case 1:
                System.out.println("\nBitte geben Sie das gewünschte Lebensmittel an: ");
                Scanner s = new Scanner(System.in);
                String item = s.nextLine();
                items.add(item);    //adds the user input to the list items

                System.out.println("\nBitte geben Sie die gewünschte Menge an: ");
                Scanner am = new Scanner(System.in);
                amount = am.nextInt();
                amounts.add(amount);    //adds the user input to the list amounts

                System.out.printf("----------------------------------------\n");    //graphical seperator, got a few of these
                break;
                case 2:
                breakLoop = true;
                print();    //continues to print() to display the items
                break;
                default: //if user didn't give 1 or 2 as input 
                System.out.printf("Bitte wähle 1 oder 2!\n");
            }
        }    
    }

    public static void print(){  
        if(items.size()>0){     //runs only if the user put something in the list
          System.out.printf("\n----------------------------------------\n");   

          //runs the loop as many times as there are items in the list    
          for (int i = 0;i<items.size(); i++){ 
            //creates a random price between 1.00 and 15.00, and rounds to two decimal places  
            double price = Math.round((Math.random()*15.0+1.0)*100.0)/100.0; 

            double totalItemPrice = price*amounts.get(i);   //calculates the price the items multiplied by their amounts
            
            totalPrice = totalPrice+totalItemPrice;     //adds the totalItemPrice to the total price of all items combined

            //converts the current index value of the list to a string, easier to read and work with
            String printItem = items.get(i);       
            int printAmount = amounts.get(i);

            //prints the name, amount, price and total price for the current index value
            System.out.printf(printItem+"\t\t "+printAmount+" x "+"%2.2f", price);
            System.out.printf(" EUR\n"); 
            System.out.printf("\n\t\t\t\t"+"%3.2f", totalItemPrice);
            System.out.printf(" EUR\n");
        }  
     }else{     //informs the user of his failure to comply to basic instructions
        System.out.printf("Es wurden keine Lebensmittel hinzugefügt. Bitte erneut versuchen!\n");
        try {
            Thread.sleep(3000);     //gives the user time to read, need try-catch for this reason only
        } catch (Exception e) {
            System.out.println(e);
        }
        main(null);     //gives the user another chance to put some items in the list 
     } 
     //prints the total price
     System.out.printf("----------------------------------------\n"); 
     System.out.printf("Gesamt:\t\t\t\t%4.2f",+totalPrice);
     System.out.printf(" EUR\n");
     System.out.printf("----------------------------------------\n"); 

     //asks the user the amount he wants to give
     System.out.println("\nWie viel Geld möchten Sie geben?\n");
     Scanner m = new Scanner(System.in);
     double money = m.nextInt();
     if(money>=totalPrice){     //can the user input cover the total price?
        //prints total, given and returned money 
        System.out.printf("\n----------------------------------------\n"); 
        System.out.printf("Gesamt:\t\t\t\t%4.2f",+totalPrice);
        System.out.printf(" EUR\n");
        System.out.printf("Gegeben:\t\t\t%4.2f",+money);
        System.out.printf(" EUR\n\n");
        System.out.printf("Zurück: \t\t\t%3.2f",+(money-totalPrice));
        System.out.printf(" EUR\n\n");
        try {
            Thread.sleep(3000);
            System.exit(0);
        } catch (Exception e) {
            System.out.println(e);
        }
     }else{     //quits the program if the user refuses to pay enough money
        System.out.printf("Das reicht leider nicht aus.\n");
        try {
            Thread.sleep(2000);
            System.exit(0);
            m.close();
        } catch (Exception e) {
            System.out.println(e);
        }
     }                
    }
}