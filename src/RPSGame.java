
//this class will handle the game logic, including deciding the computers choice and determining the result

import java.util.Random;

public class RPSGame {
	//We use enum to define the three options, ie Rock, Paper, and Scissors
	public enum Choice {
		ROCK, PAPER, SCISSORS;
	}
	
	public Choice getComputerChoice() {
		Random random = new Random();
		int pick = random.nextInt(3);
		switch (pick) {
		case 0: return Choice.ROCK;
		case 1: return Choice.PAPER;
		case 2: return Choice.SCISSORS;
		default: return null; //This shouldnt be reached
		}
		
	}
	
	public String getResult(Choice playerChoice, Choice computerChoice) {
		if(playerChoice == computerChoice) {
			return("It's a Draw!");
		}else if
			((playerChoice == Choice.ROCK && computerChoice == Choice.SCISSORS) ||
			(playerChoice == Choice.PAPER && computerChoice == Choice.ROCK)  ||
			(playerChoice == Choice.SCISSORS && computerChoice == Choice.PAPER)){
				return("You Win!!");
			} else {
				return("Computer Wins");
		}
	}
}
