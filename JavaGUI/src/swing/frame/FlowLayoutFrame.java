package swing.frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutFrame extends JFrame{
	
	public FlowLayoutFrame(String title, int x, int y) {
		
		this.setTitle(title);
		this.setSize(x, y);
		this.setLocationRelativeTo(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setLayout(new FlowLayout(FlowLayout.RIGHT,20,20));
		// 오른쪽으로 정렬해서, 위 아래 간격은 20만큼.
		
		JButton b1 = new JButton("A");
		add(b1);
		JButton b2 = new JButton("B");
		add(b2);
		JButton b3 = new JButton("C");
		add(b3);
		JButton b4 = new JButton("D");
		add(b4);
		JButton b5 = new JButton("E");
		add(b5);

		this.setVisible(true);
	}

	public static void main(String[] args) {
		new FlowLayoutFrame("FlowLayout 프레임",300,200);
	}

}
