package tankstellensoftware;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import java.awt.Font;

public class ViewAnzeige extends JFrame
{
	private JPanel contentPane;
	private JList list;

	
	public ViewAnzeige()
	{
		setTitle("ViewAnzeige");
		initialize();
		setBounds(100, 100, 450, 300);
	}
	private void initialize() 
	{
		this.setVisible(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getList());
	}

	protected JList getList() {
		if (list == null) {
			list = new JList();
			list.setFont(new Font("Tahoma", Font.PLAIN, 40));
			list.setBounds(5, 5, 424, 251);
		}
		return list;
	}
}
