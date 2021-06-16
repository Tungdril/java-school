import java.util.Scanner;

public class NumberGuessing {
    public static void main(String[] args) {

        int randomNumber = (int) (Math.random()*100);
        boolean found = false;
        int counter = 1;

        System.out.println("Zufallszahl zwischen 0 und 99 wurde generiert. Fange an zu raten!\n"); 
        
           while(found == false){
                try {
            Scanner guess = new Scanner(System.in);

            System.out.println("Zahl: ");
            int guessedNumber = guess.nextInt();

            if(guessedNumber == randomNumber){
                found = true;
            }else if(guessedNumber > randomNumber){
                System.out.println(counter + ". Versuch: Zu groß!");
                counter++;
            }else if(guessedNumber < randomNumber){
                System.out.println(counter + ". Versuch: Zu klein!"); 
                counter++;
                }
            }catch (Exception e) {
                System.out.println("Das ist keine gültige Zahl!");
        }
    }
     System.out.println("Treffer nach "+ counter + " Versuchen!"); 
     System.out.println("Nochmal spielen (y/n)?");

     Scanner r = new Scanner(System.in);

     String repeat = r.next();

     if(repeat.equals("y")){
         main(null);
     }else{
         r.close();
         System.exit(0);
     }
  } 
}
    
        
 

