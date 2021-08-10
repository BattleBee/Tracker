package com.github.elizalex.tracker;

import java.util.Scanner;

/*
Реализует интерфейс Input и работает с классом Scanner.
Используется для разрыва зависимости класса StartUI от класса Scanner как внешнего ресурса.
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String askStr(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }
}