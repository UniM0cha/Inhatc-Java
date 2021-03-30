package swing.event;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.http.WebSocket.Listener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyEvent extends JFrame implements ActionListener{
	
	JButton btnOk, btnCancel;
	
	public MyEvent(String title, int width, int height) {
		this.setTitle(title);
		this.setSize(width, height);
		this.setLocationRelativeTo(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());

		btnOk = new JButton("OK");
		btnOk.addActionListener(this);
		add(btnOk);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(this);
		add(btnCancel);
		
		
		this.setVisible(true);
		
		
	}

	public static void main(String[] args) {
		new MyEvent("이벤트 처리",300,300);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btnOk) {
			System.out.println("1111");
		}else if (obj == btnCancel) {
			System.out.println("2222");
		}
	}

}