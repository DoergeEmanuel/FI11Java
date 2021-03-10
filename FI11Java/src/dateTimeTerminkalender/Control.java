package dateTimeTerminkalender;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.swing.DefaultListModel;

public class Control
{
	View view;
	ActionListener hinzu;
	ActionListener aktualisiere;
	DefaultListModel<Termin> modelTermin;
	
	
	public Control()
	{
		view = new View();
		
		modelTermin = new DefaultListModel<Termin>();
		
		hinzu = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				hinzufuegen(view.getTextFieldTitel().getText(), view.getTextFieldJahr().getText(), view.getTextFieldMonat().getText(), view.getTextFieldTag().getText(), view.getTextFieldStunde().getText(), view.getTextFieldMinute().getText());
				
			}
		};
		aktualisiere = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				List<Termin> terminliste = new ArrayList<>();
				
				terminliste.clear();
				
				
				
				for(int i = 0; i < modelTermin.size(); i++)
				{
					
					
					terminliste.add(modelTermin.getElementAt(i));
					
				}
				modelTermin.clear();
				
				for(int i = 0; i < terminliste.size(); i++)
				{
					
					
					terminliste.get(i).berechneZeitunterschied();
					
					
					System.out.println(terminliste.get(i)+ "");
					Termin termin = terminliste.get(i);
					
					modelTermin.addElement(termin);
					
				}
			}
		};
		
		
		
		
		view.getListTermine().setModel(modelTermin);
		view.getButtonHinzufuegen().addActionListener(hinzu);
		view.getButtonAktualisieren().addActionListener(aktualisiere);
		
	}
	private void hinzufuegen(String titel, String jahr, String monat, String tag, String stunde, String minute)
	{
		LocalDateTime datum = LocalDateTime.of(Integer.parseInt(jahr), Integer.parseInt(monat), Integer.parseInt(tag), Integer.parseInt(stunde), Integer.parseInt(minute), 0, 0); 
		
		Termin termin = new Termin(titel, datum);
		modelTermin.addElement(termin);
		
		List<Termin> terminliste = new ArrayList<>();
		
		terminliste.clear();
		
		
		
		for(int i = 0; i < modelTermin.size(); i++)
		{
			
			
			terminliste.add(modelTermin.getElementAt(i));
			
			
		}
		modelTermin.clear();
		Collections.sort(terminliste);
		
		for(int i = 0; i < terminliste.size(); i++)
		{
			
			
			terminliste.get(i).berechneZeitunterschied();
			
			
			System.out.println(terminliste.get(i)+ "");
			Termin termin2 = terminliste.get(i);
			
			modelTermin.addElement(termin2);
			
		}
	}
		
		
	
	
}
