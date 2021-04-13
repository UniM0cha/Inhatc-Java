import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SwingGUI extends JFrame {
	
	JPanel p, left, right;

	public SwingGUI(String title, int width, int height) {
		this.setTitle(title);
		this.setSize(width, height);
		this.setLocationRelativeTo(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		p = new JPanel();
		p.setBackground(Color.gray);
		p.setLayout(null);
		add(p);

		left = new JPanel();
		left.setSize(170, 180);
		left.setLocation(10, 10);
		left.setBackground(Color.yellow);
		left.setLayout(new GridLayout(4,1));
		left.setBorder(BorderFactory.createEmptyBorder(3,20,50,20));
		p.add(left);
		
		JLabel ID = new JLabel("Type ID",JLabel.CENTER);
		ID.setFont(new Font("",Font.BOLD,15));
		left.add(ID);
		JTextField IDInput = new JTextField(10);
		left.add(IDInput);
		JLabel Pw = new JLabel("Type Password",JLabel.CENTER);
		Pw.setFont(new Font("",Font.BOLD,15));
		left.add(Pw);
		JTextField PwInput = new JTextField(10);
		left.add(PwInput);
		
		right = new JPanel();
		right.setSize(170, 180);
		right.setLocation(200, 10);
		right.setBackground(Color.green);
		right.setLayout(new GridLayout(3,1));
		right.setBorder(BorderFactory.createEmptyBorder(3,20,85,20));
		p.add(right);
		
		JLabel Favor = new JLabel("좋아하는 프로그램",JLabel.CENTER);
		right.add(Favor);
		JCheckBox Java = new JCheckBox("Java 프로그램");
		Java.setSelected(true);
		Java.setOpaque(true);
		right.add(Java);
		JCheckBox Cp = new JCheckBox("C++ 프로그램");
		Cp.setOpaque(true);
		right.add(Cp);
		
		JButton Ok = new JButton("OK");
		Ok.setLocation(150, 200);
		Ok.setSize(90,40);
		p.add(Ok);
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new SwingGUI("Cotainer & Component",400, 280);
	}
}
