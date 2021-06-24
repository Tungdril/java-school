import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class NumberGuessing {
    public static void main(String[] args) {

        int randomNumber = (int) (Math.random()*100);
        boolean found = false;
        int counter = 1;

        System.out.println("Zufallszahl zwischen 0 und 99 wurde generiert. Fange an zu raten!\n"); 
        
           while(found == false){
                try {
            @SuppressWarnings("resource")
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
     System.out.println("Treffer nach "+ counter + " Versuchen!\n");
     save(counter);
     System.out.println("\nNochmal spielen (y/n)?");

     Scanner r = new Scanner(System.in);

     String repeat = r.next();

     if(repeat.equals("y")){
         main(null);
     }else{
         r.close();
        showHS();
         System.exit(0);
     }
  } 

  public static void save(int counter){
      System.out.println("Bitte gib deinen Namen ein:");
      @SuppressWarnings("resource")
      Scanner n = new Scanner(System.in);
      String name = n.nextLine();
      
      try(  FileWriter fw = new FileWriter("Highscores.txt", true);
            BufferedWriter saveWriter = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(saveWriter))
            { 

          if(counter == 1){
              out.println(name + ": " + counter + " Versuch\r\n");
          }else{
            out.println(name + ": " + counter + " Versuche\r\n");
          }

          saveWriter.close();
          System.out.println("Saving successful!");
          
          } catch (Exception e) {
          System.out.println("Error while saving!");
      }
  }

  public static void showHS(){
    try{
        File save = new File("Highscores.txt");
        Scanner readSave = new Scanner(save);
        while(readSave.hasNextLine()){
            String data = readSave.nextLine();
            System.out.println(data);
        }
        readSave.close();
    } catch (Exception e) {
        System.out.println("Errow while reading!");
    }

  }
} 