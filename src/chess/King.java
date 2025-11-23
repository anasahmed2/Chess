package chess;

import java.util.ArrayList;
import java.util.List;

public class King extends Peice {

    public King(Color color) {
        super(color);
    }

    @override
    public List<Move> getPotentialMoves(Board board) {
        List<Move> res = new ArrayList<>();
        int[] dr = {-1,-1,-1,0,0,1,1,1};
        int[] dc = {-1,0,1,-1,1,-1,0,1};
        for (int i=0;i<8;i++){
            Position to = new Position(position.row+dr[i], position.col+dc[i]);
            if (!to.isValid()) continue;
            Piece p = board.getPieceAt(to);
            if (p == null || p.getColor() != color) res.add(new Move(position,to));
        }
        return res;
    }

    @override
    public Piece copy() {
        King k = new King(color);
        k.setHasMoved(hasMoved);
        return k;
    }

    @override
    public char getSymbol() {
        if (color == Color.WHITE) {
            return 'K';
        } else {
            return 'k';
        }
    }
}