package wordcount;

import java.util.Scanner;

public class Count {

	public String input(){
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		return str;
	}
	
	public String[] extract(String str){
		String[] result = new String[10];
		StringBuilder sb = new StringBuilder();
		int j=0;
		char[] c = str.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if(c[i]==' '){
				result[j] = sb.toString();
				sb = new StringBuilder();
				j++;
			}
			else{
				sb.append(c[i]);
			}
			result[j]= sb.toString();
		}
		return result;

	}	
	
	public WordCount[] count(String[] result){
		int count = 0;
		String word= "";
		WordCount[] arr = new WordCount[10];
		int pos=0;
		for (int i = 0; i < result.length; i++) {
			word=result[i];
			if(word==null){
				continue;
				}
			for (int j = i; j < result.length; j++) {
				if(word.equals(result[j])){
					count++;
					result[j]=null;
				}
			}
			
			arr[pos] = new WordCount(word,count);
			pos++;
			word="";
			count=0;
		}
		
		return arr;
		
	}
	
	public WordCount[] sort(WordCount[] arr){
		WordCount temp;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				WordCount first = arr[i];
				WordCount second = arr[j];
				
				if(arr[i]==null||arr[j]==null){
					continue;
				}
				
				int comp = first.word.compareToIgnoreCase(second.word);
				if(comp>0)
				{
					temp = arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		return arr;
	}
	
}
