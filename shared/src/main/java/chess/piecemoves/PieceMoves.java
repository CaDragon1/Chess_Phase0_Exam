package chess.piecemoves;

import chess.ChessBoard;
import chess.ChessGame;
import chess.ChessMove;
import chess.ChessPosition;

import java.util.HashSet;

public abstract class PieceMoves {

    protected ChessBoard gameBoard;
    protected ChessPosition startPosition;
    protected HashSet<ChessMove> moveList;
    protected ChessGame.TeamColor team;

    public PieceMoves(ChessBoard gameBoard, ChessPosition startPosition) {
        this.gameBoard = gameBoard;
        this.startPosition = startPosition;
        team = gameBoard.getPiece(startPosition).getTeamColor();
        calculateMoves();
    }

    public void calculateMoves(){}

    public HashSet<ChessMove> getMoveList() {
        return moveList;
    }

    protected boolean isInBounds(int row, int col) {
        return row > 0 && col > 0 && row <= 8 && col <= 8;
    }

    protected boolean checkSpace(ChessPosition endPosition) {
        if (gameBoard.getPiece(endPosition) != null) {
            if (gameBoard.getPiece(endPosition).getTeamColor() != team) {
                moveList.add(new ChessMove(startPosition, endPosition));
            }
            return false;
        }
        else {
            moveList.add(new ChessMove(startPosition, endPosition));
            return true;
        }
    }
}
