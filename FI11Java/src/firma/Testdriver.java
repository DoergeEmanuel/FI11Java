package firma;

public class Testdriver 
{
	
	public static void main(String[] arg)
	{
		double bonus;
		
		Mitarbeiter mitarbeiter[] = new Mitarbeiter[4];
		
		Arbeiter paul = new Arbeiter("Paul", 17.20, 140);
		Angestellter kurt = new Angestellter("Kurt", 4000.00, 500.00);
		Praktikant olga = new Praktikant("Olga", 500.00);
		Chef otto = new Chef("Otto", 7000.00);
		otto.setAdresse(new Adresse("1", "3", "3"));
		
		mitarbeiter[0] = paul;
		mitarbeiter[0].setAdresse(new Adresse("1", "3", "3"));
		mitarbeiter[1] = kurt;
		mitarbeiter[1].setAdresse(new Adresse("1", "3", "3"));
		mitarbeiter[2] = olga;
		mitarbeiter[2].setAdresse(new Adresse("1", "3", "3"));
		mitarbeiter[3] = otto;
	
		
		kurt.setName("Hans");
		olga.setHungerlohn(1000);
		
		System.out.println(paul + " = " + paul.berechneEntgeld() + " Entgeld");
		System.out.println(kurt + " = " + kurt.berechneEntgeld() + " Entgeld");
		System.out.println(olga + " = " + olga.berechneEntgeld() + " Entgeld");
		System.out.println(otto + " = " + otto.berechneEntgeld() + " Entgeld");
		
		for(int i = 0; i < 4; i++)
		{
			System.out.println(mitarbeiter[i] + " = " + mitarbeiter[i].berechneEntgeld() + " Entgeld");
		}
		for(int i = 0; i < 4; i++)
		{
			try
			{
				System.out.println("Bitte Bonus eingeben fuer Mitarbeiter " + mitarbeiter[i].getName());
				bonus = new java.util.Scanner(System.in).nextDouble();
				System.out.println(mitarbeiter[i] + " + " + bonus + " = " + mitarbeiter[i].berechneEntgeldPlusBonus(bonus) + " Entgeld mit Bonus");
			}
			catch(Exception e)
			{
				System.out.println("Achtung Exception");
			}
		}
		
	}
		
		
	
}
