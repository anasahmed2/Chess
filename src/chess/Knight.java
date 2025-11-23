package chess;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {
    public Knight(Color color) {
        super(color);
    }

    @Override
    public List<Move> getPotentialMoves(Board board) {
        List<Move> res = new ArrayList<>();
        int[] dr = {-2,-2,-1,-1,1,1,2,2};
        int[] dc = {-1,1,-2,2,-2,2,-1,1};
        for (int i=0;i<8;i++){
            Position to = new Position(position.row+dr[i], position.col+dc[i]);
            if (!to.isValid()) continue;
            Piece p = board.getPieceAt(to);
            if (p == null || p.getColor() != color) res.add(new Move(position,to));
        }
        return res;
    }

    @Override
    public Piece copy() {
        Knight k = new Knight(color);
        k.setHasMoved(hasMoved);
        return k;
    }

    @Override
    public char getSymbol() {
        return color==Color.WHITE? 'N':'n';
    }
}
