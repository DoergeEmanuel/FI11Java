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
	ItemListener waehle2;
	
	Model model;
	Farbe farbe;
	
	public Control()
	{
		view = new View();
		
		modelModell = new DefaultComboBoxModel<Model>();
		modelFarbe = new DefaultComboBoxModel<Farbe>();
		modelPs = new DefaultComboBoxModel<Ps>();
		
		arrayListModell = new ArrayList<Model>();
		
		fuelleInhalte();
		
		
		
		setzeEventhandler();
		
		view.getComboBoxModell().setModel(modelModell);
		view.getComboBoxFarbe().setModel(modelFarbe);
		view.getComboBoxPs().setModel(modelPs);
		
		view.getComboBoxModell().addItemListener(waehle);
		
		
		view.getComboBoxFarbe().addItemListener(waehle2);
			
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
		waehle2 = new ItemListener()
		{
			@Override
			public void itemStateChanged(ItemEvent e)
			{
				if(view.getComboBoxFarbe().getSelectedItem() != null)
				{
					waehlen2(view.getComboBoxFarbe().getSelectedItem());
				}
					
			}
		};
	}
	private void waehlen2(Object o)
	{	
		
		String name = model.getModel();
		Farbe farbe = (Farbe) o;
		String farbeString = farbe.getFarbe();
		
		ArrayList<Model> farbeList = new ArrayList<Model>();
		ArrayList<Model> psList = new ArrayList<>();
		
		modelPs.removeAllElements();
		psList.removeAll(farbeList);
		
		
		
		for(int i = 0; i < arrayListModell.size(); i++)
		{
			
			if(arrayListModell.get(i).getModel().equals(name))
			{
				//System.out.println(arrayListModell.get(i).getModel());
				farbeList.add(arrayListModell.get(i));
			}
			
		}
		
		
		for(int i = 0; i < farbeList.size(); i++)
		{
			System.out.println(farbeList.get(i).getModel() + " - " + farbeList.get(i).getFarbe().getFarbe() + " - " + farbeList.get(i).getPs().getPs());
			if(farbeList.get(i).getFarbe().getFarbe().equals(farbeString))
			{
				System.out.println("Hier -> " + farbeList.get(i).getModel() + " - " + farbeList.get(i).getFarbe().getFarbe() + " - " + farbeList.get(i).getPs().getPs());
				psList.add(farbeList.get(i));
			}
		}
		System.out.println("Ende");
		for(Model item: psList)
		{
		//	System.out.println(modelModell.getElementAt(i).getModel());
			modelPs.addElement(item.getPs());
			
		}
		
	}
	
	private void waehlen(Object o)
	{	
		model = (Model) o;
		String name = model.getModel();
		ArrayList<Model> farbeList = new ArrayList<Model>();
		ArrayList<Model> farbeList2 = new ArrayList<Model>();
		
		modelFarbe.removeAllElements();
		farbeList.removeAll(farbeList);
		
		
		
		for(int i = 0; i < arrayListModell.size(); i++)
		{
			
			if(arrayListModell.get(i).getModel().equals(name))
			{
				//System.out.println(arrayListModell.get(i).getModel());
				farbeList.add(arrayListModell.get(i));
			}
			
		}
		//System.out.println(farbeList.size());
			
		for(int i = 0; i < farbeList.size(); i++)
		{
			
			for(int j = i + 1; j < farbeList.size(); j++)
			{
				
				if(farbeList.get(i).getFarbe().getFarbe().equals(farbeList.get(j).getFarbe().getFarbe()))
				{
				//	System.out.println(farbeList.get(i).getFarbe() +"  hier");
					farbeList2.add(farbeList.get(i));
				}
			}
		}
		//System.out.println("Ende");
		/*
		if(arrayListModell.get(i).getModel().equals(name))
		{
			
		}
		*/
		//System.out.println(farbeList.size());
		/*
		for(int i = 0; i < farbeList.size(); i++)
		{
			//System.out.println(farbeList.get(i));
		}
		*/
		
		for(Model item: farbeList2)
		{
			
			farbeList.remove(item);
			
		}
		
		for(Model item: farbeList)
		{
		//	System.out.println(modelModell.getElementAt(i).getModel());
			modelFarbe.addElement(item.getFarbe());
			
		}
	}
	
	private void fuelleInhalte()
	{
		lesen();
		ArrayList<Model> modelList = new ArrayList<Model>();
		
		
		
		for(Model item: arrayListModell)
		{
			
			modelModell.addElement(item);
		}	
		
		//System.out.println(arrayListModell.size());
		for(int i = 0; i < arrayListModell.size(); i++)
		{
			for(int j = i + 1; j < arrayListModell.size(); j++)
			{
				//System.out.println(i + " - " + j);
				//System.out.println(arrayListModell.get(i).getModel() + " - " + arrayListModell.get(j).getModel());
				if(arrayListModell.get(i).getModel().equals(arrayListModell.get(j).getModel()))
				{
					modelList.add((arrayListModell.get(i)));
				}
			}
		}
	
		for(Model item: arrayListModell)
		{
		
		//	System.out.println(modelModell.getElementAt(i).getModel());
			if(modelList.contains(item))
			{
				modelModell.removeElement(item);
			}
		}
		
	}
	private void lesen()
	{
		try 
		{
			String zeile;
			String[] values;
			
			
			BufferedReader in = new BufferedReader(new FileReader("Autohaus/Modelle.txt", StandardCharsets.UTF_8));
			
			try
			{
				in.readLine();
				while((zeile = in.readLine()) != null)
				{
					values = zeile.split("; ");
					Farbe farbe = new Farbe(values[1]);
					Ps ps = new Ps(Integer.valueOf(values[2]), Double.valueOf(values [3]));
					Model model = new Model(values[0], farbe , ps);
					
					arrayListModell.add(model);
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
