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
	private JTextField textFieldName;
	private JList listWarenkorb;
	private JLabel lblNewLabel_1;
	private JList listSortiment;
	private JButton buttonRein;
	private JButton buttonRaus;
	private JLabel lblNewLabel_2;
	private JButton buttonAbschicken;
	private JLabel lblNewLabel;

	
	
	
	
	public ViewNozama() 
	{
		initialize();
		setBounds(100, 100, 619, 366);
	}
	private void initialize()
	{
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.add(getListWarenkorb());	
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getListSortiment());
		contentPane.add(getButtonRein());
		contentPane.add(getButtonRaus());
		contentPane.add(getLblNewLabel_2());
		contentPane.add(getTextFieldName());
		contentPane.add(getButtonAbschicken());
		contentPane.add(getLblNewLabel());
	}
	protected JTextField getTextFieldName() 
	{
		if(textFieldName == null)
		{
			textFieldName = new JTextField();
			textFieldName.setBounds(94, 281, 150, 20);
		}
		return textFieldName;
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
	
	protected JLabel getLblNewLabel_1() 
	{
		if(lblNewLabel_1 == null)
		{
			lblNewLabel_1 = new JLabel("Warenkorb");
			lblNewLabel_1.setBounds(343, 65, 80, 14);
		}
		return lblNewLabel_1;
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
	
	protected JLabel getLblNewLabel_2() 
	{
		if(lblNewLabel_2 == null)
		{
			lblNewLabel_2 = new JLabel("Kundenname:");
			lblNewLabel_2.setBounds(10, 279, 80, 25);
		}
		return lblNewLabel_2;
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
	protected JLabel getLblNewLabel() 
	{
		if (lblNewLabel == null) 
		{
			lblNewLabel = new JLabel("Nozama");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel.setBounds(10, 42, 136, 37);
		}
		return lblNewLabel;
	}
}
