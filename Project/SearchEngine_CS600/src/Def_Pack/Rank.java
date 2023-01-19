package Def_Pack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class Rank {
	
	private String page;
	private Integer rank;
	private List<String> word;
	
	private Rank() {
		rank = 0;
		word = new ArrayList<>();
	}
	
	public Rank(String page) {
		this();
		this.page = page;
	}
	
	public Rank(String page, int occurence) {
		this();
		this.page = page;
		rank = occurence;
	}
	
	public void insertWord(String word, int count) {
		rank += count;
		this.word.add(word);
	}
	
	public String getName() {
		return page;
	}
	
	public Integer getWordsNum() {
		return word.size();
	}
	
	public String getWords() {
		StringBuilder sb = new StringBuilder("[");
		word.forEach(W -> {sb.append(W + ", ");});
		try {
		word.remove(word.lastIndexOf(" "));
		word.remove(word.lastIndexOf(","));
		} catch (Exception e) {}
		sb.append("]");
		return sb.toString();
	}
	
	public Integer getRank() {
		return rank;
	}
	
	public static int getCount(String word, TreeMap<String, Integer> frequencyData){
		if (frequencyData.containsKey(word)){
			return frequencyData.get(word);
		}
		else{
			return 0;
		}
	}
	
	public static void printAllCounts(TreeMap<String, Integer> frequencyData)
	{
		System.out.println("-----------------------------------------------");
        System.out.println("    Occurrences    Word");
        for(String word : frequencyData.keySet( ))
        {
            System.out.printf("%15d    %s\n", frequencyData.get(word), word);
        }
        System.out.println("-----------------------------------------------");
	}
}