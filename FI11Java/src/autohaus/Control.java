package autohaus;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

import kaufhaus.Sortiment;


public class Control 
{
	View view;
	DefaultComboBoxModel<Model> modelModell;
	DefaultComboBoxModel<Farbe> modelFarbe;
	DefaultComboBoxModel<Ps> modelPs;
	
	ArrayList<Model> arrayListModell;
	
	ItemListener waehle;
	
	public Control()
	{
		view = new View();
		
		modelModell = new DefaultComboBoxModel<Model>();
		modelFarbe = new DefaultComboBoxModel<Farbe>();
		modelPs = new DefaultComboBoxModel<Ps>();
		
		
		fuelleInhalte();
		
		
		
		setzeEventhandler();
		
		view.getComboBoxModell().setModel(modelModell);
		view.getComboBoxFarbe().setModel(modelFarbe);
		//view.getComboBoxPs().setModel(modelPs);
		
		view.getComboBoxModell().addItemListener(waehle);
	}
	
	private void setzeEventhandler()
	{
		
		waehle = new ItemListener()
		{
			@Override
			public void itemStateChanged(ItemEvent e)
			{
				waehlen(view.getComboBoxModell().getSelectedItem());	
			}
		};
	}
	
	private void waehlen(Object o)
	{	
		Model model = (Model) o;
		
		String name = model.getModel();
		
		modelFarbe.removeAllElements();
		
		for(int i = 0; i < arrayListModell.size(); i++)
		{
			if(name.equals(arrayListModell.get(i).getModel()))
			{
				
				//System.out.println(arrayListModell.get(i).getModel());
				modelFarbe.addElement(arrayListModell.get(i).getFarbe());
			}
		}
		//System.out.println(modelFarbe.getSize());
		
		for(int i = 0; i < modelFarbe.getSize(); i++)
		{
			for(int j = i + 1; j < modelFarbe.getSize(); j++)
			{
				
				if(modelFarbe.getElementAt(i).getFarbe().equals(modelFarbe.getElementAt(j).getFarbe()))
				{
					System.out.println(modelFarbe.getElementAt(i).getFarbe() + " - " + modelFarbe.getElementAt(j).getFarbe());
					modelFarbe.removeElementAt(i);
				}
			}
		}
		
		//System.out.println(modelFarbe.getSize());
	}
	
	private void fuelleInhalte()
	{
		ArrayList<Model> zwischen;
		lesen();
		
		for(Model item: arrayListModell)
		{
			modelModell.addElement(item);
		}	
		
		for(int i = 0; i < modelModell.getSize(); i++)
		{
			for(int j = i; j < modelModell.getSize(); j++)
			{
				System.out.println(modelModell.getElementAt(i).getModel() + " - " + modelModell.getElementAt(j).getModel());
				if(modelModell.getElementAt(i).getModel().equals(modelModell.getElementAt(j).getModel()))
				{
					modelModell.removeElementAt(i);
				}
			}
		}
		
	}
	private void lesen()
	{
		try 
		{
			String zeile;
			String[] values;
			arrayListModell = new ArrayList<Model>();
			
			BufferedReader in = new BufferedReader(new FileReader("Autohaus/Modelle.txt", StandardCharsets.UTF_8));
			
			try
			{
				in.readLine();
				while((zeile = in.readLine()) != null)
				{
					values = zeile.split("; ");
					Farbe farbe = new Farbe(values[1]);
					Ps ps = new Ps(Integer.valueOf(values[2]), Double.valueOf(values [3]));
					//System.out.println(values[0]);
					Model model = new Model(values[0], farbe , ps);
					
					arrayListModell.add(model);
					/*
					modelFarbe.addElement(farbe);
					modelPs.addElement(ps);
					modelModell.addElement(model);
					*/
				}
			}
			catch(IOException ex)
			{
				ex.printStackTrace();
				System.out.println("Modelle Datei Inhalt kann nicht gelesen werden");
			}
			finally
			{
				in.close();
			}
			
			
		} catch (IOException e)
		{
			e.printStackTrace();
			System.out.println("Modelle Datei kann nicht geoeffnet werden");
		}	
	}
}
