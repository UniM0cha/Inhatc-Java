package jaaaaava;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
		JMenu menuLook = new JMenu("보기");
		JMenu menuInput = new JMenu("입력");
		JMenuItem menuZoom = new JMenuItem("화면확대");
		JMenuItem menuBorder = new JMenuItem("쪽윤곽");
		
		menuBar.add(menuFile);
		menuBar.add(menuEdit);
		menuBar.add(menuLook);
		menuBar.add(menuInput);
		menuLook.add(menuZoom);
		menuLook.add(menuZoom);
		menuLook.addSeparator();
		menuLook.add(menuBorder);
		
		this.setJMenuBar(menuBar);
		
		this.setVisible(true);
	}
}

class Three extends JFrame implements ActionListener{
	
	JRadioButton btn1, btn2;
	JPanel p;
	
	public Three() {
		this.setSize(400, 200);
		this.setLocationRelativeTo(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Two RadioButton");
		
		p = new JPanel();
		
		ButtonGroup g = new ButtonGroup();
		btn1 = new JRadioButton("Red");
		btn1.addActionListener(this);
		g.add(btn1);
		btn2 = new JRadioButton("Blue");
		btn2.addActionListener(this);
		g.add(btn2);
		
		p.add(btn1);
		p.add(btn2);
		add(p);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btn1) {
			p.setBackground(Color.red);
		}
		else if (obj == btn2) {
			p.setBackground(Color.BLUE);
		}
	}
	
}

class Four extends JFrame implements ItemListener{
	
	JCheckBox chk1, chk2;
	JButton testBtn;
	
	public Four() {
		this.setSize(300, 200);
		this.setLocationRelativeTo(this);
		this.setTitle("CheckBox");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		chk1 = new JCheckBox("버튼 비활성화");
		chk1.addItemListener(this);
		chk2 = new JCheckBox("버튼 감추기");
		chk2.addItemListener(this);
		
		testBtn = new JButton("test button");
		
		add(chk1);
		add(chk2);
		add(testBtn);
		
		this.setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object obj = e.getSource();
		int state = e.getStateChange();
		if (state == ItemEvent.SELECTED) {
			if (obj == chk1) {
				testBtn.setEnabled(false);
			}
			else if (obj == chk2) {
				testBtn.setVisible(false);
			}
		}
		else if (state == ItemEvent.DESELECTED) {
			if (obj == chk1) {
				testBtn.setEnabled(true);
			}
			else if (obj == chk2) {
				testBtn.setVisible(true);
			}
		}
		
	}
}

class Five extends JFrame implements ActionListener{
	
	JTextArea ta;
	JMenuItem mSave;
	
	public Five() {
		this.setSize(500, 400);
		this.setLocationRelativeTo(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("파일 저장");
		
		JMenuBar mBar = new JMenuBar();
		JMenu mFile = new JMenu("파일");
		mSave = new JMenuItem("저장");
		mSave.addActionListener(this);
		
		ta = new JTextArea();
		ta.setLineWrap(true);
		JScrollPane sp = new JScrollPane(ta);
		
		this.add(sp);
		mBar.add(mFile);
		mFile.add(mSave);
		this.setJMenuBar(mBar);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == mSave) {
			String fileName = JOptionPane.showInputDialog("저장할 파일명을 입력하세요",JOptionPane.OK_CANCEL_OPTION) + ".txt";
			try {
				FileWriter fout = new FileWriter(fileName);
				StringTokenizer st = new StringTokenizer(ta.getText(), "\n");
				
				while(st.hasMoreTokens()) {
					fout.write(st.nextToken());
					fout.write("\r\n");
				}
				fout.close();
			} catch (IOException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(this, "오류가 발생했습니다.", "오류!", JOptionPane.ERROR_MESSAGE);
			}
			JOptionPane.showMessageDialog(this, "성공적으로 저장되었습니다.", "저장 완료", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
}

class Six extends JFrame implements KeyListener{
	
	JTextField beforeTf, afterTf;
	JRadioButton bin, oct, hex;
	
	public Six() {
		this.setSize(300, 100);
		this.setLocationRelativeTo(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Digit Changer");
		this.setLayout(new FlowLayout());
		
		beforeTf = new JTextField(9);
		beforeTf.addKeyListener(this);
		JLabel arrow = new JLabel("→");
		afterTf = new JTextField(9);
		afterTf.setEnabled(false);
		
		ButtonGroup group = new ButtonGroup();
		bin = new JRadioButton("binary");
		group.add(bin);
		oct = new JRadioButton("octal");
		group.add(oct);
		hex = new JRadioButton("hex");
		group.add(hex);
		
		add(beforeTf);
		add(arrow);
		add(afterTf);
		add(bin);
		bin.setSelected(true);
		add(oct);
		add(hex);
		
		this.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		String input = beforeTf.getText();
		int num = Integer.parseInt(input);
		if(bin.isSelected()) {
			afterTf.setText(Integer.toBinaryString(num));
		}
		else if(oct.isSelected()) {
			afterTf.setText(Integer.toOctalString(num));
		}
		else if (hex.isSelected()) {
			afterTf.setText(Integer.toHexString(num));				
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}

class ComponentSeven extends JFrame {
	
	ImageIcon ico = new ImageIcon("img/icons8-arrow-100");
	JLabel lbl;
	
	public ComponentSeven() {
		this.setSize(200,200);
		this.setLocationRelativeTo(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("이미지 드래깅");
		
		
		
		
		
		
		this.setVisible(true);
	}
	
	
}

public class Component extends JFrame{

	public static void main(String[] args) {
//		new One();
//		new Two();
//		new Three();
//		new Four();
//		new Five();
//		new Six();
		new ComponentSeven();
	}

}
