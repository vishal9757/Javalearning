package wordcount;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Count {

	public String input() {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		return str;
	}

	public String[] extract(String str) {
		ArrayList<String> result = new ArrayList<>();
		//String[] result = new String[10];
		StringBuilder sb = new StringBuilder();
		char[] c = str.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == ' ') {
				result.add(sb.toString());
				sb = new StringBuilder();
			} else {
				sb.append(c[i]);
			}
			
		}
		result.add(sb.toString());
		return result.toArray(new String[result.size()]);
	}

	public WordCount[] count(String[] result) {
		int count = 0;
		String[] str = {"C","Java","rain","count"};
		String word = "";
		ArrayList<WordCount> arr = new ArrayList<>();
		int pos = 0;
		for (int i = 0; i < result.length; i++) {
			word = result[i];
			if (word == null) {
				continue;
			}
			for (int j = i; j < result.length; j++) {
				if (word.equals(result[j])) {
					count++;
					result[j] = null;
				}
			}
			
			if(count>0)
				arr.add(new WordCount(word, count));
			pos++;
			word = "";
			count = 0;
		}
		return arr.toArray(new WordCount[arr.size()]);
	}

	public WordCount[] sort(WordCount[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				WordCount first = arr[i];
				WordCount second = arr[j];
//				if (arr[i] == null || arr[j] == null) {
//					continue;
//				}
				int comp = first.word.compareToIgnoreCase(second.word);
				if (comp > 0) {
					arr[i] = second;
					arr[j] = first;
				}
			}
		}
		return arr;
	}
}
