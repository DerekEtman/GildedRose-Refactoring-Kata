package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class GildedRoseTest {

    @Nested
    inner class initTest {
        @Test
        fun foo() {
            val items = arrayOf<Item>(Item("foo", 0, 0))
            val app = GildedRose(items)
            app.updateQuality()
            assertEquals("foo", app.items[0].name)

        }
    }
    @Nested
    inner class updateItemQuality {
        @Test
        fun `Normal items are reduced by 1`() {
            val items = arrayOf<Item>(Item("Elixir of the Mongoose", 5, 7),)
            val app = GildedRose(items)
            app.updateQuality()
            assertEquals(6, app.items[0].quality)
        }

        @Test
        fun `Conjured Items are reduced x2`() {
            val items = arrayOf(Item("Conjured Mana Cake", 1, 6))
            val app = GildedRose(items)
            app.updateQuality()
            assertEquals(4, app.items[0].quality)
        }

        @Test
        fun `increase quality of backstage passes`() {
            val items = arrayOf( Item("Backstage passes to a TAFKAL80ETC concert", 10, 49))
            val app = GildedRose(items)
            app.updateQuality()
            assertEquals(50, items[0].quality)
        }
    }


    @Nested
    inner class updateItemSellIn {
        @Test
        fun ` decrease Sell In Date Test`() {
            val items = arrayOf( Item("Backstage passes to a TAFKAL80ETC concert", 10, 49))
            val app = GildedRose(items)
            app.updateQuality()
            assertEquals(9, items[0].sellIn)
        }
    }
}


