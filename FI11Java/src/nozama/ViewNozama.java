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
		
		JLabel lblNewLabel = new JLabel("Nozama");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 26, 80, 25);
		contentPane.add(lblNewLabel);
		
		JList listWarenkorb = new JList();
		listWarenkorb.setBounds(347, 90, 234, 166);
		contentPane.add(listWarenkorb);
		
		JLabel lblNewLabel_1 = new JLabel("Warenkorb");
		lblNewLabel_1.setBounds(347, 59, 80, 14);
		contentPane.add(lblNewLabel_1);
		
		JList listSortiment = new JList();
		listSortiment.setBounds(10, 90, 234, 166);
		contentPane.add(listSortiment);
		
		JButton buttonRein = new JButton(">");
		buttonRein.setBounds(254, 122, 89, 42);
		contentPane.add(buttonRein);
		
		JButton buttonRaus = new JButton("<");
		buttonRaus.setBounds(254, 175, 89, 42);
		contentPane.add(buttonRaus);
		
		JLabel lblNewLabel_2 = new JLabel("Kundenname:");
		lblNewLabel_2.setBounds(10, 279, 80, 25);
		contentPane.add(lblNewLabel_2);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(94, 281, 150, 20);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		JButton buttonAbschicken = new JButton("Bestellung abschicken");
		buttonAbschicken.setBounds(347, 280, 234, 23);
		contentPane.add(buttonAbschicken);
	}
}
