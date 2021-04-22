package swing.components;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class ListEx extends JFrame implements MouseListener{
	
	private String[] tests = {"test1", "test2", "test3",
			"test4", "test5", "test6","test7", "test8", "test9", "test10"};
	private JList<String> lstTest;
	private JList<ImageIcon> lstImg;
	private ImageIcon[] imgs = {new ImageIcon("images/right_arrow_green.png"),
			new ImageIcon("images/right_arrow_white.png"),
			new ImageIcon("images/java.png")};
	
	public ListEx(String title, int width, int height) {
		this.setTitle(title);
		this.setSize(width, height);
		this.setLocationRelativeTo(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		//리스트에 스트링 배열 추가
		lstTest = new JList<String>(tests);
		//마우스 리스너 추가 가능
		lstTest.addMouseListener(this);
		
		//스크롤 팬 추가
		JScrollPane sp = new JScrollPane(lstTest,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(sp);

		
		lstImg = new JList<ImageIcon>(imgs);
		add(lstImg);
		
		
		this.setVisible(true);
	}

	
	
	public static void main(String[] args) {
		new ListEx("List 연습",500,500);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
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

}