package swing.app;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SubFrame extends JFrame implements ActionListener{
	
	private JPanel cenPanel;
	private JTextField tfID;
	private JButton btnOk;
	private MainFrame mainFrame;

	public JTextField getTfID() {
		return tfID;
	}

	public void setTfID(JTextField tfID) {
		this.tfID = tfID;
	}

	public SubFrame(String title, int width, int height, MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		mainFrame.setTitle("다음주 월요일에 시험...");
		setTitle(title);
		setSize(width,height);
		setLocationRelativeTo(this);
		
		setCenPenel();
		
		setVisible(true);
	}

	private void setCenPenel() {
		cenPanel = new JPanel();
		cenPanel.setBackground(Color.BLUE);
		
		JLabel lbl = new JLabel("아이디 : ");
		
		tfID = new JTextField(10);
		
		btnOk = new JButton("OK");
		btnOk.addActionListener(this);
		
		cenPanel.add(lbl);
		cenPanel.add(tfID);
		cenPanel.add(btnOk);
		add(cenPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if (obj == btnOk) {
//			mainFrame.setTitle("잠시 쉴까요?");
			// 메인프레임의 텍스트 필드에 서브프레임의 텍스트 필드에 입력한 값 적용
			mainFrame.getTfID().setText(tfID.getText());
		}
		
	}

}
