package com.gildedrose;

import java.util.LinkedList;
import java.util.List;

import com.gildedrose.stock.Inventory;
import com.gildedrose.stock.StoredItem;

class GildedRose {
    private final List<StoredItem> storedItems = new LinkedList<>();

    public GildedRose(Item[] items) {
        for (Item item : items) {
        	storedItems.add(Inventory.recognizeItem(item));
		}
    }

    public void updateQuality() {
    	storedItems.forEach(i -> {
    		i.updateQuality();
    		i.updateSellIn();
    	});
    }
}