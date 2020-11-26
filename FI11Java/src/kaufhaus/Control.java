package kaufhaus;

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
import java.nio.file.FileSystem;
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


public class Control
{
	View view;
	ViewErfolg viewErfolg;
	ActionListener hinzu;
	ActionListener raus;
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
	
	public Control()
	{
		view = new View();
		
		listModelSortiment = new DefaultListModel<Sortiment>();
		listModelWarenkorb = new DefaultListModel<Sortiment>();
		bestellListe = new ArrayList<Bestellung>();
		
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
		
			Path datei = Paths.get("Kaufhaus/Sortiment.txt");
			BufferedReader in = Files.newBufferedReader(datei , StandardCharsets.UTF_8); 
		//	BufferedReader in = new BufferedReader(new FileReader("Kaufhaus/Sortiment.txt", StandardCharsets.UTF_8)); 
			
			try
			{
				zeile = in.readLine();
				while((zeile = in.readLine()) != null)
				{
					values = zeile.split("; ");
					values[2] = values[2].replace(',', '.');
					values[2] = values[2].replace("€", "");
				//	System.out.println(values[0] + ";" + values[1] + ";" + values[2]);
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
			System.out.println("Die Sortiment Datei kann nicht gelesen werden");
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
		
		view.getButtonAbschicken().addActionListener(speichere);
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
		
		try
		{ 
			dateiLesen();
			dateiNameErzeugen();
			
				
			  BufferedWriter out = Files.newBufferedWriter(Paths.get(bestellung.getDatei()), StandardOpenOption.CREATE);
			//BufferedWriter out = new BufferedWriter(new FileWriter(bestellung.getDatei(), false));
			try
			{
				//dateiSpeichern();
				String nummer, bezeichnung, preis;
				out.write("Artikelnummer; Arikelbezeichnung; Preis");
				System.out.println("Artikelnummer; Arikelbezeichnung; Preis");
				out.newLine();
				for(int i = 0; i < listModelWarenkorb.getSize(); i++)
				{
					nummer = listModelWarenkorb.elementAt(i).getArtikelnummer();
					bezeichnung = listModelWarenkorb.elementAt(i).getArtikelbezeichnung();
					preis = Double.toString(listModelWarenkorb.elementAt(i).getPreis());
					out.write(nummer + "; " + bezeichnung + "; " + preis + "€");
					System.out.println(nummer + "; " + bezeichnung + "; " + preis + "€");
					out.newLine();
				}
				bestellListe.add(bestellung);
				dateiSpeichern();
			}
			catch(IOException ex)
			{
				System.out.println(ex.getMessage());
				
			}
			finally
			{
				out.close();
				
			}
			
			
		}
		catch(IOException e)
		{
			System.out.println(e);
			
		}
	}	
	
	
	
	
	private void dateiLesen()
	{
		try
		{
			String zeile = null;
			String[] values = null;
			
			Path datei = Paths.get("Kaufhaus/Kunden.txt");
			BufferedReader in = Files.newBufferedReader(datei, StandardCharsets.UTF_8); 
		  //BufferedReader in = new BufferedReader(new FileReader("Kaufhaus/Kunden.txt", StandardCharsets.UTF_8)); 
			try
			{
				while((zeile = in.readLine()) != null && zeile.length() != 0)
				{
					values = zeile.split("; ");
					//System.out.println(values[1]);
					bestellListe.add(new Bestellung(values[0], Integer.valueOf(values[1])));
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
			System.out.println("Noch gibt es nichts zu lesen");
		}	
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
		try
		{
			BufferedWriter out = Files.newBufferedWriter(Paths.get("Kaufhaus/Kunden.txt"), StandardOpenOption.APPEND); 
		//	BufferedWriter out = new BufferedWriter(new FileWriter("Kaufhaus/Kunden.txt", true));
			
			try
			{
				out.write(bestellung.getDatei() + "; " + Integer.valueOf(bestellung.getBestellnummer()));
				out.newLine();
				System.out.println(bestellung.getDatei() + "; " + Integer.valueOf(bestellung.getBestellnummer()));
				
			}
			catch(IOException ex)
			{
				System.out.println(ex.getMessage());
			}
			finally
			{
				out.close();
			}
			viewErfolg = new ViewErfolg();
			viewErfolg.getListWarenkorb().setModel(listModelWarenkorb);
			viewErfolg.getLabelBestellnummer().setText(String.valueOf(bestellung.getBestellnummer()));
			
		}
		catch(IOException e)
		{
			System.out.println("IOException");
			
		}		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/* Nicht Objektorientiert
	
	
	private void speichern ()
	{
	
		try
		{
			
			
			dateinameErstellen();
			
			System.out.println("" + wertString + "hier");
			
			if(datei.equals("keinName"))
			{
				 JOptionPane.showMessageDialog(null,datei,"Achtung", JOptionPane.CANCEL_OPTION);
			}
			else
			{
				BufferedWriter out = new BufferedWriter(new FileWriter(datei, false));
				try
				{
					dateiSpeichern();
					String nummer, bezeichnung, preis;
					out.write("Artikelnummer; Arikelbezeichnung; Preis;");
					System.out.println("Artikelnummer; Arikelbezeichnung; Preis;");
					out.newLine();
					for(int i = 0; i < listModelWarenkorb.getSize(); i++)
					{
						nummer = listModelWarenkorb.elementAt(i).getArtikelnummer();
						bezeichnung = listModelWarenkorb.elementAt(i).getArtikelbezeichnung();
						preis = Double.toString(listModelWarenkorb.elementAt(i).getPreis());
						out.write(nummer + "; " + bezeichnung + "; " + preis + " €;");
						System.out.println(nummer + "; " + bezeichnung + "; " + preis + " €;");
						out.newLine();
					}
				}
				catch(IOException ex)
				{
					System.out.println(ex.getMessage());
				}
				finally
				{
					out.close();
				}
			}
		}
		catch(IOException e)
		{
			System.out.println("IOException");
		}		
	}
	
	private void dateinameErstellen()
	{
		
		
		String name = null;
		ArrayList<String> nummern;
		
		
		name = view.getTextFieldKundenname().getText();
		
		//System.out.println(name);
		
		if(name.length() != 0)
		{
			
			try
			{
				String zeile = null;
				String[] values = null;
				BufferedReader in = new BufferedReader(new FileReader("Kunden.txt"));
				nummern = new ArrayList<String>();
				try
				{
					while((zeile = in.readLine()) != null)
					{
						values = zeile.split(";");
						nummern.add(values[1]);
					}
					
					
					int wert = Integer.valueOf(values[1]);
					wert++;
					wertString = Integer.toString(wert);
					
				}
				catch(IOException ex)
				{
					System.out.println(ex.getMessage());
				}
				finally
				{
					in.close();
				}
				
				datei = name + wertString + ".txt";
			
			}
			catch(IOException e)
			{	
				System.out.println("Die Datei konnte nicht gefunden werden");
			}
		}	
		else
		{
			datei = "keinName";
		}
		
	}
	private void dateiSpeichern()
	{
		try
		{
			
			BufferedWriter out2 = new BufferedWriter(new FileWriter("Kunden.txt", true));
			try
			{
				out2.newLine();
				out2.write(datei + ";" + wertString);
				System.out.println(datei + ";" + wertString);
				
			}
			catch(IOException ex)
			{
				System.out.println(ex.getMessage());
			}
			finally
			{
				out2.close();
			}
			
		}
		catch(IOException e)
		{
			System.out.println("IOException");
		}		
	}
	
	*/
}

