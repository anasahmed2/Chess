package chess;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {
    public Bishop(Color color) {
        super(color);
    }

    @Override
    public List<Move> getPotentialMoves(Board board) {
        List<Move> res = new ArrayList<>();
        int[] dr = {-1,-1,1,1};
        int[] dc = {-1,1,-1,1};
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
        Bishop b = new Bishop(color);
        b.setHasMoved(hasMoved); return b;
    }

    @Override
    public char getSymbol() {
        return color==Color.WHITE? 'B':'b';
    }
}