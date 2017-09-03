package com.gildedrose.itemtypes;

public interface StoredItem {

	/**
	 * Updates the quality of the item according to its current sellIn value.
	 */
	void updateQuality();

	/**
	 * Updates the sellIn-value of the item for one day.
	 */
	void updateSellIn();

}