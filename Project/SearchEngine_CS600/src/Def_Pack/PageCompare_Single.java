package Def_Pack;

import java.util.Comparator;

public class PageCompare_Single implements Comparator<Rank> {

	@Override
	public int compare(Rank o1, Rank o2) {
		return o2.getRank().compareTo(o1.getRank());
	}
}