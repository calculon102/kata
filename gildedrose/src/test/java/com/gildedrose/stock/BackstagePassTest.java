package com.gildedrose.stock;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.gildedrose.Item;

public class BackstagePassTest {


	@Test
	public void qualityIncreasesByOneWithMoreThan10DaysToSell() {
		Item item = new Item("Backstage Pass", 11, 0);
		BackstagePass pass = new BackstagePass(item);

		pass.updateQuality();

		assertThat(item.quality, is(1));
	}

	@Test
	public void qualityIncreasesByTwoWith10OrLessDaysToSell() {
		Item item = new Item("Backstage Pass", 10, 0);
		BackstagePass pass = new BackstagePass(item);

		pass.updateQuality();

		assertThat(item.quality, is(2));
	}

	@Test
	public void qualityIncreasesByThreeWith5OrLessDaysToSell() {
		Item item = new Item("Backstage Pass", 5, 0);
		BackstagePass pass = new BackstagePass(item);

		pass.updateQuality();

		assertThat(item.quality, is(3));
	}

	@Test
	public void qualityDropsToZeroAfterConcert() {
		Item item = new Item("Backstage Pass", -1, 50);
		BackstagePass pass = new BackstagePass(item);

		pass.updateQuality();

		assertThat(item.quality, is(0));
	}
}
