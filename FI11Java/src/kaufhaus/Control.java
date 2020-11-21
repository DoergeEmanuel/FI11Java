package kaufhaus;

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
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class Control
{
	View view;
	ActionListener hinzu;
	ActionListener raus;
	ListSelectionListener waehleSortiment;
	ListSelectionListener waehleWarenkorb;
	
	double gesamtpreis;
	NumberFormat format = NumberFormat.getCurrencyInstance();
	
	private DefaultListModel<Sortiment> listModelSortiment;
	private DefaultListModel<Sortiment> listModelWarenkorb;
	
	public Control()
	{
		view = new View();
		
		listModelSortiment = new DefaultListModel<Sortiment>();
		listModelWarenkorb = new DefaultListModel<Sortiment>();
		fuelleInhalte();
		setzeListener();
		
	}
	private void fuelleInhalte()
	{
		gesamtpreis = 0;
		try
		{
			String zeile = null;
			String[] values;
			BufferedReader in = new BufferedReader(new FileReader("Sortiment.txt"));
			try
			{
				zeile = in.readLine();
				while((zeile = in.readLine()) != null)
				{
					values = zeile.split("; ");
					values[2] = values[2].replace(",", ".");
					values[2] = values[2].replace(" €", "");
					//System.out.println(values[0] + ";" + values[1] + ";" + values[2]);
					listModelSortiment.addElement(new Sortiment(values[0],values[1], Double.valueOf(values[2])));
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
			view.getListSortiment().setModel(listModelSortiment);
		
		}
		catch(IOException e)
		{
			System.out.println("Die Datei konnte nicht gefunden werden");
		}
	}
	
	
	private void setzeListener()
	{
		
		waehleSortiment = new ListSelectionListener() 
		{
			@Override
			public void valueChanged(ListSelectionEvent e) 
			{
				double preis = 0;
				
				preis = waehlen(view.getListSortiment().getSelectedValuesList());
				
				view.getTextFieldPreisSortiment().setText(format.format(preis));
				
			}
		};
		view.getListSortiment().addListSelectionListener(waehleSortiment);
		
		waehleWarenkorb = new ListSelectionListener() 
		{
			@Override
			public void valueChanged(ListSelectionEvent e) 
			{
				double preis = 0;
				
				preis = waehlen(view.getListWarenkorb().getSelectedValuesList());
				
				view.getTextFieldPreisWarenkorb().setText(format.format(preis));
			}
		};
		view.getListWarenkorb().addListSelectionListener(waehleWarenkorb);
		
		
		hinzu = new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				hinzufuegen(view.getListSortiment().getSelectedValuesList());
			}
		};
		view.getButtonRein().addActionListener(hinzu);
		
		raus = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				loeschen(view.getListWarenkorb().getSelectedValuesList());
			}
		};
		view.getButtonRaus().addActionListener(raus);
	}
	
	private void hinzufuegen(List<Sortiment> liste)
	{
		for (Sortiment item : liste) 
		{
			gesamtpreis += item.getPreis();
		    listModelWarenkorb.addElement(item);
		    view.getListWarenkorb().setModel(listModelWarenkorb);
		}
		
		view.getTextFieldGesamtpreis().setText(format.format(gesamtpreis));
	}
	private void loeschen(List<Sortiment> liste)
	{
		for(Sortiment item: liste)
		{
			gesamtpreis -= item.getPreis();
			listModelWarenkorb.removeElement(item);
			view.getListSortiment().setModel(listModelSortiment);
		}
	
		view.getTextFieldGesamtpreis().setText(format.format(gesamtpreis));
	}
	private double waehlen(List<Sortiment> liste)
	{
		double preis = 0;
		
		for(Sortiment item: liste)
		{
			preis += item.getPreis();
			System.out.println(preis);
		}
		return preis;
	}
}

