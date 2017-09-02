package com.gildedrose.stock;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.gildedrose.Item;

public class GeneralItemTest {

	@Test
	public void decreasedQualityByOneIfQualityAndSellinArePositive() {
		Item item = new Item("Test Item", 10, 10);

		StoredItem stockItem = new GeneralItem(item);
		stockItem.updateQuality();

		assertThat(item.quality, is(9));
	}

	@Test
	public void neverDecreasesQualityBelowZeroWithPositiveSellIn() {
		Item item = new Item("Test Item", 10, 0);

		StoredItem stockItem = new GeneralItem(item);
		stockItem.updateQuality();

		assertThat(item.quality, is(0));
	}

	@Test
	public void neverDecreasesQualityBelowZeroWithNegativeSellIn() {
		Item item = new Item("Test Item", -1, 1);

		StoredItem stockItem = new GeneralItem(item);
		stockItem.updateQuality();

		assertThat(item.quality, is(0));
	}

	@Test
	public void decreasesQualityTwiceAsFastWhenSellInDateHasPassed() {
		Item item = new Item("Test Item", -1, 2);

		StoredItem stockItem = new GeneralItem(item);
		stockItem.updateQuality();

		assertThat(item.quality, is(0));
	}

	@Test
	public void decreasesSellInByOneEachUpdate() {
		Item item = new Item("Test Item", 1, 0);

		StoredItem stockItem = new GeneralItem(item);
		stockItem.updateSellIn();

		assertThat(item.sellIn, is(0));
	}
}
