package jaaaaava;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ListComboImage extends JFrame implements ActionListener{

	private String[] data = new String[] {"data1","data2","data3","data4","data5","data6"};
	private JList<String> lst;
	// Jlist에는 addItem이 존재하지 않아서 model을 이용해 추가해준다.
	private DefaultListModel<String> model = new DefaultListModel<>();
	private JButton btnRight, btnLeft;
	private JComboBox<String> cb;
	private Vector<String> cbVec = new Vector<>();

	public ListComboImage(int width, int height, String title) {
		// TODO 프레임 정의
		this.setTitle(title);
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(this);
		this.setLayout(new FlowLayout());
		
		// model 초기화
		for(String str : data)
			model.addElement(str);
		
		// 멤버함수로 구현
		createWest();
		createCenter();
		createEast();
		
		this.setVisible(true);
	}

	private void createWest() {
		// TODO 리스트 구현
		JPanel panWest = new JPanel();
		
		lst = new JList<>(model);
		
		JScrollPane sp = new JScrollPane(lst);
		sp.setPreferredSize(new Dimension(100,200));
		
		panWest.add(sp);
		this.add(panWest);
	}
	
	private void createCenter() {
		// TODO 오른쪽 왼쪽 이미지 버튼 구현
		JPanel panCenter = new JPanel(new FlowLayout(FlowLayout.CENTER,0,25));
		panCenter.setPreferredSize(new Dimension(100,200));
		
		ImageIcon rightArrow = new ImageIcon("img/icons8-arrow-100.png");
		ImageIcon leftArrow = new ImageIcon("img/icons8-arrow-101.png");

		btnRight = new JButton(rightArrow);
//		btnRight = new JButton(">>");
		btnRight.addActionListener(this);
		btnLeft = new JButton(leftArrow);
//		btnLeft = new JButton("<<");
		btnLeft.addActionListener(this);
		
		panCenter.add(btnRight);
		panCenter.add(btnLeft);
		this.add(panCenter);
	}
	
	private void createEast() {
		// TODO 콤보박스 구현
		JPanel panEast = new JPanel();
		
		cb = new JComboBox<>(cbVec);
		cb.setPreferredSize(new Dimension(100,20));
		
		panEast.add(cb);
		this.add(panEast);
	}

	public static void main(String[] args) {
		// TODO	프레임 생성
		new ListComboImage(400, 300, "리스트콤보예제");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 버튼 이벤트 구현
		Object obj = e.getSource();
		if (obj == btnRight) {
			// 선택되지 않았음에도 값이 들어가는 현상 발생
			if(lst.getSelectedValue() != null) {
				// 리스트에서 삭제함과 동시에 콤보박스에 삽입
				cb.addItem(model.remove(lst.getSelectedIndex()));
			}
		}
		else if (obj == btnLeft) {
			// 콤보박스에 데이터가 없는 경우 오류발생
			if(!cbVec.isEmpty()) {
				// 콤보박스에서 삭제함과 동시에 리스트에 삽입
				model.addElement(cbVec.remove(cb.getSelectedIndex()));
				// 연속으로 제거하려고 하면 오류발생
				if(cbVec.size() > 0)
					cb.setSelectedIndex(0);
				else
					cb.setSelectedIndex(-1);
			}
		}
		
		
	}
}
