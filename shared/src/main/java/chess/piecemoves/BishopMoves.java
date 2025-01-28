package chess.piecemoves;

import chess.ChessBoard;
import chess.ChessPosition;

public class BishopMoves extends PieceMovesFar {
    public BishopMoves(ChessBoard gameBoard, ChessPosition startPosition) {
        super(gameBoard, startPosition);
        calculateMoves();
    }

    @Override
    public void calculateMoves() {
        checkLine(-1, -1);
        checkLine(1, 1);
        checkLine(1, -1);
        checkLine(-1, 1);
    }
}
