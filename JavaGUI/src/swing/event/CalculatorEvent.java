package swing.event;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorEvent extends JFrame implements ActionListener{
	
	JTextField txt;
	JButton[] btn = new JButton[16];
	JButton clr;
	int num1, num2, flag = 0;
	
	public CalculatorEvent(String title, int x, int y) {
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
		new CalculatorEvent("계산기",250,350);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton obj = (JButton) e.getSource();
		if(obj == btn[3] || obj == btn[7] || obj == btn[11] || obj == btn[15]) {
			num1 = Integer.parseInt(txt.getText());
			txt.setText(obj.getText());
			if(obj == btn[3]) {
				flag = 1;
			}else if(obj == btn[7]) {
				flag = 2;
			}else if(obj == btn[11]) {
				flag = 3;
			}else {
				flag = 4;
			}
			
		}else if(obj == btn[14]) {
			num2 = Integer.parseInt(txt.getText());
			switch(flag) {
			case 0:
				break;
			case 1:
				txt.setText(Integer.toString(num1 + num2));
				break;
			case 2:
				txt.setText(Integer.toString(num1 - num2));
				break;
			case 3:
				txt.setText(Integer.toString(num1 * num2));
				break;
			case 4:
				txt.setText(Integer.toString(num1 / num2));
				break;
			}
			flag = 0;
		}else if(obj == clr) {
			txt.setText(" ");
			flag = 0;
		}else {
			if(txt.getText().equals(" ")) {
				txt.setText("");
			}
			if(flag != 0) {
				txt.setText("");
			}
			String newText = txt.getText() + obj.getText();
			txt.setText(newText);
		}
	}

}

//구현 못한 것 : 다항식 계산 / 소수점 / 실수계산
