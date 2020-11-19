package pizza;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;
import java.text.NumberFormat;

import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class Control
{
	private View view;
	
	private DefaultComboBoxModel<Pizza> comboBoxModelPizza;
	private DefaultComboBoxModel<Groesse> comboBoxModelGroesse;
	private DefaultListModel<Bestellung> listModelBestellung;
	
	private ItemListener listenerAuswaehlen;
	private MouseAdapter listenerHinzufuegen;
	private MouseAdapter listenerAllesEntfernen;
	private MouseAdapter listenerAuswahlEntfernen;
	private ListSelectionListener listenerWechseln;
	
	double gesamtpreis;
	
	NumberFormat format = NumberFormat.getCurrencyInstance();
	
	public Control()
	{	
		this.view = new View();	
		
		JScrollPane s = new JScrollPane(view.getListBestellung());
		s.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		view.getContentPane().add(s);
		s.setBounds(10, 89, 375, 190);
		s.setVisible(true);
		
		comboBoxModelPizza = new DefaultComboBoxModel<Pizza>();
		comboBoxModelGroesse = new DefaultComboBoxModel<Groesse>();
		listModelBestellung = new DefaultListModel<Bestellung>();
		
		fuelleInhalte();
		
		setzeListener();	
	}
	
	private void fuelleInhalte()
	{
		try
		{
			String zeile = null;
			String[] values;
			BufferedReader in = new BufferedReader(new FileReader("PizzaAuslesen.txt"));
			BufferedReader in2 = new BufferedReader(new FileReader("GroesseAuslesen.txt"));
			
			try
			{
				BufferedWriter out = new BufferedWriter(new FileWriter("test.txt", true));
				out.write("hallo");
				out.close();
				
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			try
			{
				
				
				while((zeile = in.readLine()) != null)
				{
					System.out.println(zeile);
					values = zeile.split(";"); 
					comboBoxModelPizza.addElement(new Pizza(values[0], Double.valueOf(values[1])));
				}
				
				while((zeile = in2.readLine()) != null)
				{
					System.out.println(zeile);
					values = zeile.split(";"); 
					comboBoxModelGroesse.addElement(new Groesse(values[0], Double.valueOf(values[1])));
				}
			}
			catch(IOException ex)
			{
				System.out.println(ex.getMessage());
			}
			finally
			{
				in.close();
			}
		}
		catch(IOException e)
		{
			System.out.println("IOException");
			e.printStackTrace();
		}
		
	/*	comboBoxModelPizza.addElement(new Pizza("Pizza1", 3));
		comboBoxModelPizza.addElement(new Pizza("Pizza2", 3.5));
		comboBoxModelPizza.addElement(new Pizza("Pizza3", 4)); */
		
		view.getComboBoxPizza().setModel(comboBoxModelPizza);
		
	/*	comboBoxModelGroesse.addElement(new Groesse("klein", 1));
		comboBoxModelGroesse.addElement(new Groesse("mittel", 1.3));
		comboBoxModelGroesse.addElement(new Groesse("groﬂ", 1.6)); */
		
		view.getComboBoxGroesse().setModel(comboBoxModelGroesse);
		
		view.getListBestellung().setModel(listModelBestellung);
		
		gesamtpreis = 0;
		waehlen(view.getComboBoxPizza().getSelectedItem(), view.getComboBoxGroesse().getSelectedItem());
		view.getTextFieldGesamtpreis().setText(format.format(Math.round(100.0 * gesamtpreis) / 100.0));
	}
	
	
	private void setzeListener()
	{
		listenerHinzufuegen = new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				hinzufuegen(view.getComboBoxPizza().getSelectedItem(), view.getComboBoxGroesse().getSelectedItem(), view.getTextFieldExtras().getText());
			}
		};
		
		listenerAuswaehlen = new ItemListener() 
		{
			@Override
			public void itemStateChanged(ItemEvent e) 
			{
				waehlen(view.getComboBoxPizza().getSelectedItem(), view.getComboBoxGroesse().getSelectedItem());
			}
		};
		
		listenerWechseln = new ListSelectionListener()
		{
			@Override
			public void valueChanged(ListSelectionEvent e)
			{
				wechseln(view.getListBestellung().getSelectedValuesList());
			}	
		};
		
		listenerAuswahlEntfernen = new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				auswahlEntfernen(view.getListBestellung().getSelectedValuesList());
			}
		};
		
		listenerAllesEntfernen = new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				listModelBestellung.removeAllElements();
				gesamtpreis = 0;
				
				view.getTextFieldGesamtpreis().setText(format.format(Math.round(100.0 * gesamtpreis) / 100.0));
			}
		};	
		
		
		view.getButtonHinzufuegen().addMouseListener(listenerHinzufuegen);
		view.getComboBoxPizza().addItemListener(listenerAuswaehlen);
		view.getComboBoxGroesse().addItemListener(listenerAuswaehlen);
		view.getListBestellung().addListSelectionListener(listenerWechseln);
		view.getButtonAllesEntfernen().addMouseListener(listenerAllesEntfernen);
		view.getButtonEntfernen().addMouseListener(listenerAuswahlEntfernen);
	}	
	
	
	public void auswahlEntfernen(List<Bestellung> b)
	{	
		if(b != null)
		{
			for(int i = 0; i < b.size(); i++)
			{
				gesamtpreis = gesamtpreis - ((b.get(i).getPizza().getPreis()) * (b.get(i).getGroesse().getFaktor()));
				listModelBestellung.removeElement(b.get(i));
			}
			
			view.getTextFieldGesamtpreis().setText(format.format(Math.round(100.0 * gesamtpreis) / 100.0));
		}	
	}
	
	public void wechseln(List<Bestellung> b)
	{
		double preis = 0;
		
		
		if(b != null)
		{	
			for(int i = 0; i < b.size(); i++)
			{
				preis = preis + b.get(i).getPizza().getPreis() * b.get(i).getGroesse().getFaktor();
			}
				
			view.getTextFieldPreis().setText(format.format(Math.round(100.0 * preis) / 100.0));
		}	
	}
	
	public void waehlen(Object o1, Object o2)
	{
		Pizza p = (Pizza)o1;
		Groesse g = (Groesse)o2;
		
		double preis = p.getPreis() * g.getFaktor();
		
		view.getTextFieldPreis().setText(format.format(Math.round(100.0 * preis) / 100.0));
	} 
	
	public void hinzufuegen(Object o1, Object o2, String extras)
	{
		try
		{
			Pizza p = (Pizza)o1;
			Groesse g = (Groesse)o2;
					
			listModelBestellung.addElement(new Bestellung(p, g, extras));
					
			gesamtpreis = gesamtpreis + (p.getPreis() * g.getFaktor());
			
			view.getTextFieldGesamtpreis().setText(format.format(Math.round(100.0 * gesamtpreis) / 100.0));
			//showMessageDialog(null, gesamtpreis);
		}
		catch(Exception e)
		{
			System.out.println("Fehler beim Hinzuf¸gen");
		}
	}	
}

