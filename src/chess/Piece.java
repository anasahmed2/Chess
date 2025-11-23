package chess;

import java.util.List;

public abstract class Piece {

    protected Color color;
    protected Position position;
    protected Boolean hasMoved = false;

    public Piece(Color colo) {
        this.color = color;
    }


}