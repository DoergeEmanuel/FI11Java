package kaufhausDateiHandlerSerialsierung;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class Serializer extends Dateihandler
{
	public Serializer()
	{
		
	}
	
	@Override
	public boolean schreibenDefaultListModelSortiment(String pfad, DefaultListModel<Sortiment> listModelWarenkorb)
	{
		/*
		try 
		{
			FileOutputStream fos = new FileOutputStream (pfad, false);
		
			ObjectOutputStream oos = new ObjectOutputStream (fos); 
			try
			{
				
				for(int i = 0; i < listModelWarenkorb.size(); i++)
				{
					oos.writeObject ((Sortiment) listModelWarenkorb.getElementAt(i));	
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
				oos.close();
				fos.close();
			}
		}
		catch (IOException e)
		{
			System.out.println("Die Sortiment Datei kann nicht gespeichert werden");
			return false;
		}	
		*/
		
		try (FileOutputStream fos = new FileOutputStream (pfad, false);
				ObjectOutputStream oos = new ObjectOutputStream (fos))
		{		
				
				oos.writeObject(listModelWarenkorb);
				
				return true;
		}
		catch (IOException e)
		{
			System.out.println("Die Sortiment Datei kann nicht gespeichert werden");
			return false;
		}	
		
	}
	
	
	
	@Override
	public DefaultListModel<Sortiment> lesenDefaultListModelSortiment(String pfad)
	{	
		/*
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
		*/
		
		/*
		DefaultListModel<Sortiment> liste;
		
		liste = new DefaultListModel<Sortiment>();
		
		try 
		{
			FileInputStream fis = new FileInputStream(pfad);
			System.out.println(pfad);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			
			
			try
			{
			
			
				liste = (DefaultListModel<Sortiment>) ois.readObject();
				//Object[] array = (Object[]) ois.readObject();
				
					
				System.out.println("hallo");
				return liste;
			}
			catch(IOException | ClassNotFoundException ex)
			{
				System.out.println(ex);
				System.out.println("achtung");
				return null;
			}
			finally
			{
				ois.close();
				fis.close();
			}
		
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		*/
		
		DefaultListModel<Sortiment> liste;
		
		liste = new DefaultListModel<Sortiment>();
		
		try (FileInputStream fis = new FileInputStream(pfad);
				ObjectInputStream ois = new ObjectInputStream(fis))
		{
			
			
				liste = (DefaultListModel<Sortiment>) ois.readObject();
				//System.out.println(liste.getElementAt(3));
				return liste;
			
		
		}
		catch (ClassNotFoundException | IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	
	
	
	
	
	
	@Override
	public ArrayList<Bestellung> lesenArrayListBestellung(String pfad) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean schreibeBestellung(String pfad, Bestellung bestellung) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	
}
