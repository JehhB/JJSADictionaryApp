package jjsadictionaryapp;

import java.util.Scanner;
import bktree.LavenshteinDistance;
import dictionarymodel.DictionaryModel;

public class JJSADictionaryApp {

	public static void main(String[] args) {
		var in = new Scanner(System.in);
		var dictionary = new DictionaryModel();
		dictionary.init();

		System.out.print("Enter word to search: ");
		String word = in.nextLine();
		var searcher = new LavenshteinDistance(word);

		var result = dictionary.search(searcher);

		if (result == null) {
			System.out.printf("No result found for \"%s\"%n", word);
		} else if (searcher.getDistance(result.get(0).toString()) == 0) {
			var res = result.get(0);
			res.entries.forEach(entry -> {
				System.out.print(res.word + " ");
				switch (entry.partOfSpeech) {
					case NOUN ->
						System.out.print("n. ");
					case VERB ->
						System.out.print("v. ");
					case ADJECTIVE ->
						System.out.print("adj. ");
					case ADVERB ->
						System.out.print("adv. ");
				}

				System.out.printf("%d %s%n", entry.entryNumber, entry.definition);
			});
		} else {
			System.out.printf("No exact match for \"%s\"%n", word);
			System.out.println("Do you mean:");
			result.forEach(suggestion -> {
				System.out.println("  " + suggestion);
			});
		}
	}
}
