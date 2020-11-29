package kaufhaus2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;


public class Control 
{
	View view;
	ViewErfolg erfolg;
	DefaultListModel<Sortiment> listModelSortiment;
	DefaultListModel<Sortiment> listModelWarenkorb;
	ActionListener rein;
	ActionListener raus;
	ActionListener speichere;
	
	public Control()
	{
		view = new View();
		
		listModelSortiment = new DefaultListModel<Sortiment>();
		listModelWarenkorb = new DefaultListModel<Sortiment>();
		
		initialize();
		setzeListener();
		
		view.getButtonRein().addActionListener(rein);
		view.getButtonRaus().addActionListener(raus);
		view.getButtonAbschicken().addActionListener(speichere);
		
		view.getListSortiment().setModel(listModelSortiment);
		view.getListWarenkorb().setModel(listModelWarenkorb);
		
	}
	
	
	
	private void setzeListener()
	{
		rein = new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				rein2(view.getListSortiment().getSelectedValuesList());
			}
		};
		
		raus = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				raus2(view.getListWarenkorb().getSelectedValuesList());
			}
		};
				
		speichere = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				speichern();
			}	
		};
	
		
	}
	
	private void speichern()
	{
		boolean erfolgreich = false;
		
		String name = view.getTextFieldKunde().getText();
		
		Kunde kunde = new Kunde(name);
		
		erfolgreich = schreibe(kunde);
		
		if(erfolgreich == true)
		{
			System.out.printf("Die Datei " + kunde.getDatei() + " wurde erfolgreich erstellt");
			
			erfolg = new ViewErfolg(); 
			
			erfolg.getListBestellung().setModel(listModelWarenkorb);
			
			DefaultComboBoxModel<Sortiment> comboBoxModelBestellung = new DefaultComboBoxModel<Sortiment>();
			for(int i = 0; i < listModelWarenkorb.getSize(); i++)
			{
				comboBoxModelBestellung.addElement(listModelWarenkorb.getElementAt(i));
			}
		//	DefaultComboBoxModel<Sortiment> comboBoxModelBestellung = new DefaultComboBoxModel<>();
		
			erfolg.getComboBoxBestellung().setModel(comboBoxModelBestellung);
		}
	}
	
	private boolean schreibe(Kunde kunde)
	{
		
		try
		{
			Path pfad = Paths.get(kunde.getDatei());
			BufferedWriter out = Files.newBufferedWriter(pfad, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
			/*
			FileWriter fw = new FileWriter(kunde.getDatei(), StandardCharsets.UTF_8, false);
			BufferedWriter out = new BufferedWriter(fw);
			*/
			try
			{
				String nummer, bezeichnung;
				double preis;
				out.write("Artikelnummer; Artikelbezeichnung; Preis");
				for(int i = 0; i < listModelWarenkorb.getSize(); i++)
				{
					nummer = listModelWarenkorb.getElementAt(i).getArtikelnummer();
					bezeichnung = listModelWarenkorb.getElementAt(i).getArtikelbezeichnung();
					preis = listModelWarenkorb.getElementAt(i).getPreis();
					out.newLine();
					out.write(nummer + "; " + bezeichnung + "; " + Double.toString(preis) + "€");
					System.out.println(nummer + "; " + bezeichnung + "; " + Double.toString(preis) + "€");
				}
				return true;
			}
			catch (IOException ex) 
			{
				System.out.println("Die Datei des Kunden konnte nicht erstellt werden");
				ex.printStackTrace();
				return false;
			}
			finally
			{
				out.close();
			}
		}
		catch (IOException e) 
		{
			System.out.println("Die Datei des Kunden konnte nicht erstellt werden");
			e.printStackTrace();
			return false;
		}
		
	}
	
	private void raus2(List<Sortiment> auswahl)
	{
		for(Sortiment item: auswahl)
		{
			listModelWarenkorb.removeElement(item);
		}
	}
	
	private void rein2(List<Sortiment> auswahl)
	{
		for(Sortiment item : auswahl)
		{
			System.out.println(item);
			listModelWarenkorb.addElement(item);
		}
	}
	
	private void initialize()
	{
		lesen();
	}
	
	private void lesen()
	{
		try 
		{
			/*
			JFileChooser chooser = new JFileChooser();
			chooser.showOpenDialog(null);
			String file = chooser.getSelectedFile().toString();
			*/
			/*
			FileReader fr = new FileReader("Kaufhaus/Sortiment.txt", StandardCharsets.UTF_8);
			BufferedReader in = new BufferedReader(fr);
			*/
			Path pfad = Paths.get("Kaufhaus/Sortiment.txt");
			BufferedReader in = Files.newBufferedReader(pfad, StandardCharsets.UTF_8);
			
			String zeile;
			String[] values;
			
			try
			{
				String artikelnummer, artikelbezeichnung;
				double preis;
				in.readLine();
				while((zeile = in.readLine()) != null)
				{
					
					values = zeile.split("; ");
					artikelnummer = values[0];
					artikelbezeichnung = values[1];
					values[2] = values[2].replace(",", ".");
					values[2] = values[2].replace("€", "");
					preis = Double.valueOf(values[2]);
					System.out.println(values[0] + "; " + values[1] + "; " + values[2] + "€");
					listModelSortiment.addElement(new Sortiment(artikelnummer, artikelbezeichnung, preis));
				}
			}
			catch (IOException ex) 
			{
				System.out.println("Der Inhalt der Sortiment Datei konnte nicht geoeffnet werden.");
				ex.printStackTrace();
			}
			finally
			{
				in.close();
			}
		}
		catch (IOException e) 
		{
			System.out.println("Die Sortiment Datei konnte nicht geoeffnet werden.");
			e.printStackTrace();
		}
		
		
	}
}
