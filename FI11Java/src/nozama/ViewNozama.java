package nozama;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ViewNozama extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldKundenname;
	private JList listWarenkorb;
	private JLabel labelWarenkorb;
	private JList listSortiment;
	private JButton buttonRein;
	private JButton buttonRaus;
	private JLabel labelKundenname;
	private JButton buttonAbschicken;
	private JLabel labelNozama;

	
	public ViewNozama() 
	{
		initialize();
		this.setBounds(100, 100, 616, 395);
	}
	private void initialize()
	{
		this.setVisible(true);
		setTitle("Bestellung");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.add(getListWarenkorb());	
		contentPane.add(getLabelWarenkorb());
		contentPane.add(getListSortiment());
		contentPane.add(getButtonRein());
		contentPane.add(getButtonRaus());
		contentPane.add(getLabelKundenname());
		contentPane.add(getTextFieldKundenname());
		contentPane.add(getButtonAbschicken());
		contentPane.add(getLabelNozama());
		
	}
	protected JTextField getTextFieldKundenname() 
	{
		if(textFieldKundenname == null)
		{
			textFieldKundenname = new JTextField();
			textFieldKundenname.setBounds(94, 281, 150, 20);
		}
		return textFieldKundenname;
	}
	protected JList getListWarenkorb() 
	{
		if(listWarenkorb == null)
		{
			listWarenkorb = new JList();
			listWarenkorb.setBounds(347, 90, 234, 166);
		}
		return listWarenkorb;
	}
	
	protected JLabel getLabelWarenkorb() 
	{
		if(labelWarenkorb == null)
		{
			labelWarenkorb = new JLabel("Warenkorb");
			labelWarenkorb.setBounds(343, 65, 80, 14);
		}
		return labelWarenkorb;
	}
	
	protected JList getListSortiment() 
	{
		if(listSortiment == null)
		{
			listSortiment = new JList();
			listSortiment.setBounds(10, 90, 234, 166);
		}
		return listSortiment;
	}
	
	protected JButton getButtonRein() 
	{
		if(buttonRein == null)
		{
			buttonRein = new JButton(">");
			buttonRein.setBounds(254, 122, 89, 42);
		}
		return buttonRein;
	}
	
	protected JButton getButtonRaus() 
	{
		if(buttonRaus == null)
		{
			buttonRaus = new JButton("<");
			buttonRaus.setBounds(254, 175, 89, 42);
		}
		return buttonRaus;
	}
	
	protected JLabel getLabelKundenname() 
	{
		if(labelKundenname == null)
		{
			labelKundenname = new JLabel("Kundenname:");
			labelKundenname.setBounds(10, 279, 80, 25);
		}
		return labelKundenname;
	}
	
	protected JButton getButtonAbschicken() 
	{
		if(buttonAbschicken == null)
		{
			JButton buttonAbschicken = new JButton("Bestellung abschicken");
			buttonAbschicken.setBounds(347, 280, 234, 23);
		}
		return buttonAbschicken;
	}
	protected JLabel getLabelNozama() 
	{
		if (labelNozama == null) 
		{
			labelNozama = new JLabel("Nozama");
			labelNozama.setFont(new Font("Tahoma", Font.PLAIN, 20));
			labelNozama.setBounds(10, 42, 136, 37);
		}
		return labelNozama;
	}
}
