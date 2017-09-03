package com.gildedrose.itemtypes;

import com.gildedrose.Item;

public final class Store {

	private Store() {
		// NOP
	}

	public static StoredItem wrap(Item item) {
		if (item.name.startsWith("Aged Brie")) {
			return new AgedBrie(item);
		}

		if (item.name.startsWith("Sulfuras")) {
			return new Sulfuras(item);
		}

		if (item.name.startsWith("Backstage passes")) {
			return new BackstagePass(item);
		}

		if (item.name.startsWith("Conjured")) {
			return new Conjured(item);
		}

		return new Generic(item);
	}

}
