package swing.components;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class CheckBoxEx extends JFrame implements ItemListener{

	private JCheckBox chk1, chk2, chk3;
	private JLabel lblSum;
	
	public CheckBoxEx(String title, int width, int height) {
		this.setTitle(title);
		this.setSize(width, height);
		this.setLocationRelativeTo(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel Center = new JPanel();
		add(Center,BorderLayout.CENTER);
		
		JLabel lbl1 = new JLabel("사과 100원, 배 500원, 체리 2000원");
		
		//사과 체크박스
		chk1 = new JCheckBox("사과");
		chk1.addItemListener(this);
		chk1.setBorderPainted(true);
		
		//배 체크박스
		chk2 = new JCheckBox("배");
		chk2.addItemListener(this);
		chk2.setBorderPainted(true);
		
		//체리 체크박스
		chk3 = new JCheckBox("체리");
		chk3.addItemListener(this);
		chk3.setBorderPainted(true);
		
		lblSum = new JLabel("현재 0원 입니다.");
		
		Center.add(lbl1);
		Center.add(chk1);
		Center.add(chk2);
		Center.add(chk3);
		Center.add(lblSum);
		
		JPanel Bottom = new JPanel();
		add(Bottom,BorderLayout.SOUTH);
		
		//남자 여자 라디오 버튼 (그룹생성)
		ButtonGroup bg = new ButtonGroup();
		JRadioButton rbMan = new JRadioButton("남자");
		JRadioButton rbWoman = new JRadioButton("여자");
		
		bg.add(rbMan);
		bg.add(rbWoman);
		
		Bottom.add(rbMan);
		Bottom.add(rbWoman);
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new CheckBoxEx("체크박스 연습",250,150);
	}
	
	int sum = 0;

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		Object obj = e.getItem();
		
		//체크박스 기능 구현
		if(e.getStateChange() == ItemEvent.SELECTED) {
			if (obj == chk1) {
				sum += 100;
			}else if(obj == chk2) {
				sum += 500;
			}else if(obj == chk3) {
				sum += 2000;
			}
		}else {
			if (obj == chk1) {
				sum -= 100;
			}else if(obj == chk2) {
				sum -= 500;
			}else if(obj == chk3) {
				sum -= 2000;
			}
		}

		lblSum.setText("현재 " + sum + "원 입니다.");
	}

}
