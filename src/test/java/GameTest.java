import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Game game = new Game();

    //Объявляем данные игроков
    Player player1 = new Player(11, "Misha", 100);
    Player player2 = new Player(22, "Sasha", 85);
    Player player3 = new Player(33, "Anna", 90);
    Player player4 = new Player(5, "Max", 95);
    Player player5 = new Player(1, "Artem", 100);

    //играют зарегистрированные player1 и player2
    @Test
    public void testRegisteredPlayersGame() {
        game.register(player1);
        game.register(player2);

        //ожидаем что первый зарегистрированный участник выйграет по "strength"
        int expected = 1;
        int actual = game.round(player1.getName(), player2.getName()); //запускаем метод "round" и указываем участников в нём

        Assertions.assertEquals(expected, actual);
    }

    //играют зарегистрированные player3 и player4
    @Test
    public void testRegisteredPlayersGameTwo() {
        game.register(player3);
        game.register(player4);

        //ожидаем что второй зарегистрированный участник выйграет по "strength"
        int expected = 2;
        int actual = game.round(player3.getName(), player4.getName()); //запускаем метод "round" и указываем участников в нём

        Assertions.assertEquals(expected, actual);
    }

    //играют зарегистрированные player1 и player5
    @Test
    public void testRegisteredPlayersGameEquals() {
        game.register(player1);
        game.register(player5);

        //их "strength" равны, ожидаем значение "0"
        int expected = 0;
        int actual = game.round(player1.getName(), player5.getName()); //запускаем метод "round" и указываем участников в нём

        Assertions.assertEquals(expected, actual);
    }

    //регистрируются player5 и player4, но играют player5 и player1(не зарегистрированный)
    @Test
    public void testNotRegisteredPlayerTwo() {
        game.register(player5);
        game.register(player4);

        //должно сработать исключение, т.к. участвует не зарегистрированный участник (player1)
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player5.getName(), player1.getName());
        });
    }

    //регистрируются player5 и player4, но играют player1(не зарегистрированный) и player4
    @Test
    public void testNotRegisteredPlayerOne() {
        game.register(player5);
        game.register(player4);

        //должно сработать исключение, т.к. участвует не зарегистрированный участник (player1)
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player1.getName(), player4.getName());
        });
    }
}
