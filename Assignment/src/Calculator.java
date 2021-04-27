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
	
	JTextField txt; // 텍스트필드
	JButton[] btn = new JButton[16]; // 입력버튼
	JButton clr; // 클리어 버튼
	private JButton c;
	int op = 0; // 연산자를 구별하기 위한 변수
	double num = 0;
	double acc = 0;
	boolean isCal = false;
	boolean isFirst = true;
	
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
		
		//숫자, 연산기호 버튼
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
		
		JPanel can = new JPanel();
		bottom.add(can,BorderLayout.NORTH);
		
		//C 버튼
		c = new JButton("C");
		c.addActionListener(this);
		can.add(c);
		
		//클리어 버튼
		clr = new JButton("Clear");
		clr.addActionListener(this);
		can.add(clr);
		
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
		// 버튼의 텍스트를 불러와 변수 s에 저장
		String s = e.getActionCommand();
		
		// +,-,*,/,= 등 기능키에 대한 정의
		if(s == "+" || s == "-" || s == "*" || s == "/" || s == "=") {
			isCal = true;
			if (isFirst) {
				if(!txt.getText().equals(""))
					acc = Double.parseDouble(txt.getText());
				isFirst = false;
				setOperator(s);
				return;
			}
			
			// 후처리 계산을 위해 op변수에 연산자 저장
			num = Double.parseDouble(txt.getText());
			switch(op) {
			case 1:
				acc += num;
				break;
			case 2:
				acc -= num;
				break;
			case 3:
				acc *= num;
				break;
			case 4:
				acc /= num;
				break;
			}
			
			setOperator(s);
		}

		else if (s == "C") {
			// c구현
			int len = txt.getText().length();
			if (len > 0) {
				txt.setText(txt.getText().substring(0, len-1));
			}
		}
		else if (s == "Clear") {
			// clear구현
			txt.setText("");
			num = 0;
			op = 0;
			isFirst = true;
			isCal = false;
			return;
		}
		else {
			// 숫자키 구현
			if (isCal) {
				txt.setText("");
			}
			txt.setText(txt.getText() + s);
			isCal = false;
		}
	}

	private void setOperator(String s) {
		if(s == "+") {
			op = 1;
			txt.setText("+");
		}
		else if (s == "-") {
			op = 2;
			txt.setText("-");
		}
		else if (s == "*") {
			op = 3;
			txt.setText("*");
		}
		else if (s == "/") {
			op = 4;
			txt.setText("/");
		}
		else if (s == "=") {
			txt.setText(acc + "");
			op = 0;
			acc = 0;
			num = 0;
			isFirst = true;
			isCal = true;
		}
	}
}