package jaaaaava;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test extends JFrame implements ActionListener {
	
	JButton btn;
	
	public Test(){
		this.setSize(200, 300);
		
		btn = new JButton("서브프레임");
		btn.addActionListener(this);
		add(btn);
		
		this.setVisible(true);
	}
	
	class frame extends JFrame{
		
		public frame() {
			this.setSize(300, 300);
			this.setLocationRelativeTo(this);
			this.setTitle("테스트");
			
			this.setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		new Test();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new frame();
	}

}
