package jaaaaava;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TestTry extends JFrame implements ActionListener, KeyListener {
	
	JTextArea ta;
	JButton btnSend;
	JTextField tf;
	JMenuItem cal;

	public TestTry() {
		this.setSize(400, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("채팅창");
		this.setLocationRelativeTo(this);

		JMenuBar mb = new JMenuBar();
		JMenu menu = new JMenu("도구");
		cal = new JMenuItem("계산기");
		cal.addActionListener(this);

		menu.add(cal);
		mb.add(menu);
		this.setJMenuBar(mb);

		JPanel center = new JPanel(new BorderLayout());
		center.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		ta = new JTextArea();
		ta.setLineWrap(true);
		ta.setEditable(false);
		JScrollPane sp = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		center.add(sp);
		this.add(center, BorderLayout.CENTER);

		JPanel south = new JPanel();

		tf = new JTextField(25);
		tf.addKeyListener(this);

		btnSend = new JButton("전송");
		btnSend.addActionListener(this);

		south.add(tf);
		south.add(btnSend);
		this.add(south, BorderLayout.SOUTH);

		this.setVisible(true);
		tf.requestFocus();
	}

	public static void main(String[] args) {
		new TestTry();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btnSend) {
			Send();
		} else if (obj == cal) {
			new SubFrame(this);
		}
	}

	public void Send() {
		ta.setText(ta.getText() + tf.getText() + "\n");
		tf.setText("");
		tf.requestFocus();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 10) {
			Send();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}

class SubFrame extends JFrame implements ActionListener, ItemListener {

	JComboBox<String> cb;
	JTextField t1, t2, t3;
	String[] str = new String[] { "", "+", "-", "*", "/" };
	TestTry mainframe;
	JButton btn;

	public SubFrame(TestTry mainframe) {
		this.setSize(300, 200);
		this.setLocationRelativeTo(this);
		this.setTitle("계산기");
		this.setLayout(new FlowLayout());

		this.mainframe = mainframe;

		cb = new JComboBox<>(str);
		cb.addItemListener(this);

		JPanel p = new JPanel(new GridLayout(3, 1));

		t1 = new JTextField(15);
		t2 = new JTextField(15);
		t3 = new JTextField(15);
		t3.setEditable(false);

		btn = new JButton("삽입");
		btn.addActionListener(this);

		p.add(t1);
		p.add(t2);
		p.add(t3);

		add(cb);
		add(p);
		add(btn);

		this.setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (!t1.getText().isBlank() && !t2.getText().isBlank()) {
			double n1 = Double.parseDouble(t1.getText());
			double n2 = Double.parseDouble(t2.getText());
			if (e.getItem().equals("+")) {
				t3.setText(n1 + n2 + "");
			} else if (e.getItem().equals("-")) {
				t3.setText(n1 - n2 + "");
			} else if (e.getItem().equals("*")) {
				t3.setText(n1 * n2 + "");
			} else if (e.getItem().equals("/")) {
				t3.setText(n1 / n2 + "");
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn) {
			mainframe.tf.setText(t3.getText());
			this.dispose();
		}
	}
}