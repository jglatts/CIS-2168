package lottery;

import java.util.*;

public class Lottery {
   public static final int NUMBERS = 6;
   public static final int MAX_NUMBER = 100;
   public static final int PRIZE = 100;

   public static void main(String[] args) {
      // get winning number and ticket sets
      Set<Integer> winning = createWinningNumbers();
      Set<Integer> ticket = getTicket();
      System.out.println();

      // keep only winning numbers from the player's ticket
      // YOUR CODE BELOW
      
      System.out.println("Your ticket was: " + ticket);
      ticket.retainAll(winning);
      System.out.println("Correct Numbers: " + winning);
      // YOUR CODE BELOW
      // if there are any winning numbers, the do the following:
      //   1) compute the prize: double prize = PRIZE * Math.pow(2, matches.size());
      //   2) print the numbers that matched
      //   3) print the prize amount, if any.
      if (!ticket.isEmpty()) {
          double prize = PRIZE * Math.pow(2, ticket.size());
          System.out.println("Winning Numbers: " + ticket);
          System.out.println("Prize amount: " + prize);
      }
      else System.out.println("Sorry... No winning numbers");
   }

   // generates a set of the winning lotto numbers
   public static Set<Integer> createWinningNumbers() {
      // YOUR CODE BELOW:
      Random rand = new Random();
      Set<Integer> winningNumbers = new HashSet<>();
      while (winningNumbers.size() != NUMBERS) {
          int n = rand.nextInt(MAX_NUMBER) + 1;
          if (!winningNumbers.contains(n)) winningNumbers.add(n);   
      }
      return winningNumbers; // <- CHANGE THIS LINE TO A CORRECT ONE
   }

   // reads the player's lottery ticket from the console
   public static Set<Integer> getTicket() {
      /*Set<Integer> ticket = new HashSet<>();
      Scanner console = new Scanner(System.in);
      System.out.print("Type " + NUMBERS + " lotto numbers: ");
      while (ticket.size() < NUMBERS) {
         int number = console.nextInt();
         ticket.add(number);
      }*/
      return createWinningNumbers();
   }
}

    

