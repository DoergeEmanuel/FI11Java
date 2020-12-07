package tankstellensoftware;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewIntern extends JFrame
{

	private JPanel contentPane;
	private JLabel labelBenzin;
	private JTextField textFieldBenzin;
	private JTextField textFieldSuper;
	private JTextField textFieldSuperPlus;
	private JTextField textFieldDiesel;
	private JLabel labelSuper;
	private JLabel labelDiesel;
	private JLabel labelSuperPlus;
	private JButton buttonAktualisieren;

	
	public ViewIntern()
	{
		initialize();
		setBounds(100, 100, 302, 299);
	}
	private void initialize() 
	{
		this.setVisible(true);
		setTitle("ViewIntern");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		contentPane.add(getLabelBenzin());
		contentPane.add(getTextFieldBenzin());
		contentPane.add(getTextFieldSuper());
		contentPane.add(getTextFieldSuperPlus());
		contentPane.add(getTextFieldDiesel());
		contentPane.add(getLabelSuper());
		contentPane.add(getLabelDiesel());
		contentPane.add(getLabelSuperPlus());
		contentPane.add(getButtonAktualisieren());
	}
	private JLabel getLabelBenzin() {
		if (labelBenzin == null) {
			labelBenzin = new JLabel("Benzin");
			labelBenzin.setBounds(32, 44, 46, 14);
		}
		return labelBenzin;
	}
	protected JTextField getTextFieldBenzin() {
		if (textFieldBenzin == null) {
			textFieldBenzin = new JTextField();
			textFieldBenzin.setBounds(135, 41, 86, 20);
			textFieldBenzin.setColumns(10);
		}
		return textFieldBenzin;
	}
	protected JTextField getTextFieldSuper() {
		if (textFieldSuper == null) {
			textFieldSuper = new JTextField();
			textFieldSuper.setBounds(135, 86, 86, 20);
			textFieldSuper.setColumns(10);
		}
		return textFieldSuper;
	}
	protected JTextField getTextFieldSuperPlus() {
		if (textFieldSuperPlus == null) {
			textFieldSuperPlus = new JTextField();
			textFieldSuperPlus.setBounds(135, 131, 86, 20);
			textFieldSuperPlus.setColumns(10);
		}
		return textFieldSuperPlus;
	}
	protected JTextField getTextFieldDiesel() {
		if (textFieldDiesel == null) {
			textFieldDiesel = new JTextField();
			textFieldDiesel.setBounds(135, 183, 86, 20);
			textFieldDiesel.setColumns(10);
		}
		return textFieldDiesel;
	}
	private JLabel getLabelSuper() {
		if (labelSuper == null) {
			labelSuper = new JLabel("Super");
			labelSuper.setBounds(32, 89, 46, 14);
		}
		return labelSuper;
	}
	private JLabel getLabelDiesel() {
		if (labelDiesel == null) {
			labelDiesel = new JLabel("Diesel");
			labelDiesel.setBounds(32, 186, 46, 14);
		}
		return labelDiesel;
	}
	private JLabel getLabelSuperPlus() {
		if (labelSuperPlus == null) {
			labelSuperPlus = new JLabel("SuperPlus");
			labelSuperPlus.setBounds(32, 134, 86, 14);
		}
		return labelSuperPlus;
	}
	protected JButton getButtonAktualisieren() {
		if (buttonAktualisieren == null) {
			buttonAktualisieren = new JButton("Aktivieren");
			buttonAktualisieren.setBounds(29, 226, 192, 23);
		}
		return buttonAktualisieren;
	}
}
