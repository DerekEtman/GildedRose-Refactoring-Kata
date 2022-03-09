package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun isDecreasingItem(item: Item): Boolean {
        if(item.name != "Aged Brie" && item.name != "Backstage passes to a TAFKAL80ETC concert") {
            return false
        }
        return true
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

                if (items[i].quality < 50) {
                    increaseItemQuality(items[i], 1)
                    if (items[i].name == "Backstage passes to a TAFKAL80ETC concert") {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                increaseItemQuality(items[i], 1)
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                increaseItemQuality(items[i], 1)
                            }
                        }
                    }
                }
            }


            if (items[i].name != "Sulfuras, Hand of Ragnaros") {
//                items[i].sellIn = items[i].sellIn - 1
                decreaseSellInDate(items[i], 1)
            }

            if (items[i].sellIn < 0) {
                if (!isDecreasingItem(items[0])) {
                    if (items[i].name != "Backstage passes to a TAFKAL80ETC concert") {
                        if (items[i].quality > 0) {
                            if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                                decreaseItemQuality(items[i], 1)
                            }
                        }
                    } else {
                        decreaseItemQuality(items[i], items[i].quality)
                    }
                } else {
                    if (items[i].quality < 50) {
                        increaseItemQuality(items[i], 1)
                    }
                }
            }
        }
    }

}

