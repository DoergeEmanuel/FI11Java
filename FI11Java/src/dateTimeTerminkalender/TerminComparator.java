package dateTimeTerminkalender;

import java.util.Comparator;

public class TerminComparator implements Comparator<Termin>
{
	public int compare(Termin termin1, Termin termin2)
	{	
		
		return termin1.getDatum().compareTo(termin2.getDatum());
	}
}
