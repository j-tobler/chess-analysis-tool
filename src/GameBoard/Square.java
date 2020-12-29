package GameBoard;

import GameBoard.Pieces.Piece;

public class Square {

    private Coordinate coordinate;
    private Board board;
    private Colour colour;
    private Piece piece;

    public Square(Coordinate coordinate, Board board, Colour colour) {
        this.coordinate = coordinate;
        this.colour = colour;
        this.board = board;
        this.piece = null;
    }

    public enum Colour {
        white,
        black,
        blue;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Colour getColour() {
        return colour;
    }

    public Piece getPiece() {
        return piece;
    }
}
