package game;

import util.ConsoleReader;
import util.DisplayWord;
import util.HangmanDictionary;


/**
 * This class represents the traditional word-guessing game Hangman
 * that plays interactively with the user.
 *
 * @author Robert C. Duvall
 * @author Shannon Duvall
 */
public class HangmanGame { 
	
    private Executioner myExecutioner;
    private Guesser myGuesser;

    /**
     * Create Hangman game with the given dictionary of words to play a game with words 
     * of the given length and giving the user the given number of chances.
     */
    public HangmanGame(Executioner myExecutioner, Guesser myGuesser) {
        this.myExecutioner = myExecutioner;
        this.myGuesser = myGuesser;
    }
    
    /**
     * Play one complete game.
     */
    public void play() {
        boolean gameOver = false;
        while (!gameOver) {
            printStatus();

            String guess = ConsoleReader.promptString("Make a guess: ");
            if (guess.length() == 1 && Character.isAlphabetic(guess.charAt(0))) {
            	// takes the guessed char and runs it into the makeGuess method
            	char guessedChar = guess.toLowerCase().charAt(0);
                char checkGuess = myGuesser.makeGuess(guessedChar);
                
                // This makes sure guess is a valid character
                if (checkGuess != '1') {  
                	// If it is it then checks if it is in secret or not. 
                	// If character is in secret, the checkGuessInSecret updates the DisplayWord with the character. 
                	// If not it changes the guesses left
                    if (!myExecutioner.checkGuessInSecret(checkGuess)) {
                        myGuesser.changeGuessesLeft(); 
                    }
                }

                if (isGameLost()) {
                    System.out.println("YOU ARE HUNG!!!");
                    gameOver = true;
                }
                else if (isGameWon()) {
                    System.out.println("YOU WIN!!!");
                    gameOver = true;
                }
            }
            else {
                System.out.println("Please enter a single letter ...");
            }
        }
        System.out.println("The secret word was " + myExecutioner.getSecretWord());
    }
    
   
    // Returns true only if the guesser has guessed all letters in the secret word.
    private boolean isGameWon() {
        return myExecutioner.getDisplayWord().equals(myExecutioner.getSecretWord());
    }

    // Returns true only if the guesser has used up all their chances to guess.
    private boolean isGameLost() {
        return myGuesser.getGuessesLeft() == 0;
   }
    
    // Print game stats
    private void printStatus() {
        System.out.println(myExecutioner.getDisplayWord());
        System.out.println("# misses left = " + myGuesser.getGuessesLeft());
        System.out.println("letters not yet guessed = " + myGuesser.getLettersLeftToGuess());
        // NOT PUBLIC, but makes it easier to test
        //System.out.println("*** " + mySecretWord);
        System.out.println();
    }
}
