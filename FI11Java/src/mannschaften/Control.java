package mannschaften;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import kaufhaus.Sortiment;

public class Control
{
	private View view;
	
	private DefaultComboBoxModel<Liga<Mannschaft<? extends Spieler>>> comboBoxModelLiga1;
	private DefaultComboBoxModel<Liga<Mannschaft<? extends Spieler>>> comboBoxModelLiga2;
	
	private DefaultComboBoxModel<Mannschaft> comboBoxModelMannschaft1;
	private DefaultComboBoxModel<Mannschaft> comboBoxModelMannschaft2;
	private DefaultListModel<Mannschaft> listModelMannschaft1;
	private DefaultListModel<Mannschaft> listModelMannschaft2;
	private DefaultListModel<Spieler> listModelSpieler1;
	private DefaultListModel<Spieler> listModelSpieler2;

	private ItemListener comboBoxFuellenMannschaften1;
	private ItemListener comboBoxFuellenMannschaften2;
	private ItemListener listeFuelleSpieler1;
	private ItemListener listeFuelleSpieler2;

	private ActionListener rein;
	private ActionListener raus;
	private ActionListener reinM;
	private ActionListener rausM;
	
	ArrayList<Liga> ligaListe;
	
	
	public Control()
	{
		view = new View();
		
		comboBoxModelLiga1 = new DefaultComboBoxModel();
		comboBoxModelLiga2 = new DefaultComboBoxModel();
		comboBoxModelMannschaft1 = new DefaultComboBoxModel();
		comboBoxModelMannschaft2 = new DefaultComboBoxModel();
		
		listModelMannschaft1 = new DefaultListModel();
		listModelMannschaft2 = new DefaultListModel();
		listModelSpieler1 = new DefaultListModel<Spieler>();
		listModelSpieler2 = new DefaultListModel<Spieler>();
		
		datenAdden();
		
		listenerAdden();
	}
	
	private void datenAdden()
	{
		Liga<Mannschaft<FussballSpieler>> bundesliga;
		Liga<Mannschaft<BasketballSpieler>> basketliga;
		Liga<Mannschaft<BasketballSpieler>> bundesligaBaskets;
		Liga<Mannschaft<FussballSpieler>> primeraDivision;
		Liga<Mannschaft<? extends Spieler>> wildeliga;
		
		Mannschaft<FussballSpieler> fcBayern;
		Mannschaft<FussballSpieler> real;
		Mannschaft<BasketballSpieler> basketball;
		Mannschaft<BasketballSpieler> basketball2;
		Mannschaft<Spieler> wilderball;
		
		FussballSpieler spieler1;
		FussballSpieler spieler2;
		BasketballSpieler spieler3;
		BasketballSpieler spieler4;
		
		
		ligaListe = new ArrayList();
		
		Ligafabrik lf = new Ligafabrik();
	
		
		wildeliga = (Liga<Mannschaft<? extends Spieler>>) lf.erzeugeLiga(new WilderDummySpieler("dummy"), "wildeliga");
		bundesliga = (Liga<Mannschaft<FussballSpieler>>) lf.erzeugeLiga(new FussballSpieler("dummy"), "bundesliga");
		basketliga = (Liga<Mannschaft<BasketballSpieler>>) lf.erzeugeLiga(new BasketballSpieler("dummy"), "basketliga");
		primeraDivision = (Liga<Mannschaft<FussballSpieler>>) lf.erzeugeLiga(new FussballSpieler("dummy"), "primera division");
		bundesligaBaskets = (Liga<Mannschaft<BasketballSpieler>>) lf.erzeugeLiga(new BasketballSpieler("dummy"), "bundesligaBaskets");
		
	
		ligaListe.add(basketliga);
		ligaListe.add(bundesliga);
		ligaListe.add(bundesligaBaskets);
		ligaListe.add(wildeliga);
		ligaListe.add(primeraDivision);
		
		Mannschaftsfabrik mf = new Mannschaftsfabrik();
		
		real = (Mannschaft<FussballSpieler>) mf.erzeugeMannschaft(new FussballSpieler("dummy"), "Real Madrid");
		fcBayern = (Mannschaft<FussballSpieler>) mf.erzeugeMannschaft(new FussballSpieler("dummy"), "Fc Bayern");
		basketball = (Mannschaft<BasketballSpieler>) mf.erzeugeMannschaft(new BasketballSpieler("dummy"), "basketballverein1");
		basketball2 = (Mannschaft<BasketballSpieler>) mf.erzeugeMannschaft(new BasketballSpieler("dummy"), "basketballverein2");
		wilderball = (Mannschaft<Spieler>) mf.erzeugeMannschaft(new WilderDummySpieler("dummy"), "wilderballverein");
		
		bundesliga.mannschaftAdden(real);
		bundesliga.mannschaftAdden(fcBayern);
		basketliga.mannschaftAdden(basketball);
		basketliga.mannschaftAdden(basketball2);
		wildeliga.mannschaftAdden(wilderball);
		wildeliga.mannschaftAdden(fcBayern);
		wildeliga.mannschaftAdden(basketball);
		primeraDivision.mannschaftAdden(real);
		primeraDivision.mannschaftAdden(fcBayern);
		bundesligaBaskets.mannschaftAdden(basketball);
		
		spieler1 = new FussballSpieler("Lewandwoski");
		spieler2 = new FussballSpieler("name2");
		
		spieler3 = new BasketballSpieler("name3");
		spieler4 = new BasketballSpieler("name4");
		
		fcBayern.spielerAdden(spieler1);
		fcBayern.spielerAdden(spieler2);
		
		basketball.spielerAdden(spieler3);
		basketball.spielerAdden(spieler4);
		
		basketball2.spielerAdden(spieler3);
		
		wilderball.spielerAdden(spieler1);
		wilderball.spielerAdden(spieler2);
		wilderball.spielerAdden(spieler3);
		wilderball.spielerAdden(spieler4);
		
		
		for(Liga l: ligaListe)
		{
			comboBoxModelLiga1.addElement(l);
			comboBoxModelLiga2.addElement(l);
		}
	}
	
	private void listenerAdden()
	{
		comboBoxFuellenMannschaften1 = (e) ->
		{
			fuelleListundComboBoxMannschaften(view.getComboBoxLigen1().getSelectedItem(), listModelMannschaft1, comboBoxModelMannschaft1);
		};
		
		comboBoxFuellenMannschaften2 = (e) ->
		{
			fuelleListundComboBoxMannschaften(view.getComboBoxLigen2().getSelectedItem(), listModelMannschaft2, comboBoxModelMannschaft2);
		};
		
		listeFuelleSpieler1 = (e) ->
		{
			fuelleListeSpieler(view.getComboBoxMannschaften1().getSelectedItem(), listModelSpieler1);			
		};
		
		listeFuelleSpieler2 = (e) ->
		{
			fuelleListeSpieler(view.getComboBoxMannschaften2().getSelectedItem(), listModelSpieler2);
		};
		
		rein = (e) ->
		{
			reinlassen(view.getComboBoxMannschaften1().getSelectedItem(), view.getComboBoxMannschaften2().getSelectedItem(), view.getList1().getSelectedValuesList(), listModelSpieler1, listModelSpieler2);
		};
		
		raus = (e) ->
		{
			reinlassen(view.getComboBoxMannschaften2().getSelectedItem(), view.getComboBoxMannschaften1().getSelectedItem(), view.getList2().getSelectedValuesList(), listModelSpieler2, listModelSpieler1);
		};
		
		reinM = (e) ->
		{
			reinlassenM(view.getComboBoxLigen1().getSelectedItem(), view.getComboBoxLigen2().getSelectedItem(), view.getList1Mannschaften().getSelectedValuesList(), listModelMannschaft1, listModelMannschaft2, comboBoxModelMannschaft1, comboBoxModelMannschaft2);
		};
		
		rausM = (e) ->
		{
			reinlassenM(view.getComboBoxLigen2().getSelectedItem(), view.getComboBoxLigen1().getSelectedItem(), view.getList2Mannschaften().getSelectedValuesList(), listModelMannschaft2, listModelMannschaft1, comboBoxModelMannschaft2, comboBoxModelMannschaft1);	
		};
		
		
		view.getComboBoxLigen1().setModel(comboBoxModelLiga1);
		view.getComboBoxLigen2().setModel(comboBoxModelLiga2);
		view.getComboBoxMannschaften1().setModel(comboBoxModelMannschaft1);
		view.getComboBoxMannschaften2().setModel(comboBoxModelMannschaft2);
		view.getList1().setModel(listModelSpieler1);
		view.getList2().setModel(listModelSpieler2);
		view.getList1Mannschaften().setModel(listModelMannschaft1);
		view.getList2Mannschaften().setModel(listModelMannschaft2);

		
		view.getComboBoxLigen1().addItemListener(comboBoxFuellenMannschaften1);
		view.getComboBoxLigen2().addItemListener(comboBoxFuellenMannschaften2);
		
		view.getComboBoxMannschaften1().addItemListener(listeFuelleSpieler1);
		view.getComboBoxMannschaften2().addItemListener(listeFuelleSpieler2);
		
		view.getButtonRechts().addActionListener(rein);
		view.getButtonLinks().addActionListener(raus);
		
		view.getButtonRechtsMannschaften().addActionListener(reinM);
		view.getButtonLinksMannschaften().addActionListener(rausM);
	}
	
	
	private void fuelleListundComboBoxMannschaften(Object o, DefaultListModel<Mannschaft> dlmM, DefaultComboBoxModel<Mannschaft> dcmM)
	{
		dcmM.removeAllElements();
	
		Liga l = (Liga) o;
		
		ArrayList<Mannschaft> mliste = l.getMannschaftListe();
		
		//System.out.println("" + mliste.getClass());
		
		dlmM.removeAllElements();
		for(Mannschaft m: mliste)
		{
			dcmM.addElement(m);
			dlmM.addElement(m);
		}
	}
	private void fuelleComboBoxMannschaften2(Object o)
	{
		Liga l = (Liga) o;
		
		ArrayList<Mannschaft> mliste = l.getMannschaftListe();
		
		//System.out.println("" + mliste.getClass());
		comboBoxModelMannschaft2.removeAllElements();
		listModelMannschaft2.removeAllElements();
		for(Mannschaft m: mliste)
		{
			
			comboBoxModelMannschaft2.addElement(m);
			listModelMannschaft2.addElement(m);
		}
	}
	private void fuelleListeSpieler(Object o, DefaultListModel<Spieler> dlmS)
	{
		dlmS.removeAllElements();
		
		if(o != null)
		{
			Mannschaft m = (Mannschaft) o;
			
			for(Object o1: m.getSpielerliste())
			{
				dlmS.addElement((Spieler) o1);
			} 	
		}
	}
	
	private void reinlassenM(Object o1, Object o2, Object o3, DefaultListModel<Mannschaft> dlmM1, DefaultListModel<Mannschaft> dlmM2, DefaultComboBoxModel<Mannschaft> dcmM1, DefaultComboBoxModel<Mannschaft> dcmM2)
	{
		Liga l = (Liga) o1;
		Liga l2 = (Liga) o2;
		
		List<Mannschaft<Spieler>> mannschaften;
		
		mannschaften = (List<Mannschaft<Spieler>>) o3;
		
		if(mannschaften != null && l.hashCode() != l2.hashCode())
		{	
			for(Mannschaft m: mannschaften)
			{
				if(m.getDummyType() == l2.getDummyType()|| l2.getDummyType() == new WilderDummySpieler("test").getClass())
				{
					l.rausschmeissen(m);
					dlmM1.removeElement(m);
					dcmM1.removeElement(m);
					
					//System.out.println("Das zweite: " + m2.getDummyType());					
					l2.mannschaftAdden(m);
					dlmM2.addElement(m);
					dcmM2.addElement(m);
				}
				else
				{
					System.out.println("Der Typ passt nicht");
				}
			}		
		}
		else
		{
			System.out.println("Bitte schieben sie eine Auswahl nur in eine gültige Liga");
		}
	}
	
	private void reinlassen(Object o1, Object o2, Object o3, DefaultListModel<Spieler> dlmS1, DefaultListModel<Spieler> dlmS2)
	{
		Mannschaft m = (Mannschaft) o1;
		
		Mannschaft m2 = (Mannschaft) o2;
		
		List<Spieler> spieler;
		
		spieler = (List<Spieler>) o3;
		
		if(spieler != null && m2 != null && m.hashCode() != m2.hashCode())
		{//alles ausgewählt
			if(m2.getDummyType() == m.getDummyType() || m2.getDummyType() == new WilderDummySpieler("test").getClass() || m.getDummyType() == new WilderDummySpieler("test").getClass())
			{//gleicher typ
				for(Spieler s: spieler)
				{
					if(s.getClass() == m2.getDummyType()|| m2.getDummyType() == new WilderDummySpieler("test").getClass())
					{//einzelner Spieler vom wilde liga typ,  oder in eine wilde Liga stecken
						
						m.rausschmeissen(s);
						dlmS1.removeElement(s);
						
						m2.spielerAdden(s);
						dlmS2.addElement(s);
					}
					else
					{
						System.out.println("Der Typ passt nicht");
					}
				}
			}
			else
			{
				System.out.println("Der Typ passt nicht");
			}
		}
		else
		{
			System.out.println("Bitte machen sie eine gültige Auswahl");
		}
	}
}
