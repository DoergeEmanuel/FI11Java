package tankstellensoftware;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class ViewZapfsaeule extends JFrame
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
	private JComboBox comboBox;

	
	public ViewZapfsaeule()
	{
		initialize();
		setBounds(100, 100, 332, 260);
	}
	private void initialize() 
	{
		this.setVisible(false);
		setTitle("ViewZapfsaeule");
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
		contentPane.add(getComboBox());
	}
	private JLabel getLabelBenzin() {
		if (labelBenzin == null) {
			labelBenzin = new JLabel("Benzin");
			labelBenzin.setBounds(32, 62, 46, 14);
		}
		return labelBenzin;
	}
	protected JTextField getTextFieldBenzin() {
		if (textFieldBenzin == null) {
			textFieldBenzin = new JTextField();
			textFieldBenzin.setBounds(135, 59, 117, 20);
			textFieldBenzin.setColumns(10);
		}
		return textFieldBenzin;
	}
	protected JTextField getTextFieldSuper() {
		if (textFieldSuper == null) {
			textFieldSuper = new JTextField();
			textFieldSuper.setBounds(135, 99, 117, 20);
			textFieldSuper.setColumns(10);
		}
		return textFieldSuper;
	}
	protected JTextField getTextFieldSuperPlus() {
		if (textFieldSuperPlus == null) {
			textFieldSuperPlus = new JTextField();
			textFieldSuperPlus.setBounds(135, 144, 117, 20);
			textFieldSuperPlus.setColumns(10);
		}
		return textFieldSuperPlus;
	}
	protected JTextField getTextFieldDiesel() {
		if (textFieldDiesel == null) {
			textFieldDiesel = new JTextField();
			textFieldDiesel.setBounds(135, 184, 117, 20);
			textFieldDiesel.setColumns(10);
		}
		return textFieldDiesel;
	}
	private JLabel getLabelSuper() {
		if (labelSuper == null) {
			labelSuper = new JLabel("Super");
			labelSuper.setBounds(32, 102, 46, 14);
		}
		return labelSuper;
	}
	private JLabel getLabelDiesel() {
		if (labelDiesel == null) {
			labelDiesel = new JLabel("Diesel");
			labelDiesel.setBounds(32, 187, 46, 14);
		}
		return labelDiesel;
	}
	private JLabel getLabelSuperPlus() {
		if (labelSuperPlus == null) {
			labelSuperPlus = new JLabel("SuperPlus");
			labelSuperPlus.setBounds(32, 147, 86, 14);
		}
		return labelSuperPlus;
	}
	protected JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(28, 11, 224, 22);
		}
		return comboBox;
	}
}
