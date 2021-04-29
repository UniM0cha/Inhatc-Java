package jaaaaava;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Event extends JFrame implements MouseListener, KeyListener, MouseMotionListener {

	JLabel lbl;
	JPanel p;
	private int size;
	
	public Event(){
		this.setSize(300, 300);
		this.setLocationRelativeTo(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("클릭 연습");
//		this.setLayout(new FlowLayout());
		this.addKeyListener(this);
		
		p = new JPanel();
		p.setLayout(null);

		lbl = new JLabel("■");
		lbl.setSize(20, 20);
		lbl.setLocation(50, 50);
		lbl.addMouseListener(this);
		
//		lbl = new JLabel("Love Java");

		p.add(lbl);
		add(p);
		
//		p = new JPanel();
//		p.setBackground(Color.cyan);-
//		p.addMouseListener(this);
//		p.addMouseMotionListener(this);
//		add(p);
		
//		lbl = new JLabel("자기야");
//		lbl.addMouseListener(this);
//		this.add(lbl);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Event();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int xBound = p.getWidth() - lbl.getWidth(); 
		int yBound = p.getHeight() - lbl.getHeight(); 
		int x = (int)(Math.random()*xBound);
		int y = (int)(Math.random()*yBound);
		lbl.setLocation(x, y);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
//		p.setBackground(Color.green);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
//		lbl.setText("사랑해");
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
//		lbl.setText("자기야");
	}

	@Override
	public void keyTyped(KeyEvent e) {
//		if(e.getKeyChar() == 'r') {
//			p.setBackground(Color.red);
//		}
		if(e.getKeyChar() == '+') {
			size = lbl.getFont().getSize();
			size += 5;
			lbl.setFont(new Font("", ABORT, size));
		}
		if(e.getKeyChar() == '-') {
			size = lbl.getFont().getSize();
			if (size >= 10)
				size -= 5;
			lbl.setFont(new Font("", ABORT, size));
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
//		p.setBackground(Color.cyan);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
//		p.setBackground(Color.yellow);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
