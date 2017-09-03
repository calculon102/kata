package com.gildedrose.itemtypes;

import com.gildedrose.Item;

public class Conjured extends AbstractStoreItem {

	public Conjured(Item item) {
		super(item);
	}

	@Override
	protected int getQualityModifier() {
		if (item.quality <= 0) {
			return 0;
		}

		if (item.quality == 1) {
			return -1;
		}

		return -2;
	}

}
