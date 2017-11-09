package wordcount;

import java.util.*;

public class Word {
	public static void main(String args[]) {
		Count c = new Count();
		String[] result = c.extract("This is a count is teach C c and Java but rain so no C java");
		WordCount[] count = c.count(result);
		WordCount[] sort = c.sort(count);
		for (int i = 0; i < sort.length; i++) {
			System.out.println(sort[i]);
		}

	}
}
