package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Game {

    private Board board;
    private Color currentTurn;

    public Game() {
        board = new Board();
        board.setupInitial();
        currentTurn = Color.WHITE;
    }

    public Board getBoard() {
        return board;
    }

    public Color getCurrentTurn() {
        return currentTurn;
    }

    public boolean makeMove(Move move) {
        Piece p = board.getPieceAt(move.from);
        if (p == null || p.getColor() != currentTurn) return false;

        List<Move> legal = getLegalMovesForPosition(move.from);
        for (Move m : legal) {
            if (m.equals(move)) {
                board.applyMove(m);
                currentTurn = (currentTurn == Color.WHITE) ? Color.BLACK : Color.WHITE;
                return true;
            }
        }
        return false;
    }

    public List<Move> getLegalMovesForPosition(Position pos) {
        Piece p = board.getPieceAt(pos);
        List<Move> res = new ArrayList<>();
        if (p == null) return res;
        if (p.getColor() != currentTurn) return res;

        List<Move> potential = p.getPotentialMoves(board);
        // filter out moves that would leave own king in check
        for (Move m : potential) {
            Board copy = board.copy();
            copy.applyMove(m);
            if (!copy.isInCheck(p.getColor())) res.add(m);
        }
        return res;
    }

    public List<Move> getAllLegalMoves(Color color) {
        List<Move> res = new ArrayList<>();
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                Position pos = new Position(r, c);
                Piece p = board.getPieceAt(pos);
                if (p != null && p.getColor() == color) {
                    res.addAll(getLegalMovesForPosition(pos));
                }
            }
        }
        return res;
    }

}