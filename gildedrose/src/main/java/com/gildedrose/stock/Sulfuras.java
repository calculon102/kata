package com.gildedrose.stock;

import com.gildedrose.Item;

final class Sulfuras extends AbstractStoreItem {

	public Sulfuras(Item item) {
		super(item);
	}

	@Override
	protected int getQualityModifier() {
		return 0;
	}

	@Override
	public void updateSellIn() {
		return; // Nothing
	}
}
