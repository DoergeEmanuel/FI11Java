package collectionsAktien;

import java.util.Comparator;

public class ComparatorAktien implements Comparator<Aktie>
{
	@Override
	public int compare(Aktie a1, Aktie a2)
	{
		
		if(a1.getWkn() == null && a2.getWkn() == null)
		{
			return 0;
		}
		if(a1.getWkn() == null)
		{
			return 1;
		}
		if(a2.getWkn() == null)
		{
			return -1;
		}
		
		
		return a1.getWkn().compareTo(a2.getWkn());
	}
}


