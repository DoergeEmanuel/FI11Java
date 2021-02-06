package generics;

import java.util.ArrayList;

public class test
{
	public static void main(String[] args) 

	{ 

	// TODO Auto-generated method stub 

	 

	ArrayList<String> namensliste = new ArrayList<>(); 

	ArrayList<Integer> zahlenliste = new ArrayList<>(); 

	 

	ArrayList<?> wildeliste = new ArrayList<>(); 

	ArrayList<Object> wildeliste2 = new ArrayList<>(); 

	 

	wildeliste = zahlenliste; 

	 

	//wildeliste.add("5"); // geht nicht

	 

	System.out.println("leer"); 

	for (Object object : wildeliste) 

	{ 

	System.out.println(object); 

	} 

	 

	namensliste.add("FOO"); 

	zahlenliste.add(5); 

	 

	//namensliste = zahlenliste;  // geht nicht => Type Mismatch! 

	 

	wildeliste = namensliste; 

	//wildeliste.add("hallo"); // => geht nicht == add ( new Irgendwas() ) 

	 

	System.out.println("namensliste"); 

	for (Object object : wildeliste) 

	{ 

	System.out.println(object); 

	} 

	 

	wildeliste = zahlenliste; 

	// wildeliste.add(10);  // geht nicht siehe oben 

	 

	System.out.println("zahlenliste"); 

	for (Object object : wildeliste) 

	{ 

	System.out.println(object); 

	} 

	 

	// wildeliste.add("Hallo"); // geht nicht! 

	 

	System.out.println("wildeliste"); 

	for (Object object : wildeliste) 

	{ 

	System.out.println(object); 

	} 

	 

	} 
}
