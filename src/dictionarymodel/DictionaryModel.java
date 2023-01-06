package dictionarymodel;

import bktree.BKTree;
import bktree.LavenshteinDistance;
import java.util.List;
import java.util.ArrayList;
import java.util.TreeMap;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Comparator;

public class DictionaryModel {

	private BKTree<DictionaryEntry> model;
	private List<DictionaryEntry> elements;

	public DictionaryModel() {
		var map = new TreeMap<String, DictionaryEntry>();

		try (InputStream in = getClass().getResourceAsStream("/res/dictionary.tsv")) {
			var reader = new BufferedReader(new InputStreamReader(in));
			String line = null;

			while ((line = reader.readLine()) != null) {
				String[] values = line.split("\t");
				if (values.length != 4) {
					continue;
				}

				String word = values[0];
				PartsOfSpeech partOfSpeech = null;
				switch (values[1]) {
					case "n" ->
						partOfSpeech = PartsOfSpeech.NOUN;
					case "v" ->
						partOfSpeech = PartsOfSpeech.VERB;
					case "a" ->
						partOfSpeech = PartsOfSpeech.ADJECTIVE;
					case "r" ->
						partOfSpeech = PartsOfSpeech.ADVERB;
				}
				int entryNumber = Integer.parseInt(values[2]);
				String definition = values[3];

				DictionarySingleEntry entry = new DictionarySingleEntry(entryNumber, partOfSpeech, definition);
				map.compute(word, (key, value) -> {
					value = value == null ? new DictionaryEntry(word) : value;
					value.addEntry(entry);
					return value;
				});
			}
		} catch (IOException x) {
			System.err.println(x);
		}

		if (map.size() <= 0) {
			return;
		}

		elements = new ArrayList<DictionaryEntry>(map.values());
		var prevEntry = elements.get(0);
		for (int i = 1; i < elements.size(); ++i) {
			var entry = elements.get(i);
			entry.prev = prevEntry;
			prevEntry.next = entry;

			prevEntry = entry;
		}

		var temp = new ArrayList<DictionaryEntry>(elements);
		temp.sort(new Comparator<>() {
			public int compare(DictionaryEntry t, DictionaryEntry t1) {
				return t1.word.length() - t.word.length();
			}
		});
		model = new BKTree<>(temp.get(0));
		temp.subList(1, temp.size()).forEach((entry) -> {
			model.insert(entry);
		});
	}

	public int getSize() {
		return elements.size();
	}

	public DictionaryEntry getElementAt(int i) {
		return elements.get(i);
	}

	public List<DictionaryEntry> getElements() {
		return elements;
	}

	public BKTree<DictionaryEntry> getModel() {
		return model;
	}

	public List<DictionaryEntry> search(LavenshteinDistance lavenshteinDistance) {
		if (model == null) {
			return null;
		}
		int tol = lavenshteinDistance.toString().length() / 2;

		var result = model.search(lavenshteinDistance, tol);
		if (result.isEmpty()) {
			return null;
		}

		return result;
	}

	public List<DictionaryEntry> search(String word) {
		return search(new LavenshteinDistance(word));
	}
}
