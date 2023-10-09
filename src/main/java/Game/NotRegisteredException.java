package Game;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String playerName) {

        super("Игрок с номером" + playerName + "не найден!");
    }
}

