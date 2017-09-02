package com.gildedrose.stock;

import static org.hamcrest.core.IsInstanceOf.instanceOf;

import org.junit.Assert;
import org.junit.Test;

import com.gildedrose.Item;

public class InventoryTest {

	@Test
	public void shouldStoreGeneralItems() {
		Item item = new Item("General Item", 1, 2);
		StoredItem stored = Inventory.recognizeItem(item);

		Assert.assertThat(stored, instanceOf(GeneralItem.class));
	}

	@Test
	public void shouldRecognizeAgedBrie() {
		Item item = new Item("Aged Brie", 1, 2);
		StoredItem stored = Inventory.recognizeItem(item);

		Assert.assertThat(stored, instanceOf(AgedBrie.class));
	}

	@Test
	public void shouldRecognizeSulfuras() {
		Item item = new Item("Sulfuras, Ragnarok", 1, 2);
		StoredItem stored = Inventory.recognizeItem(item);

		Assert.assertThat(stored, instanceOf(Sulfuras.class));
	}

	@Test
	public void shouldRecognizeBackstagePasses() {
		Item item = new Item("Backstage passes to ...", 1, 2);
		StoredItem stored = Inventory.recognizeItem(item);

		Assert.assertThat(stored, instanceOf(BackstagePass.class));
	}
}
