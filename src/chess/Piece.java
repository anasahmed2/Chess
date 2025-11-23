package chess;

import java.util.List;

public abstract class Piece {

    protected Color color;
    protected Position position;
    protected Boolean hasMoved = false;

    public Piece(Color colo) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position p) {
        this.position = p;
    }

    public boolean hasMoved() {
        return hasMoved;
    }

    public void setHasMoved(Boolean v) {
        hasMoved = v;
    }

    public abstract List<Move> getPotentialMoves(Board board);

    public abstract Piece copy();

    public abstract char getSymbol();


}