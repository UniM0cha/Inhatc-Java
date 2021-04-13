package swing.editor;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MyEditor extends JFrame implements ActionListener{
	
	private JMenuBar mbar;
	private JMenu menuFile;
	private JMenu menuEdit;
	private JMenu menuInfo;
	private JMenuItem menuItemNew;
	private JMenuItem menuItemOpen;
	private JMenuItem menuItemSave;
	private JMenuItem menuItemExit;
	private JMenuItem menuItemCopy;
	private JMenuItem menuItemPaste;
	private JMenuItem menuItemSave1;
	private JMenuItem menuItemInfo;

	public MyEditor(String title, int width, int height) {
		this.setTitle(title);
		this.setSize(width, height);
		this.setLocationRelativeTo(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());

		setMenu();
		
		setJMenuBar(mbar);
		
		this.setVisible(true);
	}

	private void setMenu() {
		mbar = new JMenuBar();
		
		menuFile = new JMenu("파일");
		
		menuItemNew = new JMenuItem("새파일");
		menuItemNew.addActionListener(this);
		menuItemOpen = new JMenuItem("열기");
		menuItemSave = new JMenuItem("저장");
		menuItemExit = new JMenuItem("닫기");
		menuItemExit.addActionListener(this);
		
		menuFile.add(menuItemNew);
		menuFile.add(menuItemOpen);
		menuFile.add(menuItemSave);
		menuFile.addSeparator();
		menuFile.add(menuItemExit);
		mbar.add(menuFile);
		
		
		menuEdit = new JMenu("편집");
		
		menuItemCopy = new JMenuItem("복사");
		menuItemPaste = new JMenuItem("붙혀넣기");
		menuItemSave1 = new JMenuItem("저장");
		
		menuEdit.add(menuItemCopy);
		menuEdit.add(menuItemPaste);
		menuEdit.add(menuItemSave1);
		mbar.add(menuEdit);
		
		
		menuInfo = new JMenu("정보");
		
		menuItemInfo = new JMenuItem("프로그램 정보");
		menuItemInfo.addActionListener(this);
		
		menuInfo.add(menuItemInfo);
		
		mbar.add(menuInfo);
	}

	public static void main(String[] args) {
		new MyEditor("기본 에디터 ver 0.1",600,400);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == menuItemExit) {
			int result = JOptionPane.showConfirmDialog(null, "진짜 나갈거임?","나가기",JOptionPane.OK_CANCEL_OPTION ,JOptionPane.ERROR_MESSAGE);
			if(result == JOptionPane.OK_OPTION) {
				System.exit(0);
			}
		}
		else if (obj == menuItemInfo) {
			JOptionPane.showMessageDialog(null, "기본 에디터 ver 0.1","에디터", JOptionPane.INFORMATION_MESSAGE);
		}
		else if (obj == menuItemNew) {
			String value = JOptionPane.showInputDialog("숫자입력");
			String value2 = JOptionPane.showInputDialog("숫자입력");
			System.out.println(Integer.parseInt(value) + Integer.parseInt(value2));
		}
	}
}
