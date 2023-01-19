package Def_Pack;

import java.util.*;
import java.io.IOException; 
public class Main_Mutli {

	//Starting point of the application
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap<String, Integer> frequencyData = new TreeMap<String, Integer>();
		
		//links to read data from
		String[] links = {"https://www.aninews.in/news/national/general-news/captain-kodalapuram-assumes-command-of-ins-garuda20221215231654/",
				"https://www.aninews.in/news/national/general-news/india-successfully-carries-out-night-trials-of-over-5000-km-range-agni-5-ballistic-missile20221215195944/",
					"https://www.aninews.in/news/national/general-news/delhi-hc-reserves-order-on-pleas-challenging-agnipath-scheme20221215193349/",
					"https://www.aninews.in/news/world/asia/indian-navy-chief-apprises-sri-lankan-president-of-bilateral-maritime-engagements-between-two-navies20221215184209/",
					"https://www.aninews.in/news/world/asia/indian-navy-chief-discusses-defence-cooperation-with-sri-lankan-pm-president-in-colombo20221215034859/",
					"https://www.aninews.in/news/world/others/former-us-pilot-held-in-australia-faces-us-charges-over-chinese-military-pilot-training20221215024648/",
					"https://www.aninews.in/news/world/asia/cns-admiral-r-hari-kumar-visits-sri-lankan-navy-ship-slns-sindurala-naval-facilities-at-colombo-port20221214131743/",
					"https://www.aninews.in/news/world/us/we-fully-support-indias-ongoing-efforts-to-de-escalate-situation-us-on-india-china-arunachal-border-clash20221214104641/",
					"https://www.aninews.in/news/national/general-news/gen-bipin-rawats-and-my-views-gelled-what-we-wanted-to-do-was-almost-same-general-naravane-on-his-relations-with-first-cds20221214215844/",
					"https://www.aninews.in/news/national/general-news/chinese-troops-attempted-to-change-status-quo-in-arunachal-rajnath-singh-in-rajya-sabha20221213140545/",
					"https://www.aninews.in/news/national/general-news/iaf-jets-had-to-be-scrambled-on-2-3-occasions-in-last-few-weeks-to-prevent-air-violations-by-china-over-arunachal-pradesh20221213102646/",
					"https://www.aninews.in/news/business/mtar-signs-mou-with-in-space-india-for-design-development-of-small-satellite-launch-vehicle20221212133414/",
					"https://www.aninews.in/news/national/general-news/yogi-govt-to-impart-self-defence-training-to-girls-under-mission-shakti-phase-four20221211220546/"};
			Data_File d = new Data_File();
		
		//looping through the above 6 links and calling the function to scrape only paragraphs through them.
		//Below is the call to store the words and find the word occurrences.
		for(String link : links)
		{
			d.getData(link,frequencyData);
		}
	
		//Printing the counts for all words.
		Rank.printAllCounts(frequencyData);
		Scanner scan = new Scanner(System.in);
		
		while (true) 
		{
			System.out.println("\nPlease enter the string of words you are looking for: ");
			String line = scan.nextLine();
			
			// To stop asking for words
			if (line.equals("exit")) break;
			
			List<Rank> pages = new ArrayList<>();
			Map<String, Rank> pMap = new HashMap<>();
			
			//Below looping is done to find through each page whether the requested word  is present or not with their respective count.
			for (String word : line.split(" "))
			{
				if (StopWord.is(word)) continue;
				
				for(int i = 0; i < links.length; i++)
				{
					Integer count = d.getData(links[i],word);
					if (count > 0) 
					{
						Rank pr = pMap.get(links[i]);
						if (pr == null)
						{
							pMap.put(links[i], new Rank(links[i]));
							pr = pMap.get(links[i]);
							pages.add(pr);
						}
						pr.insertWord(word, count);
					}
				} 
			}
			
			pages.sort(new PageCompare_Multi());
			for (Rank page : pages) 
			{
				System.out.println(page.getName() + " has " + page.getWords() + " " + page.getRank() + " times");
			}
		}
		scan.close();
		System.exit(0);
	}
}
