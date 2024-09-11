import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        RPSGame game = new RPSGame();
        
        boolean replay = true;
        
        while(replay) {
            int playerWins = 0;
            int computerWins = 0;
            int draws = 0;

            // This loop runs the best 2/3 matches
            while(playerWins < 2 && computerWins < 2) {
                System.out.println("Enter your choice (ROCK, PAPER, SCISSORS)");
                String playerInput = scanner.nextLine().toUpperCase();
                
                RPSGame.Choice playerChoice = null;
                try {
                    playerChoice = RPSGame.Choice.valueOf(playerInput);
                } catch(IllegalArgumentException e) {
                    System.out.println("Invalid choice, try again");
                    continue;  // Continue the loop if invalid input
                }
                
                RPSGame.Choice computerChoice = game.getComputerChoice();
                System.out.println("Computer chose: " + computerChoice);
                
                String result = game.getResult(playerChoice, computerChoice);
                System.out.println(result);
                
                if(result.equals("You Win!!")) {
                    playerWins++;
                } else if(result.equals("Computer Wins")) {
                    computerWins++;
                } else if(result.equals("It's a Draw!")) {
                    draws++;
                }
                
                System.out.println("Player wins: " + playerWins + " | Computer Wins: " + computerWins + " | Draws: " + draws);    
            }
            
            // Check who won the best 2 out of 3 after the loop finishes
            if(playerWins == 2) {
                System.out.println("You won best out of three!!");
            } else {
                System.out.println("Computer won best out of three :(");
            }
            
            // Ask if the player wants to replay
            System.out.print("Do you want to play again? (YES or NO): ");
            String replayInput = scanner.nextLine().toUpperCase();
            if(replayInput.equals("YES")) {
                replay = true;
            } else if (replayInput.equals("NO")) {
                replay = false;
            } else {
                System.out.println("Invalid input, assuming NO.");
                replay = false;
            }
        }
        
        scanner.close();
    }
}
