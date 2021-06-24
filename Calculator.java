import java.util.Scanner;

public class Calculator {
    public static void main(String [] args){
        //graphical start menu (sort of)
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("[1] Do you wish to perform simple mathematical operation (+, -, *, /)? \n[2] Or calculate a checksum?");
        System.out.println("[3] Quit the Program");
        System.out.println("-----------------------------------------------------------------------------------------------------");

        //used to ignore memory leak warning, as it is irrelevant
        @SuppressWarnings("resource")
        //first input to decide if calc() or check() is called
        Scanner ty = new Scanner(System.in);
        int type = ty.nextInt();
        
        if(type == 1){
            calc();
        } else if (type == 2){
            check();
        }else if (type == 3){
            System.exit(0);
        }else {
            //input mismatch handling
            System.out.println("Invalid choice, try again.\n");
            main(null);
        }
    }

    public static void calc(){
        //initialize variables
        double first, second, solution;
        String operator;

        //pseudo graphic stuff, the second:
        System.out.println("------------------");
        System.out.println("--- Calculator ---");
        System.out.println("------------------\n");

        @SuppressWarnings("resource")
        //scanner used for getting the numbers and operators
        Scanner in = new Scanner(System.in);
        
        //gets the value for first, second and mathimatical operator from the user 
        try {
        System.out.println("Enter the first number of the calculation:");
        first = in.nextDouble();

        System.out.println("Enter the secound number of the calculation:");
        second = in.nextDouble();

        System.out.println("Enter the mathematical operation you wih to perform (+, -, *, /):");
        operator = in.next();

        //coverts the string operator to a char, for efficiency and readability I guess
        char operatorChar = operator.charAt(0);

        //calculates the result based on the given operator, prints the solution and calls repeat()
        //repeat(false) is used, since we are not using the check() method, explained later on
        switch(operatorChar){
            case '+':
            solution = first + second;
            System.out.println("\n" + first + " " + operatorChar + " " + second + " = " + solution);
            repeat(false);
            break;

            case '-':
            solution = first - second;
            System.out.println("\n" + first + " " + operatorChar + " " + second + " = " + solution);
            repeat(false);
            break;

            case '*':
            solution = first * second;
            System.out.println("\n" + first + " " + operatorChar + " " + second + " = " + solution);
            repeat(false);
            break;

            case '/':
            solution = first / second;
            System.out.println("\n" + first + " " + operatorChar + " " + second + " = " + solution);
            repeat(false);
            break;

            default: 
            ////input mismatch handling for operator alone
            System.out.println("Please enter a valid operator!\n");
            calc();
        }
        } catch (Exception e) {
            //input mismatch handling
            System.out.println("Invalid input, try again.\n");
            calc();
        }
    }

    public static void check(){
        //this is used so repeat() calls this method again, instead of calc() 
        boolean isCheck = true;
        
        //pseudo graphic stuff, the third:
        System.out.println("----------------");
        System.out.println("--- Checksum ---");
        System.out.println("----------------\n");

        @SuppressWarnings("resource")
        //scanner for initial number input
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the number you wish to calculate a checksum with (whole numbers only!):");

        //calculates the checksum of the input
        try {
            long number = in.nextLong();
            
            long checksum = 0L;

            while(number > 0){
                checksum = checksum + (number % 10);
                number = number - (number % 10);
                number = number/10;
            }
            System.out.println("Result: " + checksum);
            //calls repeat and tells it isCheck is true
            repeat(isCheck);

        } catch (Exception e) {
            //input mismatch handling
            System.out.println("Invalid input, try again.\n");
            check();
        }
    }
    
    public static void repeat(boolean isCheck){
        //gives the user the opportunity to calculate as much as he wants, without getting thrown out after each operation
        System.out.println("\nDo you wish to calculate another problem? (y/n)");
        System.out.println("Pressing 'm' will return you to the main menu!");

        @SuppressWarnings("resource")
        Scanner ag = new Scanner(System.in);
        String again = ag.next();

        //converts string again to a char for ease of use
        char againChar = again.charAt(0);

        if(againChar == 'y' && isCheck == false){
            calc();
        }else if (againChar == 'y' && isCheck == true){
            check();
        }else if (againChar == 'n'){
            //quits the program
            System.exit(0);
        } else if (againChar == 'm'){
            main(null);
        } else {
            //returns user to main menu
            System.out.println("Invalid choice, returning to menu!");
            main(null);
        }
    }
}