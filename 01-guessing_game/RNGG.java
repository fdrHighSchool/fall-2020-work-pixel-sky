import java.util.*;

public class RNGG {
    public static void main(String[] args) {
        // game state
        boolean game = true;
        
        // scanner object
        Scanner userInput = new Scanner(System.in);

        // ask user for name
        String name = askName(userInput);

        // game loop
        while (game) {
            System.out.printf("hello %s\n", name);
            int count = 0;

            // pick random number
            Random rand = new Random();    
            int upperBound = (int) Math.pow(10, askDifficulty(userInput));
            int randomNumber = rand.nextInt(upperBound) + 1;

            int min = 1;
            int max = upperBound;

            int old_guess = 0;
            int guess = -1;

            userInput.nextLine(); //throw away the \n not consumed by nextInt()

            do {
                try {
                    System.out.printf("take a guess (%d-%d): ", min, max);
                    String hint = userInput.nextLine();
                    
                    if (count != 0) {
                        if (hint.equals("hint1")) {
                            System.out.printf("off by %d\n", randomNumber - old_guess);
                            continue;
                        }
                        else if (hint.equals("hint2")) {
                            if (randomNumber % 2 == 0) {
                                System.out.println("even");
                                continue;
                            }
                            else {
                                System.out.println("odd");
                                continue;
                            }
                        }
                    }
                    
                    guess = Integer.parseInt(hint);
                
                }
                catch (NumberFormatException e)
                {
                    System.out.println("invaild input");
                    continue;
                }

                count++;
                old_guess = guess;

                if (guess < randomNumber && !(guess < min)) {
                    min = guess;
                }
                else if (guess > randomNumber && !(guess > max)) {
                    max = guess;
                }
            } while (guess != randomNumber);
            
            System.out.printf("Congrats! It took you %d guesses to win.\n", count);

            // ask if user want to play again
            game = playAgain(userInput);
        }

        // close Scanner
        userInput.close();
    }

    // ask for users name 
    public static String askName(Scanner userInput) {
        while (true) {
            // ask for name
            System.out.print("what is your name: ");
            String name = userInput.nextLine();

            // if user submit nothing, continue
            if (name == "") {
                System.out.println("please enter a name.");
                continue;
            }
            else {
                return name;
            }
        }
    }

    // ask for difficulty
    public static int askDifficulty(Scanner userInput) {
        int difficulty;
        do {
            System.out.printf("choose a difficulty form 1-3 (higher more difficult): ");
            difficulty = userInput.nextInt();
        } while (! (1 <= difficulty && difficulty <= 3));

        return difficulty;
    }

    // ask if user wants to play again
    public static boolean playAgain(Scanner userInput) {
        System.out.print("do you want to play again? y/n: ");
            if (userInput.nextLine().equals("y")) {
                return true;
            }
            else {
                return false;
            }
    }
}
