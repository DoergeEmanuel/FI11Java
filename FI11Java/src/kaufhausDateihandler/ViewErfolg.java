package kaufhausDateihandler;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;

public class ViewErfolg extends JFrame {

	private JPanel contentPane;
	private JList listWarenkorb;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel labelBestellnummer;

	
	public ViewErfolg() 
	{
		initialize();
		setBounds(100, 100, 298, 274);
	}
	private void initialize()
	{
		this.setVisible(true);
		setTitle("Herzlichen Gl\u00FCckwunsch!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.add(getListWarenkorb());
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getLabelBestellnummer());
	}

	protected JList getListWarenkorb() {
		if (listWarenkorb == null) {
			listWarenkorb = new JList();
			listWarenkorb.setBounds(23, 11, 234, 166);
		}
		return listWarenkorb;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Ihre Bestellung wurde erfolgreich aufgegeben!");
			lblNewLabel.setBounds(10, 188, 262, 26);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Ihre Bestellnummer:");
			lblNewLabel_1.setBounds(10, 215, 126, 20);
		}
		return lblNewLabel_1;
	}
	protected JLabel getLabelBestellnummer() {
		if (labelBestellnummer == null) {
			labelBestellnummer = new JLabel("New label");
			labelBestellnummer.setBounds(146, 215, 46, 17);
		}
		return labelBestellnummer;
	}
}
