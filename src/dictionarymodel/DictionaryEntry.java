package dictionarymodel;

import java.util.Map;
import java.util.TreeMap;

public class DictionaryEntry {

	public String word;
	public Map<Integer, DictionarySingleEntry> entries;

	public DictionaryEntry(String word) {
		this.word = word;
		this.entries = new TreeMap();
	}

	public void addEntry(DictionarySingleEntry entry) {
		entries.put(entry.entryNumber, entry);
	}

	@Override
	public String toString() {
		return word;
	}

}
