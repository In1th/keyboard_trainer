public class Statistics {

    public float correctSignsRatio;
    public float timeOfTyping;
    public int sentencesCleared;

    public int charactersCorrect;
    private long firstTick;

    /** class constructor*/
    public Statistics(){
        correctSignsRatio = 0;
        timeOfTyping = 0;
        sentencesCleared = 0;
        firstTick = 0;

        timeTick();
    }

    /**sets a new correct characters ratio
     * @param text_length text length of the current sentence
     * */
    public void getCorrectSignRatio(int text_length){
        correctSignsRatio = Math.round((100f*charactersCorrect)/text_length);
    }

    /**sets the timestamp for the firstTick, as well as sets the time of typing a sentence*/
    public void timeTick(){
        long tick = System.nanoTime();
        if (firstTick == 0) firstTick = tick;
        else {
            if (firstTick < tick) {
                timeOfTyping = Math.round(1f*(tick - firstTick)/Math.pow(10,9));
                firstTick = tick;
            }
        }
    }

    /**checks if a pressed key matches the sample
     * @return a boolean
     * @param key1 the pressed key
     * @param key2 the sample key (current character of the sentece)
     * */
    public static boolean isKeyCorrect(String key1, String key2){
        if (key1.equals(key2)) return true;
        else return false;
    }

}
