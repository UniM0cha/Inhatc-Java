package jaaaaava;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JFrame implements ActionListener{
	
//	JButton btn;
//	JLabel one, plus, two, three;
	JButton newStar, exit, edit;
	JTextField tf;
	int num = 10;
	JPanel center;
	
	public GUI() {
//		this.setSize(400, 200);
		this.setSize(300, 300);
		this.setLocationRelativeTo(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setTitle("Let's study Java");
//		this.setTitle("BorderLayout Practice");
//		this.setTitle("FlowLayout Practice");
//		this.setTitle("Random Labels");
		this.setTitle("3개의 패널을 가진 어쩌구");
//		this.setLayout(new BorderLayout(50,5));
//		this.setLayout(new FlowLayout());
//		this.setLayout(null);
		this.setLayout(new BorderLayout());
		
		JPanel north = new JPanel();
		north.setBackground(Color.yellow);
		newStar = new JButton("새로 배치");
		newStar.addActionListener(this);
		exit = new JButton("종료");
		exit.addActionListener(this);
		north.add(newStar);
		north.add(exit);
		this.add(north, BorderLayout.NORTH);
		
		center = new JPanel(null);
		this.add(center, BorderLayout.CENTER);
		
		JPanel south = new JPanel();
		south.setBackground(Color.gray);
		edit = new JButton("별 개수 수정");
		edit.addActionListener(this);
		tf = new JTextField(10);
		south.add(edit);
		south.add(tf);
		this.add(south, BorderLayout.SOUTH);
		
		
//		for(int i = 0; i < 19; i++) {
//			JLabel lbl = new JLabel(Integer.toString(i));
//			int x = (int)(Math.random()*220) + 30;
//			int y = (int)(Math.random()*220) + 30;
//			lbl.setLocation(x,y);
//			lbl.setSize(20,20);
//			lbl.setForeground(Color.magenta);
//			add(lbl);
//		}
		
//		one = new JLabel("100");
//		plus = new JLabel("+");
//		two = new JLabel("200");
//		btn = new JButton("=");
//		btn.addActionListener(this);
//		three = new JLabel("");
//		
//		add(one);
//		add(plus);
//		add(two);
//		add(btn);
//		add(three);
		
//		JButton north = new JButton("North");
//		JButton west = new JButton("West");
//		JButton center = new JButton("Center");
//		JButton east = new JButton("East");
//		JButton south = new JButton("South");
		
//		add(north,BorderLayout.NORTH);
//		add(west,BorderLayout.WEST);
//		add(center,BorderLayout.CENTER);
//		add(east,BorderLayout.EAST);
//		add(south,BorderLayout.SOUTH);
		
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new GUI(); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
//		if (obj == btn) {
//			three.setText((Integer.parseInt(one.getText()) + Integer.parseInt(two.getText())) + "");
//		}
		
		if(obj == newStar) {
			newStarCreate();
		}
		else if (obj == exit) {
			System.exit(0);
		}
		else if (obj == edit) {
			if (!tf.getText().equals("")) {
				num = Integer.parseInt(tf.getText());
				newStarCreate();
			}
		}
	}

	private void newStarCreate() {
		center.removeAll();
		for(int i = 0; i < num; i++) {
			JLabel lbl = new JLabel("*");
			int x = (int)(Math.random()*270) + 5;
			int y = (int)(Math.random()*170) + 5;
			lbl.setLocation(x,y);
			lbl.setSize(20,20);
			lbl.setForeground(Color.magenta);
			center.add(lbl);
		}
		center.repaint();
	}
}

