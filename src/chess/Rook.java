package chess;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {
    public Rook(Color color) {
        super(color);
    }

    @Override
    public List<Move> getPotentialMoves(Board board) {
        List<Move> res = new ArrayList<>();
        int[] dr = {-1,0,0,1};
        int[] dc = {0,-1,1,0};
        for (int i=0;i<4;i++){
            int r = position.row + dr[i];
            int c = position.col + dc[i];
            while (true) {
                Position to = new Position(r,c);
                if (!to.isValid()) break;
                Piece p = board.getPieceAt(to);
                if (p == null) res.add(new Move(position,to));
                else { if (p.getColor()!=color) res.add(new Move(position,to)); break; }
                r += dr[i]; c += dc[i];
            }
        }
        return res;
    }

    @Override
    public Piece copy() {
        Rook r = new Rook(color);
        r.setHasMoved(hasMoved);
        return r;
    }

    @Override
    public char getSymbol() {
        return color==Color.WHITE? 'R':'r';
    }
}