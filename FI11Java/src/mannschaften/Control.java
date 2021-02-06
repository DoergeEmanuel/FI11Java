package mannschaften;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import kaufhaus.Sortiment;

public class Control
{
	private View view;
	
	private DefaultComboBoxModel<Liga> comboBoxModelLiga1;
	private DefaultComboBoxModel<Liga> comboBoxModelLiga2;
	
	private DefaultComboBoxModel<Mannschaft> comboBoxModelMannschaft1;
	private DefaultComboBoxModel<Mannschaft> comboBoxModelMannschaft2;
	
	private DefaultListModel<Spieler> listModelSpieler1;
	private DefaultListModel<Spieler> listModelSpieler2;
	private DefaultComboBoxModel<Spieler> comboBoxModelSpieler1;
	private DefaultComboBoxModel<Spieler> comboBoxModelSpieler2;
	
	ArrayList<Liga> ligaListe;
	
	Liga<Mannschaft<FussballSpieler>> bundesliga;
	Liga<Mannschaft<BasketballSpieler>> basketliga;
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
	
	
	
	
	private ItemListener comboBoxFuellenMannschaften1;
	private ItemListener comboBoxFuellenMannschaften2;
	private ItemListener listeFuelleSpieler1;
	private ItemListener listeFuelleSpieler2;
	
	private ActionListener rein;
	private ActionListener raus;
	
	
	public Control()
	{
		view = new View();
		
		
		comboBoxModelLiga1 = new DefaultComboBoxModel<Liga>();
		comboBoxModelLiga2 = new DefaultComboBoxModel<Liga>();
		comboBoxModelMannschaft1 = new DefaultComboBoxModel<Mannschaft>();
		comboBoxModelMannschaft2 = new DefaultComboBoxModel<Mannschaft>();
		
		listModelSpieler1 = new DefaultListModel<Spieler>();
		listModelSpieler2 = new DefaultListModel<Spieler>();
		
		comboBoxModelSpieler1 = new DefaultComboBoxModel<Spieler>();
		comboBoxModelSpieler2 = new DefaultComboBoxModel<Spieler>();
		
		
		
		
		
		
		datenAdden();
		
		
		listenerAdden();
		
		/*
		fcBayern.mannschaftAusgeben();
		basketball.mannschaftAusgeben();
		*/
		
	
	
		view.getComboBoxLigen1().setModel(comboBoxModelLiga1);
		view.getComboBoxLigen2().setModel(comboBoxModelLiga2);
		view.getComboBoxMannschaften1().setModel(comboBoxModelMannschaft1);
		view.getComboBoxMannschaften2().setModel(comboBoxModelMannschaft2);
		view.getList1().setModel(listModelSpieler1);
		view.getList2().setModel(listModelSpieler2);
		view.getComboBoxSpieler1().setModel(comboBoxModelSpieler1);
		view.getComboBoxSpieler2().setModel(comboBoxModelSpieler2);
		
		view.getComboBoxLigen1().addItemListener(comboBoxFuellenMannschaften1);
		view.getComboBoxLigen2().addItemListener(comboBoxFuellenMannschaften2);
		
		view.getComboBoxMannschaften1().addItemListener(listeFuelleSpieler1);
		view.getComboBoxMannschaften2().addItemListener(listeFuelleSpieler2);
		
		view.getButtonRechts().addActionListener(rein);
		view.getButtonLinks().addActionListener(raus);
		/*
		view.getList1().addListSelectionListener(listeFuelleSpieler1);
		view.getList2().addListSelectionListener(listeFuelleSpieler2);
		*/
		
		
	
		
		
	}
	
	private void listenerAdden()
	{
		
		comboBoxFuellenMannschaften1 = new ItemListener()
		{
			
			@Override
			public void itemStateChanged(ItemEvent e)
			{
				
				fuelleComboBoxMannschaften1(view.getComboBoxLigen1().getSelectedItem());
				
			}
		};
		
		comboBoxFuellenMannschaften2 = new ItemListener()
		{
			@Override
			public void itemStateChanged(ItemEvent e)
			{
				
				fuelleComboBoxMannschaften2(view.getComboBoxLigen2().getSelectedItem());
				
			};
			
		};
		
		listeFuelleSpieler1 = (e) ->
		{
			fuelleListeSpieler1(view.getComboBoxMannschaften1().getSelectedItem());
		};
			
		listeFuelleSpieler2 = (e) ->
		{
			fuelleListeSpieler2(view.getComboBoxMannschaften2().getSelectedItem());
		};
		
		rein = (e) ->
		{
		
			reinlassen(view.getComboBoxMannschaften1().getSelectedItem(), view.getComboBoxMannschaften2().getSelectedItem());
			
		};
		raus = (e) ->
		{
			
		
			rauslassen(view.getComboBoxMannschaften2().getSelectedItem(), view.getComboBoxMannschaften1().getSelectedItem());
			
		};
	
		
	}
	private void rauslassen(Object o1, Object o2)
	{
		Mannschaft m = (Mannschaft) o1;
		
		Mannschaft m2 = (Mannschaft) o2;
		
		
		
		List<Spieler> spieler;
		
		//	m.mannschaftAusgeben();
			
		if(view.getList2().getSelectedValuesList() != null && view.getComboBoxMannschaften1().getSelectedItem() != null)
		{
			if(m2.getDummyType() == m.getDummyType() || m2.getDummyType() == new WilderDummySpieler("test").getClass() || m.getDummyType() == new WilderDummySpieler("test").getClass())
			{
				spieler = (List<Spieler>) view.getList2().getSelectedValuesList();
				
				for(Spieler s: spieler)
				{
					if(s.getClass() == m2.getDummyType() || m2.getDummyType() == new WilderDummySpieler("test").getClass())
					{
						m.rausschmeissen(s);
						listModelSpieler2.removeElement(s);
						
					 
						m2.spielerAdden(s);
						listModelSpieler1.addElement(s);
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
			System.out.println("Bitte vervollständigen Sie die Auswahl");
		}
	}
	
	private void reinlassen(Object o1, Object o2)
	{
		
			Mannschaft m = (Mannschaft) o1;
			
			//System.out.println("Das erste: " + m.getDummyType());
			
			Mannschaft m2 = (Mannschaft) o2;
			
			List<Spieler> spieler;
			
		//	m.mannschaftAusgeben();
			
			
			if(view.getList1().getSelectedValuesList() != null && view.getComboBoxMannschaften2().getSelectedItem() != null)
			{
				if(m2.getDummyType() == m.getDummyType() || m2.getDummyType() == new WilderDummySpieler("test").getClass() || m.getDummyType() == new WilderDummySpieler("test").getClass())
				{
					spieler = (List<Spieler>) view.getList1().getSelectedValuesList();
				
					for(Spieler s: spieler)
					{
						if(s.getClass() == m2.getDummyType() || m2.getDummyType() == new WilderDummySpieler("test").getClass())
						{
							m.rausschmeissen(s);
							listModelSpieler1.removeElement(s);
							
							//System.out.println("Das zweite: " + m2.getDummyType());					
							m2.spielerAdden(s);
							listModelSpieler2.addElement(s);
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
				System.out.println("Bitte vervollständigen Sie die Auswahl");
			}
			
		
				
		
	
	}
	
	private void datenAdden()
	{
		Mannschaftsfabrik mf = new Mannschaftsfabrik();
		
		ligaListe = new ArrayList<Liga>();
		
	
		
		basketliga = new Liga<Mannschaft<BasketballSpieler>>("basketliga");
		bundesliga = new Liga<Mannschaft<FussballSpieler>>("bundesliga");
		wildeliga = new Liga<Mannschaft<? extends Spieler>>("wildeliga");
		
		ligaListe.add(basketliga);
		ligaListe.add(bundesliga);
		ligaListe.add(wildeliga);
		
		
		real = (Mannschaft<FussballSpieler>) mf.erzeugeMannschaft(new FussballSpieler("dummy"), "Real Madrid");
		
	//	System.out.println("" + real.getDummyType());
		
		
	//	fcBayern = new Mannschaft<FussballSpieler>("Fc Bayern");
		fcBayern = (Mannschaft<FussballSpieler>) mf.erzeugeMannschaft(new FussballSpieler("dummy"), "Fc Bayern");
	//	basketball = new Mannschaft<BasketballSpieler>("basketballverein1");
		basketball = (Mannschaft<BasketballSpieler>) mf.erzeugeMannschaft(new BasketballSpieler("dummy"), "basketballverein1");
		basketball2 = (Mannschaft<BasketballSpieler>) mf.erzeugeMannschaft(new BasketballSpieler("dummy"), "basketballverein2");
	//	System.out.println("" + basketball.getDummyType());
	//	wilderball = new Mannschaft<Spieler>("wilderballverein");
		wilderball = (Mannschaft<Spieler>) mf.erzeugeMannschaft(new WilderDummySpieler("dummy"), "wilderballverein");
		
		bundesliga.mannschaftAdden(real);
		bundesliga.mannschaftAdden(fcBayern);
		basketliga.mannschaftAdden(basketball);
		basketliga.mannschaftAdden(basketball2);
		wildeliga.mannschaftAdden(wilderball);
		wildeliga.mannschaftAdden(fcBayern);
		wildeliga.mannschaftAdden(basketball);
		
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
	
	private void fuelleListeSpieler1(Object o)
	{
		if(o != null)
		{
		
			
			Mannschaft m = (Mannschaft) o;
			
			
			 
			listModelSpieler1.removeAllElements();
			comboBoxModelSpieler1.removeAllElements();
			
		
			for(Object o1: m.getSpielerliste())
			{
				
				listModelSpieler1.addElement((Spieler) o1);
				comboBoxModelSpieler1.addElement((Spieler) o1);
			} 
			
		}
		
	}
	
	private void fuelleListeSpieler2(Object o)
	{
		if(o != null)
		{
		
			
			Mannschaft m = (Mannschaft) o;
			
			
			 
			listModelSpieler2.removeAllElements();
			comboBoxModelSpieler2.removeAllElements();
		
			for(Object o1: m.getSpielerliste())
			{
				Spieler s = (Spieler) o1;
			//	System.out.println(s);
				listModelSpieler2.addElement((Spieler) o1);
				comboBoxModelSpieler2.addElement((Spieler) o1);
			} 
			
			//System.out.println(m.getSpielerliste().size());
			
		}
		
	}
	
	
	private void fuelleComboBoxMannschaften1(Object o)
	{
		if(o != null)
		{
			Liga l = (Liga) o;
			
			ArrayList<Mannschaft> mliste = l.getMannschaftListe();
			
			//System.out.println("" + mliste.getClass());
			comboBoxModelMannschaft1.removeAllElements();
			for(Mannschaft m: mliste)
			{
				
				comboBoxModelMannschaft1.addElement(m);
			}
		}
		
		
	}
	private void fuelleComboBoxMannschaften2(Object o)
	{
		Liga l = (Liga) o;
		
		ArrayList<Mannschaft> mliste = l.getMannschaftListe();
		
		//System.out.println("" + mliste.getClass());
		comboBoxModelMannschaft2.removeAllElements();
		for(Mannschaft m: mliste)
		{
			
			comboBoxModelMannschaft2.addElement(m);
		}
		
	}
	
	
}
