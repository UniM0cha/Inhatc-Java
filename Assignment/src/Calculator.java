

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame implements ActionListener{
	
	JTextField txt;
	JButton[] btn = new JButton[16];
	JButton clr;
	int num1, num2, flag = 0;
	
	public Calculator(String title, int x, int y) {
		this.setTitle(title);
		this.setSize(x, y);
		this.setLocationRelativeTo(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//TOP
		JPanel top = new JPanel();
		top.setLayout(new BorderLayout());
		
		//제목
		JLabel lblTitle = new JLabel("Swing으로 구현한 계산기",JLabel.CENTER);
		top.add(lblTitle,BorderLayout.NORTH);
		
		//입력란
		txt = new JTextField();
		txt.setHorizontalAlignment(JTextField.RIGHT);
		top.add(txt,BorderLayout.CENTER);
		
		this.add(top,BorderLayout.NORTH);
		
		//CENTER
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(4,4));
		
		//버튼
		String name[] = {"7","8","9","+","4","5","6","-","1","2","3","*","0",".","=","/"};
		
		int i = 0;
		for(String n : name) {
			btn[i] = new JButton(n);
			center.add(btn[i]);
			btn[i].addActionListener(this);
			i++;
		}
		
		this.add(center,BorderLayout.CENTER);
		
		//BOTTOM
		JPanel bottom = new JPanel();
		bottom.setLayout(new BorderLayout());
		
		//클리어 버튼
		clr = new JButton("Clear");
		clr.addActionListener(this);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton ls = (JButton) e.getSource();

		txt.setText(txt.getText() + ls.getText());
	}
}

/* 한칸 지우기
public void actionPerformed(ActionEvent e) {
	int n = label.getText().length()-1;
	
	if (n == 0) {
		label.setText("");
		info.setText("수식을 입력하세요 ");
		flag = 0;
	}						
	else if (n > 0 && n <= 10) {
		label.setFont(new Font("맑은 고딕", 0, 40));
		label.setText(label.getText().substring(0, n));
		info.setText("수식을 지우는 중입니다 ");						
	}						
	else {
		label.setFont(new Font("맑은 고딕", 0, 35));
		label.setText(label.getText().substring(0, n));
		info.setText("수식을 지우는 중입니다 ");
	}
}
*/