package dictionarymodel;

public class DictionarySingleEntry implements Comparable<DictionarySingleEntry> {

	public int entryNumber;
	public PartsOfSpeech partOfSpeech;
	public String definition;

	public DictionarySingleEntry(int entryNumber, PartsOfSpeech partOfSpeech, String definition) {
		this.entryNumber = entryNumber;
		this.partOfSpeech = partOfSpeech;
		this.definition = definition;
	}

	@Override
	public int compareTo(DictionarySingleEntry b) {
		return entryNumber - b.entryNumber;
	}
}
