package com.gildedrose.itemtypes;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.gildedrose.Item;

public class SulfurasTest {

	@Test
	public void neverLosesQuality() {
		Item item = new Item("Sulfuras", 1, 1);
		Sulfuras sulfuras = new Sulfuras(item);

		sulfuras.updateQuality();

		assertThat(item.quality, is(1));
	}

	@Test
	public void neverNeedsToBeSold() {
		Item item = new Item("Sulfuras", 1, 1);
		Sulfuras sulfuras = new Sulfuras(item);

		sulfuras.updateSellIn();

		assertThat(item.sellIn, is(1));
	}
}
