package game;

import util.DisplayWord;
import util.HangmanDictionary;

public class Executioner {
	
    public String mySecretWord;
    public DisplayWord myDisplayWord;
    
	public Executioner(HangmanDictionary dictionary, int wordLength) {
		mySecretWord = makeSecretWord(dictionary, wordLength);
		myDisplayWord = new DisplayWord(mySecretWord);
	}
	
	// Returns a secret word.
    private String makeSecretWord (HangmanDictionary dictionary, int wordLength) {
        return dictionary.getRandomWord(wordLength).toLowerCase();
    }
    
 // Returns true only if given guess is in the secret word.
    public boolean checkGuessInSecret(char guess) {
        if (mySecretWord.indexOf(guess) >= 0) {
            myDisplayWord.update(guess, mySecretWord);
            return true;
        }
        return false;
    }
    // methods to use the 2 fields in other classes
    public String getSecretWord() {
		return mySecretWord;
    }
    public DisplayWord getDisplayWord() {
		return myDisplayWord;    	
    }
    
    
    
    
	
}
