package kaufhausDateihandler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class DHNIO  extends Dateihandler
{
	public DHNIO() 
	{
		super();
	}

	@Override
	public DefaultListModel<Sortiment> lesenDefaultListModelSortiment(String pfad)
	{
		Path datei;
		try 
		{
			datei = Paths.get(pfad);
			in = Files.newBufferedReader(datei , StandardCharsets.UTF_8); 	
			return super.lesenDefaultListModel2();	
		} catch (IOException e)
		{
			System.out.println("Die Sortiment Datei kann nicht gelesen werden");
			return null;
		}		
	}
	
	@Override
	public boolean schreibenDefaultListModelSortiment(String pfad, DefaultListModel<Sortiment> listModelWarenkorb)
	{
		Path p = Paths.get(pfad);
		try 
		{
			out = Files.newBufferedWriter(p, StandardOpenOption.CREATE);
			return super.schreibenDefaultListModelSortiment2(listModelWarenkorb);
		} catch (IOException e)
		{
			System.out.println("Die Sortiment Datei kann nicht gespeichert werden");
			return false;
		}		
	}

	@Override
	public ArrayList<Bestellung> lesenArrayListBestellung(String pfad)
	{
		Path datei;
		try 
		{
			datei = Paths.get(pfad);
			in = Files.newBufferedReader(datei , StandardCharsets.UTF_8); 	
			
			return super.einlesenArrayList();
		} catch (IOException e)
		{
			System.out.println("Die Kunden Datei kann nicht gelesen werden");
			return null;
		}		
	}
	
	@Override
	public boolean schreibeBestellung(String pfad, Bestellung bestellung)
	{
		FileWriter fw;
		Path p = Paths.get(pfad);
		try 
		{
			out = Files.newBufferedWriter(p, StandardOpenOption.APPEND);
			return super.schreibeBestellung2(bestellung);
		} catch (IOException e)
		{
			System.out.println("Die Sortiment Datei kann nicht gespeichert werden");
			return false;
		}
	}
}
