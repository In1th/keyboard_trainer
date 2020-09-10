import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.security.Key;
import java.util.Scanner;

public class KetGetting implements KeyListener {

    public String key;

    public static String getKey(){
        Scanner sc = new Scanner(System.in);
        String key = sc.nextLine();
        assert key.length() == 1;
        return key;
    }


    @Override
    public void keyTyped(KeyEvent keyEvent) {
        key = Character.toString(keyEvent.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
