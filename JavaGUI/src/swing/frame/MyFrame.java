package swing.frame;

import javax.swing.JFrame;

public class MyFrame extends JFrame{
	
	public MyFrame(String title, int width, int height) {
		this.setTitle(title);
		this.setSize(width, height);
		this.setLocationRelativeTo(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new MyFrame("Frame",300,200);
	}

}
