import java.util.*;

public class KassenbonList {

    static ArrayList<String> items = new ArrayList<>();
    static int amount=0;
    


    public static void main(String[] args){
        boolean breakLoop = false;
        while(breakLoop==false){
            System.out.println("\nMöchten sie ein Lebensmittel hinzufügen oder den kauf abschließen? \n");
            System.out.println("1: Lebensmittel hinzufügen\n2: Kauf abschließen");
            Scanner a = new Scanner(System.in);
            int itemAdd = a.nextInt();
            switch(itemAdd){
                case 1:
                System.out.println("\nBitte geben sie die gewünschten Lebensmittel an: ");
                Scanner s = new Scanner(System.in);
                String item = s.nextLine();
                items.add(item);

                System.out.println("\nBitte geben sie die gewünschten menge an: ");
                Scanner am = new Scanner(System.in);
                amount = am.nextInt();
                

                System.out.printf("---------------------------------\n"); //graphic seperator
                break;
                case 2:
                breakLoop = true;
                print();
                break;
            }
        }    
    }
    static void print(){
        double price = (Math.random()*15.0+1.0);

        for (int i = 0;i<items.size(); i++){       
            String printItem = items.get(i);       
            System.out.printf(printItem+"\t 1 x "+"%.2f", price);
            System.out.printf(" EUR\n"); 
        }
        
    }
}

//TODO item amount with price multiplication and print, add total price, given and return value
