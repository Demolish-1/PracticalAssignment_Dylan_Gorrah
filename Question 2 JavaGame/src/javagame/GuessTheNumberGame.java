// Dylan Gorrah St10398445


package javagame;

import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

// Base class
abstract class GameLevel {
    private final int numberToGuess;
    private final int maxGuesses;
    private final int[] guesses;
    private int currentGuessCount;

    // Constructor
    public GameLevel(int maxGuesses, int maxNumber) {
        this.maxGuesses = maxGuesses;
        this.numberToGuess = generateRandomNumber(maxNumber);
        this.guesses = new int[maxGuesses];
        this.currentGuessCount = 0;
    }

    // Information hiding: private method
    private int generateRandomNumber(int maxNumber) {
        Random rand = new Random();
        return rand.nextInt(maxNumber) + 1;
    }

    // Public method
    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Guess the number between 1 and " + getMaxNumber() + ":");

        while (currentGuessCount < maxGuesses) {
            try {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();

                // Store the guess in the array
                guesses[currentGuessCount] = guess;
                currentGuessCount++;

                if (guess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    return;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
            }
        }

        System.out.println("Sorry! You've used all your guesses. The correct number was " + numberToGuess);
        System.out.println("Your guesses were: ");
        for (int i = 0; i < currentGuessCount; i++) {
            System.out.print(guesses[i] + " ");
        }
        System.out.println();
    }

    // Abstract method to be implemented by derived classes
    public abstract int getMaxNumber();
}

// Easy level class
class EasyLevel extends GameLevel {
    public EasyLevel() {
        super(10, 10); // 10 guesses, number range 1-10
    }

    @Override
    public int getMaxNumber() {
        return 10;
    }
}

// Medium level class
class MediumLevel extends GameLevel {
    public MediumLevel() {
        super(7, 50); // 7 guesses, number range 1-50
    }

    @Override
    public int getMaxNumber() {
        return 50;
    }
}

// Hard level class
class HardLevel extends GameLevel {
    public HardLevel() {
        super(5, 100); // 5 guesses, number range 1-100
    }

    @Override
    public int getMaxNumber() {
        return 100;
    }
}

// Main class
public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        boolean validInput = false;

        do {
            try {
                 System.out.println("===============================================================");
                System.out.println("Number guessing game!");
                 System.out.println("===============================================================");
                System.out.println("welcome!, Choose difficulty level: 1. Easy  2. Medium  3. Hard");
         
                String input = scanner.next();

                // Check if input is a valid integer
                if (input.matches("\\d+")) {
                    choice = Integer.parseInt(input);

                    // Check if input is within valid range
                    if (choice >= 1 && choice <= 3) {
                        validInput = true;
                    } else {
                        System.out.println("Invalid choice. Please choose a number between 1 and 3.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        } while (!validInput);

        GameLevel game;

        switch (choice) {
            case 1 -> game = new EasyLevel();
            case 2 -> game = new MediumLevel();
            case 3 -> game = new HardLevel();
            default -> {
                System.out.println("Unexpected error occurred. Defaulting to Easy level.");
                game = new EasyLevel();
            }
        }

        game.play();
    }
}