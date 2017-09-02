package com.gildedrose.stock;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.gildedrose.Item;

public class AgedBrieTest {

	@Test
	public void qualityIncreasesOverTime() {
		Item item = new Item("Aged Brie", 10, 0);
		AgedBrie brie = new AgedBrie(item);

		brie.updateQuality();

		assertThat(item.quality, is(1));
	}


	@Test
	public void qualityIsNeverMoreThan50() {
		Item item = new Item("Aged Brie", 10, 50);
		AgedBrie brie = new AgedBrie(item);

		brie.updateQuality();

		assertThat(item.quality, is(50));
	}
}
