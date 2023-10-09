package Game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {
    @Test
    void victoryOfTheFirstPlayer() {
        Player nikolay = new Player(1, "Nikolay", 100);
        Player alex = new Player(2, "Alex", 200);
        Game game = new Game();

        game.register(nikolay);
        game.register(alex);

        int actual = game.round("Alex", "Nikolay");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void victoryOfTheSecondPlayer() {
        Player nikolay = new Player(1, "Nikolay", 200);
        Player alex = new Player(2, "Alex", 100);
        Game game = new Game();

        game.register(nikolay);
        game.register(alex);

        int actual = game.round("Alex", "Nikolay");
        int expected = 2;
        Assertions.assertEquals(expected, actual);


    }

    @Test
    void victoryOfTheDrawlayer() {
        Player nikolay = new Player(1, "Nikolay", 100);
        Player alex = new Player(2, "Alex", 100);
        Game game = new Game();

        game.register(nikolay);
        game.register(alex);

        int actual = game.round("Nikolay", "Alex");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void firstPlayerNotFound() {
        Player nikolay = new Player(1, "Nikolay", 100);
        Player alex = new Player(2, "Alex", 100);
        Game game = new Game();

        game.register(nikolay);
        game.register(alex);


        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Мария", "Alex")
        );
    }

    @Test
    void SecondPlayerNotFound() {
        Player nikolay = new Player(1, "Nikolay", 100);
        Player alex = new Player(2, "Alex", 100);
        Game game = new Game();

        game.register(nikolay);
        game.register(alex);


        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Nikolay", "Alexandr")
        );
    }
}