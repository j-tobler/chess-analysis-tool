package GameBoard;
import GameBoard.Pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private Square[][] squares;
    private CapturePool[] capturePools;
    private List<Piece> pieces;

    public Board() {
        // initialise squares
        squares = new Square[64][64];
        for (int i = 0; i < 64; i++) {
            for (int j = 0; j < 64; j++) {
                Square.Colour colour = i % 2 == j % 2 ? Square.Colour.black : Square.Colour.white;
                squares[i][j] = new Square(new Coordinate(i, j), this, colour);
            }
        }
        // initialise capture pools
        capturePools = new CapturePool[2];
        capturePools[0] = new CapturePool(); // white's capture pool
        capturePools[1] = new CapturePool(); // black's capture pool
        // initialise pieces
        pieces = new ArrayList<>();
    }

    public Square getSquareAt(Coordinate coordinate) {
        return squares[coordinate.getFile()][coordinate.getRank()];
    }
}
