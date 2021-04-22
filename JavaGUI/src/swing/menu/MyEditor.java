package swing.menu;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MyEditor extends JFrame implements ActionListener{
	
	private JMenuBar mb;
	private JMenu menuFile, menuEdit, menuInfo;
	private JMenuItem menuItemNew, menuItemOpen, menuItemSave, menuItemExit;
	private JMenuItem menuItemInfo;

	public MyEditor(String title, int width, int height) {
		this.setTitle(title);
		this.setSize(width, height);
		this.setLocationRelativeTo(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());

		//멤버함수로 따로 생성
		makeMenu();
		
		this.setJMenuBar(mb);
		
		this.setVisible(true);
	}

	private void makeMenu() {
		// TODO 메뉴 만들기
		mb = new JMenuBar();
		menuFile = new JMenu("File");
		menuItemNew = new JMenuItem("New");
		menuItemOpen = new JMenuItem("Open");
		menuItemSave = new JMenuItem("Save");
		menuItemExit = new JMenuItem("Exit");
		menuItemExit.addActionListener(this);
		
		menuEdit = new JMenu("Edit");

		menuInfo = new JMenu("Info");
		menuItemInfo = new JMenuItem("About..");
		
		menuFile.add(menuItemNew);
		menuFile.add(menuItemOpen);
		menuFile.add(menuItemSave);
		menuFile.addSeparator();
		menuFile.add(menuItemExit);
		mb.add(menuFile);
		
		mb.add(menuEdit);
		
		menuInfo.add(menuItemInfo);
		mb.add(menuInfo);
	}

	public static void main(String[] args) {
		new MyEditor("간단 메모장",800,500);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 닫기 메뉴 아이템 구현
		Object obj = e.getSource();
		if(obj == menuItemExit) {
			System.exit(0);
		}
		
	}

}
