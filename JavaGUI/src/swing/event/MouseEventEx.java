package swing.event;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseEventEx extends JFrame implements MouseListener, ActionListener{
	
	JButton btn, btn2;
	// 멤버변수로 선언해주어야 색상 적용 가능...!
	
	public MouseEventEx(String title, int x, int y) {
		this.setTitle(title);
		this.setSize(x, y);
		this.setLocationRelativeTo(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		btn = new JButton("마우스 이벤트 테스트 버튼");
		btn.addMouseListener(this);
		btn.addActionListener(this);
		btn.setOpaque(true);	//맥에선 이걸 해줘야 색이 표시됨....
		this.add(btn);
		
		btn2 = new JButton("Test");
		btn2.addMouseListener(this);
		btn2.setOpaque(true);
		this.add(btn2);		
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new MouseEventEx("마우스이벤트 연습",300,200);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	// 마우스가 버튼에 들어오면 버튼에 하늘색 적용
	@Override
	public void mouseEntered(MouseEvent e) {
		Object obj = e.getSource();
		if(obj == btn) {
			btn.setBackground(Color.CYAN);
		} else if(obj == btn2) {
			btn2.setBackground(Color.cyan);
		}
	}

	// 마우스가 버튼에서 나가면 버튼에 노란색 적
	@Override
	public void mouseExited(MouseEvent e) {
		Object obj = e.getSource();
		if(obj == btn) {
			btn.setBackground(Color.yellow);
		} else if(obj == btn2) {
			btn2.setBackground(Color.yellow);
		}
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btn) {
			System.out.println(btn.getText());
		}
	}
}
