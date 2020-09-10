import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** This class manages the whole UI
 * @author krukm
 * @version 1.0
 */

public class UI {

    /**keeps UI's statisctics*/
    public Statistics stats;

    /**holds the current sentence*/
    public Sentence currentSentence;

    /**holds an array of sentences pulled out from the text file */
    private Sentence[] sentences;

    /**picks a random sentence from the pool */
    private Sentence randSentence(){
        Random random = new Random();
        int randInt = random.nextInt(sentences.length);
        return sentences[randInt];
    }

    /**puts a random sentence to the currentSentence variable */
    public void putNewSentence(){
        Sentence randomSentence = new Sentence("0");
        int randomIndex = 0;
        while (randomSentence.text.equals("0")) {
            randomSentence = randSentence();
        }
        currentSentence = randomSentence;

        sentences[randomIndex] = new Sentence("0");
        stats.charactersCorrect = 0;
    }

    /**class constructor
     * @param fileName  name of the sentence database with a proper extension*/
    public UI(String fileName){

        stats = new Statistics();
        List<String> lines = new ArrayList<>();
        int i = 0;


        try {
            lines = Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        sentences = new Sentence[lines.size()];
        for (String line : lines) {
            sentences[i] = new Sentence(line);
            i++;
        }

        putNewSentence();

    }

}
