package com.example.testingtesting123

import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class UniqueCollectionTest {

    lateinit var collection: UniqueCollection

    @Before
    fun setUp() {
        collection = UniqueCollection()
    }

    @Test
    fun addAnItem() {
        collection.addItem(Item("Item1"))
        val item = collection.get(0)
        assert(item.name == "Item1")
    }

    @Test
    fun addUniqueItem() {
        collection.addItem(Item("Item1"))
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        assert (collection.size() == 2)
    }
    @Test
    fun getItem() {
        val originalItem = Item("Item1")
        collection.addItem(originalItem)
        val item = collection.get(0)
        assert(originalItem == item) { "Item fetched from collection does not match original item. Expected: ${originalItem.name}, Actual: ${item.name}" }
    }

    @Test
    fun removeSpecificItem(){
        collection.addItem(Item("item1"))
        collection.addItem(Item("item2"))

        collection.remove(Item("item1"))
        assertEquals(1, collection.size())
        //assertEquals("item2", collection.get(0).name)

    }

    @Test
    fun clearAllItems() {
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        val originalSize = collection.size()
        collection.clear()
        val newSize = collection.size();

        assert(originalSize == 2 && newSize == 0) {"Items not cleared"}
    }
}