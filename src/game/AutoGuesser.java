package game;

public class AutoGuesser extends Guesser {
	private static final String LETTERS_ORDERED_BY_FREQUENCY = "etaoinshrldcumfpgwybvkxjqz";
    private int myIndex;

    public AutoGuesser(int numGuessesLeft) {
        super(numGuessesLeft);
        myIndex = 0;
    }
    // Overides the makeGuess method to now make a guess based on the frequency of letters used
    @Override
    public char makeGuess(char guess) {
        if (myIndex < LETTERS_ORDERED_BY_FREQUENCY.length()) {
            char automaticGuess = LETTERS_ORDERED_BY_FREQUENCY.charAt(myIndex);
            myIndex++; 
            return automaticGuess;
        }
		return '1';
    }
}
