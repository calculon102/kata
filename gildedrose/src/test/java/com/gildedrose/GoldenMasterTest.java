package com.gildedrose;

import static java.lang.System.lineSeparator;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.gildedrose.util.ParsedCsv;

/*
+----------------------------------------------------------------------------------------------------+
|oooooooooooooooooooooooooooooooooooooooooooooooo+ooooooooooooooooooooooooooooooooooo+:oooooooooooooo|
|ooooooooo+ooooooooooooooooooooooooooooooooo+oooo::oooooooooooooooooooooooooooooo+::~:+oooooooooooooo|
|ooooooooo:~::oooooooooooooooooooooooooooooo~~++:~::++:+ooooooooooooooooooooo+::~..:ooooooooooooooooo|
|oooooooooo+~..::+ooooooooooooooooooooo+:....   ...   :~.::oooooooooooo++::::~...:ooooooooooooooooooo|
|oooooooooooo:....~:++oooooooooooooo:.. ....~~~~~.~~.~:~    ~:oooooo+:~~~~~.....:oooooooooooooooooooo|
|oooooooooooooo:....~::::++oooo+o+:     ..~~::::~~.~~~~  . .  .~+::~.~:.......:oooooooooooooooooooooo|
|ooooooooooooooo:+~.....~~~:::: .      ..~~~::::::~~~..... .        ..   . ..:ooooooooooooooooooooooo|
|ooooooooooooooooo+~..~...~~~:~. . .. .....~~~~~:~~~..~...         .  ..  ~:ooooooooooooooooooooooooo|
|ooooooooooooooooooo+:~~~..  .::. .  .  .......~~~... . .          . ...:+ooooooooooooooooooooooooooo|
|ooooooooooooooooooooo:::~~.   .~ .....~~~:~~~....... .      .~~.    .~:+oooooooooooooooooooooooooooo|
|oooooooooooooooooooooooo+::~. ~~ ....~.~:~:::~... . ..    .~:~.~.   .ooooooooooooooooooooooooooooooo|
|oooooooooooooooooooooooo+.~~~.   . .~~.. .~.:::~..~:~~~....~..  .  ~+ooooooooooooooooooooooooooooooo|
|oooooooooooooooooooooooo+~:~... .. .~:~~....  .~~:+:::::~:~.....~..ooooooooooooooooooooooooooooooooo|
|oooooooooooooooooooooooo+::::~ . ....~~:::~~:::::+::::::.~~::~::~.:oooooo+oooo+ooooooooooooooooooooo|
|ooooooooooooooooooooooooo++ooo~  ... .~~~::::::::::~~..~.~~::~~.. +ooo:....::~:::::::::+oooooooooooo|
|oooooooooooooooooooooooooooooo: .   ~~  ..~~~~:~~::::~~~~~~..  .. :++:~~~.~~:::::::~~~.~~.~::ooooooo|
|ooooooooooooooooo++:+oo:+oo+::~.    .~~.   . ~.~..........   ...   ~:~~:~:~::::::++::::~~~.. .~+oooo|
|oo+::ooooooo+o::~~... .~::.:.. . .   ..~~~.    . .  ~ .     ~~..   ~~~~...~~~::::::~~~~.....~.. ~+oo|
|+~~:~.~~::::.. . . ... ..~ ~~.     .    ..~~... . .  . .. .~.      ...~~:::+++++++++++:+::::~~..  :o|
|:.~~~. ~           .~~.~ ::.~~~ :~  .      ..~~.~.~. ~....~~~ .::~ :ooooooooooooooooooooooooooooo+:+|
|:.   ...:::::+:~   . ~oo:ooooo+:+:. .         .~~~~~......~:o:~oo+ ~oooooooooooooooooooooooooooooooo|
|oooooo+oooooooo+.~.~.:oooooo+o:..~.       .       . .... .~~~::ooo: :ooooooooooooooooooooooooooooooo|
|oooooooooooooooo~~~~~.~::~~~~~::~~:. ~.   .....          .~~:~~::+o:~+oooooooooooooooooooooooooooooo|
|oooooooooooooooo~..~~:. ~:::::~~~... ~:   .~::::~~~~.     .~:::~~.~:+ooooooooooooooooooooooooooooooo|
|oooooooooooooooo. ~.~:~.~~::::  .    .~     ~~~~~:~... :~ ..~....~..~.:ooooooooooooooooooooooooooooo|
|oooooooooooooooo: .~.~..  .~....~:         ..~...~~.   :o+:~~~. .~~.~..ooooooooooooooooooooooooooooo|
|ooooooooooooooooo~.     ..:+:ooooo+        .~....  ..   ~ooooo:... .. +ooooooooooooooooooooooooooooo|
|ooooooooooooooooooo:~:+o::ooooooooo:    .......    .      ooo+..::~. :oooooooooooooooooooooooooooooo|
|oooooooooooooooooooooooo:+oooooooooo~     . .   ...       ++o:.~:~~.:ooooooooooooooooooooooooooooooo|
|oooooooooooooooooooooooo:ooooooooooo           ..   ..    . ...:: .+oooooooooooooooooooooooooooooooo|
|oooooooooooooooooooooooo+oooooooooo+.           .         ...  ..:oooooooooooooooooooooooooooooooooo|
|oooooooooooooooooooooooooooooooooo~    .     . ...         . .  :ooooooooooooooooooooooooooooooooooo|
|ooooooooooooooooooooooooooooo:++:.           .~~:~           . :oooooooooooooooooooooooooooooooooooo|
|oooooooooooooooooooooooooo:.o::o.      . ...~.~~...            .oooooooooooooooooooooooooooooooooooo|
|oooooooooooooooooooooooo:::+~:.~~~.    .......~~..    .          +oooooooooooooooooooooooooooooooooo|
|oooooooooooooooooooooooo:~:++~~       ..~....  ~..  . . .....    .oooooooooooooooooooooooooooooooooo|
|ooooooooooooooooooooooo:~::~~~~.    .. .....   .     ..  .....    ~+oooooooooooooooooooooooooooooooo|
|oooooooooooooooooooooo+~o:.:~..     ..~...     .          .   .    .oooooooooooooooooooooooooooooooo|
|ooooooooooooooooooooooo::..~. . ...   ....     .            ..~::~.  ~+ooooooooooooooooooooooooooooo|
|ooooooooooooooooooooooo:... ..:::~~..  ..  .~~~            ~~~~::::  ..+oooooooooooooooooooooooooooo|
|oooooooooooooooooooooo:.:+~..::~. .  ..    .~.~.            ...~~~~. ++:oooooooooooooooooooooooooooo|
|ooooooooooooooooooooo::+o~ .....~~  :o:.   ....~ .      .++  ~.. .   .oooooooooooooooooooooooooooooo|
|ooooooooooooooooooooo:oo: ......~.  +o:: +. ..~....   :oooo .....~. . +ooooooooooooooooooooooooooooo|
|oooooooooooooooooooooooo: .... . .  :oo+.o:~ ..~.. ..:oooo+. ...~~~~. :ooooooooooooooooooooooooooooo|
|oooooooooooooooooooooooo~..~~~.~..  :ooo~o++~+:....::+oooo+...~~~~~.. :ooooooooooooooooooooooooooooo|
|oooooooooooooooooooooooo......~.   ~ooo+:o+o+o:... :o+ooooo: ....~~.. :ooooooooooooooooooooooooooooo|
|oooooooooooooooooooooooo: .......  +oooooooooo+:~  +ooooooo: ..~~~~.  .ooooooooooooooooooooooooooooo|
|oooooooooooooooooooooooo: .....    +ooooooooooo:  :oooooooo: ...~...  .ooooooooooooooooooooooooooooo|
|oooooooooooooooooooooooo. .......  +ooooooooooo: :ooooooooo+  .......  :oooooooooooooooooooooooooooo|
|oooooooooooooooooooooo:~ ...  . .. ~ooooooooooo: oooooooooo:  .  ...~....~:ooooooooooooooooooooooooo|
|ooooooooooooooooooo:..   . ...      +ooooooooooo~ooooooooo+      ...... .  ~:::::+oooooooooooooooooo|
|ooooooooooooooo+:::........ ..  .~:+ooooooooooooooooooooooo~...   .   .. ... .    ~ooooooooooooooooo|
|ooooooooooooo:.    .. ... .   .:oooooooooooooooooooooooooooooooo++::.   .      :~:+ooooooooooooooooo|
|ooooooooooooo:::..~  .     ~::oooooooooooooooooooooooooooooooooooooooo+oo+::+o++oooooooooooooooooooo|
|oooooooooooooooo+oo:+o::o++ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo|
+----------------------------------------------------------------------------------------------------+
 */

/**
 * Compares current implementation with output of the original state.
 * Does not include the new conjured-feature.
 * @author calculon102
 */
@RunWith(Parameterized.class)
public final class GoldenMasterTest {
	@Parameter(value = 0)
	public String itemCsv;

	@Parameter(value = 1)
	public int days;

	@Parameters(name="{0} for {1} days")
	public static Iterable<Object[]> createFixtures() {
		return Arrays.asList(new Object[][] {
			// More test-cases could be added.
			{ "original.csv", 2 },
		});
	}

	@Test
	public void compareOutputOfOriginalWithCurrentImplementation() throws IOException, URISyntaxException {
		Item[] items = new ParsedCsv(itemCsv, this.getClass()).asItems();

		GildedRose currentApp = new GildedRose(items);
		GildedRoseOriginal originalApp = new GildedRoseOriginal(items);

		StringBuilder currentOutput = new StringBuilder();
		StringBuilder originalOutput = new StringBuilder();

		for (int i = 0; i < days; i++) {
			String dayHeader = "-------- day " + i + " --------" + lineSeparator();
			currentOutput.append(dayHeader);
			originalOutput.append(dayHeader);

			String csvHeader = "name, sellIn, quality" + lineSeparator();
			currentOutput.append(csvHeader);
			originalOutput.append(csvHeader);

			for (Item item : items) {
				currentOutput.append(item).append(lineSeparator());
				originalOutput.append(item).append(lineSeparator());
			}
			currentOutput.append(lineSeparator());
			originalOutput.append(lineSeparator());

			currentApp.updateQuality();
			originalApp.updateQuality();
		}

		System.out.println("=== === === Output for " + itemCsv + " in " + days + " days. === === ===");
		System.out.println();
		System.out.println(currentOutput.toString());

		assertEquals(originalOutput.toString(), currentOutput.toString());
	}


}
