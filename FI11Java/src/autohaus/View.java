package autohaus;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class View extends JFrame {

	private JPanel contentPane;
	private JList list;
	private JLabel labelLogo;
	private JLabel labelAuswahl;
	private JLabel labelModel;
	private JLabel labelFarbe;
	private JLabel labelPS;
	private JLabel labelExtras;
	private JComboBox comboBoxModell;
	private JComboBox comboBoxFarbe;
	private JComboBox comboBoxPs;
	private JComboBox comboBoxExtras;
	private JButton buttonBestaetigen;
	private JLabel labelPreisNetto;
	private JLabel labelMWSt;
	private JLabel labelPreisBrutto;
	private JLabel labelWertPreisNetto;
	private JLabel labelWertMWSt;
	private JLabel labelWertPreisBrutto;
	private JButton buttonBestellen;

	
	public View() 
	{
		initialize();
		setBounds(100, 100, 645, 432);
	}
	private void initialize()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.add(getList());
		contentPane.add(getLabelLogo());
		contentPane.add(getLabelAuswahl());
		contentPane.add(getLabelModel());
		contentPane.add(getLabelFarbe());
		contentPane.add(getLabelPS());
		contentPane.add(getLabelExtras());
		contentPane.add(getComboBoxModell());
		contentPane.add(getComboBoxFarbe());
		contentPane.add(getComboBoxPs());
		contentPane.add(getComboBoxExtras());
		contentPane.add(getButtonBestaetigen());
		contentPane.add(getLabelPreisNetto());
		contentPane.add(getLabelMWSt());
		contentPane.add(getLabelPreisBrutto());
		contentPane.add(getLabelWertPreisNetto());
		contentPane.add(getLabelWertMWSt());
		contentPane.add(getLabelWertPreisBrutto());
		contentPane.add(getButtonBestellen());
		
	}
	private JList getList() {
		if (list == null) {
			list = new JList();
			list.setBounds(281, 66, 320, 134);
		}
		return list;
	}
	
	private JLabel getLabelLogo() 
	{
		if (labelLogo == null) 
		{
			ImageIcon ico = new ImageIcon("Autohaus/Alset.png");
            ico.setImage(ico.getImage().getScaledInstance(200, 60, Image.SCALE_DEFAULT));
			labelLogo = new JLabel(ico);
			labelLogo.setBounds(10, 11, 138, 81);
		}
		return labelLogo;
	}
	private JLabel getLabelAuswahl() {
		if (labelAuswahl == null) {
			labelAuswahl = new JLabel("Ihre Auswahl:");
			labelAuswahl.setFont(new Font("Tahoma", Font.BOLD, 12));
			labelAuswahl.setBounds(281, 26, 131, 29);
		}
		return labelAuswahl;
	}
	private JLabel getLabelModel() {
		if (labelModel == null) {
			labelModel = new JLabel("Modell:");
			labelModel.setBounds(10, 124, 60, 21);
		}
		return labelModel;
	}
	private JLabel getLabelFarbe() {
		if (labelFarbe == null) {
			labelFarbe = new JLabel("Farbe:");
			labelFarbe.setBounds(10, 168, 39, 14);
		}
		return labelFarbe;
	}
	private JLabel getLabelPS() {
		if (labelPS == null) {
			labelPS = new JLabel("PS:");
			labelPS.setBounds(10, 212, 46, 14);
		}
		return labelPS;
	}
	private JLabel getLabelExtras() {
		if (labelExtras == null) {
			labelExtras = new JLabel("Extras:");
			labelExtras.setBounds(10, 256, 46, 14);
		}
		return labelExtras;
	}
	protected JComboBox getComboBoxModell() {
		if (comboBoxModell == null) {
			comboBoxModell = new JComboBox();
			comboBoxModell.setBounds(74, 123, 164, 22);
		}
		return comboBoxModell;
	}
	protected JComboBox getComboBoxFarbe() {
		if (comboBoxFarbe == null) {
			comboBoxFarbe = new JComboBox();
			comboBoxFarbe.setBounds(74, 164, 164, 22);
		}
		return comboBoxFarbe;
	}
	protected JComboBox getComboBoxPs() {
		if (comboBoxPs == null) {
			comboBoxPs = new JComboBox();
			comboBoxPs.setBounds(74, 208, 164, 22);
		}
		return comboBoxPs;
	}
	private JComboBox getComboBoxExtras() {
		if (comboBoxExtras == null) {
			comboBoxExtras = new JComboBox();
			comboBoxExtras.setBounds(74, 252, 164, 22);
		}
		return comboBoxExtras;
	}
	private JButton getButtonBestaetigen() {
		if (buttonBestaetigen == null) {
			buttonBestaetigen = new JButton("Auswahl best\u00E4tigen");
			buttonBestaetigen.setBounds(10, 325, 228, 23);
		}
		return buttonBestaetigen;
	}
	private JLabel getLabelPreisNetto() {
		if (labelPreisNetto == null) {
			labelPreisNetto = new JLabel("Gesamtpreis netto:");
			labelPreisNetto.setBounds(281, 239, 131, 31);
		}
		return labelPreisNetto;
	}
	private JLabel getLabelMWSt() {
		if (labelMWSt == null) {
			labelMWSt = new JLabel("19% MWSt:");
			labelMWSt.setBounds(281, 281, 81, 29);
		}
		return labelMWSt;
	}
	private JLabel getLabelPreisBrutto() {
		if (labelPreisBrutto == null) {
			labelPreisBrutto = new JLabel("Bruttpreis:");
			labelPreisBrutto.setBounds(281, 329, 81, 19);
		}
		return labelPreisBrutto;
	}
	private JLabel getLabelWertPreisNetto() {
		if (labelWertPreisNetto == null) {
			labelWertPreisNetto = new JLabel("");
			labelWertPreisNetto.setBounds(411, 247, 60, 23);
		}
		return labelWertPreisNetto;
	}
	private JLabel getLabelWertMWSt() {
		if (labelWertMWSt == null) {
			labelWertMWSt = new JLabel("");
			labelWertMWSt.setBounds(411, 288, 46, 14);
		}
		return labelWertMWSt;
	}
	private JLabel getLabelWertPreisBrutto() {
		if (labelWertPreisBrutto == null) {
			labelWertPreisBrutto = new JLabel("");
			labelWertPreisBrutto.setBounds(411, 329, 46, 14);
		}
		return labelWertPreisBrutto;
	}
	private JButton getButtonBestellen() {
		if (buttonBestellen == null) {
			buttonBestellen = new JButton("Auto bestellen");
			buttonBestellen.setBounds(481, 243, 120, 105);
		}
		return buttonBestellen;
	}
}
