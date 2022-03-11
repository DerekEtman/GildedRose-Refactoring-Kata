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
        items.forEach {  item ->

            if(item.name == "Backstage passes to a TAFKAL80ETC concert" && isExpired(item.sellIn)){
                println("here" + item.quality)
                return decreaseItemQuality(item, item.quality)
            }

            if (!isDecreasingItem(item)) {

                if (item.quality > 0) {

                    if (item.name != "Sulfuras, Hand of Ragnaros" && item.name != "Conjured Mana Cake") {
                        decreaseItemQuality(item, 1)
                    }

                    if(item.name == "Conjured Mana Cake") {
                        decreaseItemQuality(item, 2)
                    }

                }
            } else {
                if (!isMaxQuality(item.quality)) {
                    increaseItemQuality(item, 1)

                    if (item.name == "Backstage passes to a TAFKAL80ETC concert") {

                        if ( item.sellIn < 11 && !isMaxQuality(item.quality)) {
                                increaseItemQuality(item, 1)
                        }

                        if ( item.sellIn < 6 && !isMaxQuality(item.quality)) {
                            increaseItemQuality(item, 1)
                        }

                    }

                }

            }

//


            if (item.name != "Sulfuras, Hand of Ragnaros") {
                decreaseSellInDate(item, 1)
            }

            if (isExpired(item.sellIn)) {

                if (!isDecreasingItem(items[0])) {

                    if (item.name != "Backstage passes to a TAFKAL80ETC concert") {
                        if (item.quality > 0 && item.name != "Sulfuras, Hand of Ragnaros") {
                                decreaseItemQuality(item, 1)
                        }
                    }
//                    else {
//                        println("here")
//                        decreaseItemQuality(item, item.quality)
//                    }
                } else {
                    if (!isMaxQuality(item.quality)) {
                        increaseItemQuality(item, 1)
                    }
                }
            }
        }
    }

}

