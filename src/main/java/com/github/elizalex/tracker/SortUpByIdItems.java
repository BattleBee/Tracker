package com.github.elizalex.tracker;

import java.util.Comparator;

public class SortUpByIdItems implements Comparator<Item> {

    @Override
    public int compare(Item item1, Item item2) {
        return Integer.compare(item1.getId(), item2.getId());
    }
}
