package Def_Pack;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class StopWord {
	
	public static List<String> stop_words = new ArrayList<>();
	// Class to eradicate stop words from results.
	// Even if we put stop words to search, it will print there are no such words in the results.
	static {
		try
		{
			Scanner scan = new Scanner(new File("stopwords.txt"));
	        while(scan.hasNext())
		        {
		            stop_words.add(scan.next());
		        }
	        scan.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static boolean is(String word)
	{
		return stop_words.contains(word);
	}
}
