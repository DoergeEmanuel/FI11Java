package tankstellensoftware;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.JComboBox;

public class ViewHandyApp extends JFrame
{

	private JPanel contentPane;
	private JLabel labelName;
	private JList list;
	private JComboBox comboBox;

	
	public ViewHandyApp()
	{
		
		initialize();
		setBounds(100, 100, 450, 300);
	}
	private void initialize() 
	{
		this.setVisible(false);
		setTitle("ViewHandyApp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		contentPane.add(getLabelName());
		contentPane.add(getList());
		contentPane.add(getComboBox());
	}

	private JLabel getLabelName() {
		if (labelName == null) {
			labelName = new JLabel("Tanki");
			labelName.setFont(new Font("Tahoma", Font.BOLD, 20));
			labelName.setBounds(21, 38, 104, 34);
		}
		return labelName;
	}
	protected JList getList() {
		if (list == null) {
			list = new JList();
			list.setBounds(21, 109, 403, 96);
		}
		return list;
	}
	protected JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(21, 76, 403, 22);
		}
		return comboBox;
	}
}
