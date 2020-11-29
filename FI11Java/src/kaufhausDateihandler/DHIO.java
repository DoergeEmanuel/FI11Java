package kaufhausDateihandler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;


public class DHIO extends Dateihandler
{
	public DHIO() 
	{
		super();
	}

	@Override
	public DefaultListModel<Sortiment> lesenDefaultListModelSortiment(String pfad)
	{
		FileReader fr = null;
		try 
		{
			fr = new FileReader(pfad, StandardCharsets.UTF_8);
			in = new BufferedReader(fr);
			
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
		FileWriter fw;
		try 
		{
			fw = new FileWriter(pfad, false);
			out = new BufferedWriter(fw);
			
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
		FileReader fr = null;
		try 
		{		
			fr = new FileReader(pfad, StandardCharsets.UTF_8);
			System.out.println(fr);
			in = new BufferedReader(fr);
			
			return super.einlesenArrayList();
		} catch (IOException e)
		{
			System.out.println(e);
			System.out.println("Die Kunden Datei kann nicht gelesen werden");
			return null;
		}		
	}
	
	@Override
	public boolean schreibeBestellung(String pfad, Bestellung bestellung)
	{
		FileWriter fw;
		try 
		{
			fw = new FileWriter(pfad, true);
			out = new BufferedWriter(fw);
			
			return super.schreibeBestellung2(bestellung);
		} catch (IOException e)
		{
			System.out.println("Die Sortiment Datei kann nicht gespeichert werden");
			return false;
		}
	}
}
	
