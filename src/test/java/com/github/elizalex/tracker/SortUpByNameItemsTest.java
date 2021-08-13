package com.github.elizalex.tracker;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class SortUpByNameItemsTest {

    @Test
    public void compare() {
        Item item1 = new Item("Vasya");
        Item item2 = new Item("Petya");
        Item item3 = new Item("Olya");
        List<Item> input = Arrays.asList(item1, item2, item3);
        input.sort(new SortUpByNameItems());
        assertEquals(input.get(0).getName(), "Olya");
        assertEquals(input.get(1).getName(), "Petya");
        assertEquals(input.get(2).getName(), "Vasya");
    }
}
