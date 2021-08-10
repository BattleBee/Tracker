package com.github.elizalex.tracker;

public interface UserAction {

    String name();

    boolean execute(Input input, Store store);
}
