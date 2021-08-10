package com.github.elizalex.tracker;

/*
 * Определяет работу класса по получению данных от пользователя.
 * Используется  в данном проекте при реализации паттерна Strategy.
 */
public interface Input {
    String askStr(String question);

    int askInt(String question);
}
