package dictionarymodel;

import java.util.Map;
import java.util.TreeMap;

public class DictionaryEntry implements Comparable<String> {

	public String word;
	public Map<Integer, DictionarySingleEntry> entries;
	public DictionaryEntry next, prev;

	public DictionaryEntry(String word) {
		this.word = word;
		this.entries = new TreeMap();
		next = null;
		prev = null;
	}

	public void addEntry(DictionarySingleEntry entry) {
		entries.put(entry.entryNumber, entry);
	}

	@Override
	public String toString() {
		return word;
	}

	@Override
	public int compareTo(String t) {
		return word.compareTo(t);
	}

}
