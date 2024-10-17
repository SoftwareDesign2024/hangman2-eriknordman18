package game;

public class Guesser {
	// tracks guesses left
	private int myNumGuessesLeft;
	// tracks letters guessed
	private StringBuilder myLettersLeftToGuess;
	
	//Used to build myLettersLeftToGuess
	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	
	
	public Guesser(int myNumGuessesLeft) {
		this.myNumGuessesLeft = myNumGuessesLeft;
		 myLettersLeftToGuess = new StringBuilder(ALPHABET);
	}
	
	
	// Process a guess by updating the necessary internal state.
    public char makeGuess (char guess) {
        // do not count repeated guess as a miss
        int index = myLettersLeftToGuess.indexOf("" + guess);
        if (index >= 0) {
            recordGuess(index);
            return guess;
        }
        return '1';  
        }
    
    
    // Record that a specific letter was guessed
    private void recordGuess (int index) {
        myLettersLeftToGuess.deleteCharAt(index);
    }
    
    // Used to access the letters left to guess in the hangmanGame class.
    public StringBuilder getLettersLeftToGuess() {
    	return myLettersLeftToGuess;
    }

 // Used to access the guessLeft in HangmanGame
    public int getGuessesLeft() {
    	return myNumGuessesLeft;
    }
    //When the guess is wrong this changes the guesses left by one.
    public void changeGuessesLeft() {
    	myNumGuessesLeft -= 1;
    }
}
