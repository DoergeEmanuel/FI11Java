package kaufhaus;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View extends JFrame
{
	private JPanel contentPane;
	private JLabel labelSortiment;
	private JLabel labelWarenkorb;
	private JLabel labelGesamtpreis;
	private JTextField textFieldGesamtpreis;
	private JList listSortiment;
	private JList listWarenkorb;
	private JButton buttonRein;
	private JButton buttonRaus;
	private JTextField textFieldPreis;
	private JTextField textFieldPreisSortiment;
	private JLabel labelPreisSortiment;
	private JLabel labelPreisWarenkorb;
	private JLabel labelKundenname;
	private JTextField textFieldPreisWarenkorb;
	private JTextField textFieldKundenname;
	private JButton buttonAbschicken;
	private JLabel labelLogo;

	
	public View()
	{
		initialize();
		
		setBounds(100, 100, 642, 436);
	}
	private void initialize() 
	{	
		this.setVisible(true);//hinzufügen!!!
		setTitle("Kaufhaus");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLabelSortiment());
		contentPane.add(getLabelWarenkorb());
		contentPane.add(getLabelGesamtpreis());
		contentPane.add(getTextFieldGesamtpreis());
		contentPane.add(getListSortiment());
		contentPane.add(getListWarenkorb());
		contentPane.add(getButtonRein());
		contentPane.add(getButtonRaus());
		contentPane.add(getLabelPreisSortiment());
		contentPane.add(getTextFieldPreisSortiment());
		contentPane.add(getLabelPreisWarenkorb());
		contentPane.add(getTextFieldPreisWarenkorb());
		contentPane.add(getLabelKundenname());
		contentPane.add(getTextFieldKundenname());
		contentPane.add(getButtonAbschicken());
		contentPane.add(getLabelLogo());
		
		
		
		
		
		
	}
	protected JTextField getTextFieldKundenname() 
	{
		if (textFieldKundenname == null)
		{
			textFieldKundenname = new JTextField();
			textFieldKundenname.setColumns(10);
			textFieldKundenname.setBounds(124, 346, 121, 20);
		}
		return textFieldKundenname;
	}
	protected JButton getButtonAbschicken() 
	{
		if (buttonAbschicken == null) 
		{
			buttonAbschicken = new JButton("Bestellung abschicken");
			buttonAbschicken.setBounds(385, 322, 231, 42);
		}
		return buttonAbschicken;
	}
	private JLabel getLabelKundenname() 
	{
		if (labelKundenname == null) 
		{
			labelKundenname = new JLabel("Kundenname:");
			labelKundenname.setBounds(10, 349, 104, 14);
		}
		return labelKundenname;
	}
	private JLabel getLabelSortiment() 
	{
		if (labelSortiment == null) 
		{
			labelSortiment = new JLabel("Sortiment");
			labelSortiment.setBounds(10, 71, 75, 25);
		}
		return labelSortiment;
	}
	private JLabel getLabelWarenkorb() 
	{
		if (labelWarenkorb == null) 
		{
			labelWarenkorb = new JLabel("Warenkorb");
			labelWarenkorb.setBounds(385, 71, 68, 25);
		}
		return labelWarenkorb;
	}
	private JLabel getLabelGesamtpreis() 
	{
		if (labelGesamtpreis == null) 
		{
			labelGesamtpreis = new JLabel("Gesamtpreis:");
			labelGesamtpreis.setBounds(10, 301, 104, 14);
		}
		return labelGesamtpreis;
	}
	protected JTextField getTextFieldGesamtpreis() 
	{
		if (textFieldGesamtpreis == null)
		{
			textFieldGesamtpreis = new JTextField();
			textFieldGesamtpreis.setBounds(124, 298, 121, 20);
			textFieldGesamtpreis.setColumns(10);
		}
		return textFieldGesamtpreis;
	}
	
	protected JList getListSortiment() 
	{
		if (listSortiment == null) 
		{
			listSortiment = new JList();
			listSortiment.setBounds(10, 96, 234, 166);
		}
		return listSortiment;
	}
	protected JList getListWarenkorb() 
	{
		if (listWarenkorb == null) 
		{
			listWarenkorb = new JList();
			listWarenkorb.setBounds(385, 96, 234, 166);
		}
		return listWarenkorb;
	}
	protected JButton getButtonRein() 
	{
		if (buttonRein == null) 
		{
			buttonRein = new JButton(">");
			buttonRein.setBounds(270, 128, 89, 42);
		}
		return buttonRein;
	}
	protected JButton getButtonRaus() 
	{
		if (buttonRaus == null) 
		{
			buttonRaus = new JButton("<");
			buttonRaus.setBounds(270, 183, 89, 42);
		}
		return buttonRaus;
	}
	private JLabel getLabelPreisSortiment() {
		if (labelPreisSortiment == null) {
			labelPreisSortiment = new JLabel("Preis Sortiment:");
			labelPreisSortiment.setBounds(10, 273, 104, 14);
		}
		return labelPreisSortiment;
	}
	protected JTextField getTextFieldPreisSortiment() {
		if (textFieldPreisSortiment == null) {
			textFieldPreisSortiment = new JTextField();
			textFieldPreisSortiment.setColumns(10);
			textFieldPreisSortiment.setBounds(124, 273, 121, 20);
		}
		return textFieldPreisSortiment;
	}
	private JLabel getLabelPreisWarenkorb() {
		if (labelPreisWarenkorb == null) {
			labelPreisWarenkorb = new JLabel("Preis Warenkorb:");
			labelPreisWarenkorb.setBounds(382, 276, 106, 14);
		}
		return labelPreisWarenkorb;
	}
	protected JTextField getTextFieldPreisWarenkorb() {
		if (textFieldPreisWarenkorb == null) {
			textFieldPreisWarenkorb = new JTextField();
			textFieldPreisWarenkorb.setColumns(10);
			textFieldPreisWarenkorb.setBounds(498, 273, 121, 20);
		}
		return textFieldPreisWarenkorb;
	}
	private JLabel getLabelLogo() {
		if (labelLogo == null) {
			ImageIcon ico = new ImageIcon("Kaufhaus/Nozama.jpg");
            ico.setImage(ico.getImage().getScaledInstance(235,59,Image.SCALE_DEFAULT));
			labelLogo = new JLabel(ico);
			labelLogo.setBounds(10, 11, 235, 59);
		}
		return labelLogo;
	}
}
