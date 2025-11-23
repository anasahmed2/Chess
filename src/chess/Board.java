package chess;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private Piece[][] grid;

    public Board() {
        grid = new Piece[8][8]
    }

    public Piece getPieceAt(Position pos) {
        if (!pos.isValid) {
            return null;
        }

        return grid[pos.row][pos.col];
    }




}