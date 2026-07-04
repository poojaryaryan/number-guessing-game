import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.println("********************");
        System.out.println("Number Guessing Game");
        System.out.println("********************");

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
        } else {
            attempts = Integer.MAX_VALUE;
        }

        int attemptsUsed = 0;
        int number = random.nextInt(1, 101);

        System.out.print("Guess a number from 1 to 100: ");
        int guess = sc.nextInt();

        while (attempts > 0) {

            attemptsUsed++;

            if (guess == number) {
                break;
            }

            if (guess > number) {
                System.out.print("Your guess is too high. Try again: ");
            } else {
                System.out.print("Your guess is too low. Try again: ");
            }

            attempts--;
            guess = sc.nextInt();
        }

        if (guess == number) {
            System.out.println("\nYour guess is correct! The number was " + number);
            System.out.println("Attempts used: " + attemptsUsed);
        } else {
            System.out.println("\nNo more attempts left!");
            System.out.println("The correct number was " + number);
        }

        sc.close();
    }
}
