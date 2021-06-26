import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class MainFrame extends JFrame implements ActionListener {

	JMenuItem item;
	DefaultListModel<String> model = new DefaultListModel<>();
	JList<String> list = new JList<>(model);

	public MainFrame() {
		this.setTitle("201845092 이정윤");
		System.out.println("김승민");
		this.setLocationRelativeTo(this);
		this.setSize(300, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		JMenuBar mb = new JMenuBar();
		JMenu menu = new JMenu("문제");
		item = new JMenuItem("간단계산기");
		item.addActionListener(this);

		JScrollPane sp = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.add(sp);

		menu.add(item);
		mb.add(menu);
		this.setJMenuBar(mb);

		this.setVisible(true);
	}

	public static void main(String[] args) {
		new MainFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == item) {
			new cal(this);
		}
	}
}

class cal extends JFrame implements ActionListener {

	JTextField tf;
	JButton btn1, btn2, btn3, btn4, btn5, btn6, btnC, btnE;
	MainFrame mainframe;

	public cal(MainFrame mainframe) {
		this.setTitle("간단한 계산기");
		this.setLocationRelativeTo(this);
		this.setSize(300, 220);
		this.mainframe = mainframe;

		JPanel panNorth = new JPanel(new BorderLayout());

		JPanel p1 = new JPanel();
		p1.setBackground(Color.yellow);

		JLabel lbl = new JLabel("201845092 / 이정윤");
		p1.add(lbl);
		panNorth.add(p1, BorderLayout.NORTH);

		JPanel p2 = new JPanel();
		p2.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		tf = new JTextField("0", 23);
		tf.setHorizontalAlignment(JTextField.RIGHT);
		p2.add(tf);
		panNorth.add(p2, BorderLayout.SOUTH);

		this.add(panNorth, BorderLayout.NORTH);

		JPanel panCenter = new JPanel(new GridLayout(2, 4, 5, 5));
		panCenter.setBorder(BorderFactory.createEmptyBorder(5, 25, 15, 25));

		btn1 = new JButton("1");
		btn1.addActionListener(this);
		panCenter.add(btn1);
		btn2 = new JButton("2");
		btn2.addActionListener(this);
		panCenter.add(btn2);
		btn3 = new JButton("3");
		btn3.addActionListener(this);
		panCenter.add(btn3);
		btnC = new JButton("C");
		btnC.addActionListener(this);
		panCenter.add(btnC);
		btn4 = new JButton("4");
		btn4.addActionListener(this);
		panCenter.add(btn4);
		btn5 = new JButton("5");
		btn5.addActionListener(this);
		panCenter.add(btn5);
		btn6 = new JButton("6");
		btn6.addActionListener(this);
		panCenter.add(btn6);
		btnE = new JButton("=");
		btnE.addActionListener(this);
		panCenter.add(btnE);

		this.add(panCenter, BorderLayout.CENTER);

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton obj = (JButton) e.getSource();
		if (tf.getText().equals("0")) {
			if (!(obj == btnC) && !(obj == btnE)) {
				tf.setText(obj.getText());
			}
		} else {
			if (obj == btnC) {
				int len = tf.getText().length();
				if (len > 1) {
					tf.setText(tf.getText().substring(0, len - 1));
				} else if (len == 1) {
					tf.setText("0");
				}
			} else if (obj == btnE) {
				mainframe.model.addElement(tf.getText());
				tf.setText("0");
			} else {
				tf.setText(tf.getText() + obj.getText());
			}
		}

	}
}
