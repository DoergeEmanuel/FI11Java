package dateTimeTerminkalender;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTextField;

public class View extends JFrame
{

	private JPanel contentPane;
	private JTable table_1;
	private JLabel labelTitel;
	private JLabel labelDatum;
	private JLabel labelRestzeit;
	private JList listTermine;
	private JLabel labelTitel2;
	private JButton buttonHinzufuegen;
	private JTextField textFieldTitel;
	private JTextField textFieldJahr;
	private JTextField textFieldMonat;
	private JTextField textFieldTag;
	private JTextField textFieldStunde;
	private JLabel labelJahr;
	private JLabel labelMonat;
	private JLabel labelTag;
	private JLabel labelStunde;
	private JButton buttonAktualisieren;
	private JLabel labelMinute;
	private JTextField textFieldMinute;

	
	public View()
	{
		initialize();
		setBounds(100, 100, 870, 516);
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getTable_1());
		contentPane.add(getLabelTitel());
		contentPane.add(getLabelDatum());
		contentPane.add(getLabelRestzeit());
		contentPane.add(getListTermine());
		contentPane.add(getLabelTitel2());
		contentPane.add(getButtonHinzufuegen());
		contentPane.add(getTextFieldTitel());
		contentPane.add(getTextFieldJahr());
		contentPane.add(getTextFieldMonat());
		contentPane.add(getTextFieldTag());
		contentPane.add(getTextFieldStunde());
		contentPane.add(getLabelJahr());
		contentPane.add(getLabelMonat());
		contentPane.add(getLabelTag());
		contentPane.add(getLabelStunde());
		contentPane.add(getButtonAktualisieren());
		contentPane.add(getLabelMinute());
		contentPane.add(getTextFieldMinute());
	}
	protected JTable getTable_1() {
		if (table_1 == null) {
			table_1 = new JTable();
			table_1.setBounds(423, 249, 1, 1);
		}
		return table_1;
	}
	protected JLabel getLabelTitel() {
		if (labelTitel == null) {
			labelTitel = new JLabel("Titel");
			labelTitel.setBounds(59, 23, 46, 14);
		}
		return labelTitel;
	}
	protected JLabel getLabelDatum() {
		if (labelDatum == null) {
			labelDatum = new JLabel("Datum");
			labelDatum.setBounds(178, 23, 46, 14);
		}
		return labelDatum;
	}
	protected JLabel getLabelRestzeit() {
		if (labelRestzeit == null) {
			labelRestzeit = new JLabel("Restzeit");
			labelRestzeit.setBounds(309, 23, 46, 14);
		}
		return labelRestzeit;
	}
	protected JList getListTermine() {
		if (listTermine == null) {
			listTermine = new JList();
			listTermine.setBounds(59, 71, 605, 266);
		}
		return listTermine;
	}
	protected JLabel getLabelTitel2() {
		if (labelTitel2 == null) {
			labelTitel2 = new JLabel("Titel");
			labelTitel2.setBounds(59, 385, 65, 14);
		}
		return labelTitel2;
	}
	protected JButton getButtonHinzufuegen() {
		if (buttonHinzufuegen == null) {
			buttonHinzufuegen = new JButton("Hinzufuegen");
			buttonHinzufuegen.setBounds(715, 290, 129, 47);
		}
		return buttonHinzufuegen;
	}
	protected JTextField getTextFieldTitel() {
		if (textFieldTitel == null) {
			textFieldTitel = new JTextField();
			textFieldTitel.setBounds(59, 421, 118, 20);
			textFieldTitel.setColumns(10);
		}
		return textFieldTitel;
	}
	protected JTextField getTextFieldJahr() {
		if (textFieldJahr == null) {
			textFieldJahr = new JTextField();
			textFieldJahr.setBounds(199, 421, 76, 20);
			textFieldJahr.setColumns(10);
		}
		return textFieldJahr;
	}
	protected JTextField getTextFieldMonat() {
		if (textFieldMonat == null) {
			textFieldMonat = new JTextField();
			textFieldMonat.setColumns(10);
			textFieldMonat.setBounds(309, 421, 76, 20);
		}
		return textFieldMonat;
	}
	protected JTextField getTextFieldTag() {
		if (textFieldTag == null) {
			textFieldTag = new JTextField();
			textFieldTag.setColumns(10);
			textFieldTag.setBounds(415, 421, 76, 20);
		}
		return textFieldTag;
	}
	protected JTextField getTextFieldStunde() {
		if (textFieldStunde == null) {
			textFieldStunde = new JTextField();
			textFieldStunde.setColumns(10);
			textFieldStunde.setBounds(527, 421, 76, 20);
		}
		return textFieldStunde;
	}
	protected JLabel getLabelJahr() {
		if (labelJahr == null) {
			labelJahr = new JLabel("Jahr");
			labelJahr.setBounds(199, 385, 65, 14);
		}
		return labelJahr;
	}
	protected JLabel getLabelMonat() {
		if (labelMonat == null) {
			labelMonat = new JLabel("Monat");
			labelMonat.setBounds(308, 385, 65, 14);
		}
		return labelMonat;
	}
	protected JLabel getLabelTag() {
		if (labelTag == null) {
			labelTag = new JLabel("Tag");
			labelTag.setBounds(413, 385, 65, 14);
		}
		return labelTag;
	}
	protected JLabel getLabelStunde() {
		if (labelStunde == null) {
			labelStunde = new JLabel("Stunde");
			labelStunde.setBounds(527, 385, 65, 14);
		}
		return labelStunde;
	}
	protected JButton getButtonAktualisieren() {
		if (buttonAktualisieren == null) {
			buttonAktualisieren = new JButton("Aktualisieren");
			buttonAktualisieren.setBounds(715, 222, 129, 47);
		}
		return buttonAktualisieren;
	}
	private JLabel getLabelMinute() {
		if (labelMinute == null) {
			labelMinute = new JLabel("Minute");
			labelMinute.setBounds(694, 385, 65, 14);
		}
		return labelMinute;
	}
	protected JTextField getTextFieldMinute() {
		if (textFieldMinute == null) {
			textFieldMinute = new JTextField();
			textFieldMinute.setColumns(10);
			textFieldMinute.setBounds(683, 421, 76, 20);
		}
		return textFieldMinute;
	}
}
