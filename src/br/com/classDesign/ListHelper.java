package br.com.classDesign;

import java.util.ArrayList;
import static java.util.Collections.sort;
import java.util.List;

public class ListHelper {
	public List<String> copyAndSortList(List<String> original) {
		List<String> list = new ArrayList<String>(original);
		sort(list);
		return list;
	}
}
