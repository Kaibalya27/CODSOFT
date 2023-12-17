import java.util.*;
public class Number_game {
    public static void numbergame() {
        Scanner sc = new Scanner(System.in);
        int round = 0;
        int randomno;
        int score = 0;
        while(true) {
            round++;
            randomno = (int)(1+Math.random()*100);
            int attempts = 0;
            System.out.println("\nGuess a number in between range of 1 to 100");
            while (attempts < 5) {
                System.out.print("Your guess: ");
                int userGuess=0;
                try {
                    userGuess = sc.nextInt();
                    attempts++;
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Please enter a valid number.");
                    sc.next();
                }
                if (userGuess == randomno) {
                    System.out.println("Congratulations! You guessed the correct number " + randomno + " in " + (attempts) + " attempts.");
                    score += 1;
                    break;
                } else if (userGuess < randomno) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }
            if (attempts == 5) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " +
                        randomno + ".");
            }
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = sc.next().toLowerCase().trim();

            if (!playAgain.equals("yes")) {
                break;
            }
        }
        System.out.println("Thank You for playing");
        System.out.println("Rounds played: " + round);
        System.out.println("Total score: " + score);
    }
    public static void main(String[] args) {
        numbergame();
    }
}

