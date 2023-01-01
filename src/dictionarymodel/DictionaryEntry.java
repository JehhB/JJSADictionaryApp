package dictionarymodel;

import java.util.List;
import java.util.ArrayList;

public class DictionaryEntry {
	public String word;
	public List<DictionarySingleEntry> entries;

	public DictionaryEntry(String word) {
		this.word = word;
		this.entries = new ArrayList();
	}

	public void addEntry(DictionarySingleEntry entry) {
		entries.add(entry);
	}

	@Override
	public String toString() {
		return word;
	}

}
