package randomNumberGuesser;

import java.util.Scanner;

public class NumberGuesser
	{
		static Scanner userInput = new Scanner(System.in);
		static int range;
		static String rangeToldToUser;
		static int randomNumber;
		static boolean isStillPlaying = true;
		static boolean stillGuessing = true;
		static int numberOfGuesses;
		static int userDifficulty;
		public static void main(String[] args)
			{
				
				greetPlayer();
				while (isStillPlaying){
					pickDifficulty();
					generateRandomNumber();
					askForUserGuess();
					endGame();
				}	
			}
				
		public static void greetPlayer() {
			System.out.println("What's your name?");
			String userName = userInput.nextLine();
			System.out.println("Hello " + userName);
		}
		public static void pickDifficulty() {
			System.out.println("what difficulty would you like to play at?");
			System.out.println("1) Easy (1-5)");
			System.out.println("2) Medium (1-10)");
			System.out.println("3) Hard (1-1000)");
			int userDifficulty = userInput.nextInt();
			if (userDifficulty == 1){
				range = 5;
				rangeToldToUser = "1-5";
			}
			else if (userDifficulty == 2){
				range = 10;
				rangeToldToUser = "1-10";
			}
			else if (userDifficulty == 3){
				range = 1000;
				rangeToldToUser = "1-1000";
			}
			else {
				System.out.println("You don't get to play");
			}
		}
		public static void generateRandomNumber() {
			randomNumber = (int)(Math.random()*range)+1;
		}
		public static void askForUserGuess() {
			System.out.println("Pick a number between " + rangeToldToUser);
			while (stillGuessing){
				int userGuess = userInput.nextInt();
				if (userGuess == randomNumber){
					numberOfGuesses++;
					stillGuessing = false;
				}
				else if (userGuess > randomNumber){
					System.out.println("Too high");
					numberOfGuesses++;
				}
				else {
					System.out.println("Too low");
					numberOfGuesses++;
				}
			}
		}
		public static void endGame() {
			System.out.println("Congrats, the number was " + randomNumber);
			if (numberOfGuesses > 1){
			System.out.println("You guessed it correctly in " + numberOfGuesses + " guesses");
			int lowRange;
			int highRange;
				if (userDifficulty == 1){
					lowRange = 3;
					highRange = 4;
				}
				else if (userDifficulty == 2){
					lowRange = 3;
					highRange = 7;
				}
				else {
					lowRange = 10;
					highRange = 20;
				}
				
					if (numberOfGuesses < lowRange){
						System.out.println("That's was pretty good");
					}
					else if (numberOfGuesses >= lowRange && numberOfGuesses < highRange){
						System.out.println("That was pretty mediocre");
					}
					else {
						System.out.println("Wow, that was horribly");
					}

			}
			else {
				System.out.println("You guessed it correctly in " + numberOfGuesses + " guess");
				System.out.println("You are a GOD!");
			}
			System.out.println();
			System.out.println("Would you like to play again?");
			System.out.println("1) Yes");
			System.out.println("2) No");
			int playAgain = userInput.nextInt();
			if (playAgain == 2){
				isStillPlaying = false;
				System.out.println("Thank you for playing");
			}
			else {
				stillGuessing = true;
			}
		}

	}
