package swing.event;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyKeyEvent extends JFrame implements KeyListener{
	
	private JLabel lbl1, lbl2, lbl3;
	private JPanel panBase;
	
	
	public MyKeyEvent(String title, int width, int height) {
		this.setTitle(title);
		this.setSize(width, height);
		this.setLocationRelativeTo(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		panBase = new JPanel();
		panBase.setBackground(Color.darkGray);
		panBase.addKeyListener(this);
		add(panBase);
		
		
		lbl1 = new JLabel("getKeyCode()");
		lbl1.setForeground(Color.white);
		panBase.add(lbl1);
		lbl2 = new JLabel("getKeyChar()");
		lbl2.setForeground(Color.white);
		panBase.add(lbl2);
		lbl3 = new JLabel("getKeyText()");
		lbl3.setForeground(Color.white);
		panBase.add(lbl3);
		
		
		this.setVisible(true);
		
		panBase.requestFocus();
	}

	public static void main(String[] args) {
		new MyKeyEvent("Frame",300,200);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		lbl1.setText(e.getKeyCode()+"");
		lbl2.setText(e.getKeyChar()+"");
		lbl3.setText(KeyEvent.getKeyText(e.getKeyCode()));
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			System.out.println("FUCK");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
