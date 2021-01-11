import java.util.*;

class Main {
  public static void main(String[] args) {
    // greet the user of your with a certain 
    // amount of base coins to their bank (can be random or fixed)
    Scanner input = new Scanner(System.in);
    System.out.println("You have 500 coins in your bank.");
    int totalCoins = 500;
    int item = 0;
    
    // game loop
    boolean game = true;
    
    //create a looping structure that allows the user to play until they choose to quit 
    // in the loop, present the user with a menu of options that asks the      user what they want to do:
    // 1. play 
    // 2. shop
    // 3. quit
    while (game) {
      System.out.println("What do you want to do \ntype 1 to play \ntype 2 to shop \ntype 3 to quit");
      int choice = input.nextInt();
    
      // based on their entry, call the method to perform that behavior
      // at all times, keep updating the user's bank balance
      switch (choice) {
        // play
        case 1:
          totalCoins += play(rng);
          System.out.printf("you have %d in your bank\n", totalCoins);
          break;
          
        // shop
        case 2:
          totalCoins -= shop(input);
          item++;
          System.out.printf("You brought %d item(s)", item);
          System.out.printf("you have %d in your bank\n", totalCoins);
          break;
      
        // exit
        case 3:
          game = false;
          System.out.printf("exit with %d coins and %s items\n", totalCoins, item);
          break;
      }
    }//end of while loop
    input.close();
  }//end main method
  
  // return the randomly generated coins
  public static int play () {
    // generate random coins from 1 - 100
    int coins = (int)(Math.random() * 100) + 1;
    return coins;
  }
  
  // ask the user on much they want to spend
  public static int shop (Scanner input) {
    System.out.println("How much do you want to spend?");
    int amount = input.nextInt();
    return amount;
  }
  
}//end class
