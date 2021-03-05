package StreamsEinfuehrung;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Testdriver
{
	public static void main(String[] args)
	{
		//Aufgabe 1
		/*
		ArrayList<String> namen = new ArrayList<>();
		namen.add("Andy");
		namen.add("Barbara");
		namen.add("Carsten");
		namen.add("Marius");
		namen.add("Micha");
		namen.add("Tim");
		
		Stream<String> namen2 = namen.stream().map(name -> {
			//System.out.println("map: " + name);
			return name.toUpperCase();
		}).
		filter(name -> {
			System.out.println("filter: " + name);
			return name.startsWith("M");
		});	
		
		namen2.forEach(name -> System.out.println("foreach: " + name));
		*/
		/*
		Stream.of("Andy", "Barbara", "Carsten", "Marius", "Micha", "Tim").
		
		filter(name -> {
			System.out.println("filter: " + name);
			return name.startsWith("M");
		}).
		
		map(name -> {
			System.out.println("map: " + name);
			return name.toUpperCase();
		}).
		
		
		forEach(name -> System.out.println("foreach: " + name));
		*/
		
		
		
		
		//Aufgabe 2
		
		/*
		Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).
				forEach(zahl -> System.out.println(zahl));
		*/
		/*
		Stream<Integer> zahlen = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		zahlen.forEach(zahl -> System.out.println(zahl));
		*/
		
		
		
		//Aufgabe 3
		
		/*
		final int result = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).
		
		filter(zahl -> zahl % 2 == 1).
		
		map(zahl -> zahl * zahl).
		
		reduce(0, Integer:: sum);
		
		//reduce(zahl)
	
		System.out.println(result);
		*/
		/*
		filter(zahl -> {
			if((int) zahl % 2 == 1)
			{
				
				return true;
			}
			return false;
		}).
		map(zahl -> {
			zahl * zahl;
			return zahl;
		 }.
		*/
		
		//Aufgabe 4
		//a)
		
		Stream<Integer> infiniteStream; 
		infiniteStream = IntStream.iterate(0, i -> i + 1).skip(11).limit(10).boxed();
				infiniteStream.forEach(System.out::println);
		
		
				
		//b)
		/*
		IntStream.iterate(0, i -> i + 1).
			boxed().
		//	sorted().
			limit(10).
			map(e -> "" + e).
		
		forEach(System.out::println);
		*/
	}

	

			

}
