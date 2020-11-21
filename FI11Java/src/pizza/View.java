package pizza;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class View extends JFrame
{
	private JPanel contentPane;
	private JLabel labelPizza;
	private JLabel labelExtras;
	private JTextField textFieldExtras;
	private JLabel labelGroesse;
	private JTextField textFieldPreis;
	private JComboBox comboBoxPizza;
	private JComboBox comboBoxGroesse;
	private JList listBestellung;
	private JButton buttonHinzufuegen;
	private JButton buttonEntfernen;
	private JLabel labelGesamtpreis;
	private JTextField textFieldGesamtpreis;
	private JButton buttonDrucken;
	private JButton buttonHardcopy;
	private JButton buttonAllesEntfernen;

	
	public View()
	{
		initialize();
		
		
		JScrollPane s = new JScrollPane(getListBestellung());
		s.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		getContentPane().add(s);
		s.setBounds(10, 89, 375, 190);
		s.setVisible(true);
		
		setBounds(100, 100, 559, 377);
	}
	private void initialize() 
	{	
		this.setVisible(true);//hinzufügen!!!
		setTitle("Pizzabestellung");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.add(getLabelPizza());
		contentPane.add(getLabelExtras());
		contentPane.add(getTextFieldExtras());
		contentPane.add(getLabelGroesse());
		contentPane.add(getTextFieldPreis());
		contentPane.add(getComboBoxPizza());
		contentPane.add(getComboBoxGroesse());
		contentPane.add(getListBestellung());
		contentPane.add(getButtonHinzufuegen());
		contentPane.add(getButtonEntfernen());
		contentPane.add(getLabelGesamtpreis());
		contentPane.add(getTextFieldGesamtpreis());
		contentPane.add(getButtonDrucken());
		contentPane.add(getButtonHardcopy());
		contentPane.add(getButtonAllesEntfernen());
		
		
	}
	
	private JLabel getLabelPizza() 
	{
		if (labelPizza == null) 
		{
			labelPizza = new JLabel("Pizza:");
			labelPizza.setBounds(10, 30, 46, 14);
		}
		return labelPizza;
	}
	private JLabel getLabelExtras() 
	{
		if (labelExtras == null) 
		{
			labelExtras = new JLabel("Extras:");
			labelExtras.setBounds(10, 61, 46, 14);
		}
		return labelExtras;
	}
	protected JTextField getTextFieldExtras() 
	{
		if (textFieldExtras == null) 
		{
			textFieldExtras = new JTextField();
			textFieldExtras.setBounds(89, 58, 296, 20);
			textFieldExtras.setColumns(10);
		}
		return textFieldExtras;
	}
	private JLabel getLabelGroesse() 
	{
		if (labelGroesse == null) 
		{
			labelGroesse = new JLabel("Gr\u00F6\u00DFe:");
			labelGroesse.setBounds(313, 30, 46, 14);
		}
		return labelGroesse;
	}
	protected JTextField getTextFieldPreis() 
	{
		if (textFieldPreis == null) 
		{
			textFieldPreis = new JTextField();
			textFieldPreis.setBounds(395, 58, 126, 20);
			textFieldPreis.setColumns(10);
		}
		return textFieldPreis;
	}
	protected JComboBox getComboBoxPizza() 
	{
		if (comboBoxPizza == null) 
		{
			comboBoxPizza = new JComboBox();
			comboBoxPizza.setBounds(89, 26, 191, 22);
		}
		return comboBoxPizza;
	}
	protected JComboBox getComboBoxGroesse() 
	{
		if (comboBoxGroesse == null) 
		{
			comboBoxGroesse = new JComboBox();
			comboBoxGroesse.setBounds(395, 26, 126, 22);
		}
		return comboBoxGroesse;
	}
	protected JList getListBestellung() 
	{
		if (listBestellung == null) 
		{
			listBestellung = new JList();
			listBestellung.setBounds(10, 89, 375, 190);
		}
		return listBestellung;
	}
	protected JButton getButtonHinzufuegen() 
	{
		if (buttonHinzufuegen == null) 
		{
			buttonHinzufuegen = new JButton("Hinzuf\u00FCgen");
			buttonHinzufuegen.setBounds(395, 89, 126, 23);
		}
		return buttonHinzufuegen;
	}
	protected JButton getButtonEntfernen() 
	{
		if (buttonEntfernen == null) 
		{
			buttonEntfernen = new JButton("Entfernen");
			buttonEntfernen.setBounds(395, 123, 126, 23);
		}
		return buttonEntfernen;
	}
	private JLabel getLabelGesamtpreis() 
	{
		if (labelGesamtpreis == null) 
		{
			labelGesamtpreis = new JLabel("Gesamtpreis:");
			labelGesamtpreis.setBounds(10, 301, 101, 14);
		}
		return labelGesamtpreis;
	}
	protected JTextField getTextFieldGesamtpreis() 
	{
		if (textFieldGesamtpreis == null)
		{
			textFieldGesamtpreis = new JTextField();
			textFieldGesamtpreis.setBounds(121, 298, 169, 20);
			textFieldGesamtpreis.setColumns(10);
		}
		return textFieldGesamtpreis;
	}
	protected JButton getButtonDrucken() 
	{
		if (buttonDrucken == null)
		{
			buttonDrucken = new JButton("Drucken");
			buttonDrucken.setBounds(308, 297, 102, 23);
		}
		return buttonDrucken;
	}
	protected JButton getButtonHardcopy()
	{
		if (buttonHardcopy == null)
		{
			buttonHardcopy = new JButton("Hardcopy");
			buttonHardcopy.setBounds(420, 297, 101, 23);
		}
		return buttonHardcopy;
	}
	protected JButton getButtonAllesEntfernen()
	{
		if (buttonAllesEntfernen == null) 
		{
			buttonAllesEntfernen = new JButton("Alles Entfernen");
			buttonAllesEntfernen.setBounds(395, 157, 126, 23);
		}
		return buttonAllesEntfernen;
	}	
}
