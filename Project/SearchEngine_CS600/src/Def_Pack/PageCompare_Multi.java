package Def_Pack;

import java.util.Comparator;

public class PageCompare_Multi implements Comparator<Rank> {

	@Override
	public int compare(Rank o1, Rank o2) {
		if (o1.getWordsNum().compareTo(o2.getWordsNum()) == 0) {
			return o2.getRank().compareTo(o1.getRank());
		} else {
			return o2.getWordsNum().compareTo(o1.getWordsNum());
		}
	}
}