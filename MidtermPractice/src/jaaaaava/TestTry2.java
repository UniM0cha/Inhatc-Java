package jaaaaava;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TestTry2 extends JFrame implements ActionListener {

	JMenuItem it, it2;

	public TestTry2() {
		this.setSize(400, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(this);
		this.setTitle("테스트");

		JMenuBar mb = new JMenuBar();
		JMenu menu = new JMenu("도구");
		it = new JMenuItem("계산기");
		it.addActionListener(this);

		menu.add(it);
		mb.add(menu);
		this.setJMenuBar(mb);

		this.setVisible(true);
	}

	public static void main(String[] args) {
		new TestTry2();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == it) {
			new SubFrame2();
		}
	}
}

class SubFrame2 extends JFrame implements ActionListener, ItemListener {

	JComboBox<String> cb;
	JTextField t1, t2, t3;
	String[] str = new String[] { "", "+", "-", "*", "/" };

	public SubFrame2() {
		this.setSize(300, 200);
		this.setLocationRelativeTo(this);
		this.setTitle("계산기");
		this.setLayout(new FlowLayout());

		cb = new JComboBox<>(str);
		cb.addItemListener(this);

		JPanel p = new JPanel(new GridLayout(3, 1));

		t1 = new JTextField(15);
		t2 = new JTextField(15);
		t3 = new JTextField(15);
		t3.setEditable(false);

		p.add(t1);
		p.add(t2);
		p.add(t3);

		add(cb);
		add(p);

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
		// TODO Auto-generated method stub

	}

}


