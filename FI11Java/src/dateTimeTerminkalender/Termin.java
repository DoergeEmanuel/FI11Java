package dateTimeTerminkalender;


import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Termin implements Comparable<Termin>
{
	private String titel;
	private LocalDateTime datum;
	//private Period restzeit;
	//private Duration restzeit2;
	
	private long jahre;
	private long monate;
	private long tage;
	private long stunden;
	private long minuten;
	
	
	public Termin(String titel, LocalDateTime datum)
	{
		this.titel = titel;
		this.datum = datum;
		
		
		berechneZeitunterschied();
	}

	public LocalDateTime getDatum()
	{
		return datum;
	}

	public void berechneZeitunterschied()
	{
		final LocalDateTime jetzt = LocalDateTime.now();
		/*
		Duration restzeit7 = null;
		
		LocalDateTime restzeit3 = jetzt.withHour(datum.getHour()).withMinute(datum.getMinute());
		
		restzeit2 = Duration.between(jetzt, restzeit3);
		
		long zwischen2 = restzeit2.getSeconds();
		
		//System.out.println(zwischen2);
		
		
		/*
		
		
		if(zwischen2 < 0)
		{
			restzeit3 = jetzt.plusDays(1);
			
			LocalDateTime restzeit6 = jetzt.plusDays(1).withHour(0).withMinute(0);
			LocalDateTime restzeit5 = jetzt.plusDays(1).withHour(datum.getHour()).withMinute(datum.getMinute());
			
			restzeit7 = Duration.between(jetzt, jetzt.withHour(23).withMinute(59));
			restzeit2 = Duration.between(restzeit6, restzeit5);
			
			restzeit7.getSeconds();
		}
		
		*/
		
		/*
		restzeit = Period.between(jetzt.toLocalDate() , datum.toLocalDate());
		
		jahre = restzeit.getYears();
		monate = restzeit.getMonths();
		tage = restzeit.getDays();
		
		long zwischen = restzeit2.getSeconds();
		
		if(restzeit7 != null)
		{
			zwischen += restzeit7.getSeconds();
		}
		
		stunden = zwischen / 3600;
		zwischen -= stunden * 3600;
		minuten = zwischen / 60;
		zwischen -= stunden * 60;
		*/
		
		jahre = ChronoUnit.YEARS.between(jetzt, datum);
		monate = ChronoUnit.MONTHS.between(jetzt, datum);
		tage = ChronoUnit.DAYS.between(jetzt, datum);
		stunden = ChronoUnit.HOURS.between(jetzt, datum);
		minuten = ChronoUnit.MINUTES.between(jetzt, datum);
		
	}

	@Override
	public String toString()
	{
		final DateTimeFormatter zeitformat1 = DateTimeFormatter.ofPattern("dd. MMM yyyy "+ "'um'" + " hh:mm");
		
		
		return titel + "           " + zeitformat1.format(datum) + "            " + minuten + " Minuten";
	}

	@Override
	public int compareTo(Termin o)
	{
		return this.getDatum().compareTo(o.getDatum());
		
	}
	
	
	
}
