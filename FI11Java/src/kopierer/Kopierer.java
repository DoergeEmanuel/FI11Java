package kopierer;

import java.util.ArrayList;
import java.util.List;

public class Kopierer<T>
{
	
	public void kopiere(List<T> liste1, List<T> liste2)
	{
		for(T element : liste1)
		{
			liste2.add(element);
		}
	}
	
	
	
	
}