package com.github.elizalex.tracker;

import java.util.ArrayList;
import java.util.List;

public class MemTracker implements Store {

    private List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return List.copyOf(items);
    }

    public List<Item> findByName(String key) {
        List<Item> itemsWithName = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                itemsWithName.add(item);
            }
        }
        return itemsWithName;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public boolean replace(int id, Item item) {
        int i = indexOf(id);
        if (i != -1) {
            item.setId(id);
            items.set(i, item);
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        int i = indexOf(id);
        if (i != -1) {
            items.remove(i);
            return true;
        }
        return false;
    }

    @Override
    public void init() {
        // Этот класс не будет подключаться к базе данных.
    }

    @Override
    public void close() {
        // Этот класс не будет подключаться к базе данных.
    }
}

