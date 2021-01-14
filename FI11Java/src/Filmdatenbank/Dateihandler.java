package Filmdatenbank;

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
	protected ArrayList<Film> arrayListFilme;


	public Dateihandler() 
	{
	
	}


	public abstract ArrayList<Film> lesenArrayListFilme(String pfad);
	

	
	
	protected ArrayList<Film> einlesenArrayListFilme()
	{
		try
		{
			try
			{
				String zeile = null;
				String[] values = null;
				arrayListFilme = new ArrayList<Film>();
				
				in.readLine();
				while((zeile = in.readLine()) != null && zeile.length() != 0)
				{
					values = zeile.split(";");
					//System.out.println(values[0] + " " + values[1] + " " + values[2] + " " + values[3]);
					arrayListFilme.add(new Film(Integer.valueOf(values[0]), values[1], values[2], Integer.valueOf(values[3])));
				}
				//System.out.println(bestellListe.size());
				return arrayListFilme;
			}
			catch(IOException ex)
			{
				System.out.println(ex.getMessage());
				System.out.println("Datei kann nicht gelesen werden!");
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
}
	

	