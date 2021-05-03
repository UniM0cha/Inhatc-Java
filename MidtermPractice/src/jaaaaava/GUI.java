package jaaaaava;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI {

	public static void main(String[] args) {
		new Seven(); 
	}
}

class Seven extends JFrame implements ActionListener {
	
	JButton newStar, exit, edit;
	JTextField tf;
	int num = 10;
	JPanel center;
	
	public Seven() {
		this.setSize(300, 300);
		this.setLocationRelativeTo(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("3개의 패널을 가진 어쩌구");
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
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
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
