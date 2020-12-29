package GameBoard.Pieces;
import GameBoard.Board;
import GameBoard.Coordinate;
import GameBoard.Square;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {

    Colour colour;
    Square square;
    Board board;

    /**
     * The construction of a Piece with a given square should be coupled with the assignment of this
     * Piece to that square, or, if the square is null, the assignment of this Piece to its
     * appropriate capture pool.
     *
     * @param colour of this piece.
     * @param board to which this piece belongs.
     * @param square on which this piece stands.
     */
    public Piece(Colour colour, Board board, Square square) {
        this.colour = colour;
        this.square = square;
        this.board = board;
    }

    public enum Colour {
        white,
        black;
    }

    public Colour getColour() {
        return colour;
    }

    public Square getSquare() {
        return square;
    }

    public abstract List<Square> getMoves();

    List<Square> searchPath(int file, int rank) {
        List<Square> path = new ArrayList<>();
        Coordinate coordinate = square.getCoordinate();
        while ((coordinate = coordinate.sum(file, rank)) != null) {
            Square square = board.getSquareAt(coordinate);
            Piece piece = square.getPiece();
            if (piece != null) {
                if (piece.colour != colour) {
                    path.add(square);
                }
                break;
            }
            path.add(square);
        }
        return path;
    }
}
