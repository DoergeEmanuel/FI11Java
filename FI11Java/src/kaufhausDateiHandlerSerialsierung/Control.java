package kaufhausDateiHandlerSerialsierung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.NumberFormat;

import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import tankstellensoftware.ViewAnzeige;


public class Control
{
	View view;
	ViewAnzeigen viewAnzeigen;
	ViewErfolg viewErfolg;
	ActionListener hinzu;
	ActionListener raus;
	ActionListener zeigeAn;
	ListSelectionListener waehleSortiment;
	ListSelectionListener waehleWarenkorb;
	ActionListener speichere;
	double gesamtpreis;
	ArrayList<Bestellung> bestellListe;
	Bestellung bestellung;
	
	//String wertString = null;
	//String datei = null;
	NumberFormat format = NumberFormat.getCurrencyInstance();
	
	private DefaultListModel<Sortiment> listModelSortiment;
	private DefaultListModel<Sortiment> listModelWarenkorb;
	private DefaultListModel<Sortiment> listModelBestellung;
	
	public Control()
	{
		view = new View();
		
		listModelSortiment = new DefaultListModel<Sortiment>();
		listModelWarenkorb = new DefaultListModel<Sortiment>();
		listModelBestellung = new DefaultListModel<Sortiment>();
		bestellListe = new ArrayList<Bestellung>();
		
		fuelleInhalte();
		setzeListener();	
		
		view.getListSortiment().setModel(listModelSortiment);
		view.getListWarenkorb().setModel(listModelWarenkorb);
		view.getListWarenkorb().setModel(listModelBestellung);
		
		view.getListSortiment().addListSelectionListener(waehleSortiment);
		view.getListWarenkorb().addListSelectionListener(waehleWarenkorb);
		view.getButtonRein().addActionListener(hinzu);
		view.getButtonRaus().addActionListener(raus);
		view.getButtonAbschicken().addActionListener(speichere);
		view.getButtonAnzeigen().addActionListener(zeigeAn);
		
	}
	private void fuelleInhalte()
	{
		gesamtpreis = 0;
		
		DHNIO dhnio = new DHNIO();
		String path = "Kaufhaus/Sortiment.txt";
		listModelSortiment = dhnio.lesenDefaultListModelSortiment(path);	
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
		
		
		
		hinzu = new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				hinzufuegen(view.getListSortiment().getSelectedValuesList());
			}
		};
		
		
		raus = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				loeschen(view.getListWarenkorb().getSelectedValuesList());
			}
		};
		
		
		speichere = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				int laenge = view.getTextFieldKundenname().getText().length();
				
				if(listModelWarenkorb.size() != 0 && laenge != 0 )
				{
					speichern();
					view.getTextFieldKundenname().setText("");
				}
				else
				{
					 JOptionPane.showMessageDialog(null,"Bitte gültige Bestellung und gültiger Name eingeben","Achtung", JOptionPane.CANCEL_OPTION);
				}
			}
		};
		
		zeigeAn = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				anzeigen();
				viewAnzeigen = new ViewAnzeigen();
			}
		};
	}
	
	private void anzeigen()
	{
		String pfad = "Kaufhaus/Bestellungen/Hanswurscht22.txt";
		Serializer serializer = new Serializer();
		
		listModelBestellung = serializer.lesenDefaultListModelSortiment(pfad);
		
		
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
		//	System.out.println(preis);
		}
		return preis;
	}
	
	private void speichern ()
	{
		boolean erfolg;
			
		dateiLesen();
		dateiNameErzeugen();

		String pfad = bestellung.getDatei();
		Serializer serializer = new Serializer();
		erfolg = serializer.schreibenDefaultListModelSortiment(pfad, listModelWarenkorb);
	
		if(erfolg == true)
		{
			bestellListe.add(bestellung);
			dateiSpeichern();
		}
		
	}	
	
	private void dateiLesen()
	{
		DHIO dhio = new DHIO();
		String pfad = "Kaufhaus/Kunden.txt";
		bestellListe = dhio.lesenArrayListBestellung(pfad);
	}

	
	private void dateiNameErzeugen()
	{
		String name = view.getTextFieldKundenname().getText();
		int nummer;
		
		
		if(bestellListe.size() != 0)
		{
			nummer = bestellListe.get(bestellListe.size()-1).getBestellnummer();
			nummer++;
		}
		else
		{
			nummer = 1;
		}
		
		bestellung = new Bestellung(name, nummer);	
	}
	
	private void dateiSpeichern()
	{
		boolean erfolg;
		
		DHIO dhio = new DHIO();
		String pfad = "Kaufhaus/Kunden.txt";
		erfolg = dhio.schreibeBestellung(pfad, bestellung);
		
		if(erfolg == true)
		{
			viewErfolg = new ViewErfolg();
			viewErfolg.getListWarenkorb().setModel(listModelWarenkorb);
			viewErfolg.getLabelBestellnummer().setText(String.valueOf(bestellung.getBestellnummer()));
		}
	}	
}