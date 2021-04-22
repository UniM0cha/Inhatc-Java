package swing.components;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ComboBoxEx extends JFrame implements ActionListener{
	
	private String[] strs = {"arrow1", "arrow2"};
	private ImageIcon[] imgs = {new ImageIcon("images/right_arrow_green.png"),
			new ImageIcon("images/right_arrow_white.png")};
	private JComboBox<String> cbStr;
	private JLabel lblImg;
	
	public ComboBoxEx(String title, int width, int height) {
		this.setTitle(title);
		this.setSize(width, height);
		this.setLocationRelativeTo(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		//콤보박스 생성
		cbStr = new JComboBox<>(strs);
		cbStr.addActionListener(this);
		
		//초기 이미지 지정
		lblImg = new JLabel(imgs[0]);
		
		add(cbStr);
		add(lblImg);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new ComboBoxEx("Combo 연습",300,300);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 콤보박스가 선택되면 이미지 변경
		Object obj = e.getSource();
		if (obj == cbStr) {
			int index = cbStr.getSelectedIndex();
			lblImg.setIcon(imgs[index]);
		}
	}

}