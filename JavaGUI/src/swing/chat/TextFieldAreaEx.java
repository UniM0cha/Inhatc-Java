package swing.chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextFieldAreaEx extends JFrame implements ActionListener{
	
	private JPanel panCenter, panSouth; 
	private JTextField tf;
	private JButton btnOk;
	private JTextArea ta;
	
	public TextFieldAreaEx(String title, int width, int height) {
		this.setTitle(title);
		this.setSize(width, height);
		this.setLocationRelativeTo(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		setCenter();
		setSouth();
		
		add(panCenter, BorderLayout.CENTER);
		add(panSouth, BorderLayout.SOUTH);
		
		this.setVisible(true);
		tf.requestFocus();
	}
	
	private void setCenter() {
		panCenter = new JPanel();
		panCenter.setLayout(new BorderLayout());
		
		ta = new JTextArea();
		JScrollPane scroll = new JScrollPane(ta,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		ta.setEditable(false);
		ta.setFont(new Font("", Font.BOLD, 13));
		panCenter.add(scroll);
		
		panCenter.setBackground(Color.yellow);
	}

	private void setSouth() {
		panSouth = new JPanel();
		
		tf = new JTextField(16);
		tf.addActionListener(this);
		panSouth.add(tf);
		
		btnOk = new JButton("전송");
		btnOk.addActionListener(this);
		panSouth.add(btnOk);
		
		panSouth.setBackground(Color.BLUE);
	}

	public static void main(String[] args) {
		new TextFieldAreaEx("My Chat",300,400);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btnOk || obj == tf) {
			ta.append("이준기 : " + tf.getText() + "\n");
			tf.setText("");
			tf.requestFocus();
		}
	}
}
