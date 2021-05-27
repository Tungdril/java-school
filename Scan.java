import java.util.Scanner;

public class Scan{

    public static void main(String[] args){
        System.out.println("Bitte geben sie Ihren namen an: ");
        Scanner nameScanner = new Scanner(System.in);
        String name = nameScanner.next();
        nameScanner.close();

        System.out.println("Bitte geben sie Ihren Kontostand an: ");
        Scanner walletScanner = new Scanner(System.in);
        double wallet = walletScanner.nextDouble();
        walletScanner.close();

        if(wallet>0.0){
            System.out.printf(name+" guten Tag! Viel spaß mit Ihren ");
            System.out.printf("%.2f", wallet);
            System.out.printf(" Euro.\n");
        }else{
            System.out.printf(name+", bezahlen Sie ");
            System.out.printf("%.2f", (Math.abs(wallet)));
            System.out.printf(" Euro.\n");
        }
    }

}
