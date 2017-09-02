package com.gildedrose.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.gildedrose.Item;

/**
 * Super-Quick'n'Dirty CSV-Parser für Items. Nur für den Golden-Master-Test! :)
 *
 * - Zeilen werden per Zeilenumbruch getrennt
 * - Spalten werden mit Semikolon getrennt
 * - Je Zeile drei Spalten!
 * - Erste Spalte ist eine beliebige Zeichenkette
 * - Zweite und dritte Spalte sind Integer
 * - Leerzeilen und Zeilen beginnen mit einer Raute # werden ignoriert.
 * @author FrGr
 */
public final class ParsedCsv {
	private final Path csvFile;


	 /**
	  * Super-Quick'n'Dirty CSV-Parser für Items.
	  * @param resourceName Name der CSV-Datei.
	  * @param location Klasse aus deren Lokation der Pfad zur Datei ermittelt wird.
	  * @throws URISyntaxException
	  */
	public ParsedCsv(String resourceName, Class<?> location) throws URISyntaxException {
		csvFile = Paths.get(location.getResource(resourceName).toURI());
	}


	public Item[] asItems()
			throws IOException, URISyntaxException {

		List<String> lines = Files.readAllLines(csvFile);

		List<Item> result = new ArrayList<>(lines.size());

		for (String line : lines) {
			String trimmedLine = line.trim();
			if (trimmedLine.isEmpty() || trimmedLine.startsWith("#")) {
				continue;
			}

			String[] parts = trimmedLine.split(";");
			if (parts.length != 3) {
				throw new IllegalArgumentException("Illegal content line in " + csvFile + ": " + line);
			}

			String name = parts[0];
			Integer sellIn = Integer.valueOf(parts[1].trim());
			Integer quality = Integer.valueOf(parts[2].trim());
			result.add(new Item(name, sellIn, quality));
		}

		return result.toArray(new Item[0]);
	}
}
