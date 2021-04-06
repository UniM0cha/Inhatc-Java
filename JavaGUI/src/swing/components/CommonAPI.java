package swing.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CommonAPI extends JFrame implements ActionListener{
	
	private JButton b1, b2;
	
	public CommonAPI(String title, int width, int height) {
		this.setTitle(title);
		this.setSize(width, height);
		this.setLocationRelativeTo(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		setResizable(false);
		
		b1 = new JButton("위치와 크기 정보");
		b1.addActionListener(this);
		
		b2 = new JButton("모양 정보");
		//글자 색, 배경, 폰트 지정
		b2.setForeground(Color.magenta);
		b2.setBackground(Color.yellow);
		b2.setFont(new Font("나눔고딕", Font.BOLD, 20));
		b2.setOpaque(true);	//맥은 설정해야 배경색이 나옵니다...
		b2.addActionListener(this);
		
		add(b1);
		add(b2);
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new CommonAPI("공통 기능 확인",200,200);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == b1) {
			//b1 버튼을 누를 때 위치와 크기 출력
			System.out.println("위치 : " + b1.getX() + ", " + b1.getY());
			System.out.println("크기 : " + b1.getWidth() + ", " + b1.getHeight());
		} else if (obj == b2) {
			//b2 버튼을 누를 때 폰트와 글자색 출력
			System.out.println("폰트 : " + b2.getFont());
			System.out.println("글자색 : " + b2.getForeground());
		}
	}

}
