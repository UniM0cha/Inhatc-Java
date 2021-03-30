package swing.frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutFrame extends JFrame{
	
	public BorderLayoutFrame(String title, int x, int y) {
		
		this.setTitle(title);
		this.setSize(x, y);
		this.setLocationRelativeTo(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setLayout(new BorderLayout(10,10));
		//보더 레이아웃 선언. 위쪽과 아래쪽 여백 10씩.
		
		JButton b1 = new JButton("A");
		add(b1,BorderLayout.NORTH);
		JButton b2 = new JButton("B");
		add(b2,BorderLayout.WEST);
		JButton b3 = new JButton("C");
		add(b3,BorderLayout.EAST);
		JButton b4 = new JButton("D");
		add(b4,BorderLayout.SOUTH);
		JButton b5 = new JButton("E");
		add(b5,BorderLayout.CENTER);

		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new BorderLayoutFrame("BorderLayout 프레임",300,200);
	}

}


