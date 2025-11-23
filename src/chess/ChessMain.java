package chess;

import java.util.List;

public class ChessMain {
    public static void main(String[] args) {
        Game game = new Game();
        System.out.println("Intial Board:");
        game.getBoard().printBoard()
    }
}