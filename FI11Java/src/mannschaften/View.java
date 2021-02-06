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
	private JComboBox comboBoxSpieler1;
	private JComboBox comboBoxSpieler2;
	private JList list1Mannschaften;
	private JList list2Mannschaften;
	private JButton buttonRechtsMannschaften;
	private JButton buttonLinksMannschaften;

	
	public View()
	{
		initialize();
		setBounds(100, 100, 683, 819);
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
		contentPane.add(getComboBoxSpieler1());
		contentPane.add(getComboBoxSpieler2());
		contentPane.add(getList1Mannschaften());
		contentPane.add(getList2Mannschaften());
		contentPane.add(getButtonRechtsMannschaften());
		contentPane.add(getButtonLinksMannschaften());
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
			list1.setBounds(39, 465, 239, 250);
		}
		return list1;
	}
	protected JList getList2() {
		if (list2 == null) {
			list2 = new JList();
			list2.setBounds(392, 465, 239, 250);
		}
		return list2;
	}
	protected JButton getButtonRechts() {
		if (buttonRechts == null) {
			buttonRechts = new JButton(">");
			buttonRechts.setFont(new Font("Tahoma", Font.PLAIN, 20));
			buttonRechts.setBounds(288, 499, 89, 60);
		}
		return buttonRechts;
	}
	protected JButton getButtonLinks() {
		if (buttonLinks == null) {
			buttonLinks = new JButton("<");
			buttonLinks.setFont(new Font("Tahoma", Font.PLAIN, 20));
			buttonLinks.setBounds(288, 594, 89, 60);
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
	protected JComboBox getComboBoxSpieler1() {
		if (comboBoxSpieler1 == null) {
			comboBoxSpieler1 = new JComboBox();
			comboBoxSpieler1.setBounds(39, 414, 239, 22);
		}
		return comboBoxSpieler1;
	}
	protected JComboBox getComboBoxSpieler2() {
		if (comboBoxSpieler2 == null) {
			comboBoxSpieler2 = new JComboBox();
			comboBoxSpieler2.setBounds(392, 414, 239, 22);
		}
		return comboBoxSpieler2;
	}
	protected JList getList1Mannschaften() {
		if (list1Mannschaften == null) {
			list1Mannschaften = new JList();
			list1Mannschaften.setBounds(39, 132, 239, 250);
		}
		return list1Mannschaften;
	}
	protected JList getList2Mannschaften() {
		if (list2Mannschaften == null) {
			list2Mannschaften = new JList();
			list2Mannschaften.setBounds(392, 132, 239, 250);
		}
		return list2Mannschaften;
	}
	protected JButton getButtonRechtsMannschaften() {
		if (buttonRechtsMannschaften == null) {
			buttonRechtsMannschaften = new JButton(">");
			buttonRechtsMannschaften.setFont(new Font("Tahoma", Font.PLAIN, 20));
			buttonRechtsMannschaften.setBounds(288, 184, 89, 60);
		}
		return buttonRechtsMannschaften;
	}
	protected JButton getButtonLinksMannschaften() {
		if (buttonLinksMannschaften == null) {
			buttonLinksMannschaften = new JButton("<");
			buttonLinksMannschaften.setFont(new Font("Tahoma", Font.PLAIN, 20));
			buttonLinksMannschaften.setBounds(288, 255, 89, 60);
		}
		return buttonLinksMannschaften;
	}
}
