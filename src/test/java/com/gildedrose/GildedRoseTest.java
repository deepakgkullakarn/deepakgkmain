package com.gildedrose;

import org.junit.jupiter.api.Test;

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
}
