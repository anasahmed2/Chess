package chess;

public class Position {

    public final int row;
    public final int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public boolean isValid() {
        return row>=0 && row<8 && col>=0 && col<8;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Position)) return false;
        Position p = (Position)o;
        return p.row == row && p.col == col;
    }

    @Override
    public int hashCode() { return row*31 + col; }

    @Override
    public String toString() {
        char file = (char)('a' + col);
        int rank = 8 - row;
        return ""+file+rank;
    }
}