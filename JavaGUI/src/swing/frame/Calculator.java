package swing.frame;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame{
	
	public Calculator(String title, int x, int y) {
		this.setTitle(title);
		this.setSize(x, y);
		this.setLocationRelativeTo(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//TOP
		JPanel top = new JPanel();
		top.setLayout(new BorderLayout());
		
		//제목
		JLabel lblTitle = new JLabel("Swing 으로 구현한 계산기",JLabel.CENTER);
		top.add(lblTitle,BorderLayout.NORTH);
		
		//입력란
		JTextField txt = new JTextField();
		top.add(txt,BorderLayout.CENTER);
		
		this.add(top,BorderLayout.NORTH);
		
		//CENTER
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(4,4));
		
		//버튼
		String name[] = {"7","8","9","+","4","5","6","-","1","2","3","*","0",".","=","/"};
		
		for (String i : name) {
			JButton b = new JButton(i);
			center.add(b);
		}
		
		this.add(center,BorderLayout.CENTER);
		
		//BOTTOM
		JPanel bottom = new JPanel();
		bottom.setLayout(new BorderLayout());
		
		//클리어 버튼
		JButton clr = new JButton("Clear");
		bottom.add(clr,BorderLayout.NORTH);
		
		//이름
		JLabel lblName = new JLabel("만든이 : 이정윤", JLabel.RIGHT);
		bottom.add(lblName,BorderLayout.CENTER);
		
		//이메일
		JLabel lblEmail = new JLabel("eMail : solst_ice@naver.com", JLabel.RIGHT);
		bottom.add(lblEmail,BorderLayout.SOUTH);
		
		this.add(bottom,BorderLayout.SOUTH);
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Calculator("계산기",250,350);
	}

}
