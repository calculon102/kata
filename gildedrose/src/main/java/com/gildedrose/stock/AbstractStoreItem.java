package com.gildedrose.stock;

import static java.util.Objects.requireNonNull;

import com.gildedrose.Item;

abstract class AbstractStoreItem implements StoredItem {

	protected final Item item;

	public AbstractStoreItem(Item item) {
		this.item = requireNonNull(item, "item");
	}

	protected abstract int getQualityModifier();

	@Override
	public final void updateQuality() {
		item.quality += getQualityModifier();
	}

	@Override
	public void updateSellIn() {
		item.sellIn -= 1;
	}
}