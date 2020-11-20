package nozama;

import javax.swing.DefaultListModel; 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Control 
{
	ViewNozama viewNozama;
	
	private DefaultListModel<Sortiment> listModelSortiment;
	
	public Control()
	{
		viewNozama = new ViewNozama();
		
		listModelSortiment = new DefaultListModel<Sortiment>();
		
		fuelleInhalte();
	}
	private void fuelleInhalte()
	{
		try
		{
			String zeile = null;
			String[] values;
			BufferedReader in = new BufferedReader(new FileReader("Sortiment.txt"));
			try
			{
				while((zeile = in.readLine()) != null)
				{
					values = zeile.split("; ");
					
				}
			}
			catch(IOException ex)
			{
				System.out.println(ex.getMessage());
			}
		//	listModelSortiment.addElement(new Sortiment());
		}
		catch(IOException e)
		{
			System.out.println("IOException");
		}
		
	} 
}
