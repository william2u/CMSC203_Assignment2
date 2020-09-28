package RandomNumberGuesser;

import java.util.Scanner;

public class RandomNumberGuesser {

	public static void main(String[] args) {
		
		boolean keepPlaying = true;
		int lowGuess;
		int highGuess;
		int nextGuess;
		int nbr;
		
		// Create a new object of type Scanner that reads from the keyboard
		Scanner input = new Scanner(System.in); 
		
		do {
			// reset the number of guesses
			RNG.resetCount();
		
			// generate a random number
			nbr = RNG.rand();
		
			// reset parameters
			lowGuess = 1;
			highGuess = 100;
		
			System.out.println("We have generated a random number between 1 and 100, make a guess");
		
			// prompt user to guess number generated
			System.out.println("Enter your first guess:");
			nextGuess = input.nextInt();
		
			do {
				//check validity of the input
				if(RNG.inputValidation(nextGuess, lowGuess, highGuess)){
			
					// check if user's answer is not correct
					if(nextGuess>nbr ){
						highGuess=nextGuess;
					}
					if(nextGuess<nbr ){
						lowGuess=nextGuess;
					}
					if(nextGuess<nbr || nextGuess>nbr){
						System.out.println("Number of guesses is "+ RNG.getCount());
						System.out.println("Enter your next guess between "+ lowGuess +" and "+ highGuess);
						nextGuess = input.nextInt();
					}
				}else {
					//System.out.println("Invalid input !!");
					System.out.println("Number of guesses is "+ RNG.getCount());
					System.out.println("Enter your next guess between "+ lowGuess +" and "+ highGuess);
					nextGuess = input.nextInt();
				}		
			}while(nextGuess!=nbr);
		
			// the user's answer is correct
			System.out.println("Number of guesses is "+ (1+RNG.getCount()));
			System.out.println("Congratulation, you guessed correctly!");
			System.out.println("Keep Playing? (1 for Yes or 2 for No)");
		
			// Ask user if he/she want to play again
			Scanner index = new Scanner(System.in);
			String answer = index.nextLine();
			if ( answer.equals("No") || answer.equals("no") || answer.equals("n") ) { 
				keepPlaying = false;
			}
			//if ( answer.equals("Yes") || answer.equals("yes") || answer.equals("y") ){
			//	keepPlaying = true;
			//}
			index.close();
			
		}while(keepPlaying == true);
		
		System.out.println("Thanks for playing");
		// close scanner
		input.close();

	}

}