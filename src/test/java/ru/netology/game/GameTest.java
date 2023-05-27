package ru.netology.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    public void testWhenFirstPlayerWins() {
        Player andrey = new Player(1, "Андрей", 500);
        Player sasha = new Player(2, "Саша", 300);
        Game game = new Game();

        game.register(andrey);
        game.register(sasha);
        int actual = game.round("Андрей", "Саша");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenSecondPlayerWins() {
        Player andrey = new Player(1, "Андрей", 500);
        Player sasha = new Player(2, "Саша", 300);
        Game game = new Game();

        game.register(andrey);
        game.register(sasha);
        int actual = game.round("Саша", "Андрей");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenRoundDraw() {
        Player andrey = new Player(1, "Андрей", 500);
        Player sasha = new Player(2, "Саша", 500);
        Game game = new Game();

        game.register(andrey);
        game.register(sasha);
        int actual = game.round("Саша", "Андрей");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerNotExist() {
        Player andrey = new Player(1, "Андрей", 500);
        Player sasha = new Player(2, "Саша", 300);
        Game game = new Game();

        game.register(andrey);
        game.register(sasha);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Михаил", "Андрей")
        );

    }

    @Test
    public void testWhenSecondPlayerNotExist() {
        Player andrey = new Player(1, "Андрей", 500);
        Player sasha = new Player(2, "Саша", 300);
        Game game = new Game();

        game.register(andrey);
        game.register(sasha);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Андрей", "Михаил")
        );

    }

    @Test
    public void testWhenBothPlayersAreNotExists() {
        Player andrey = new Player(1, "Андрей", 500);
        Player sasha = new Player(2, "Саша", 300);
        Game game = new Game();

        game.register(andrey);
        game.register(sasha);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Иван", "Михаил")
        );

    }

}