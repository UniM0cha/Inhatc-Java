package swing.event;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyActionEvent extends JFrame implements ActionListener{
	// 클래스 자체에 들어있는 리스너
	private JButton btn, btn2;
	
	public MyActionEvent(String title, int width, int height) {
		this.setTitle(title);
		this.setSize(width, height);
		this.setLocationRelativeTo(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		btn = new JButton("Action");
		btn.addActionListener(this);
		// 클래스 자체에 리스너가 삽입되어 있으므로 this로 자신을 가리켜준다.
		this.add(btn);
		
		btn2 = new JButton("잡아.");
		btn2.addActionListener(this);
		this.add(btn2);
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new MyActionEvent("액션 이벤트 연습",300,200);
	}
	// 클래스 자체에 상속되었으므로 클래스 안에서 이벤트 정의
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == btn) {
			System.out.println(btn.getText());
		} else if(obj == btn2) {
			System.out.println(btn2.getText());
		}
	}

}