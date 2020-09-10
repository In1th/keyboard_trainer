import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class main extends JPanel {


    /**@Override
    public void paint(Graphics g){
        g.drawString("Hello to JavaTutorial.net", 10, 10);
    }**/

    public static void main(String[] args){

        String file = "sentences.txt";
        UI userInterface = new UI(file);
        Display dis = new Display();
        KetGetting kg = new KetGetting();
        Statistics st = new Statistics();
        Frame fr = new Frame();


        while (true){
            dis.clearScreen();
            dis.displayStatistics(st);
            String s = dis.displaySentence(userInterface.currentSentence);

            fr.label.setText(s);
            fr.label1.setText(dis.displayStatistics(st));


            int keyIndex = userInterface.currentSentence.nextCharacterId;
            boolean correctKey = st.isKeyCorrect(Character.toString(userInterface.currentSentence.text.charAt(keyIndex)),fr.key);

            if (correctKey && !(fr.key.equals(""))){
                if (userInterface.currentSentence.correctSigns[keyIndex]) st.charactersCorrect++;
                userInterface.currentSentence.giveNextSign();
                if(userInterface.currentSentence.nextCharacterId == userInterface.currentSentence.text.length()) {
                    st.sentencesCleared++;
                    st.getCorrectSignRatio(userInterface.currentSentence.text.length());
                    st.timeTick();
                    userInterface.putNewSentence();
                }
                fr.key = "";
            }
            else if (!correctKey && !(fr.key.equals(""))) {
                userInterface.currentSentence.correctSigns[keyIndex] = false;
                fr.key = "";
            }
            }
        }

    }

