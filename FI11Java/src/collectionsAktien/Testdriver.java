package collectionsAktien;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import sortierung.Bier;
import sortierung.BierNamenInhaltComparator;

public class Testdriver
{
	public static void main(String[] args)
	{
		Collection<Aktie> treeSetDepot = new TreeSet<>();
		Collection<Aktie> hashSetDepot = new HashSet<Aktie>();
		List<Aktie> listDepot = new ArrayList<Aktie>();
		Collection<Aktie> depotUnderTest;
		
		
		Aktie pfizer = new Aktie("852009", "Pfizer Inc", 10);
		Aktie microsoft = new Aktie("870747", "Microsoft", 5);
		Aktie merck = new Aktie("659990", "Merck", 30);
		Aktie apple = new Aktie("865985", "Apple", 8);
		Aktie basf = new Aktie("BASF11", "BASF", 20);
		Aktie basf2 = new Aktie("BASF11", "BASF", 9);
		
		Map<String, Aktie> treeMapDepot = new TreeMap<>(); 
		
		treeMapDepot.put(pfizer.getWkn(), pfizer);
		treeMapDepot.put(microsoft.getWkn(), microsoft);
		treeMapDepot.put(merck.getWkn(), merck);
		treeMapDepot.put(apple.getWkn(), apple);
		treeMapDepot.put(basf.getWkn(), basf);
		treeMapDepot.put(basf2.getWkn(), basf2);
		
		Collection<String> werte = treeMapDepot.keySet();
		Collection<Aktie> werte2 = treeMapDepot.values();
		
		/*
		for(Aktie s: werte2)
		{
			System.out.println(s);
		}
		*/
		
		treeSetDepot.add(pfizer);
		treeSetDepot.add(microsoft);
		treeSetDepot.add(merck);
		treeSetDepot.add(apple);
		treeSetDepot.add(basf);
		treeSetDepot.add(basf2);
		
		/*
		listDepot.add(pfizer);
		listDepot.add(microsoft);
		listDepot.add(merck);
		listDepot.add(apple);
		listDepot.add(basf);
		listDepot.add(basf2);
		*/
		
		hashSetDepot.add(pfizer);
		hashSetDepot.add(microsoft);
		hashSetDepot.add(merck);
		hashSetDepot.add(apple);
		hashSetDepot.add(basf);
		hashSetDepot.add(basf2);
		
		/*
		Comparator<Aktie> comp = new ComparatorAktien();
		
		
		Collections.sort(listDepot);
		*/
		/*
		treeSetDepot.clear();
		treeSetDepot = listDepot;
		*/
		
		
		for(Aktie a: treeSetDepot)
		{
			System.out.println(a);
		}
		
		/*
		for(Aktie a: hashSetDepot)
		{
			System.out.println(a);
		}
		*/
		
	}
}
