package dictionarymodel;

import java.lang.Iterable;
import java.util.TreeSet;
import java.util.Comparator;

public class DictionaryEntry {

	public String word;
	public Iterable<DictionarySingleEntry> entries;

	public DictionaryEntry(String word) {
		this.word = word;
		this.entries = new TreeSet(new Comparator<DictionarySingleEntry>() {
			@Override
			public int compare(DictionarySingleEntry t, DictionarySingleEntry t1) {
				return t.entryNumber - t1.entryNumber;
			}

		});
	}

	public void addEntry(DictionarySingleEntry entry) {
		((TreeSet) entries).add(entry);
	}

	@Override
	public String toString() {
		return word;
	}

}
