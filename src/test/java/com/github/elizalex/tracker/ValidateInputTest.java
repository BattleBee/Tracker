package com.github.elizalex.tracker;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import static org.hamcrest.Matchers.is;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"one", "1"}
        );
        ValidateInput input = new ValidateInput(in, out);
        int selected = input.askInt("Select:");
        MatcherAssert.assertThat(selected, is(1));
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"1"}
        );
        ValidateInput input = new ValidateInput(in, out);
        int selected = input.askInt("Select:");
        MatcherAssert.assertThat(selected, is(1));
    }

    @Test
    public void whenDoubleValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"1", "1"}
        );
        ValidateInput input = new ValidateInput(in, out);
        int selected = input.askInt("Select:");
        MatcherAssert.assertThat(selected, is(1));
    }

    @Test
    public void whenInvalidInputMinus1() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"-1"}
        );
        ValidateInput input = new ValidateInput(in, out);
        int selected = input.askInt("Select:");
        MatcherAssert.assertThat(selected, is(-1));
    }
}