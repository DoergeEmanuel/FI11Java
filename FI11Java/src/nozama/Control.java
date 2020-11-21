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
				zeile = in.readLine();
				while((zeile = in.readLine()) != null)
				{
					values = zeile.split("; ");
					values[2] = values[2].replace(",", ".");
					values[2] = values[2].replace(" €", "");
					//System.out.println(values[0] + ";" + values[1] + ";" + values[2]);
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
		
		}
		catch(IOException e)
		{
			System.out.println("Die Datei konnte nicht gefunden werden");
		}
		viewNozama.getListSortiment().setModel(listModelSortiment);
		
	} 
}
