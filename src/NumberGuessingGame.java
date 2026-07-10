import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.println("==================================");
        System.out.println("      NUMBER GUESSING GAME");
        System.out.println("==================================");

        boolean playAgain = true;
        int number = 0;

        while(playAgain) {
            number = selectGameMode(sc,random);

            System.out.println("\n==================================");
            System.out.println("        ATTEMPT MODE");
            System.out.println("==================================");

            System.out.println("1. Limited Attempts");
            System.out.println("2. Unlimited Attempts");

            System.out.print("\nEnter your choice (1-2): ");
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

                System.out.print("Enter your guess (" + lb + " - " + ub + "): ");
                guess = sc.nextInt();
                while (guess < lb || guess > ub) {
                    System.out.print("Please enter a number between (" + lb + "-" + ub + "): ");
                    guess = sc.nextInt();
                }

                attempts--;
                attemptsUsed++;

                if (guess == number) {
                    break;
                }

                if(attempts > 0){
                    if (guess > number) {
                        System.out.println("Too high! Try again.");
                    } else {
                        System.out.println("Too low! Try again.");
                    }
                }
            }

            if (guess == number) {
                System.out.println("\n==================================");
                System.out.println("       CONGRATULATIONS!");
                System.out.println("==================================");
                System.out.println("You guessed the correct number!");
                System.out.println("Correct Number : " + number);
                System.out.println("Attempts Used  : " + attemptsUsed);
            } else {
                System.out.println("\n==================================");
                System.out.println("          GAME OVER");
                System.out.println("==================================");
                System.out.println("You've used all your attempts.");
                System.out.println("The correct number was : " + number);
            }

            System.out.println("\n==================================");
            System.out.println("          PLAY AGAIN?");
            System.out.println("==================================");

            System.out.println("1. Yes");
            System.out.println("2. No");

            System.out.print("\nEnter your choice (1-2): ");
            int choice2 = sc.nextInt();

            while (choice2 != 1 && choice2 != 2) {
                System.out.print("Enter a VALID choice: ");
                choice2 = sc.nextInt();
            }

            if(choice2==2){
                playAgain = false;
            }
        }

        System.out.println("\n==================================");
        System.out.println("       Thanks for playing!          ");
        System.out.println("        Have a great day!            ");
        System.out.println("==================================");

        sc.close();
    }
    public static int lb = 0;
    public static int ub = 0;
    public static int selectGameMode(Scanner sc, Random random){
        int number = 0;
        System.out.println("\n==================================");
        System.out.println("         SELECT GAME MODE");
        System.out.println("==================================");
        System.out.println("1. Custom Game");
        System.out.println("   • Choose your own lower and upper bounds.");
        System.out.println();
        System.out.println("2. Quick Game");
        System.out.println("   • Choose from predefined ranges.");
        System.out.print("\nEnter your choice (1-2): ");
        int choice = sc.nextInt();

        while(choice!=1 && choice!=2){
            System.out.print("Invalid choice! Please enter 1 or 2: ");
            choice = sc.nextInt();
        }

        if(choice==1){
            System.out.println("\n==================================");
            System.out.println("         CUSTOM GAME");
            System.out.println("==================================");

            System.out.println("Rules:");
            System.out.println("• Both bounds must be greater than or equal to 0.");
            System.out.println("• Lower bound must be less than the upper bound.");
            System.out.println("• Both bounds are inclusive.");
            System.out.println();

            System.out.print("Enter lower bound: ");
            int lowerBound = sc.nextInt();
            while(lowerBound<0){
                System.out.print("Invalid. Enter lower bound again: ");
                lowerBound = sc.nextInt();
            }
            System.out.print("Enter upper bound: ");
            int upperBound = sc.nextInt();
            while((upperBound<0) || (upperBound<=lowerBound)){
                if(upperBound<0){
                    System.out.print("Invalid. Enter upper bound again: ");
                    upperBound = sc.nextInt();
                }
                else{
                    System.out.println("Upper bound cannot be less than lower bound.");
                    System.out.print("Enter upper bound again: ");
                    upperBound = sc.nextInt();
                }
            }
            number = random.nextInt(lowerBound,upperBound+1);
            lb = lowerBound;
            ub = upperBound;
            System.out.println("\n----------------------------------");
            System.out.println("Your range : " + lowerBound + "-" + upperBound);
            System.out.println("----------------------------------");
        }
        else{
            System.out.println("\n==================================");
            System.out.println("          QUICK GAME");
            System.out.println("==================================");
            System.out.println("Available Ranges:");
            System.out.println();
            System.out.println("1. 1 - 50");
            System.out.println("2. 1 - 100");
            System.out.println("3. 1 - 500");
            System.out.println("4. 1 - 1000");
            System.out.print("\nEnter your choice (1-4): ");
            int quickGameChoice = sc.nextInt();
            while(quickGameChoice<1 || quickGameChoice>4){
                System.out.println("Invalid. Enter valid choice: ");
                quickGameChoice = sc.nextInt();
            }
            switch(quickGameChoice){
                case 1 :
                    number = random.nextInt(1,51);
                    System.out.println("\n----------------------------------");
                    System.out.println("Selected Range : 1 - 50");
                    System.out.println("----------------------------------");
                    lb = 1;
                    ub = 50;
                    break;
                case 2 :
                    number = random.nextInt(1,101);
                    System.out.println("\n----------------------------------");
                    System.out.println("Selected Range : 1 - 100");
                    System.out.println("----------------------------------");
                    lb = 1;
                    ub = 100;
                    break;
                case 3 :
                    number = random.nextInt(1,501);
                    System.out.println("\n----------------------------------");
                    System.out.println("Selected Range : 1 - 500");
                    System.out.println("----------------------------------");
                    lb = 1;
                    ub = 500;
                    break;
                case 4 :
                    number = random.nextInt(1,1001);
                    System.out.println("\n----------------------------------");
                    System.out.println("Selected Range : 1 - 1000");
                    System.out.println("----------------------------------");
                    lb = 1;
                    ub = 1000;
                    break;
            }

        }
        return number;
    }
}
