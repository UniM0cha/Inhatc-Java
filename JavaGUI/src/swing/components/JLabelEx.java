package swing.components;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class JLabelEx extends JFrame{
	
	public JLabelEx(String title, int width, int height) {
		this.setTitle(title);
		this.setSize(width, height);
		this.setLocationRelativeTo(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());

		//System.out.println(System.getProperty("user.dir"));
		
		//전화기 이미지 출력
		ImageIcon iconTel = new ImageIcon("images/tel.png");
		JLabel lblImg = new JLabel(iconTel);
		add(lblImg);
		
		//자바 이미지 출력
		ImageIcon iconJava = new ImageIcon("images/java.png");
		JLabel lblImg2 = new JLabel(iconJava);
		add(lblImg2);
		
		//화살표 이미지가 들어간 버튼 생성
		ImageIcon arrWhite = new ImageIcon("images/right_arrow_white.png");
		ImageIcon arrGreen = new ImageIcon("images/right_arrow_green.png");
		JButton btn = new JButton("버튼", arrWhite);
		btn.setVerticalTextPosition(JButton.BOTTOM);
		btn.setRolloverIcon(arrGreen);
		btn.setPressedIcon(arrGreen);		
		add(btn);
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new JLabelEx("JLabel 연습",500,300);
	}

}
