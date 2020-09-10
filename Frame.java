import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Frame extends JFrame implements KeyListener {

    public JLabel label;
    public JLabel label1;

    public String key;

    public Frame() {
        super("Typing trainer");
        label = new JLabel("a",JLabel.CENTER);
        label1 = new JLabel("a", JLabel.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(label, BorderLayout.CENTER);
        getContentPane().add(label1, BorderLayout.NORTH);
        addKeyListener(this);
        pack();
        setSize(800, 300);
        setResizable(false);
        setVisible(true);

        this.key = "";
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
