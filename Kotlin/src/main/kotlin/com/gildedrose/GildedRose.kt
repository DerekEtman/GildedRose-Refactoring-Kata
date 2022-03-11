package com.gildedrose

//create public interface


class GildedRose(var items: Array<Item>) {

    fun isDecreasingItem(item: Item): Boolean {
        if(item.name != "Aged Brie" && item.name != "Backstage passes to a TAFKAL80ETC concert") {
            return false
        }
        return true
    }

    fun isMaxQuality(itemQuality: Int): Boolean {
        if(itemQuality < 50) {
            return false
        }
        return true
    }

    fun isExpired(sellDate: Int): Boolean {
        if(sellDate < 0){
            return true
        }
        return false
    }

    fun decreaseItemQuality(item: Item, amount: Int) {
        item.quality = item.quality - amount
        println("New Item Quality" + item.quality)
    }

    fun increaseItemQuality(item: Item, amount: Int) {
        item.quality = item.quality + amount
    }

    fun decreaseSellInDate(item: Item, amount: Int) {
        item.sellIn = item.sellIn - amount
    }

    fun updateQuality() {
        items = items.map { item -> baseUpdateItem(item) }.toTypedArray()
    }

}

