import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players = new ArrayList<>();

    //метод регистрации участника
    public void register(Player player) {
        players.add(player);
    }

    //метод соревнования участников (если не зарегистрированны выкидывается исключение "NotRegisteredException")
    public int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;
        for (Player player : players) {
            if (player.getName().equals(playerName1)) {
                player1 = player;
            }
            if (player.getName().equals(playerName2)) {
                player2 = player;
            }
        }
        if (player1 == null) {
            throw new NotRegisteredException("Игрок не зарегистрирован");
        }
        if (player2 == null) {
            throw new NotRegisteredException("Игрок не зарегистрирован");
        }
        if (player1.getStrength() == player2.getStrength()) {
            return 0; //если силы игроков равны возвращаем "0"
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1; //если первый участник сильнее возвращаем "1"
        }
        return 2; //иначе возвращаем "2" (т.е. если второй участник сильнее)
    }
}
