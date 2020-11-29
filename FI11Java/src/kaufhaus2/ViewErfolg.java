package kaufhaus2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JList;

public class ViewErfolg extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBoxBestellung;
	private JList listBestellung;

	
	public ViewErfolg() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getComboBoxBestellung());
		contentPane.add(getListBestellung());
	}
	protected JComboBox getComboBoxBestellung() {
		if (comboBoxBestellung == null) {
			comboBoxBestellung = new JComboBox();
			comboBoxBestellung.setBounds(51, 27, 322, 22);
		}
		return comboBoxBestellung;
	}
	protected JList getListBestellung() {
		if (listBestellung == null) {
			listBestellung = new JList();
			listBestellung.setBounds(53, 71, 320, 159);
		}
		return listBestellung;
	}
}
