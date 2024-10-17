package game;
import util.HangmanDictionary;


/**
 * This class launches the Hangman game and plays once.
 * @author Robert C. Duvall
 * @author Shannon Duvall
 */
public class Main {
    public static final String DICTIONARY = "data/lowerwords.txt";
    public static final int NUM_LETTERS = 6;
    public static final int NUM_MISSES = 8;


    public static void main (String[] args) {
    	Executioner myExecutioner = new Executioner(new HangmanDictionary(DICTIONARY), NUM_LETTERS);
    	Guesser manualGuesser = new Guesser(NUM_MISSES);
    	
    	Executioner cheater = new CheatingExecutioner(new HangmanDictionary(DICTIONARY), NUM_LETTERS);
    	Guesser autoGuesser = new AutoGuesser(NUM_MISSES);
    	new HangmanGame(myExecutioner, autoGuesser).play();
    }
}
