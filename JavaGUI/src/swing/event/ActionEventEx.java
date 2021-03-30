package swing.event;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ActionEventEx extends JFrame{
	
	public ActionEventEx(String title, int x, int y) {
		this.setTitle(title);
		this.setSize(x, y);
		this.setLocationRelativeTo(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		MyActionListener listner = new MyActionListener();
		// 리스너 클래스를 이용하여 리스너 생성
		
		JButton btn = new JButton("Action");
		btn.addActionListener(listner);
		// 버튼에 리스너 삽입
		
		this.add(btn);
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new ActionEventEx("액션 이벤트 연습",300,200);
	}
	// 클래스를 따로 나누어 리스너 생성 -- 이 방법은 잘 쓰지 않는다
	class MyActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			String n = b.getText();
			if(n.equals("Action")) {
				b.setText("액션");
			} else {
				b.setText("Action");
			}
			// Action과 액션 왔다갔다
		}
		
	}
}

