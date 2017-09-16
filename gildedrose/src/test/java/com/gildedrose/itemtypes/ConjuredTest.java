package com.gildedrose.itemtypes;

import static org.junit.Assert.assertThat;

import org.hamcrest.core.Is;
import org.junit.Test;

import com.gildedrose.Item;

public final class ConjuredTest {

	@Test
	public void qualityDegradesTwiceAsFast() throws Exception {
		Item item = new Item("Conjured", 1, 2);
		Conjured conjured = new Conjured(item);

		conjured.updateQuality();
		assertThat(item.quality, Is.is(0));
	}

	@Test
	public void qualityIsNeverBelowZero() throws Exception {
		Item item = new Item("Conjured", 1, 1);
		Conjured conjured = new Conjured(item);

		conjured.updateQuality();
		assertThat(item.quality, Is.is(0));

		conjured.updateQuality();
		assertThat(item.quality, Is.is(0));
	}
}
