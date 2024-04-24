package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        //assertEquals("fixme", app.items[0].name);
        assertEquals("foo", app.items[0].name);
    }

    ///Testing the Conjured Item degrade quality for each passing day
    ///The Quality should reduce by twice
    @Test
    void testConjQuality() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 3, 6) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].quality);
    }

    ///Testing the Conjured Item degrade quality on selling day
    ///The Quality should reduce by four times
    @Test
    void testConjQualOnSellIn() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 0, 6) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

    ///Testing the Conjured Item degrade quality after selling day is passed
    ///The Quality should reduce by four times
    @Test
    void testConjQualNegativeSellIn() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", -1, 6) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

    ///Testing the Conjured Item degrade quality after selling day is passed
    ///The Quality should not be negative
    @Test
    void testConjQualAfterSellIn() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", -1, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue(app.items[0].quality>-1);
    }

    ///Testing the item Aged brie quality
    ///The Quality should not decrease
    @Test
    void testItemAgedBrieQuality() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue(app.items[0].quality>1);
    }

    ///Testing the item Sulfaras quality
    ///The Quality should not decrease
    @Test
    void testItemSulfarasQuality() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertFalse(app.items[0].quality<80);
    }

    ///Testing the item Back Stage quality
    ///The Quality should increase by 2 for less than 11 days sell in
    @Test
    void testItemBackstageQualilty() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 44) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue(Objects.equals(app.items[0].quality, 46));
    }

    ///Testing the item Back Stage quality
    ///The Quality should increase by 3 for less than 6 days sell in
    @Test
    void testItemBackstageQul() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 44) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue(Objects.equals(app.items[0].quality, 47));
    }

    ///Testing the item Back Stage quality
    ///The Quality should increase more than 50
    @Test
    void testItemBackstage() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertFalse(app.items[0].quality>50);
    }
}
