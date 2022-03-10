package com.gildedrose

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
    }

    fun increaseItemQuality(item: Item, amount: Int) {
        item.quality = item.quality + amount
    }

    fun decreaseSellInDate(item: Item, amount: Int) {
        item.sellIn = item.sellIn - amount
    }

    fun updateQuality() {
        for (i in items.indices) {

            if (!isDecreasingItem(items[i])) {

                if (items[i].quality > 0) {

                    if (items[i].name != "Sulfuras, Hand of Ragnaros" && items[i].name != "Conjured Mana Cake") {
                        decreaseItemQuality(items[i], 1)
                    }

                    if(items[i].name == "Conjured Mana Cake") {
                        decreaseItemQuality(items[i], 2)
                    }

                }
            } else {

                if (!isMaxQuality(items[i].quality)) {
                    increaseItemQuality(items[i], 1)
                    if (items[i].name == "Backstage passes to a TAFKAL80ETC concert") {
                        if (items[i].sellIn < 11 && !isMaxQuality(items[i].quality)) {
                                increaseItemQuality(items[i], 1)
                        }
                        if (items[i].sellIn < 6 && !isMaxQuality(items[i].quality)) {
                            increaseItemQuality(items[i], 1)
                        }
                    }
                }
            }


            if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                decreaseSellInDate(items[i], 1)
            }

            if (isExpired(items[i].sellIn)) {
                if (!isDecreasingItem(items[0])) {
                    if (items[i].name != "Backstage passes to a TAFKAL80ETC concert") {
                        if (items[i].quality > 0 && items[i].name != "Sulfuras, Hand of Ragnaros") {
                                decreaseItemQuality(items[i], 1)
                        }
                    } else {
                        decreaseItemQuality(items[i], items[i].quality)
                    }
                } else {
                    if (!isMaxQuality(items[i].quality)) {
                        increaseItemQuality(items[i], 1)
                    }
                }
            }
        }
    }

}

