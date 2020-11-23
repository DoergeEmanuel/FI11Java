package kaufhaus;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
public class DHIO extends Dateihandler
{
	
	public void schreiben(String datei)
	{
		
		BufferedWriter out = new BufferedWriter(new FileWriter(bestellung.getDatei(), false));
		try
		{
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
				//System.out.println(nummer + "; " + bezeichnung + "; " + preis + " €;");
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
	
	public void lesen(String datei)
	{
		
	}
}
*/