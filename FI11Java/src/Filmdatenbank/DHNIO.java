package Filmdatenbank;

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
	public ArrayList<Film> lesenArrayListFilme(String pfad)
	{
		Path datei;
		try 
		{
			datei = Paths.get(pfad);
			in = Files.newBufferedReader(datei , StandardCharsets.UTF_8); 	
			return super.einlesenArrayListFilme();	
		} catch (IOException e)
		{
			System.out.println("Die Filmliste Datei kann nicht gelesen werden");
			return null;
		}		
	}
}