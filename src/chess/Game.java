package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Game {

    private Board board;
    private Color currentTurn;

    public Game() {
        board = new Board();
        board.setupInitial();
        currentTurn = Color.WHITE;
    }

    public Board getBoard() {
        return board;
    }

    public Color getCurrentTurn() {
        return currentTurn;
    }


}