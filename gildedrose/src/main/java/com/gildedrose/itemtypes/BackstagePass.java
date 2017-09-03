package com.gildedrose.itemtypes;

import com.gildedrose.Item;

final class BackstagePass extends AbstractStoreItem {

	public BackstagePass(Item item) {
		super(item);
	}

	@Override
	protected int getQualityModifier() {
		if (item.sellIn < 0) {
			return -item.quality;
		}

		if (item.sellIn <= 5) {
			return 3;
		}

		if (item.sellIn <= 10) {
			return 2;
		}

		return 1;
	}

}
