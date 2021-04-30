package jaaaaava;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JungiPractice extends JFrame implements KeyListener{

    private JLabel label;
    private JPanel panel;
    private Font f;
    private int size;


    public JungiPractice(String title, int width, int height) {
        setTitle(title);
        setSize(width, height);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        label = new JLabel("LOVE JAVA");
        label.setFont(new Font("Arial", Font.PLAIN, 10));
        panel.addKeyListener(this);
        panel.add(label);
        add(panel);

        setVisible(true);
        panel.requestFocus();

    }

    public static void main(String[] args) {
        new JungiPractice("기본 프레임", 300, 300);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        f = label.getFont();
        size = f.getSize();
        if(e.getKeyChar() == '+') {
            label.setFont(new Font("Arial", Font.PLAIN, size + 5));
        }
        else if (e.getKeyChar() == '-' && size>5) {
            label.setFont(new Font("Arial", Font.PLAIN, size - 5));
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }
}