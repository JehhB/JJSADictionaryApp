package dictionarymodel;

public class DictionaryEntryWord implements Comparable<DictionaryEntryWord> {

	private String word;

	public DictionaryEntryWord(String word) {
		this.word = word;
	}

	@Override
	public String toString() {
		return word;

	}

	@Override
	public int compareTo(DictionaryEntryWord b) {
		if (word.length() == b.word.length()) {
			return word.compareTo(b.word);
		}
		return b.word.length() - word.length();
	}
}
