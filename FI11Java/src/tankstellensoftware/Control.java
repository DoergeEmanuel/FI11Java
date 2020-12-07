package tankstellensoftware;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;


public class Control
{
	ViewIntern viewIntern;
	ViewHandyApp viewHandyApp;
	ViewZapfsaeule viewZapfsaeule;
	ViewAnzeige viewAnzeige; 
	
	private DefaultListModel<Fuel> listModelFuel;
	private DefaultComboBoxModel<Fuel> comboBoxModelFuel;
	private MouseAdapter listenerAktualisieren;
	
	
	public Control()
	{
		viewIntern = new ViewIntern();
		viewHandyApp = new ViewHandyApp();
		viewZapfsaeule = new ViewZapfsaeule();
		viewAnzeige = new ViewAnzeige();
		
		listModelFuel = new DefaultListModel<>();
		comboBoxModelFuel = new DefaultComboBoxModel<>();
		
		setzeListener();
	}
	
	
	
	private void setzeListener()
	{
		listenerAktualisieren = new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				fuelleInhalte();			
			}
		};
		
		viewIntern.getButtonAktualisieren().addMouseListener(listenerAktualisieren);
	}
	
	private void fuelleInhalte()
	{
		
		try
		{
			String preis;	
			
			preis = viewIntern.getTextFieldBenzin().getText();
			listModelFuel.addElement(new Fuel("Bezin", Math.round(100.0 * Double.valueOf(preis)) / 100.0));
			comboBoxModelFuel.addElement(new Fuel("Bezin", Math.round(100.0 * Double.valueOf(preis)) / 100.0));
			preis = viewIntern.getTextFieldSuper().getText();
			listModelFuel.addElement(new Fuel("Super", Math.round(100.0 * Double.valueOf(preis)) / 100.0));
			comboBoxModelFuel.addElement(new Fuel("Super", Math.round(100.0 * Double.valueOf(preis)) / 100.0));
			preis = viewIntern.getTextFieldSuperPlus().getText();
			listModelFuel.addElement(new Fuel("Super Plus", Math.round(100.0 * Double.valueOf(preis)) / 100.0));
			comboBoxModelFuel.addElement(new Fuel("Super Plus", Math.round(100.0 * Double.valueOf(preis)) / 100.0));
			preis = viewIntern.getTextFieldDiesel().getText();
			listModelFuel.addElement(new Fuel("Diesel", Math.round(100.0 * Double.valueOf(preis)) / 100.0));
			comboBoxModelFuel.addElement(new Fuel("Diesel", Math.round(100.0 * Double.valueOf(preis)) / 100.0));
			
			viewAnzeige.getList().setModel(listModelFuel);
			viewHandyApp.getList().setModel(listModelFuel);
			viewHandyApp.getComboBox().setModel(comboBoxModelFuel);
			viewZapfsaeule.getComboBox().setModel(comboBoxModelFuel);
			
			viewZapfsaeule.getTextFieldBenzin().setText(String.valueOf(listModelFuel.getElementAt(0).getPreis()));
			viewZapfsaeule.getTextFieldSuper().setText(String.valueOf(listModelFuel.getElementAt(1).getPreis()));
			viewZapfsaeule.getTextFieldSuperPlus().setText(String.valueOf(listModelFuel.getElementAt(2).getPreis()));
			viewZapfsaeule.getTextFieldDiesel().setText(String.valueOf(listModelFuel.getElementAt(3).getPreis()));
			
			viewZapfsaeule.setVisible(true);
			viewAnzeige.setVisible(true);
			viewHandyApp.setVisible(true);	
		}
		catch(Exception e)
		{
			System.out.println("Achtung Exception");
			listModelFuel.removeAllElements();
		}
	}
}
