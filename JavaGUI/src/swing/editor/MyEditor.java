package swing.editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

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
	private JTextArea ta;

	public MyEditor(String title, int width, int height) {
		this.setTitle(title);
		this.setSize(width, height);
		this.setLocationRelativeTo(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		setMenu();
		
		setJMenuBar(mbar);
		
		ta = new JTextArea();
		ta.setLineWrap(true);
		JScrollPane sp = new JScrollPane(ta,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(sp);
		
		this.setVisible(true);
	}

	private void setMenu() {
		mbar = new JMenuBar();
		
		menuFile = new JMenu("파일");
		
		menuItemNew = new JMenuItem("새파일");
		menuItemNew.addActionListener(this);
		menuItemOpen = new JMenuItem("열기");
		menuItemOpen.addActionListener(this);
		menuItemSave = new JMenuItem("저장");
		menuItemSave.addActionListener(this);
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
		else if (obj == menuItemOpen) {
			ta.setText("");
			
			//filechooser를 연습해봅시다.
			JFileChooser fc = new JFileChooser();
			
			// 필터를 추가한다. 지금은 확장자 기준으로 (TEXT는 이름, txt는 확장자, 확장자는 여러개를 쓸 수 있다.)
			fc.addChoosableFileFilter(new FileNameExtensionFilter("TEXT", "txt"));
			fc.addChoosableFileFilter(new FileNameExtensionFilter("이미지", "jpg", "png", "gif", "bmp", "heif"));
			fc.addChoosableFileFilter(new FileNameExtensionFilter("자바", "java"));
			
			//this 로 설정하면 현재 열려있는 프레임 위에 나타난다. null 로 설정하면 화면의 가운데 (기본값)
			fc.showOpenDialog(this);
			
			File in = fc.getSelectedFile();
			// try catch를 쓰기 위해 이렇게 선언한것.
			BufferedReader br = null;
			String line = null;
			
			//파일을 못찾았을 경우를 대비하여 트라이 캐치
			try {
				br = new BufferedReader(new FileReader(in));
				//파일을 불러와서 한줄씩 읽어서 line에 저장할건데 그 값이 null일때까지 반복
				try {
					while((line = br.readLine()) != null) {
						ta.append(line + "\n");
					}

				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			} finally {
				// br을 쓰고 난 뒤 꼭 닫아주어야 한다.
				try {
					br.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		else if (obj == menuItemSave) {
			JFileChooser fc = new JFileChooser();
			
			fc.addChoosableFileFilter(new FileNameExtensionFilter("TEXT", "txt"));
			fc.addChoosableFileFilter(new FileNameExtensionFilter("이미지", "jpg", "png", "gif", "bmp", "heif"));
			fc.addChoosableFileFilter(new FileNameExtensionFilter("자바", "java"));
			
			//this 로 설정하면 현재 열려있는 프레임 위에 나타난다. null 로 설정하면 화면의 가운데 (기본값)
			fc.showSaveDialog(this);
			
			File out = fc.getSelectedFile();
			BufferedWriter bw = null;
			try {
				bw = new BufferedWriter(new FileWriter(out));
				String str = ta.getText();
				bw.write(str);
			} catch (IOException e1) {
				e1.printStackTrace();
			} finally {
				try {
					bw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}

	}
}
