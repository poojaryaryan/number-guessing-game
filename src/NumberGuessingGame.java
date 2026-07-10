import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.println("********************");
        System.out.println("Number Guessing Game");
        System.out.println("********************");

        boolean playAgain = true;
        int number = 0;

        while(playAgain) {
            number = selectGameMode(sc,random);

            System.out.println("Do you want to play with limited attempts or unlimited attempts?");
            System.out.println("1. Limited Attempts");
            System.out.println("2. Unlimited Attempts");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            while (choice != 1 && choice != 2) {
                System.out.print("Invalid choice! Enter 1 or 2: ");
                choice = sc.nextInt();
            }

            int attempts;

            if (choice == 1) {
                System.out.print("Enter the number of attempts: ");
                attempts = sc.nextInt();
                while (attempts <= 0) {
                    System.out.print("Attempts must be greater than 0. Enter again: ");
                    attempts = sc.nextInt();
                }
            } else {
                attempts = Integer.MAX_VALUE;
            }

            int attemptsUsed = 0;

            int guess = -1;

            while (attempts > 0) {

                System.out.print("Guess a number from " + lb + " to " + ub + ": ");
                guess = sc.nextInt();
                while (guess < lb || guess > ub) {
                    System.out.print("Please enter a number between " + lb + " and " + ub + ": ");
                    guess = sc.nextInt();
                }

                attempts--;
                attemptsUsed++;

                if (guess == number) {
                    break;
                }

                if(attempts > 0){
                    if (guess > number) {
                        System.out.println("Your guess is too high.");
                    } else {
                        System.out.println("Your guess is too low.");
                    }
                }
            }

            if (guess == number) {
                System.out.println("\nYour guess is correct! The number was " + number);
                System.out.println("Attempts used: " + attemptsUsed);
            } else {
                System.out.println("\nNo more attempts left!");
                System.out.println("The correct number was " + number);
            }

            System.out.println("\n==============================");
            System.out.println("Would you like to play again?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.print("Enter choice: ");
            int choice2 = sc.nextInt();

            while (choice2 != 1 && choice2 != 2) {
                System.out.print("Enter a VALID choice: ");
                System.out.println("1. Yes");
                System.out.println("2. No");
                choice2 = sc.nextInt();
            }

            if(choice2==2){
                playAgain = false;
            }
        }

        System.out.println("\nThanks for playing!");

        sc.close();
    }
    public static int lb = 0;
    public static int ub = 0;
    public static int selectGameMode(Scanner sc, Random random){
        int number = 0;
        System.out.println("Select Game Mode: ");
        System.out.println("1. Custom Game --> You can choose the LOWER BOUND and UPPER BOUND.");
        System.out.println("2. Quick Game --> You can choose from PREDEFINED RANGES.");
        System.out.print("Enter choice(1/2): ");
        int choice = sc.nextInt();

        while(choice!=1 && choice!=2){
            System.out.println("Invalid choice!");
            System.out.println("1. Custom Game --> You can choose the LOWER BOUND and UPPER BOUND.");
            System.out.println("2. Quick Game --> You can choose from PREDEFINED RANGES.");
            System.out.print("Enter again: ");
            choice = sc.nextInt();
        }

        if(choice==1){
            System.out.println("Welcome to CUSTOM GAME!");
            System.out.println("Rules:");
            System.out.println("1.Both BOUNDS must be greater(>) than or equal(=) to zero.");
            System.out.println("2.LOWER BOUND must be less than UPPER BOUND.");
            System.out.println("3.UPPER BOUND must be greater than LOWER BOUND.");
            System.out.println("4.Both LOWER BOUND and UPPER BOUND entered will be INCLUSIVE.");

            System.out.print("Enter LOWER BOUND: ");
            int lowerBound = sc.nextInt();
            while(lowerBound<0){
                System.out.print("Invalid. Enter LOWER BOUND again: ");
                lowerBound = sc.nextInt();
            }
            System.out.print("Enter UPPER BOUND: ");
            int upperBound = sc.nextInt();
            while((upperBound<0) || (upperBound<=lowerBound)){
                if(upperBound<0){
                    System.out.print("Invalid. Enter UPPER BOUND again: ");
                    upperBound = sc.nextInt();
                }
                else{
                    System.out.println("UPPER BOUND cannot be less than LOWER BOUND.");
                    System.out.print("Enter UPPER BOUND again: ");
                    upperBound = sc.nextInt();
                }
            }
            number = random.nextInt(lowerBound,upperBound+1);
            lb = lowerBound;
            ub = upperBound;
            System.out.println("Your range is: " + lowerBound + "-" + upperBound);
        }
        else{
            System.out.println("Welcome to QUICK GAME!");
            System.out.println("Available Ranges");
            System.out.println("1. 1-50");
            System.out.println("2. 1-100");
            System.out.println("3. 1-500");
            System.out.println("4. 1-1000");
            System.out.print("Enter choice: ");
            int quickGameChoice = sc.nextInt();
            while(quickGameChoice<1 || quickGameChoice>4){
                System.out.println("Invalid. Enter valid choice: ");
                quickGameChoice = sc.nextInt();
            }
            switch(quickGameChoice){
                case 1 :
                    number = random.nextInt(1,51);
                    System.out.println("Selected range: 1-50");
                    lb = 1;
                    ub = 50;
                    break;
                case 2 :
                    number = random.nextInt(1,101);
                    System.out.println("Selected range: 1-100");
                    lb = 1;
                    ub = 100;
                    break;
                case 3 :
                    number = random.nextInt(1,501);
                    System.out.println("Selected range: 1-500");
                    lb = 1;
                    ub = 500;
                    break;
                case 4 :
                    number = random.nextInt(1,1001);
                    System.out.println("Selected range: 1-1000");
                    lb = 1;
                    ub = 1000;
                    break;
            }

        }
        return number;
    }
}
