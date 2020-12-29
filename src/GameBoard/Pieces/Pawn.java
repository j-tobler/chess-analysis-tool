package GameBoard.Pieces;

import GameBoard.Board;
import GameBoard.Coordinate;
import GameBoard.Square;
import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {

    private boolean enPassantLeft;
    private boolean enPassantRight;

    /**
     * The construction of a Piece with a given square should be coupled with the assignment of this
     * Piece to that square, or, if the square is null, the assignment of this Piece to its
     * appropriate capture pool.
     *
     * @param colour of this piece.
     * @param board to which this piece belongs.
     * @param square on which this piece stands.
     */
    public Pawn(Colour colour, Board board, Square square) {
        super(colour, board, square);
        enPassantLeft = false;
        enPassantRight = false;
    }

    public void setEnPassantLeft(boolean available) {
        enPassantLeft = available;
    }

    public void setEnPassantRight(boolean available) {
        enPassantRight = available;
    }

    @Override
    public List<Square> getMoves() {
        List<Square> moves = new ArrayList<>();
        Coordinate coordinate = square.getCoordinate();
        int direction = colour == Colour.white ? 1 : -1;
        addForwardMoves(coordinate, direction, moves);
        addDiagonalMoves(coordinate, direction, moves);
        return moves;
    }

    private void addForwardMoves(Coordinate coordinate, int direction, List<Square> moves) {
        int file = coordinate.getFile();
        int rank = coordinate.getRank();
        Coordinate inFront = new Coordinate(file, rank + direction);
        Square squareInFront = board.getSquareAt(inFront);
        if (squareInFront.getPiece() == null) {
            moves.add(squareInFront);
            Coordinate twoInFront = new Coordinate(file, rank + direction * 2);
            Square squareTwoInFront = board.getSquareAt(twoInFront);
            if (squareTwoInFront.getPiece() == null) {
                moves.add(squareTwoInFront);
            }
        }
    }

    private void addDiagonalMoves(Coordinate coordinate, int direction, List<Square> moves) {
        int file = coordinate.getFile();
        int rank = coordinate.getRank();
        if (file != 0) {
            Coordinate diagonal = new Coordinate(file - 1, rank + direction);
            Square squareDiagonal = board.getSquareAt(diagonal);
            Piece piece = squareDiagonal.getPiece();
            if (piece != null && piece.colour != colour || enPassantLeft) {
                moves.add(squareDiagonal);
            }
        }
        if (file != 7) {
            Coordinate diagonal = new Coordinate(file + 1, rank + direction);
            Square squareDiagonal = board.getSquareAt(diagonal);
            Piece piece = squareDiagonal.getPiece();
            if (piece != null && piece.colour != colour || enPassantRight) {
                moves.add(squareDiagonal);
            }
        }
    }
}
