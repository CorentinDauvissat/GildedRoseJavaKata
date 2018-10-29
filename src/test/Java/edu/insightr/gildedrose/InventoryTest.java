package edu.insightr.gildedrose;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    Item[] list = new Item[]{
            new Item("+5 Dexterity Vest", 10, 20),
            new Item("Aged Brie", 2, 0),
            new Item("Elixir of the Mongoose", 5, 7),
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Conjured Mana Cake", 3, 6)
    };

    @org.junit.jupiter.api.Test
    void updateQuality() {
        int expectedQualVest = 19; //-1
        int expectedQualBrie = 1; //+1
        int expectedQualElixir = 6; //-1
        int expectedQualSulfuras = 80; //unchanged
        int expectedQualBackstage = 21; //+1
        int expectedQualConjured = 4; //-2


        Inventory test = new Inventory(list);
        test.updateQuality();

        //assertEquals(2, agedBrie.getQuality());
        //assertThat(agedBrie.getQuality(), equalTo (1));

        assertEquals(expectedQualVest, list[0].getQuality());
        assertEquals(expectedQualBrie, list[1].getQuality());
        assertEquals(expectedQualElixir, list[2].getQuality());
        assertEquals(expectedQualSulfuras, list[3].getQuality());
        assertEquals(expectedQualBackstage, list[4].getQuality());
        assertEquals(expectedQualConjured, list[5].getQuality());
    }


    @org.junit.jupiter.api.Test
    void QualityNotNegative(){
        Item[] listNotNegative = new Item[]{
                new Item("+5 Dexterity Vest", 10, 0),
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 5, 0),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 0),
                new Item("Conjured Mana Cake", 3, 0)
        };

        int expectedQual0Vest = 0;
        int expectedQual0Brie = 0;
        int expectedQual0Elixir = 0;
        int expectedQual0Backstage = 0;
        int expectedQual0Conjured = 0;


        Inventory test = new Inventory(list);
        test.updateQuality();

        assertEquals(expectedQual0Vest, listNotNegative[0].getQuality());
        assertEquals(expectedQual0Brie, listNotNegative[1].getQuality());
        assertEquals(expectedQual0Elixir, listNotNegative[2].getQuality());
        assertEquals(expectedQual0Backstage, listNotNegative[4].getQuality());
        assertEquals(expectedQual0Conjured, listNotNegative[5].getQuality());
    }
}