package swing.frame;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	
	public MyFrame(String title, int width, int hight) {
		setTitle(title);
		setSize(width, hight);
//		setLocation(800, 300);
		setLocationRelativeTo(this);	// 화면 가운데에 표시
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); - 굳이?
		setVisible(true);
	}

	public static void main(String[] args) {
		new MyFrame("내 프레임", 500, 300);
		
	}

}
