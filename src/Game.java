import java.util.Random;
import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);
    private Random rand = new Random();

    public int generateRandomNumber(){
       return rand.nextInt(1,101);
    }

    public int runLoop(int number){
        int secretNumber = generateRandomNumber();

        for (int i=1;i<=number;i++){

            System.out.print("Enter your choice: ");

            int choice = input.nextInt();
            input.nextLine();

            if (choice == secretNumber){
                return i;
            } else if (choice > secretNumber) {
                System.out.println("Incorrect! The number is less than " + choice+".");
            } else{
                System.out.println("Incorrect! The number is greater than " + choice+".");
            }
        }
        System.out.println("The secret number was: " + secretNumber);
        return -1;
    }

    public void executeGame(){
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100");
        System.out.println("Please select the difficulty level: ");

        System.out.println("1. Easy [10 chances]");
        System.out.println("2. Medium [5 chances]");
        System.out.println("3. Hard [3 chances]");

        int choice = input.nextInt();
        input.nextLine();
        int chances = 0;

        switch (choice){
            case 1 -> {
                System.out.println("Great! You have selected the Easy difficulty level.");
                chances = 10;
            }
            case 2 -> {
                System.out.println("Great! You have selected the Medium difficulty level.");
                chances = 5;
            }
            case 3 -> {
                System.out.println("Great! You have selected the Hard difficulty level.");
                chances = 3;
            }
            default -> {
                System.out.println("Invalid choice, defaulting  to Easy. ");
                chances = 10;
            }
        }

        int result = runLoop(chances);
        if (result == -1){
            System.out.println("Sorry, you lost.");
        }else {
            System.out.println("Congratulations! You guessed the correct number in "+ result + " attempts.");
        }




    }

}
