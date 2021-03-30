package swing.frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class NoLayoutFrame extends JFrame{
	
	public NoLayoutFrame(String title, int x, int y) {
		
		this.setTitle(title);
		this.setSize(x, y);
		this.setLocationRelativeTo(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setLayout(null);
		//배치관리자 삭-제
		
		JButton b1 = new JButton("A");
		b1.setSize(100, 100);
		b1.setLocation(10, 10);
		add(b1);
		JButton b2 = new JButton("B");
		b2.setSize(100, 100);
		b2.setLocation(10, 110);
		add(b2);
		JButton b3 = new JButton("C");
		b3.setSize(100, 100);
		b3.setLocation(110, 10);
		add(b3);
		JButton b4 = new JButton("D");
		b4.setBounds(110, 110, 100, 100);
		add(b4);
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new NoLayoutFrame("WHAT",300,300);
	}

}


