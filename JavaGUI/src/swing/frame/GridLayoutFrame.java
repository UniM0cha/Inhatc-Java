package swing.frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GridLayoutFrame extends JFrame{
	
	public GridLayoutFrame(String title, int x, int y) {
		
		this.setTitle(title);
		this.setSize(x, y);
		this.setLocationRelativeTo(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setLayout(new GridLayout(4, 2,5,5));
		//그리드 레이아웃 선언. 행4, 열3, 여백 위아래 5씩
		
		JLabel lbl = new JLabel("이름은 : ");
		add(lbl);
		JTextField tf = new JTextField();
		add(tf);
		JButton b1 = new JButton("1");
		add(b1);
		JButton b2 = new JButton("2");
		add(b2);
		JButton b3 = new JButton("3");
		add(b3);
		JButton b4 = new JButton("4");
		add(b4);
		JButton b5 = new JButton("5");
		add(b5);
		JButton b6 = new JButton("6");
		add(b6);

		this.setVisible(true);
	}

	public static void main(String[] args) {
		new GridLayoutFrame("GridLayout 프레임",300,200);
	}

}