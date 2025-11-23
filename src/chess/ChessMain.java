package chess;

import java.util.List;

public class ChessMain {
    public static void main(String[] args) {
        Game game = new Game();
        System.out.println("Intial Board:");
        game.getBoard().printBoard();

        Move m1 = new Move(new Position(6, 4), new Position(4, 4));
        boolean ok1 = game.makeMove(m1);
        System.out.println("Move e2->e4: " + ok1);
        game.getBoard().printBoard();

        // Move black pawn e7 to e5
        Move m2 = new Move(new Position(1, 4), new Position(3, 4));
        boolean ok2 = game.makeMove(m2);
        System.out.println("Move e7->e5: " + ok2);
        game.getBoard().printBoard();

        // Try illegal move: white knight from g1 to g4 (illegal)
        Move m3 = new Move(new Position(7, 6), new Position(4, 6));
        boolean ok3 = game.makeMove(m3);
        System.out.println("Move g1->g4 (illegal): " + ok3);

        // Show legal moves for white knight at g1
        List<Move> legal = game.getLegalMovesForPosition(new Position(7, 6));
        System.out.println("Legal moves for piece at g1:");
        for (Move mv : legal) System.out.println(mv);
    }
}