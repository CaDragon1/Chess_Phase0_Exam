package chess;

import java.util.Arrays;
import java.util.Objects;

/**
 * A chessboard that can hold and rearrange chess pieces.
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessBoard {

    private ChessPiece[][] gameBoard;

    public ChessBoard() {
        gameBoard = new ChessPiece[8][8];
        
    }

    /**
     * Adds a chess piece to the chessboard
     *
     * @param position where to add the piece to
     * @param piece    the piece to add
     */
    public void addPiece(ChessPosition position, ChessPiece piece) {
        gameBoard[position.getRow()-1][position.getColumn()-1] = piece;
    }

    /**
     * Gets a chess piece on the chessboard
     *
     * @param position The position to get the piece from
     * @return Either the piece at the position, or null if no piece is at that
     * position
     */
    public ChessPiece getPiece(ChessPosition position) {
        return gameBoard[position.getRow()-1][position.getColumn()-1];
    }

    /**
     * Sets the board to the default starting board
     * (How the game of chess normally starts)
     */
    public void resetBoard() {
        for (int row = 1; row <= 8; row++) {
            switch (row) {
                case 1, 8:
                    setBackRow(row);
                    break;
                case 2, 7:
                    setPawnRow(row);
                    break;
                default:
                    setNullRow(row);
            }
        }
    }


    public ChessGame.TeamColor resetCheckTeam(int row) {
        if (row == 1 || row == 2) {
            System.out.println("WHITE TEAM IN ROW " + row);
            return ChessGame.TeamColor.WHITE;
        }
        else if (row == 7 || row == 8) {
            System.out.println("BLACK TEAM IN ROW " + row);
            return ChessGame.TeamColor.BLACK;
        }
        else {
            System.out.println("NO TEAM IN ROW " + row);
            return null;
        }
    }

    public void setNullRow(int row) {
        ChessPosition setPosition;
        for (int i = 1; i <= 8; i++) {
            System.out.print("(" + row + ", " + i + ") null  ");
            setPosition = new ChessPosition(row, i);
            addPiece(setPosition, null);
        }
        System.out.println();
    }

    public void setPawnRow(int row) {
        ChessGame.TeamColor team = resetCheckTeam(row);
        ChessPosition setPosition;
        for (int i = 1; i <= 8; i++){
            System.out.print("(" + row + ", " + i + ") " + team.toString() + " Pawn  ");
            setPosition = new ChessPosition(row, i);
            addPiece(setPosition, new ChessPiece(team, ChessPiece.PieceType.PAWN));
        }
        System.out.println();
    }

    public void setBackRow(int row) {
        ChessGame.TeamColor team = resetCheckTeam(row);
        ChessPosition setPosition;
        ChessPiece setPiece;
        for (int col = 1; col <= 8; col++) {
            System.out.print("(" + row + ", " + col + ") " + team.toString());
            setPosition = new ChessPosition(row, col);
            switch (col) {
                case 1, 8:
                    setPiece = new ChessPiece(team, ChessPiece.PieceType.ROOK);
                    System.out.print(" Rook  ");
                    break;
                case 2, 7:
                    setPiece = new ChessPiece(team, ChessPiece.PieceType.KNIGHT);
                    System.out.print(" KNIGHT  ");
                    break;
                case 3,6:
                    setPiece = new ChessPiece(team, ChessPiece.PieceType.BISHOP);
                    System.out.print(" BISHOP  ");
                    break;
                case 4:
                    setPiece = new ChessPiece(team, ChessPiece.PieceType.QUEEN);
                    System.out.print(" QUEEN  ");
                    break;
                case 5:
                    setPiece = new ChessPiece(team, ChessPiece.PieceType.KING);
                    System.out.print(" KING  ");
                    break;
                default:
                    setPiece = null;
            }
            System.out.println();
            addPiece(setPosition, setPiece);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ChessBoard that)) {
            return false;
        }
        return Objects.deepEquals(gameBoard, that.gameBoard);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(gameBoard);
    }
}

