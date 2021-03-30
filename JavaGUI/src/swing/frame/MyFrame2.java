package swing.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame2 extends JFrame{
	
	public MyFrame2(String title, int x, int y) {
		this.setTitle(title);
		this.setSize(x, y);
		this.setLocationRelativeTo(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// 위
		JPanel top = new JPanel();	
		
		JButton btn1 = new JButton("새로 배치");
		top.add(btn1);
		JButton btn2 = new JButton("종료");
		top.add(btn2);
		
		top.setBackground(Color.YELLOW);
		add(top,BorderLayout.NORTH);
		
		// 중간
		JPanel center = new JPanel();
		center.setLayout(null);
		
		Random r = new Random();
		for(int i = 0; i < 10; i++) {
			JLabel lbl = new JLabel("*");
			lbl.setLocation(r.nextInt(400), r.nextInt(400));
			lbl.setSize(10, 10);
			lbl.setForeground(Color.RED);
			center.add(lbl);
		}
				
		add(center,BorderLayout.CENTER);
		
		// 아래
		JPanel bottom = new JPanel();
		bottom.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JButton btn3 = new JButton("별 개수 수정");
		bottom.add(btn3);
		
		JTextField txt = new JTextField(10);
		bottom.add(txt);
		
		bottom.setBackground(Color.gray);
		add(bottom,BorderLayout.SOUTH);
		
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new MyFrame2("3개의 패널을 가진 프레임",500,500);
	}

}
