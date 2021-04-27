package swing.app;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame extends JFrame implements ActionListener{
	
	private JPanel cenPanel;
	private JTextField tfID;
	private JButton btnOk;
	private JButton btnGet;
	private SubFrame sf;

	public JTextField getTfID() {
		return tfID;
	}

	public MainFrame(String title, int width, int height) {
		setTitle(title);
		setSize(width,height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(this);
		
		setCenPenel();
		
		setVisible(true);
	}

	private void setCenPenel() {
		cenPanel = new JPanel();
		cenPanel.setBackground(Color.YELLOW);
		
		JLabel lbl = new JLabel("아이디 : ");
		
		tfID = new JTextField(10);
		
		btnOk = new JButton("OK");
		btnOk.addActionListener(this);
		
		btnGet = new JButton("설정");
		btnGet.addActionListener(this);
		
		cenPanel.add(lbl);
		cenPanel.add(tfID);
		cenPanel.add(btnOk);
		cenPanel.add(btnGet);
		add(cenPanel);
	}

	public static void main(String[] args) {
		new MainFrame("타이틀", 300, 150);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btnOk) {
			// 생성할 때 부모 클래스의 주소값을 자식 클래스에게 보내준다.
			sf = new SubFrame("서브 프레임", 300, 300, this);
		}
		else if (obj == btnGet) {
			// 메인프레임에서 서브프레임의 제목 지정
			sf.setTitle("다음주는 시험");
			// 서브프레임의 텍스트필드에 메인프레임의 텍스트필드에 입력한 값 적용
			sf.getTfID().setText(tfID.getText());
		}
		
	}

}
