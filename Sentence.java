public class Sentence {

    public String text;
    public int nextCharacterId;
    public boolean[] correctSigns;


    public Sentence(String t){
        text = t;
        nextCharacterId = 0;
        correctSigns = new boolean[text.length()];
        for (int i = 0; i < correctSigns.length; i++) correctSigns[i] = true;
    }

    public void giveNextSign(){
        nextCharacterId++;
    }
}
