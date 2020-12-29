package GameBoard.Pieces;

import GameBoard.Board;
import GameBoard.Square;
import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {

    /**
     * The construction of a Piece with a given square should be coupled with the assignment of this
     * Piece to that square, or, if the square is null, the assignment of this Piece to its
     * appropriate capture pool.
     *
     * @param colour of this piece.
     * @param board to which this piece belongs.
     * @param square on which this piece stands.
     */
    public Rook(Colour colour, Board board, Square square) {
        super(colour, board, square);
    }

    @Override
    public List<Square> getMoves() {
        List<Square> moves = new ArrayList<>();
        moves.addAll(searchPath(-1, 0));
        moves.addAll(searchPath(1, 0));
        moves.addAll(searchPath(0, -1));
        moves.addAll(searchPath(0, 1));
        return moves;
    }
}
