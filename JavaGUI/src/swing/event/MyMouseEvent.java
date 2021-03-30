package swing.event;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;



public class MyMouseEvent extends JFrame implements MouseListener, MouseMotionListener, KeyListener{
	
	private JLabel lbl;
	private Container c;
	
	public MyMouseEvent(String title, int width, int height) {
		this.setTitle(title);
		this.setSize(width, height);
		this.setLocationRelativeTo(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		c = getContentPane();
		c.setLayout(null);
		c.addMouseListener(this);
		c.addMouseMotionListener(this);
		c.addKeyListener(this);
		
		lbl = new JLabel("김승민 닭꼬치");
		lbl.setSize(100, 25);
		lbl.setLocation(100, 100);
		c.add(lbl);
		
		this.setVisible(true);
		
		c.requestFocus();
	}

	public static void main(String[] args) {
		new MyMouseEvent("마우스 이벤트",300,200);
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		System.out.println(x + ", " + y);
		lbl.setLocation(x, y);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1) {
			Point p = e.getPoint();
			lbl.setLocation(p);
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		switch(code) {
		case KeyEvent.VK_UP:
			lbl.setLocation(lbl.getX(), lbl.getY()-10);
			break;
		case KeyEvent.VK_DOWN:
			lbl.setLocation(lbl.getX(), lbl.getY()+10);
			break;
		case KeyEvent.VK_LEFT:
			lbl.setLocation(lbl.getX()-10, lbl.getY());
			break;
		case KeyEvent.VK_RIGHT:
			lbl.setLocation(lbl.getX()+10, lbl.getY());
			break;
		}

		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
