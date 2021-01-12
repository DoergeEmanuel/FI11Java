package kaufhausDateiHandlerSerialsierung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;



public abstract class Dateihandler 
{
	protected BufferedReader in;
	protected BufferedWriter out;
	protected DefaultListModel<Sortiment> listModelSortiment;
	ArrayList<Bestellung> bestellListe;


	public Dateihandler() 
	{
	
	}


	public abstract DefaultListModel<Sortiment> lesenDefaultListModelSortiment(String pfad);
	
	public abstract boolean schreibenDefaultListModelSortiment(String pfad, DefaultListModel<Sortiment> listModelWarenkorb);
	
	public abstract ArrayList<Bestellung> lesenArrayListBestellung(String pfad);
	
	public abstract boolean schreibeBestellung(String pfad, Bestellung bestellung);
	
	
	
	public boolean schreibeBestellung2(Bestellung bestellung)
	{
		try
		{	
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
			return true;
		}
		catch(IOException e)
		{
			System.out.println("IOException");	
			return false;
		}		
		
	}
	
	protected ArrayList<Bestellung> einlesenArrayList()
	{
		try
		{
			try
			{
				String zeile = null;
				String[] values = null;
				bestellListe = new ArrayList<Bestellung>();
				
				while((zeile = in.readLine()) != null && zeile.length() != 0)
				{
					values = zeile.split("; ");
					bestellListe.add(new Bestellung(values[0], Integer.valueOf(values[1])));
				}
				System.out.println(bestellListe.size());
				return bestellListe;
			}
			catch(IOException ex)
			{
				System.out.println(ex.getMessage());
				return null;
			}
			finally
			{
				in.close();
			}
		}
		catch(IOException e)
		{
			System.out.println("Noch gibt es nichts zu lesen");
			return null;
		}	
	}
	
	

	protected DefaultListModel<Sortiment> lesenDefaultListModel2() 
	{
		try
		{	
			try
			{
				String zeile = null;
				String[] values;
			
				listModelSortiment = new DefaultListModel<Sortiment>();
				
				zeile = in.readLine();
				while((zeile = in.readLine()) != null)
				{
					
					values = zeile.split("; ");
					values[2] = values[2].replace(",", ".");
					values[2] = values[2].replace("€", "");	
					Sortiment produkt = new Sortiment(values[0],values[1], Double.valueOf(values[2]));
					listModelSortiment.addElement(produkt);
				}
				return listModelSortiment;
			}
			catch(IOException ex)
			{
				System.out.println(ex.getMessage());
				return null;
			}
			finally
			{
				in.close();
			}
		}
		catch(IOException e)
		{
			System.out.println("Die Sortiment Datei kann nicht gelesen werden");	
			return null;
		}
		
	}	
	
	protected boolean schreibenDefaultListModelSortiment2(DefaultListModel<Sortiment> listModelWarenkorb) 
	{
		try
		{ 
			try
			{
				bestellListe = new ArrayList<Bestellung>();
				
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
				return true;
			}
			catch(IOException ex)
			{
				System.out.println(ex);
				return false;
			}
			finally
			{
				out.close();
			}
		}
		catch(IOException e)
		{
			System.out.println(e);
			return false;
		}
	}
	
}
