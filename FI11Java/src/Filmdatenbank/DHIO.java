package Filmdatenbank;

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
	public ArrayList<Film> lesenArrayListFilme(String pfad)
	{
		FileReader fr = null;
		try 
		{
			fr = new FileReader(pfad, StandardCharsets.UTF_8);
			in = new BufferedReader(fr);
			
			return super.einlesenArrayListFilme();
		} 
		catch (IOException e)
		{
			System.out.println("Die Filmliste Datei kann nicht gelesen werden");
			return null;
		}		
	}
	
}