package dictionarymodel;

import bktree.BKTree;
import bktree.LavenshteinDistance;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class DictionaryModel {

	private BKTree<DictionaryEntry> model;

	public DictionaryModel() {
		model = null;
	}

	public void init() {
		try (InputStream in = getClass().getResourceAsStream("/dictionarymodel/dictionary.tsv")) {
			var reader = new BufferedReader(new InputStreamReader(in));
			String line = null;
			DictionaryEntry prevEntry = null;

			while ((line = reader.readLine()) != null) {
				String[] values = line.split("\t");
				if (values.length != 4) {
					continue;
				}

				String word = values[0];
				PartsOfSpeech pos = null;
				switch (values[1]) {
					case "n" ->
						pos = PartsOfSpeech.NOUN;
					case "v" ->
						pos = PartsOfSpeech.VERB;
					case "a" ->
						pos = PartsOfSpeech.ADJECTIVE;
					case "r" ->
						pos = PartsOfSpeech.ADVERB;
				}
				int entryNumber = Integer.parseInt(values[2]);
				String definition = values[3];

				DictionarySingleEntry entry = new DictionarySingleEntry(entryNumber, pos, definition);
				if (prevEntry != null && prevEntry.word.equals(word)) {
					prevEntry.addEntry(entry);
				} else {
					prevEntry = new DictionaryEntry(word);
					prevEntry.addEntry(entry);

					if (model == null) {
						model = new BKTree(entry);
					} else {
						model.insert(prevEntry);
					}
				}
			}
		} catch (IOException x) {
			System.err.println(x);
		}
	}

	public BKTree<DictionaryEntry> getModel() {
		return model;
	}

	public List<DictionaryEntry> search(String word) {
		if (model == null) {
			return null;
		}
		int tol = word.length() / 2;

		var result = model.search(word, tol);
		if (result.isEmpty()) {
			return null;
		}

		var head = result.get(0);
		if (LavenshteinDistance.getDistance(word, head) == 0) {
			ArrayList<DictionaryEntry> tmp;
			tmp = new ArrayList();
			tmp.add(head);
			return tmp;
		}

		return result;
	}
}