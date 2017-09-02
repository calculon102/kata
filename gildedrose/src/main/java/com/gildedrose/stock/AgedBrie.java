package com.gildedrose.stock;

import com.gildedrose.Item;

final class AgedBrie extends AbstractStoreItem {

	public AgedBrie(Item item) {
		super(item);
	}

	@Override
	protected int getQualityModifier() {
		if (item.quality >= 50) {
			return 0;
		}

		return 1;
	}
}
