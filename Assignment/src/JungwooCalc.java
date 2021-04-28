
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JungwooCalc extends JFrame implements ActionListener{

	private JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17;
	private JTextField tf;
	private String ot, t, nt, k = "";
	private Double n1 , n2, result;
	private int i = 0;
	private String[] arr1 = new String[10], arr2 = new String[11];
	
	public JungwooCalc(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		JPanel p1 = new JPanel();
		JLabel lb = new JLabel("Swing 으로 구현한 계산기",0);
		tf = new JTextField();
		p1.setLayout(new BorderLayout());
		p1.add(lb,BorderLayout.NORTH);
		p1.add(tf);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(4,4,0,0));
		b1 = new JButton("7"); p2.add(b1);
		b1.addActionListener(this);
		
		b2 = new JButton("8"); p2.add(b2);
		b2.addActionListener(this);
		
		b3 = new JButton("9"); p2.add(b3);
		b3.addActionListener(this);
		
		b4 = new JButton("-"); p2.add(b4);
		b4.addActionListener(this);
		
		b5 = new JButton("4"); p2.add(b5);
		b5.addActionListener(this);
		
		b6 = new JButton("5"); p2.add(b6);
		b6.addActionListener(this);
		
		b7 = new JButton("6"); p2.add(b7);
		b7.addActionListener(this);
		
		b8 = new JButton("+"); p2.add(b8);
		b8.addActionListener(this);
		
		b9 = new JButton("1"); p2.add(b9);
		b9.addActionListener(this);
		
		b10 = new JButton("2"); p2.add(b10);
		b10.addActionListener(this);
		
		b11 = new JButton("3"); p2.add(b11);
		b11.addActionListener(this);
		
		b12 = new JButton("*"); p2.add(b12);
		b12.addActionListener(this);
		
		b13 = new JButton("0"); p2.add(b13);
		b13.addActionListener(this);
		
		b14 = new JButton("."); p2.add(b14);
		b14.addActionListener(this);
		
		b15 = new JButton("="); p2.add(b15);
		b15.addActionListener(this);
		
		b16 = new JButton("/"); p2.add(b16);
		b16.addActionListener(this);
		
		JPanel p3 = new JPanel();
		b17 = new JButton("CLEAR");
		b17.addActionListener(this);
		//JLabel lb2 = new JLabel("만든이 : 박정우", JLabel.RIGHT);
		//JLabel lb3 = new JLabel("eMail : qsc0415@naver.com", JLabel.RIGHT);
 
		p3.setLayout(new BorderLayout());
		p3.add(b17, BorderLayout.NORTH);
		//p3.add(lb2, BorderLayout.CENTER);
		//p3.add(lb3, BorderLayout.SOUTH);
		
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);
		add(p3, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new JungwooCalc("계산기", 200, 300);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == b1) {													// 7
			ot = tf.getText();
			t = b1.getText();
			nt = ot + t;
			k += t;
			tf.setText(nt);
		}
		if(obj == b2) {													// 8
			ot = tf.getText();
			t = b2.getText();
			nt = ot + t;
			k += t;
			tf.setText(nt);	
		}
		if(obj == b3) {													// 9
			ot = tf.getText();
			t = b3.getText();
			nt = ot + t;
			k += t;
			tf.setText(nt);	
		}
		if(obj == b4) {													// -
			arr1[i] = "-";
			arr2[i] = k;
			i++;
			k = "";
			ot = tf.getText();
			t = b4.getText();
			nt = ot + t;
			tf.setText(nt);
		}
		if(obj == b5) {													// 4
			ot = tf.getText();
			t = b5.getText();
			nt = ot + t;
			k += t;
			tf.setText(nt);	
		}
		if(obj == b6) {													// 5
			ot = tf.getText();
			t = b6.getText();
			nt = ot + t;
			k += t;
			tf.setText(nt);	
		}
		if(obj == b7) {													// 6
			ot = tf.getText();
			t = b7.getText();
			nt = ot + t;
			k += t;
			tf.setText(nt);	
		}
		if(obj == b8) {													// +
			arr1[i] = "+";
			arr2[i] = k;
			i++;
			k = "";
			ot = tf.getText();
			t = b8.getText();
			nt = ot + t;
			tf.setText(nt);	
		}
		if(obj == b9) {													// 1
			ot = tf.getText();
			t = b9.getText();
			nt = ot + t;
			k += t;
			tf.setText(nt);	
		}
		if(obj == b10) {												// 2
			ot = tf.getText();
			t = b10.getText();
			nt = ot + t;
			k += t;
			tf.setText(nt);
		}
		if(obj == b11) {												// 3
			ot = tf.getText();
			t = b11.getText();
			nt = ot + t;
			k += t;
			tf.setText(nt);
		}
		if(obj == b12) {												// *
			arr1[i] = "*";
			arr2[i] = k;
			i++;
			k = "";
			ot = tf.getText();
			t = b12.getText();
			nt = ot + t;
			tf.setText(nt);
		}
		if(obj == b13) {												// 0
			ot = tf.getText();
			t = b13.getText();
			nt = ot + t;
			k += t;
			tf.setText(nt);
		}
		if(obj == b14) {												// .
			ot = tf.getText();
			t = b14.getText();
			nt = ot + t;
			tf.setText(nt);
		}
		if(obj == b15) {												// =
			arr2[i] = k;
			for(int j = 0; j < i; j++) {
				if (arr1[j].equals("*")) {
					n1 = Double.parseDouble(arr2[j]);
					n2 = Double.parseDouble(arr2[j + 1]);
					result = n1 * n2;
					arr1[j] = null;
					arr2[j] = null;
					arr2[j + 1] = result + "";
				}
				else if (arr1[j].equals("/")) {
					n1 = Double.parseDouble(arr2[j]);
					n2 = Double.parseDouble(arr2[j + 1]);
					result = n1 / n2;
					arr1[j] = null;
					arr2[j] = null;
					arr2[j + 1] = result + "";
				}
			}
			for(int j = 0; j < i; j++) {
				if (arr1[j].equals("+")) {
					n1 = Double.parseDouble(arr2[j]);
					for(int q = j + 1; q <= i; q++) {
						if(!arr2[q].equals("")) {
							n2 = Double.parseDouble(arr2[q]);
							result = n1 + n2;
							arr2[q] = result + "";
							break;
						}
					}	
				}
				else if (arr1[j].equals("-")) {
					n1 = Double.parseDouble(arr2[j]);
					for(int q = j + 1; q <= i; q++) {
						if(arr2[q] != null) {
							n2 = Double.parseDouble(arr2[q]);
							result = n1 - n2;
							arr2[q] = result + "";
							break;
						}
					}	
				}
			}
			tf.setText(result + "");
			
			
		}
		if(obj == b16) {												// /
			arr1[i] = "/";
			arr2[i] = k;
			i++;
			k = "";
			ot = tf.getText();
			t = b16.getText();
			nt = ot + t;
			tf.setText(nt);
		}
		if(obj == b17) {												// clear
			tf.setText(null);
			new JungwooCalc("계산기", 200, 300);
			this.dispose();
		}
	}
}