package com.gildedrose;

import java.util.LinkedList;
import java.util.List;

import com.gildedrose.itemtypes.Store;
import com.gildedrose.itemtypes.StoredItem;

class GildedRose {
    private final List<StoredItem> storedItems = new LinkedList<>();

    public GildedRose(Item[] items) {
        for (Item item : items) {
        	storedItems.add(Store.wrap(item));
		}
    }

    public void updateQuality() {
    	storedItems.forEach(i -> {
    		i.updateQuality();
    		i.updateSellIn();
    	});
    }
}