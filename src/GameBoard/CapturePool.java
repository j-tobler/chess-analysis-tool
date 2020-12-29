package GameBoard;

import GameBoard.Pieces.Piece;
import java.util.ArrayList;
import java.util.List;

public class CapturePool {

    private List<Piece> pieces;

    public CapturePool() {
        pieces = new ArrayList<>();
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public void addPiece(Piece piece) {
        pieces.add(piece);
    }

    public void clearPool() {
        pieces.clear();
    }
}
