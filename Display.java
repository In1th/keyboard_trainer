import org.jetbrains.annotations.NotNull;

public class Display {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String UNDERLINE = "\033[1m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static String displaySentence(Sentence sentence){

        String finalSentence = "<html>";

        int sign_id = sentence.nextCharacterId;

        for (int i = 0; i< sentence.text.length(); i++){
            if (i <= sign_id){
                if (i == sign_id) finalSentence += "<b><u>";
                if(sentence.correctSigns[i]) finalSentence += "<span style='background-color:green'>";
                else finalSentence += "<span style='background-color:red'>";
                finalSentence = finalSentence + sentence.text.charAt(i) + "</span>";
                if (i == sign_id) finalSentence += "</b></u>";
            }
            else finalSentence += sentence.text.charAt(i);

        }

        finalSentence += "</html>";

        return  finalSentence;

    }

    public static String displayStatistics(Statistics stats){
        String finalSentence = "<html>";
        finalSentence += "<p>Percent of correct characters: "+stats.correctSignsRatio+"%</p>";
        finalSentence += "<p>Time of typing previous sentence: "+stats.timeOfTyping+"s</p>";
        finalSentence += "<p>Sentences typed: "+stats.sentencesCleared+"</p>";
        finalSentence += "</html>";
        return finalSentence;
    }

}
