package chess;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private Piece[][] grid;

    public Board() {
        grid = new Piece[8][8];
    }

    public Piece getPieceAt(Position pos) {
        if (!pos.isValid()) {
            return null;
        }

        return grid[pos.row][pos.col];
    }

    public void setPieceAt(Position pos, Piece p) {
        if (!pos.isValid()) return;
        grid[pos.row][pos.col] = p;
        if (p != null) p.setPosition(pos);
    }

    public void applyMove(Move move) {
        Piece p = getPieceAt(move.from);
        if (p == null) return;
        // simple capture handling
        setPieceAt(move.to, p);
        setPieceAt(move.from, null);
        p.setHasMoved(true);
    }

    public Board copy() {
        Board b = new Board();
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                Piece p = grid[r][c];
                if (p != null) b.setPieceAt(new Position(r, c), p.copy());
            }
        }
        return b;
    }

    public boolean isInCheck(Color color) {
        Position kingPos = findKing(color);
        if (kingPos == null) return false;
        Color opponent = (color == Color.WHITE) ? Color.BLACK : Color.WHITE;
        // if any opponent potential move can capture king
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                Piece p = grid[r][c];
                if (p != null && p.getColor() == opponent) {
                    List<Move> pot = p.getPotentialMoves(this);
                    for (Move m : pot) if (m.to.equals(kingPos)) return true;
                }
            }
        }
        return false;
    }

    private Position findKing(Color color) {
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                Piece p = grid[r][c];
                if (p instanceof King && p.getColor() == color) return new Position(r, c);
            }
        }
        return null;
    }

    public void setupInitial() {
        // set up pawns
        for (int c = 0; c < 8; c++) {
            setPieceAt(new Position(6, c), new Pawn(Color.WHITE));
            setPieceAt(new Position(1, c), new Pawn(Color.BLACK));
        }
        // rooks
        setPieceAt(new Position(7, 0), new Rook(Color.WHITE));
        setPieceAt(new Position(7, 7), new Rook(Color.WHITE));
        setPieceAt(new Position(0, 0), new Rook(Color.BLACK));
        setPieceAt(new Position(0, 7), new Rook(Color.BLACK));
        // knights
        setPieceAt(new Position(7, 1), new Knight(Color.WHITE));
        setPieceAt(new Position(7, 6), new Knight(Color.WHITE));
        setPieceAt(new Position(0, 1), new Knight(Color.BLACK));
        setPieceAt(new Position(0, 6), new Knight(Color.BLACK));
        // bishops
        setPieceAt(new Position(7, 2), new Bishop(Color.WHITE));
        setPieceAt(new Position(7, 5), new Bishop(Color.WHITE));
        setPieceAt(new Position(0, 2), new Bishop(Color.BLACK));
        setPieceAt(new Position(0, 5), new Bishop(Color.BLACK));
        // queens
        setPieceAt(new Position(7, 3), new Queen(Color.WHITE));
        setPieceAt(new Position(0, 3), new Queen(Color.BLACK));
        // kings
        setPieceAt(new Position(7, 4), new King(Color.WHITE));
        setPieceAt(new Position(0, 4), new King(Color.BLACK));
    }

    public void printBoard() {
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                Piece p = grid[r][c];
                System.out.print((p==null?" . ":""+p.getSymbol()+"") + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}