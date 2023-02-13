package sg.edu.nus.iss.app;

import java.util.Random;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {

        Random random = new Random();
        Integer randomNumber = random.nextInt(100);

        Integer myGuess = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.printf("secret number: %d\n", randomNumber);

        while (myGuess != randomNumber) {
            myGuess = scanner.nextInt();

            if (myGuess < randomNumber) {
                System.out.println("Your guess is lower");
            } else if (myGuess > randomNumber) {
                System.out.println("Your guess is higher.");
            } else {
                System.out.println("You guessed it right!");
                scanner.close();
            }
        }
        
        
    }
}
