package Filmdatenbank;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EventListener;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

public class Control
{
	private ViewFilm view;
	private DefaultListModel<Film> listModelFilme;
	private DefaultComboBoxModel<String> genres;
	private ArrayList<Film> arrayListFilme2;
	private ArrayList<Film> arrayListFilmeZurueck;
	private ActionListener aufsteigend;
	private ActionListener absteigend;
	private ActionListener aufsteigendTitel;
	private ActionListener absteigendTitel;
	private ActionListener anfangend;
	private ActionListener suchend;
	private ItemListener genreGewaehlt;
	
	public Control()
	{
		view = new ViewFilm();
		
		listModelFilme = new DefaultListModel<Film>();
		arrayListFilme2 = new ArrayList<Film>();
		arrayListFilmeZurueck = new ArrayList<Film>();
		genres = new DefaultComboBoxModel<String>();
		
		einlesen();
		listenerSetzen();
		fuelleDropDown();
		
		
		view.getListFilme().setModel(listModelFilme);
		view.getComboBox().setModel(genres);
		
		view.getButtonAufsteigend().addActionListener(aufsteigend);
		view.getButtonAbsteigend().addActionListener(absteigend);
		view.getButtonTitelAufsteigend().addActionListener(aufsteigendTitel);
		view.getButtonTitelAbsteigend().addActionListener(absteigendTitel);
		view.getButtonZurueck().addActionListener(anfangend);
		view.getButtonSuche().addActionListener(suchend);
		view.getComboBox().addItemListener(genreGewaehlt);
		
		
	}
	
	private void listenerSetzen()
	{
		aufsteigend = (e) -> 
		 {
			 aufsteigen();
		 };
		absteigend = (e) -> 
		 {
			 absteigen();
		 };
		aufsteigendTitel = (e) -> 
		 {
			 aufsteigenTitel();
		 };
		absteigendTitel = (e) -> 
		 {
			 absteigenTitel();
		 };
		anfangend = (e) -> 
		 {
			 anfangen();
		 };
		suchend = (e) -> 
		 {
			 suchen(view.getTextField().getText());
		 };
		 genreGewaehlt = (e) ->
		 {
			 genreWaehlen(view.getComboBox().getSelectedItem());
		 };
	}
	
	private void fuelleDropDown()
	{
		int zaehler, k = 0;
		
		for(int i = 0; i < arrayListFilme2.size(); i++)
		{
			zaehler = 0;
			for(int j = i; j < arrayListFilme2.size(); j++)
			{
				if(arrayListFilme2.get(i).getGenre().equals(arrayListFilme2.get(j).getGenre()))
				{
					zaehler++;
				}
			}
			if(zaehler < 2)
			{
				genres.addElement(arrayListFilme2.get(i).getGenre());
				k++;
			}
		}
	}
	
	private void genreWaehlen(Object o)
	{
		String genreText = (String) o;
		listModelFilme.removeAllElements();
		for(int i = 0; i < arrayListFilme2.size(); i++)
		{
			//System.out.println(arrayListFilme2.get(i).getGenre() + " | " + genreText);
			if(arrayListFilme2.get(i).getGenre().equals(genreText))
			{
				listModelFilme.addElement(arrayListFilme2.get(i));
			}
		}
		arrayListFilme2Aktualisieren();
	}
	
	private void einlesen()
	{
		int zaehler, k = 0;
		DHNIO dhnio = new DHNIO();
		String pfad = "Filmliste/FilmListe.txt";
		ArrayList<Film> arrayListFilme = new ArrayList<Film>();
		arrayListFilme = dhnio.lesenArrayListFilme(pfad);
		
	
		
		for(int i = 0; i < arrayListFilme.size(); i++)
		{
			zaehler = 0;
			for(int j = i; j < arrayListFilme.size(); j++)
			{
				if(arrayListFilme.get(i).equals(arrayListFilme.get(j)))
				{
					zaehler++;
				}
			}
			if(zaehler < 2)
			{
				arrayListFilmeZurueck.add(k, arrayListFilme.get(i));
				k++;
			}
		}
	    for(Film element: arrayListFilmeZurueck)
		{
			listModelFilme.addElement(element);
			arrayListFilme2.add(element);
		}
	}
	private void suchen(String text)
	{
		int laenge = text.length();
		String text2;
		
		if(arrayListFilmeZurueck.size() > arrayListFilme2.size())
		{
			anfangen();
		}
		
		listModelFilme.removeAllElements();
		
		for(int i = 0; i < arrayListFilme2.size(); i++)
		{
			//System.out.println(text + " | " + arrayListFilme2.get(i).getTitel().substring(0, laenge));
			if(text.equals(arrayListFilme2.get(i).getTitel().substring(0, laenge)))
			{
				System.out.println("hallo");
				listModelFilme.addElement(arrayListFilme2.get(i));
			}
		}
		arrayListFilme2Aktualisieren();
	}
	
	private void aufsteigen()
	{	
		Comparator<Film> comp = new FilmNummerAufsteigendComparator();
		Collections.sort(arrayListFilme2, comp);
		
		listModelFilme.removeAllElements();
		
		for(Film element: arrayListFilme2)
		{
			listModelFilme.addElement(element);
		}
		arrayListFilme2Aktualisieren();
	}
	private void absteigen()
	{	
		Comparator<Film> comp = new FilmNummerAbsteigendComparator();
		
		Collections.sort(arrayListFilme2, comp);
		
		listModelFilme.removeAllElements();
		
		for(Film element: arrayListFilme2)
		{
			listModelFilme.addElement(element);
		}
		arrayListFilme2Aktualisieren();
	}
	private void aufsteigenTitel()
	{	
		Comparator<Film> comp = new FilmTitelAufsteigendComparator();
		Collections.sort(arrayListFilme2, comp);
		
		listModelFilme.removeAllElements();
		
		for(Film element: arrayListFilme2)
		{
			listModelFilme.addElement(element);
		}
		arrayListFilme2Aktualisieren();
	}
	private void absteigenTitel()
	{	
		Comparator<Film> comp = new FilmTitelAbsteigendComparator();
		
		Collections.sort(arrayListFilme2, comp);
		
		listModelFilme.removeAllElements();
		
		for(Film element: arrayListFilme2)
		{
			listModelFilme.addElement(element);
		}
		arrayListFilme2Aktualisieren();
	}
	private void anfangen()
	{
		listModelFilme.removeAllElements();
		
		for(Film element: arrayListFilmeZurueck)
		{
			listModelFilme.addElement(element);
		}
		arrayListFilme2Aktualisieren();
	}
	private void arrayListFilme2Aktualisieren()
	{
		arrayListFilme2.clear();
		for(int i = 0; i < listModelFilme.getSize(); i++)
		{
			arrayListFilme2.add(listModelFilme.getElementAt(i));
		}
	}
}
