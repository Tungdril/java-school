public class Kassenbon {

//defines items
static String item = "Cheese";
static String item1 = "Meat";
static String item2 = "Bread";
static String item3 = "Milk";
//defines amount of items
static int itemAmount = 1;
static int item1Amount = 1;
static int item2Amount = 2;
static int item3Amount = 3;
//defines price of items
static double itemPrice = 4.60;
static double item1Price = 7.50;
static double item2Price = 3.20;
static double item3Price = 1.90;
//calculates the total price (amount*price)
static double itemTotal = itemAmount*itemPrice;
static double item1Total = item1Amount*item1Price;
static double item2Total = item2Amount*item2Price;
static double item3Total = item3Amount*item3Price;
//defines the wallet amount
static double wallet = 25; 
//calculates the total end price
static double totalPrice=itemTotal+item1Total+item2Total+item3Total;
    public static void main(String[] args) throws Exception {
        if(totalPrice<=wallet){//does the wallet cover the purchase amount?
            //prints the first item block with the: item name, amount, the price per item and the total cost for the block
            System.out.printf(item+"\t"+itemAmount+" x   "+"%.2f",+itemPrice); 
            System.out.printf(" EUR");            
            System.out.printf("\n\t\t\t"+"%.2f",itemTotal);
            System.out.printf(" EUR\n");
            //prints the second item block with the: item name, amount, the price per item and the total cost for the block
            System.out.printf(item1+"\t"+item1Amount+" x   "+"%.2f",+item1Price);
            System.out.printf(" EUR");            
            System.out.printf("\n\t\t\t"+"%.2f",item1Total);
            System.out.printf(" EUR\n");
            //prints the third item block with the: item name, amount, the price per item and the total cost for the block    
            System.out.printf(item2+"\t"+item2Amount+" x   "+"%.2f",+item2Price);
            System.out.printf(" EUR");            
            System.out.printf("\n\t\t\t"+"%.2f",item2Total);
            System.out.printf(" EUR\n");
            //prints the fourth item block with the: item name, amount, the price per item and the total cost for the block
            System.out.printf(item3+"\t"+item3Amount+" x   "+"%.2f",+item3Price);
            System.out.printf(" EUR");            
            System.out.printf("\n\t\t\t"+"%.2f",item3Total);
            System.out.printf(" EUR\n");

            System.out.printf("---------------------------------\n"); //graphic seperator

            double total = itemTotal+item1Total+item2Total+item3Total; //calculates the total amount due
            System.out.printf("total:\t\t\t%.2f",+total);
            System.out.printf(" EUR\n");

            System.out.printf("given:\t\t\t%.2f",+wallet);  //basically just prints the wallet amount, rounding was too hard for now
            System.out.printf(" EUR\n\n");

            System.out.printf("return:\t\t\t%.2f",+(wallet-total)); //calculates the return due
            System.out.printf(" EUR\n\n");
            System.exit(0); //quits java

        }else{ //prints the difference if there is not enough money in the wallet
            double difference = totalPrice-wallet;
            System.out.printf("You're missing %.2f",+difference);
            System.out.printf(" EUR");
            System.exit(0);
        }
    }
}
