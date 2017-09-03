package com.gildedrose.itemtypes;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.gildedrose.Item;

public class StoreTest {

	@Test
	public void wrapsGenericItems() {
		Item item = new Item("General Item", 1, 2);
		StoredItem stored = Store.wrap(item);

		assertThat(stored, instanceOf(Generic.class));
	}

	@Test
	public void wrapsAgedBrie() {
		Item item = new Item("Aged Brie", 1, 2);
		StoredItem stored = Store.wrap(item);

		assertThat(stored, instanceOf(AgedBrie.class));
	}

	@Test
	public void wrapsSulfuras() {
		Item item = new Item("Sulfuras, Ragnarok", 1, 2);
		StoredItem stored = Store.wrap(item);

		assertThat(stored, instanceOf(Sulfuras.class));
	}

	@Test
	public void wrapsBackstagePasses() {
		Item item = new Item("Backstage passes to ...", 1, 2);
		StoredItem stored = Store.wrap(item);

		assertThat(stored, instanceOf(BackstagePass.class));
	}

	@Test
	public void wrapsConjured() {
		Item item = new Item("Conjured...", 1, 2);
		StoredItem stored = Store.wrap(item);

		assertThat(stored, instanceOf(Conjured.class));
	}
}
