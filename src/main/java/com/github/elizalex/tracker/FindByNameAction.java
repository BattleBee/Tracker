package com.github.elizalex.tracker;

import java.util.List;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by name";
    }

    @Override
    public boolean execute(Input input, Store store) {
        out.println("=== Find item by name ===");
        String name = input.askStr("Enter name: ");
        List<Item> items = store.findByName(name);
        if (items.isEmpty()) {
            out.println("Item with this name was not found.");
        } else {
            for (Item item : items) {
                out.println(item);
            }
        }
        return true;
    }
}

