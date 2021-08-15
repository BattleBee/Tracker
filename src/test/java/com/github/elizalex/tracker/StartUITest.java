package com.github.elizalex.tracker;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;

public class StartUITest {

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"7", "0"}
        );
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, memTracker, actions);
        String ln = System.lineSeparator();
        MatcherAssert.assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Exit Program" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu:" + ln
                        + "0. Exit Program" + ln
                        + "=== Exit Program ===" + ln
                )
        );
    }

    @Test
    public void whenFindAll() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = List.of(
                new FindAllAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(in, memTracker, actions);
        MatcherAssert.assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator()
                        + "0. Show all Items" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
                        + "=== Show all items ===" + System.lineSeparator()
                        + "Items list is empty." + System.lineSeparator()
                        + "Menu:" + System.lineSeparator()
                        + "0. Show all Items" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
                        + "=== Exit Program ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = List.of(
                new FindByIdAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(in, memTracker, actions);
        MatcherAssert.assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator()
                        + "0. Find item by id" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
                        + "=== Find item by id ===" + System.lineSeparator()
                        + "No item found with this id." + System.lineSeparator()
                        + "Menu:" + System.lineSeparator()
                        + "0. Find item by id" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
                        + "=== Exit Program ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByIdWithItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1", "1", "1", "2"}
        );
        MemTracker memTracker = new MemTracker();
        Item testItem = memTracker.add(new Item("test"));
        List<UserAction> actions = List.of(
                new FindByIdAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(in, memTracker, actions);
        MatcherAssert.assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator()
                        + "0. Find item by id" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
                        + "=== Find item by id ===" + System.lineSeparator()
                        + testItem + System.lineSeparator()
                        + "Menu:" + System.lineSeparator()
                        + "0. Find item by id" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
                        + "=== Exit Program ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "test", "1"}
        );
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = List.of(
                new FindByNameAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(in, memTracker, actions);
        MatcherAssert.assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator()
                        + "0. Find item by name" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
                        + "=== Find item by name ===" + System.lineSeparator()
                        + "Item with this name was not found." + System.lineSeparator()
                        + "Menu:" + System.lineSeparator()
                        + "0. Find item by name" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
                        + "=== Exit Program ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByNameWithItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "test", "1"}
        );
        MemTracker memTracker = new MemTracker();
        Item testItem = memTracker.add(new Item("test"));
        List<UserAction> actions = List.of(
                new FindByNameAction(out),
                new ExitAction(out)
        );
        new StartUI(out).init(in, memTracker, actions);
        MatcherAssert.assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator()
                        + "0. Find item by name" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
                        + "=== Find item by name ===" + System.lineSeparator()
                        + testItem + System.lineSeparator()
                        + "Menu:" + System.lineSeparator()
                        + "0. Find item by name" + System.lineSeparator()
                        + "1. Exit Program" + System.lineSeparator()
                        + "=== Exit Program ===" + System.lineSeparator()
        ));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        MemTracker memTracker = new MemTracker();
        List<UserAction> actions = List.of(
                new ExitAction(out)
        );
        new StartUI(out).init(in, memTracker, actions);
        MatcherAssert.assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator()
                        + "0. Exit Program" + System.lineSeparator()
                        + "=== Exit Program ===" + System.lineSeparator()
        ));
    }
}
