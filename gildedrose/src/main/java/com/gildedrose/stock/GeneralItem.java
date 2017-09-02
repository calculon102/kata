package com.gildedrose.stock;

import com.gildedrose.Item;

/**
 * Wrapper around the Item assuring quality-boundaries through accessor-methods.
 * @author calculon102
 */
final class GeneralItem extends AbstractStoreItem {

	public GeneralItem(Item item) {
		super(item);
	}

	@Override
	protected int getQualityModifier() {
		if (item.quality <= 0) {
			return 0;
		}

		return item.sellIn < 0 && item.quality > 1 ? -2 : -1;
	}
}
