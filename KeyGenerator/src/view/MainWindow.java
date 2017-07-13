package view;

import controller.ButtonController;

import javax.swing.*;

import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.LEADING;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

	private JTextField jtfNumber;
	private JButton jbGenerate;
	private JCheckBox cbCapital;
	private JCheckBox cbNonCapital;
	private JCheckBox cbNumber;
	private JCheckBox cbSpecial;
	private JTextPane jtpKey;

	public MainWindow() {
		jtfNumber = new JTextField();
		jtfNumber.setBorder(BorderFactory.createTitledBorder("Number of chars"));
		jtfNumber.setBackground(getForeground());
		cbCapital = new JCheckBox("Capital letter");
		cbNonCapital = new JCheckBox("Non-capital letter");
		cbNumber = new JCheckBox("Number");
		cbSpecial = new JCheckBox("Special character");
		jbGenerate = new JButton("Generate");

		cbCapital.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		cbNonCapital.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		cbNumber.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		cbSpecial.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

		JPanel jpAux = new JPanel();

		GroupLayout layout = new GroupLayout(jpAux);
		jpAux.setLayout(layout);
		this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

		//GroupLayout layout = new GroupLayout(getContentPane());
		//this.getContentPane().setLayout(layout);

		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(LEADING)
						.addComponent(jtfNumber)
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(LEADING)
										.addComponent(cbCapital)
										.addComponent(cbNumber))
								.addGroup(layout.createParallelGroup(LEADING)
										.addComponent(cbNonCapital)
										.addComponent(cbSpecial))))
				.addGroup(layout.createParallelGroup(LEADING)
						.addComponent(jbGenerate))
		);

		layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(BASELINE)
						.addComponent(jtfNumber)
						.addComponent(jbGenerate))
				.addGroup(layout.createParallelGroup(LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(BASELINE)
										.addComponent(cbCapital)
										.addComponent(cbNonCapital))
								.addGroup(layout.createParallelGroup(BASELINE)
										.addComponent(cbNumber)
										.addComponent(cbSpecial))))
		);

		this.add(jpAux);

		jtpKey = new JTextPane();
		jtpKey.setEditable(false);
		jtpKey.setBackground(getForeground());
		jtpKey.setBorder(BorderFactory.createTitledBorder("Key"));
		this.add(jtpKey);


		setTitle("Password generator");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public void registerController(ButtonController controller) {
		jbGenerate.addActionListener(controller);
		jtfNumber.addActionListener(controller);
	}

	public int getNumber() {
		try {
			return Integer.parseInt(jtfNumber.getText());
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public boolean[] getConditions() {
		boolean[] conds = new boolean[4];
		conds[0] = cbCapital.isSelected();
		conds[1] = cbNonCapital.isSelected();
		conds[2] = cbNumber.isSelected();
		conds[3] = cbSpecial.isSelected();
		return conds;
	}

	public void showUser(String str) {
		jtpKey.setText(str);
	}
}
