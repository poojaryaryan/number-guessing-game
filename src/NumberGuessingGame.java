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

        while(playAgain) {

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
            int number = random.nextInt(1, 101);

            int guess = -1;

            while (attempts > 0) {

                System.out.print("Guess a number from 1 to 100: ");
                guess = sc.nextInt();

                attemptsUsed++;

                if (guess == number) {
                    break;
                }

                attempts--;

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
}
