import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ListComboEx extends JFrame{

	private JList<String> lst;
	private ArrayList<String> lstVec = new ArrayList<>();
	private JButton btnRight, btnLeft;
	private JComboBox<String> cb;
	private ArrayList<String> cbVec = new ArrayList<>();

	public ListComboEx(int width, int height, String title) {
		// TODO 프레임 정의
		this.setTitle(title);
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(this);
		this.setLayout(new FlowLayout());
		
		
		lstVec.add("one");
		cbVec.add("one");
		createWest();
		
		createCenter();
		
		createEast();
		
		this.setVisible(true);
	}

	private void createWest() {
		// TODO 리스트 구현
		JPanel panWest = new JPanel();
		
		lst = new JList<>(lstVec);
		JScrollPane sp = new JScrollPane(lst);
		sp.setPreferredSize(new Dimension(100,200));
		
		panWest.add(sp);
		this.add(panWest);
	}
	
	private void createCenter() {
		// TODO 오른쪽 왼쪽 버튼 구현
		JPanel panCenter = new JPanel(new FlowLayout(FlowLayout.CENTER,0,45));
		panCenter.setPreferredSize(new Dimension(100,200));
		
		btnRight = new JButton(">>");
		btnLeft = new JButton("<<");
		
		panCenter.add(btnRight);
		panCenter.add(btnLeft);
		this.add(panCenter);
	}
	
	private void createEast() {
		// TODO 콤보박스 구현
		JPanel panEast = new JPanel();
		
		cb = new JComboBox<>(cbVec);
		cb.setPreferredSize(new Dimension(100,200));
		
		panEast.add(cb);
		this.add(panEast);
	}

	public static void main(String[] args) {
		// TODO	프레임 생성
		new ListComboEx(400, 300, "리스트콤보예제");

	}

}
