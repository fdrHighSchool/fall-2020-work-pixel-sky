//Zhi Feng , JINXIN , Yang Lu
import java.util.*;

class Main {
  public static void main(String[] args) {
    // greet the user of your with a certain 
    // amount of base coins to their bank (can be random or fixed)
    Random rng = new Random();
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
      if (choice == 1){
        int earnedCoin = play(rng);
        totalCoins += earnedCoin;
        System.out.println("you have "+ totalCoins +" in your bank");
      }
      
      else if (choice == 2){
        int UsedCoin = shop(input);
        totalCoins -= UsedCoin;
        item++;
        System.out.printf("You brought %d item(s)", item);
        System.out.println("You have "+ totalCoins +" in your bank");
      }
      
      else if (choice == 3){
        game = false;
        System.out.printf("exit with %d coins and %s items\n", totalCoins, item);
      }
    
    }//end of while loop
    input.close();
  }//end main method


  /*
   * Name: play
   * Purpose: simulate a round of the game, award the user a random 
              amount of coins for playing
   * Input: Random object
   * Return: a random number of coins the user won that round
   */
   public static int play (Random rng) {
    // generate random coins from 1 - 100
    int coins = rng.nextInt(100) + 1;
    return coins;
  }
  
  
  /*
   * Name: shop
   * Purpose: allow the player to spend coins
   * Input: how much player spend
   * Return: how many coins spent
   */
  public static int shop (Scanner input) {
    System.out.println("How much do you want to spend?");
    int amount = input.nextInt();
    return amount;
  }
  
}//end class
