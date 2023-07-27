//201912107 배수지
package Calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Button;

public class Calculator {

	private JFrame frmStandardCalculator;
	private JTextField textField;
	double firstnum;
	double secondnum;
	double result;
	String operations;
	String answer;
	private JTextField jtxtConverts;
	private JTextField jlblConverts;
	
	double Rusia = 43.31;
	double Mexico = 15.67;
	double USA = 0.77;
	double Vetnam = 17985.61;
	double Blazil = 3.99; 
	double Sing = 1.07; 
	double Yong = 0.63; 
	double EU = 0.74; 
	double India = 60.28;
	double Japan = 104.55;
	double Canada = 1.00;
	double Tukky = 13.40;
	double Pillipin = 41.86;
	double Ostria = 1.11;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frmStandardCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	*앱 만들기
	*/
	public Calculator() {
		initialize();
	}
	private void initialize() {
		frmStandardCalculator = new JFrame();
		frmStandardCalculator.getContentPane().setFont(new Font("굴림", Font.PLAIN, 14));
		frmStandardCalculator.setTitle("Standard Calculator");
		frmStandardCalculator.setBounds(100, 100, 394, 530);
		frmStandardCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmStandardCalculator.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmSrandard = new JMenuItem("Standard");
		mntmSrandard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmStandardCalculator.setTitle("Standard Calculator");
				frmStandardCalculator.setBounds(100, 100, 394, 530);
				textField.setBounds(12, 10, 356, 70);
				
			}
		});
		mnFile.add(mntmSrandard);
		
		JMenuItem mntmScientific = new JMenuItem("Scientific");
		mntmScientific.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmStandardCalculator.setTitle("Scientific Calculator");
				frmStandardCalculator.setBounds(100, 100, 720, 530);
				textField.setBounds(12, 10, 680, 70);	
			}
		});
		mnFile.add(mntmScientific);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		JMenuItem mntmConversion = new JMenuItem("Conversion");
		mntmConversion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmStandardCalculator.setTitle("Conversion");
				frmStandardCalculator.setBounds(100, 100, 1150, 530);
				textField.setBounds(12, 10, 680, 70);
			}
		});
		mnFile.add(mntmConversion);
		mnFile.add(mntmExit);
		frmStandardCalculator.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setFont(new Font("굴림", Font.PLAIN, 16));
		textField.setBounds(12, 10, 356, 70);
		frmStandardCalculator.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btn_backspace = new JButton("\u2190");
		btn_backspace.setFont(new Font("굴림", Font.PLAIN, 14));
		btn_backspace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String backspace = null;
				
				if(textField.getText().length()>0) {
					StringBuilder strB = new StringBuilder(textField.getText());
					strB.deleteCharAt(textField.getText().length() - 1);
					backspace = strB.toString();
					textField.setText(backspace);
				}
			}
		});
		btn_backspace.setToolTipText("");
		btn_backspace.setBounds(22, 90, 58, 64);
		frmStandardCalculator.getContentPane().add(btn_backspace);
		
		JButton button_1 = new JButton("CE");
		button_1.setFont(new Font("굴림", Font.PLAIN, 14));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField.setText("0");
			}
		});
		button_1.setBounds(92, 90, 58, 64);
		frmStandardCalculator.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("C");
		button_2.setFont(new Font("굴림", Font.PLAIN, 14));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField.setText("");
			}
		});
		button_2.setBounds(162, 90, 58, 64);
		frmStandardCalculator.getContentPane().add(button_2);
		
		JButton btn_pls_mis = new JButton("\u00B1");
		btn_pls_mis.setFont(new Font("굴림", Font.PLAIN, 14));
		btn_pls_mis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double pls_mis = Double.parseDouble(String.valueOf(textField.getText()));
				pls_mis = pls_mis*(-1);
				textField.setText(String.valueOf(pls_mis));
			}
		});
		btn_pls_mis.setBounds(232, 90, 58, 64);
		frmStandardCalculator.getContentPane().add(btn_pls_mis);
		
		JButton btn_root = new JButton("\u221A");
		btn_root.setFont(new Font("굴림", Font.PLAIN, 14));
		btn_root.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double root = Double.parseDouble(String.valueOf(textField.getText()));
				root = Math.sqrt(root);
				textField.setText(String.valueOf(root));
			}
		});
		btn_root.setBounds(302, 90, 58, 64);
		frmStandardCalculator.getContentPane().add(btn_root);
		
		JButton btn_7 = new JButton("7");
		btn_7.setFont(new Font("굴림", Font.PLAIN, 14));
		btn_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String number = textField.getText() + btn_7.getText();
				textField.setText(number);
			}
		});
		btn_7.setToolTipText("");
		btn_7.setBounds(22, 165, 58, 64);
		frmStandardCalculator.getContentPane().add(btn_7);
		
		JButton btn_8 = new JButton("8");
		btn_8.setFont(new Font("굴림", Font.PLAIN, 14));
		btn_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String number = textField.getText() + btn_8.getText();
				textField.setText(number);
			}
		});
		btn_8.setToolTipText("");
		btn_8.setBounds(92, 165, 58, 64);
		frmStandardCalculator.getContentPane().add(btn_8);
		
		JButton btn_9 = new JButton("9");
		btn_9.setFont(new Font("굴림", Font.PLAIN, 14));
		btn_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String number = textField.getText() + btn_9.getText();
				textField.setText(number);
			}
		});
		btn_9.setToolTipText("");
		btn_9.setBounds(162, 165, 58, 64);
		frmStandardCalculator.getContentPane().add(btn_9);
		
		JButton btn_div = new JButton("/");
		btn_div.setFont(new Font("굴림", Font.PLAIN, 14));
		btn_div.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				firstnum = Double.parseDouble(textField.getText());
				textField.setText("");
				operations = "/";
			}
		});
		btn_div.setToolTipText("");
		btn_div.setBounds(232, 165, 58, 64);
		frmStandardCalculator.getContentPane().add(btn_div);
		
		JButton btn_mod = new JButton("%");
		btn_mod.setFont(new Font("굴림", Font.PLAIN, 14));
		btn_mod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				firstnum = Double.parseDouble(textField.getText());
				textField.setText("");
				operations = "%";
			}
		});
		btn_mod.setToolTipText("");
		btn_mod.setBounds(302, 165, 58, 64);
		frmStandardCalculator.getContentPane().add(btn_mod);
		
		JButton btn_4 = new JButton("4");
		btn_4.setFont(new Font("굴림", Font.PLAIN, 14));
		btn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String number = textField.getText() + btn_4.getText();
				textField.setText(number);
			}
		});
		btn_4.setToolTipText("");
		btn_4.setBounds(22, 239, 58, 64);
		frmStandardCalculator.getContentPane().add(btn_4);
		
		JButton btn_5 = new JButton("5");
		btn_5.setFont(new Font("굴림", Font.PLAIN, 14));
		btn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String number = textField.getText() + btn_5.getText();
				textField.setText(number);
			}
		});
		btn_5.setToolTipText("");
		btn_5.setBounds(92, 239, 58, 64);
		frmStandardCalculator.getContentPane().add(btn_5);
		
		JButton btn_6 = new JButton("6");
		btn_6.setFont(new Font("굴림", Font.PLAIN, 14));
		btn_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String number = textField.getText() + btn_6.getText();
				textField.setText(number);
			}
		});
		btn_6.setToolTipText("");
		btn_6.setBounds(162, 239, 58, 64);
		frmStandardCalculator.getContentPane().add(btn_6);
		
		JButton btn_mul = new JButton("*");
		btn_mul.setFont(new Font("굴림", Font.PLAIN, 14));
		btn_mul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				firstnum = Double.parseDouble(textField.getText());
				textField.setText("");
				operations = "*";
			}
		});
		btn_mul.setToolTipText("");
		btn_mul.setBounds(232, 239, 58, 64);
		frmStandardCalculator.getContentPane().add(btn_mul);
		
		JButton btn_num = new JButton("1/x");
		btn_num.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double opt = Double.parseDouble(String.valueOf(textField.getText()));
				opt = (1/opt);
				textField.setText(String.valueOf(opt));
			}
		});
		btn_num.setFont(new Font("굴림", Font.PLAIN, 14));
		btn_num.setToolTipText("");
		btn_num.setBounds(302, 239, 58, 64);
		frmStandardCalculator.getContentPane().add(btn_num);
		
		JButton btn_1 = new JButton("1");
		btn_1.setFont(new Font("굴림", Font.PLAIN, 14));
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String number = textField.getText() + btn_1.getText();
				textField.setText(number);
			}
		});
		btn_1.setToolTipText("");
		btn_1.setBounds(22, 313, 58, 64);
		frmStandardCalculator.getContentPane().add(btn_1);
		
		JButton btn_2 = new JButton("2");
		btn_2.setFont(new Font("굴림", Font.PLAIN, 14));
		btn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String number = textField.getText() + btn_2.getText();
				textField.setText(number);
			}
		});
		btn_2.setToolTipText("");
		btn_2.setBounds(92, 313, 58, 64);
		frmStandardCalculator.getContentPane().add(btn_2);
		
		JButton btn_3 = new JButton("3");
		btn_3.setFont(new Font("굴림", Font.PLAIN, 14));
		btn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String number = textField.getText() + btn_3.getText();
				textField.setText(number);
			}
		});
		btn_3.setToolTipText("");
		btn_3.setBounds(162, 313, 58, 64);
		frmStandardCalculator.getContentPane().add(btn_3);
		
		JButton btn_sub = new JButton("-");
		btn_sub.setFont(new Font("굴림", Font.PLAIN, 14));
		btn_sub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				firstnum = Double.parseDouble(textField.getText());
				textField.setText("");
				operations = "-";
			}
		});
		btn_sub.setToolTipText("");
		btn_sub.setBounds(232, 313, 58, 64);
		frmStandardCalculator.getContentPane().add(btn_sub);
		
		JButton btn_equal = new JButton("=");
		btn_equal.setFont(new Font("굴림", Font.PLAIN, 14));
		btn_equal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String answer;
				secondnum = Double.parseDouble(textField.getText());
				if (operations == "+") {
					result = firstnum + secondnum;
					answer = String.format("%.2f", result);
					textField.setText(answer);
				}
				else if (operations == "-") {
					result = firstnum - secondnum;
					answer = String.format("%.2f", result);
					textField.setText(answer);
				}
				else if (operations == "*") {
					result = firstnum * secondnum;
					answer = String.format("%.2f", result);
					textField.setText(answer);
				}
				else if (operations == "/") {
					result = (firstnum / secondnum);
					answer = String.format("%.2f", result);
					textField.setText(answer);
				}
				else if (operations == "%") {
					result = firstnum % secondnum;
					answer = String.format("%.2f", result);
					textField.setText(answer);
				}
				else if (operations == "x^y") {
					result = Math.pow(firstnum, secondnum);
					answer = String.format("%.2f", result);
					textField.setText(answer);
				}
			}
		});
		btn_equal.setToolTipText("");
		btn_equal.setBounds(302, 313, 58, 138);
		frmStandardCalculator.getContentPane().add(btn_equal);
		
		JButton btn_0 = new JButton("0");
		btn_0.setFont(new Font("굴림", Font.PLAIN, 14));
		btn_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String number = textField.getText() + btn_0.getText();
				textField.setText(number);
			}
		});
		btn_0.setToolTipText("");
		btn_0.setBounds(22, 387, 128, 64);
		frmStandardCalculator.getContentPane().add(btn_0);
		
		JButton btn_dot = new JButton(".");
		btn_dot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField.getText().contains(".")) {
					textField.setText(textField.getText() + btn_dot.getText());
				}
			}
		});
		btn_dot.setFont(new Font("굴림", Font.PLAIN, 14));
		btn_dot.setToolTipText("");
		btn_dot.setBounds(162, 387, 58, 64);
		frmStandardCalculator.getContentPane().add(btn_dot);
		
		JButton btn_add = new JButton("+");
		btn_add.setFont(new Font("굴림", Font.PLAIN, 14));
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				firstnum = Double.parseDouble(textField.getText());
				textField.setText("");
				operations = "+";
			}
		});
		btn_add.setToolTipText("");
		btn_add.setBounds(232, 387, 58, 64);
		frmStandardCalculator.getContentPane().add(btn_add);
		
		JButton btn_Log = new JButton("Log");
		btn_Log.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double opt = Double.parseDouble(String.valueOf(textField.getText()));
				opt = Math.log10(opt);
				textField.setText(String.valueOf(opt));
			}
		});
		btn_Log.setToolTipText("");
		btn_Log.setBounds(382, 90, 70, 64);
		frmStandardCalculator.getContentPane().add(btn_Log);
		
		JButton btn_Sin = new JButton("Sin");
		btn_Sin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double opt = Double.parseDouble(String.valueOf(textField.getText()));
				opt = Math.sin(opt);
				textField.setText(String.valueOf(opt));
			}
		});
		btn_Sin.setToolTipText("");
		btn_Sin.setBounds(465, 90, 70, 64);
		frmStandardCalculator.getContentPane().add(btn_Sin);
		
		JButton btn_Sinh = new JButton("Sinh");
		btn_Sinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double opt = Double.parseDouble(String.valueOf(textField.getText()));
				opt = Math.sinh(opt);
				textField.setText(String.valueOf(opt));
			}
		});
		btn_Sinh.setToolTipText("");
		btn_Sinh.setBounds(548, 90, 70, 64);
		frmStandardCalculator.getContentPane().add(btn_Sinh);
		
		JButton btn_e = new JButton("e");
		btn_e.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double opt;
				opt = (2.71828182846);
				textField.setText(String.valueOf(opt));
			}
		});
		btn_e.setToolTipText("");
		btn_e.setBounds(630, 90, 70, 64);
		frmStandardCalculator.getContentPane().add(btn_e);
		
		JButton btn_pi = new JButton("\u03C0");
		btn_pi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double opt;
				opt = (3.14159265358979);
				textField.setText(String.valueOf(opt));
			}
		});
		btn_pi.setToolTipText("");
		btn_pi.setBounds(382, 165, 70, 64);
		frmStandardCalculator.getContentPane().add(btn_pi);
		
		JButton btn_Cos = new JButton("Cos");
		btn_Cos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double opt = Double.parseDouble(String.valueOf(textField.getText()));
				opt = Math.cos(opt);
				textField.setText(String.valueOf(opt));
			}
		});
		btn_Cos.setToolTipText("");
		btn_Cos.setBounds(465, 165, 70, 64);
		frmStandardCalculator.getContentPane().add(btn_Cos);
		
		JButton btn_Cosh = new JButton("Cosh");
		btn_Cosh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double opt = Double.parseDouble(String.valueOf(textField.getText()));
				opt = Math.cosh(opt);
				textField.setText(String.valueOf(opt));
			}
		});
		btn_Cosh.setToolTipText("");
		btn_Cosh.setBounds(548, 165, 70, 64);
		frmStandardCalculator.getContentPane().add(btn_Cosh);
		
		JButton btn_loge = new JButton("lnx");
		btn_loge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double opt = Double.parseDouble(String.valueOf(textField.getText()));
				opt = Math.log(opt);
				textField.setText(String.valueOf(opt));
			}
		});
		btn_loge.setToolTipText("");
		btn_loge.setBounds(630, 165, 70, 64);
		frmStandardCalculator.getContentPane().add(btn_loge);
		
		JButton btn_xy = new JButton("x^y");
		btn_xy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnum = Double.parseDouble(textField.getText());
				textField.setText("");
				operations = "x^y";
			}
		});
		btn_xy.setToolTipText("");
		btn_xy.setBounds(382, 239, 70, 64);
		frmStandardCalculator.getContentPane().add(btn_xy);
		
		JButton btn_Tan = new JButton("Tan");
		btn_Tan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double opt = Double.parseDouble(String.valueOf(textField.getText()));
				opt = Math.tan(opt);
				textField.setText(String.valueOf(opt));
			}
		});
		btn_Tan.setToolTipText("");
		btn_Tan.setBounds(465, 239, 70, 64);
		frmStandardCalculator.getContentPane().add(btn_Tan);
		
		JButton btn_Tanh = new JButton("Tanh");
		btn_Tanh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double opt = Double.parseDouble(String.valueOf(textField.getText()));
				opt = Math.tanh(opt);
				textField.setText(String.valueOf(opt));
			}
		});
		btn_Tanh.setToolTipText("");
		btn_Tanh.setBounds(548, 239, 70, 64);
		frmStandardCalculator.getContentPane().add(btn_Tanh);
		
		JButton btn_Exp = new JButton("Exp");
		btn_Exp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double opt = Double.parseDouble(String.valueOf(textField.getText()));
				opt = Math.pow(2.71828182846,opt);
				textField.setText(String.valueOf(opt));
			}
		});
		btn_Exp.setToolTipText("");
		btn_Exp.setBounds(630, 239, 70, 64);
		frmStandardCalculator.getContentPane().add(btn_Exp);
		
		JButton btn_square = new JButton("x^2");
		btn_square.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double opt = Double.parseDouble(String.valueOf(textField.getText()));
				opt = (opt*opt);
				textField.setText(String.valueOf(opt));
			}
		});
		btn_square.setToolTipText("");
		btn_square.setBounds(382, 313, 70, 64);
		frmStandardCalculator.getContentPane().add(btn_square);
		
		JButton btn_cube = new JButton("x^3");
		btn_cube.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double opt = Double.parseDouble(String.valueOf(textField.getText()));
				opt = (opt*opt*opt);
				textField.setText(String.valueOf(opt));
			}
		});
		btn_cube.setToolTipText("");
		btn_cube.setBounds(382, 387, 70, 64);
		frmStandardCalculator.getContentPane().add(btn_cube);
		
		JButton btn_Cbr = new JButton("Cbr");
		btn_Cbr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double opt = Double.parseDouble(String.valueOf(textField.getText()));
				opt = Math.cbrt(opt);
				textField.setText(String.valueOf(opt));
			}
		});
		btn_Cbr.setToolTipText("");
		btn_Cbr.setBounds(465, 313, 70, 64);
		frmStandardCalculator.getContentPane().add(btn_Cbr);
		
		JButton btn_Rund = new JButton("Rund");
		btn_Rund.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double opt = Double.parseDouble(String.valueOf(textField.getText()));
				opt = Math.round(opt);
				textField.setText(String.valueOf(opt));
			}
		});
		btn_Rund.setToolTipText("");
		btn_Rund.setBounds(548, 313, 70, 64);
		frmStandardCalculator.getContentPane().add(btn_Rund);
		
		JButton btn_2pi = new JButton("2*\u03C0");
		btn_2pi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double opt;
				opt = 2*(3.14159265358979);
				textField.setText(String.valueOf(opt));
			}
		});
		btn_2pi.setToolTipText("");
		btn_2pi.setBounds(630, 313, 70, 64);
		frmStandardCalculator.getContentPane().add(btn_2pi);
		
		JButton btn_Bin = new JButton("Bin");
		btn_Bin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int a = Integer.parseInt(textField.getText());
				textField.setText(Integer.toString(a,2));
			}
		});
		btn_Bin.setToolTipText("");
		btn_Bin.setBounds(465, 387, 70, 64);
		frmStandardCalculator.getContentPane().add(btn_Bin);
		
		JButton btn_Hex = new JButton("Hex");
		btn_Hex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int a = Integer.parseInt(textField.getText());
				textField.setText(Integer.toString(a,16));
			}
		});
		btn_Hex.setToolTipText("");
		btn_Hex.setBounds(548, 387, 70, 64);
		frmStandardCalculator.getContentPane().add(btn_Hex);
		
		JButton btn_Oc = new JButton("Octal");
		btn_Oc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int a = Integer.parseInt(textField.getText());
				textField.setText(Integer.toString(a,8));
			}
		});
		btn_Oc.setToolTipText("");
		btn_Oc.setBounds(630, 387, 70, 64);
		frmStandardCalculator.getContentPane().add(btn_Oc);
		
		JComboBox jcmbCurrencys = new JComboBox();
		jcmbCurrencys.setFont(new Font("굴림", Font.PLAIN, 30));
		jcmbCurrencys.setModel(new DefaultComboBoxModel(new String[] {"\uB098\uB77C \uC120\uD0DD", "\uB7EC\uC2DC\uC544", "\uBA55\uC2DC\uCF54", "\uBBF8\uAD6D", "\uBCA0\uD2B8\uB0A8", "\uBE0C\uB77C\uC9C8", "\uC2F1\uAC00\uD3EC\uB974", "\uC601\uAD6D", "\uC720\uB7FD\uC5F0\uD569", "\uC778\uB3C4", "\uC77C\uBCF8", "\uCE90\uB098\uB2E4", "\uD130\uD0A4", "\uD544\uB9AC\uD540", "\uD638\uC8FC"}));
		jcmbCurrencys.setBounds(733, 90, 364, 78);
		frmStandardCalculator.getContentPane().add(jcmbCurrencys);
		
		JLabel label = new JLabel("\uD658\uC728 \uACC4\uC0B0\uAE30");
		label.setFont(new Font("굴림", Font.BOLD, 40));
		label.setBounds(806, 24, 220, 56);
		frmStandardCalculator.getContentPane().add(label);
		
		jtxtConverts = new JTextField();
		jtxtConverts.setFont(new Font("굴림", Font.PLAIN, 25));
		jtxtConverts.setBounds(733, 199, 364, 64);
		frmStandardCalculator.getContentPane().add(jtxtConverts);
		jtxtConverts.setColumns(10);
		
		JButton btnConverts = new JButton("Convert");
		btnConverts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double Korean_Won = Double.parseDouble(jtxtConverts.getText());
				if(jcmbCurrencys.getSelectedItem().equals("러시아"))
				{
					String cConvert1 = String.format("%.2f 루블", (Korean_Won*Rusia)/1000);
					jlblConverts.setText(cConvert1);
				}
				if(jcmbCurrencys.getSelectedItem().equals("멕시코"))
				{
					String cConvert2 = String.format("%.2f 페소", (Korean_Won*Mexico)/1000);
					jlblConverts.setText(cConvert2);
				}
				if(jcmbCurrencys.getSelectedItem().equals("미국"))
				{
					String cConvert3 = String.format("%.2f 달러", (Korean_Won*USA)/1000);
					jlblConverts.setText(cConvert3);
				}
				if(jcmbCurrencys.getSelectedItem().equals("베트남"))
				{
					String cConvert4 = String.format("%.2f 동", (Korean_Won*Vetnam)/1000);
					jlblConverts.setText(cConvert4);
				}
				if(jcmbCurrencys.getSelectedItem().equals("브라질"))
				{
					String cConvert5 = String.format("%.2f 헤알", (Korean_Won*Blazil)/1000);
					jlblConverts.setText(cConvert5);
				}
				if(jcmbCurrencys.getSelectedItem().equals("싱가포르"))
				{
					String cConvert6 = String.format("%.2f 달러", (Korean_Won*Sing)/1000);
					jlblConverts.setText(cConvert6);
				}	
				if(jcmbCurrencys.getSelectedItem().equals("영국"))
				{
					String cConvert7 = String.format("%.2f 파운드", (Korean_Won*Yong)/1000);
					jlblConverts.setText(cConvert7);
				}
				if(jcmbCurrencys.getSelectedItem().equals("유럽연합"))
				{
					String cConvert8 = String.format("%.2f 유로", (Korean_Won*EU)/1000);
					jlblConverts.setText(cConvert8);
				}
				if(jcmbCurrencys.getSelectedItem().equals("인도"))
				{
					String cConvert9 = String.format("%.2f 루피", (Korean_Won*India)/1000);
					jlblConverts.setText(cConvert9);
				}
				if(jcmbCurrencys.getSelectedItem().equals("일본"))
				{
					String cConvert10 = String.format("%.2f 엔", (Korean_Won*Japan)/1000);
					jlblConverts.setText(cConvert10);
				}
				if(jcmbCurrencys.getSelectedItem().equals("캐나다"))
				{
					String cConvert11 = String.format("%.2f 달러", (Korean_Won*Canada)/1000);
					jlblConverts.setText(cConvert11);
				}
				if(jcmbCurrencys.getSelectedItem().equals("터키"))
				{
					String cConvert12 = String.format("%.2f 리라", (Korean_Won*Tukky)/1000);
					jlblConverts.setText(cConvert12);
				}
				if(jcmbCurrencys.getSelectedItem().equals("필리핀"))
				{
					String cConvert13 = String.format("%.2f 페소", (Korean_Won*Pillipin)/1000);
					jlblConverts.setText(cConvert13);
				}
				if(jcmbCurrencys.getSelectedItem().equals("호주"))
				{
					String cConvert14 = String.format("%.2f 달러", (Korean_Won*Ostria)/1000);
					jlblConverts.setText(cConvert14);
				}
				
			}
		});
		btnConverts.setFont(new Font("굴림", Font.PLAIN, 25));
		btnConverts.setBounds(755, 395, 144, 49);
		frmStandardCalculator.getContentPane().add(btnConverts);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jtxtConverts.setText(null);
				jlblConverts.setText(null);
				jcmbCurrencys.setSelectedItem("나라 선택");
			}
		});
		btnClear.setFont(new Font("굴림", Font.PLAIN, 25));
		btnClear.setBounds(931, 395, 136, 49);
		frmStandardCalculator.getContentPane().add(btnClear);
		
		jlblConverts = new JTextField();
		jlblConverts.setFont(new Font("굴림", Font.PLAIN, 25));
		jlblConverts.setBounds(755, 294, 312, 56);
		frmStandardCalculator.getContentPane().add(jlblConverts);
		jlblConverts.setColumns(10);
	}
}

