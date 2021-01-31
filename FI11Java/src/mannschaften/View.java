package mannschaften;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class View extends JFrame
{

	private JPanel contentPane;
	private JComboBox comboBoxLigen1;
	private JComboBox comboBoxLigen2;
	private JList list1;
	private JList list2;
	private JButton buttonRechts;
	private JButton buttonLinks;
	private JComboBox comboBoxMannschaften1;
	private JComboBox comboBoxMannschaften2;

	
	public View()
	{
		initialize();
		setBounds(100, 100, 683, 486);
	}
	private void initialize()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getComboBoxLigen1());
		contentPane.add(getComboBoxLigen2());
		contentPane.add(getList1());
		contentPane.add(getList2());
		contentPane.add(getButtonRechts());
		contentPane.add(getButtonLinks());
		contentPane.add(getComboBoxMannschaften1());
		contentPane.add(getComboBoxMannschaften2());
	}
	protected JComboBox getComboBoxLigen1() {
		if (comboBoxLigen1 == null) {
			comboBoxLigen1 = new JComboBox();
			comboBoxLigen1.setBounds(39, 33, 239, 22);
		}
		return comboBoxLigen1;
	}
	protected JComboBox getComboBoxLigen2() {
		if (comboBoxLigen2 == null) {
			comboBoxLigen2 = new JComboBox();
			comboBoxLigen2.setBounds(392, 33, 239, 22);
		}
		return comboBoxLigen2;
	}
	protected JList getList1() {
		if (list1 == null) {
			list1 = new JList();
			list1.setBounds(39, 153, 239, 250);
		}
		return list1;
	}
	protected JList getList2() {
		if (list2 == null) {
			list2 = new JList();
			list2.setBounds(392, 153, 239, 250);
		}
		return list2;
	}
	protected JButton getButtonRechts() {
		if (buttonRechts == null) {
			buttonRechts = new JButton(">");
			buttonRechts.setFont(new Font("Tahoma", Font.PLAIN, 20));
			buttonRechts.setBounds(288, 179, 89, 60);
		}
		return buttonRechts;
	}
	protected JButton getButtonLinks() {
		if (buttonLinks == null) {
			buttonLinks = new JButton("<");
			buttonLinks.setFont(new Font("Tahoma", Font.PLAIN, 20));
			buttonLinks.setBounds(288, 265, 89, 60);
		}
		return buttonLinks;
	}
	protected JComboBox getComboBoxMannschaften1() {
		if (comboBoxMannschaften1 == null) {
			comboBoxMannschaften1 = new JComboBox();
			comboBoxMannschaften1.setBounds(39, 91, 239, 22);
		}
		return comboBoxMannschaften1;
	}
	protected JComboBox getComboBoxMannschaften2() {
		if (comboBoxMannschaften2 == null) {
			comboBoxMannschaften2 = new JComboBox();
			comboBoxMannschaften2.setBounds(392, 91, 239, 22);
		}
		return comboBoxMannschaften2;
	}
}
