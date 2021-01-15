package Filmdatenbank;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Color;

public class ViewFilm extends JFrame
{

	private JPanel contentPane;
	private JList listFilme;
	private JButton buttonAufsteigend;
	private JButton buttonAbsteigend;
	private JTextField textField;
	private JButton buttonSuche;
	private JButton buttonZurueck;
	private JComboBox comboBox;
	private JButton buttonTitelAbsteigend;
	private JButton buttonTitelAufsteigend;
	private JLabel labelBild;
	private JPanel panel;
	private JPanel panel_1;

	
	public ViewFilm()
	{
		initialize();
		setBounds(100, 100, 755, 540);
	}
	private void initialize() 
	{
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getListFilme());
		contentPane.add(getButtonAufsteigend());
		contentPane.add(getButtonAbsteigend());
		contentPane.add(getTextField());
		contentPane.add(getButtonSuche());
		contentPane.add(getButtonZurueck());
		contentPane.add(getComboBox());
		contentPane.add(getButtonTitelAbsteigend());
		contentPane.add(getButtonTitelAufsteigend());
		contentPane.add(getPanel());
		contentPane.add(getPanel_1());
	}
	protected JList getListFilme() {
		if (listFilme == null) {
			listFilme = new JList();
			listFilme.setBounds(22, 26, 361, 445);
		}
		return listFilme;
	}
	protected JButton getButtonAufsteigend() {
		if (buttonAufsteigend == null) {
			buttonAufsteigend = new JButton("Nummer Aufsteigend");
			buttonAufsteigend.setBounds(567, 173, 150, 23);
		}
		return buttonAufsteigend;
	}
	protected JButton getButtonAbsteigend() {
		if (buttonAbsteigend == null) {
			buttonAbsteigend = new JButton("Nummer Absteigend");
			buttonAbsteigend.setBounds(409, 173, 150, 23);
		}
		return buttonAbsteigend;
	}
	protected JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(409, 241, 308, 20);
			textField.setColumns(10);
		}
		return textField;
	}
	protected JButton getButtonSuche() {
		if (buttonSuche == null) {
			buttonSuche = new JButton("Suche");
			buttonSuche.setBounds(567, 207, 150, 23);
		}
		return buttonSuche;
	}
	protected JButton getButtonZurueck() {
		if (buttonZurueck == null) {
			buttonZurueck = new JButton("Zur\u00FCck");
			buttonZurueck.setBounds(409, 207, 150, 23);
		}
		return buttonZurueck;
	}
	protected JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(409, 283, 308, 22);
		}
		return comboBox;
	}
	protected JButton getButtonTitelAbsteigend() {
		if (buttonTitelAbsteigend == null) {
			buttonTitelAbsteigend = new JButton("Titel Absteigend");
			buttonTitelAbsteigend.setBounds(409, 136, 150, 23);
		}
		return buttonTitelAbsteigend;
	}
	protected JButton getButtonTitelAufsteigend() {
		if (buttonTitelAufsteigend == null) {
			buttonTitelAufsteigend = new JButton("Titel Aufsteigend");
			buttonTitelAufsteigend.setBounds(567, 136, 150, 23);
		}
		return buttonTitelAufsteigend;
	}
	protected JLabel getLabelBild() {
		if (labelBild == null) {
			
           
			labelBild = new JLabel();
			labelBild.setBackground(Color.LIGHT_GRAY);
		}
		return labelBild;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(445, 11, 168, 129);
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(Color.LIGHT_GRAY);
			panel_1.setBounds(434, 337, 113, 111);
			panel_1.add(getLabelBild());
		}
		return panel_1;
	}
}
