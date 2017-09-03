package com.gildedrose.itemtypes;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.gildedrose.Item;
import com.gildedrose.itemtypes.Generic;
import com.gildedrose.itemtypes.StoredItem;

public class GenericTest {

	@Test
	public void qualityDecreasesByOneWithPositiveSellin() {
		Item item = new Item("Test Item", 10, 10);

		StoredItem stockItem = new Generic(item);
		stockItem.updateQuality();

		assertThat(item.quality, is(9));
	}

	@Test
	public void qualityNeverDecreasesBelowZero() {
		Item item = new Item("Test Item", 10, 0);

		StoredItem stockItem = new Generic(item);
		stockItem.updateQuality();

		assertThat(item.quality, is(0));
	}

	@Test
	public void qualityNeverDecreasesBelowZeroWithNegativeSellIn() {
		Item item = new Item("Test Item", -1, 1);

		StoredItem stockItem = new Generic(item);
		stockItem.updateQuality();

		assertThat(item.quality, is(0));
	}

	@Test
	public void qualityDecreasesTwiceAsFastWithNegativeSellIn() {
		Item item = new Item("Test Item", -1, 2);

		StoredItem stockItem = new Generic(item);
		stockItem.updateQuality();

		assertThat(item.quality, is(0));
	}

	@Test
	public void sellInDecreasesByOne() {
		Item item = new Item("Test Item", 1, 0);

		StoredItem stockItem = new Generic(item);
		stockItem.updateSellIn();

		assertThat(item.sellIn, is(0));
	}
}
