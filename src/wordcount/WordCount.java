package wordcount;

public class WordCount {
	int count;
	String word;
	
	public WordCount(String word,int count) {
		// TODO Auto-generated constructor stub
		this.count = count;
		this.word = word;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		return word+"->"+count;
	}
}
