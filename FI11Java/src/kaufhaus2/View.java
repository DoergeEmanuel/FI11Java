package kaufhaus2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class View extends JFrame {

	private JPanel contentPane;
	private JLabel labelLogo;
	private JList listSortiment;
	private JList listWarenkorb;
	private JButton buttonRein;
	private JButton buttonRaus;
	private JButton buttonAbschicken;
	private JLabel labelKunde;
	private JTextField textFieldKunde;
	private JLabel labelSortiment;
	private JLabel labelWarenkorb;

	
	public View() 
	{
		initialize();
		setBounds(100, 100, 566, 481);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void initialize()
	{
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.add(getLabelLogo());
		contentPane.add(getListSortiment());
		contentPane.add(getListWarenkorb());
		contentPane.add(getButtonRein());
		contentPane.add(getButtonRaus());
		contentPane.add(getButtonAbschicken());
		contentPane.add(getLabelKunde());
		contentPane.add(getTextFieldKunde());
		contentPane.add(getLabelSortiment());
		contentPane.add(getLabelWarenkorb());
	}

	private JLabel getLabelLogo() {
		if (labelLogo == null) 
		{
			ImageIcon ico = new ImageIcon("Kaufhaus/Nozama.jpg");
            ico.setImage(ico.getImage().getScaledInstance(235,59,Image.SCALE_DEFAULT));
			labelLogo = new JLabel(ico);
			labelLogo.setBounds(20, 11, 205, 85);
		}
		return labelLogo;
	}
	protected JList getListSortiment() {
		if (listSortiment == null) {
			listSortiment = new JList();
			listSortiment.setBounds(20, 161, 205, 197);
		}
		return listSortiment;
	}
	protected JList getListWarenkorb() {
		if (listWarenkorb == null) {
			listWarenkorb = new JList();
			listWarenkorb.setBounds(310, 161, 212, 197);
		}
		return listWarenkorb;
	}
	protected JButton getButtonRein() {
		if (buttonRein == null) {
			buttonRein = new JButton(">");
			buttonRein.setBounds(235, 207, 59, 50);
		}
		return buttonRein;
	}
	protected JButton getButtonRaus() {
		if (buttonRaus == null) {
			buttonRaus = new JButton("<");
			
			buttonRaus.setBounds(235, 268, 59, 50);
		}
		return buttonRaus;
	}
	protected JButton getButtonAbschicken() {
		if (buttonAbschicken == null) {
			buttonAbschicken = new JButton("Bestellung abschicken");
			buttonAbschicken.setBounds(306, 387, 216, 30);
		}
		return buttonAbschicken;
	}
	private JLabel getLabelKunde() {
		if (labelKunde == null) {
			labelKunde = new JLabel("Kundenname:");
			labelKunde.setBounds(10, 387, 87, 30);
		}
		return labelKunde;
	}
	protected JTextField getTextFieldKunde() {
		if (textFieldKunde == null) {
			textFieldKunde = new JTextField();
			textFieldKunde.setBounds(109, 392, 128, 20);
			textFieldKunde.setColumns(10);
		}
		return textFieldKunde;
	}
	private JLabel getLabelSortiment() {
		if (labelSortiment == null) {
			labelSortiment = new JLabel("Sortiment");
			labelSortiment.setBounds(20, 125, 97, 25);
		}
		return labelSortiment;
	}
	private JLabel getLabelWarenkorb() {
		if (labelWarenkorb == null) {
			labelWarenkorb = new JLabel("Warenkorb");
			labelWarenkorb.setBounds(310, 130, 116, 20);
		}
		return labelWarenkorb;
	}
}
