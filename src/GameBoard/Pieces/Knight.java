package GameBoard.Pieces;

import GameBoard.Board;
import GameBoard.Coordinate;
import GameBoard.Square;
import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {

    /**
     * The construction of a Piece with a given square should be coupled with the assignment of this
     * Piece to that square, or, if the square is null, the assignment of this Piece to its
     * appropriate capture pool.
     *
     * @param colour of this piece.
     * @param board to which this piece belongs.
     * @param square on which this piece stands.
     */
    public Knight(Colour colour, Board board, Square square) {
        super(colour, board, square);
    }

    @Override
    public List<Square> getMoves() {
        List<Square> moves = new ArrayList<>();
        Coordinate coordinate = square.getCoordinate();
        int file = coordinate.getFile();
        int rank = coordinate.getRank();

        addIfValid(file - 1, rank - 2, moves);
        addIfValid(file - 1, rank + 2, moves);
        addIfValid(file - 2, rank - 1, moves);
        addIfValid(file - 2, rank + 1, moves);
        addIfValid(file + 1, rank - 2, moves);
        addIfValid(file + 1, rank + 2, moves);
        addIfValid(file + 2, rank - 1, moves);
        addIfValid(file + 2, rank + 1, moves);

        return moves;
    }

    private void addIfValid(int file, int rank, List<Square> moves) {
        Coordinate coordinate;
        try {
            coordinate = new Coordinate(file, rank);
        } catch (IllegalArgumentException e) {
            return;
        }

        Square square = board.getSquareAt(coordinate);
        Piece piece = square.getPiece();
        if (piece != null && piece.colour == colour) {
            return;
        }

        moves.add(square);
    }
}
