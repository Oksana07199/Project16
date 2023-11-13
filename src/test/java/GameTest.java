import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.stats.Game;
import ru.netology.stats.NotRegisteredException;
import ru.netology.stats.Player;

public class GameTest {

    @Test
    public void testWhenSecondPlayerWin() {
        Player vasya = new Player(1, "Вася", 100);
        Player petya = new Player(2, "Петя", 120);
        Game game = new Game();

        game.register(vasya);
        game.register(petya);

        int actual = game.round("Вася", "Петя");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerWin() {
        Player vasya = new Player(1, "Вася", 130);
        Player petya = new Player(2, "Петя", 120);
        Game game = new Game();

        game.register(vasya);
        game.register(petya);

        int actual = game.round("Вася", "Петя");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenNoOneWins() {
        Player vasya = new Player(1, "Вася", 120);
        Player petya = new Player(2, "Петя", 120);
        Game game = new Game();

        game.register(vasya);
        game.register(petya);

        int actual = game.round("Вася", "Петя");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenSecondPlayerNotExist() {
        Player vasya = new Player(1, "Вася", 100);
        Player petya = new Player(2, "Петя", 120);
        Game game = new Game();

        game.register(vasya);
        game.register(petya);


        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Петя", "Жора"));

    }

    @Test
    public void testWhenPlayerNotExist() {
        Player vasya = new Player(1, "Вася", 100);
        Player petya = new Player(2, "Петя", 120);
        Game game = new Game();

        game.register(vasya);
        game.register(petya);


        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Гена", "Жора"));

    }

}
