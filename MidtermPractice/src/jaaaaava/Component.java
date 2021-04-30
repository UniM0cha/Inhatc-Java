package jaaaaava;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

class One extends JFrame{
	
	public One() {
		this.setSize(800, 200);
		this.setLocationRelativeTo(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("4 Images");
		this.setLayout(new GridLayout(1, 4));
		
		JLabel img1 = new JLabel(new ImageIcon(new ImageIcon("img/IMG_0171.png").getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
		JLabel img2 = new JLabel(new ImageIcon(new ImageIcon("img/IMG_0172.png").getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
		JLabel img3 = new JLabel(new ImageIcon(new ImageIcon("img/IMG_0173.png").getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
		JLabel img4 = new JLabel(new ImageIcon(new ImageIcon("img/IMG_0174.png").getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
		add(img1);
		add(img2);
		add(img3);
		add(img4);
		
		this.setVisible(true);
	}
	
}

class Two extends JFrame{
	public Two() {
		this.setSize(300, 200);
		this.setLocationRelativeTo(this);
		this.setTitle("메뉴 만들기");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menuFile = new JMenu("파일");
		JMenu menuEdit = new JMenu("편집");
		JMenu menuFile = new JMenu("파일");
		JMenu menuFile = new JMenu("파일");
		JMenuItem menuZoom = new JMenuItem("화면확대");
		
		menuBar.add(menuFile);
		
		this.setJMenuBar(menuBar);
		
		this.setVisible(true);
	}
}

public class Component extends JFrame{

	public static void main(String[] args) {
//		new One();
		new Two();
	}

}
