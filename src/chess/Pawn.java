package chess;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
    public Pawn(Color color) {
        super(color);
    }

    @Override
    public List<Move> getPotentialMoves(Board board) {
        List<Move> res = new ArrayList<>();
        int dir = (color == Color.WHITE) ? -1 : 1; // white moves up (decreasing row)
        // one forward
        Position one = new Position(position.row + dir, position.col);
        if (one.isValid() && board.getPieceAt(one) == null) res.add(new Move(position, one));
        // two forward
        Position two = new Position(position.row + 2*dir, position.col);
        Position startRow = (color == Color.WHITE) ? new Position(6, position.col) : new Position(1, position.col);
        if (!hasMoved && two.isValid() && board.getPieceAt(two) == null && board.getPieceAt(one) == null) res.add(new Move(position, two));
        // captures
        Position capL = new Position(position.row + dir, position.col -1);
        Position capR = new Position(position.row + dir, position.col +1);
        if (capL.isValid()) {
            Piece p = board.getPieceAt(capL);
            if (p != null && p.getColor() != color) res.add(new Move(position, capL));
        }
        if (capR.isValid()) {
            Piece p = board.getPieceAt(capR);
            if (p != null && p.getColor() != color) res.add(new Move(position, capR));
        }
        return res;
    }

    @Override
    public Piece copy() {
        Pawn p = new Pawn(color);
        p.setHasMoved(hasMoved);
        return p;
    }

    @Override
    public char getSymbol() {
        return color==Color.WHITE? 'P':'p';
    }
}
