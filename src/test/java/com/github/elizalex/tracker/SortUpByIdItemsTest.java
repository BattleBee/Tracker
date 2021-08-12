package com.github.elizalex.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class SortUpByIdItemsTest {

    @Test
    public void compare() {
        Item item1 = new Item(10, "Vasya");
        Item item2 = new Item(5, "Petya");
        Item item3 = new Item(3, "Olya");
        List<Item> input = Arrays.asList(item1, item2, item3);
        input.sort(new SortUpByIdItems());
        assertEquals(input.get(0).getId(), 3);
        assertEquals(input.get(1).getId(), 5);
        assertEquals(input.get(2).getId(), 10);
    }
}