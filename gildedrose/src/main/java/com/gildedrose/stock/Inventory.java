package com.gildedrose.stock;

import com.gildedrose.Item;

public final class Inventory {

	private Inventory() {
		// NOP
	}

	public static StoredItem recognizeItem(Item item) {
		if (item.name.startsWith("Aged Brie")) {
			return new AgedBrie(item);
		}

		if (item.name.startsWith("Sulfuras")) {
			return new Sulfuras(item);
		}

		if (item.name.startsWith("Backstage passes")) {
			return new BackstagePass(item);
		}

		return new GeneralItem(item);
	}

}
