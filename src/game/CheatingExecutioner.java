package game;

import util.DisplayWord;
import util.HangmanDictionary;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map.Entry;

public class CheatingExecutioner extends Executioner {
    private List<String> myRemainingWords;

    public CheatingExecutioner(HangmanDictionary dictionary, int wordLength) {
        super(dictionary, wordLength);
        myRemainingWords = dictionary.getWords(wordLength);  
    }
// Overides the checkGuessInSecret Method because it now needs to work with the changing guess created through cheat
    @Override
    public boolean checkGuessInSecret(char guess) {
        cheat(guess);
        return super.checkGuessInSecret(guess);  
    }

 
    public void cheat(char guess) {
    	// create template of guesses and find one with most matching remaining words
        HashMap<DisplayWord, List<String>> templatedWords = new HashMap<DisplayWord, List<String>>();
        for (String w : myRemainingWords) {
            DisplayWord template = new DisplayWord(myDisplayWord);
            template.update(guess, w);
            if (!templatedWords.containsKey(template)) {
                templatedWords.put(template, new ArrayList<>());
            }
            templatedWords.get(template).add(w);
        }
        int max = 0;
        DisplayWord maxKey = new DisplayWord("");
        for (Entry<DisplayWord, List<String>> entry : templatedWords.entrySet()) {
            //System.out.println(entry.getValue());
            if (entry.getValue().size() > max) {
                max = entry.getValue().size();
                maxKey = entry.getKey();
            }
        }

        // update secret word to match template of guesses
        myRemainingWords = templatedWords.get(maxKey);
        Collections.shuffle(myRemainingWords);
        mySecretWord = myRemainingWords.get(0);
        myDisplayWord = maxKey;
    }
}
