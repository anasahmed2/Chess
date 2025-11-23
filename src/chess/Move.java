package chess;

public class Move {

    public final Position from;
    public final Position to;

    public Move(Position from, Position to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Move)) return false;
        Move m = (Move)o;
        return from.equals(m.from) && to.equals(m.to);
    }

    @Override
    public int hashCode() {
        return from.hashCode()*31 + to.hashCode();
    }

    @Override
    public String toString() {
        return from.toString() + "->" + to.toString();
    }
}