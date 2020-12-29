package GameBoard;
import java.util.Map;

public class Coordinate {

    private final int file;
    private final int rank;
    private Map<Integer, Character> fileChars = Map.of(
            0, 'a',
            1, 'b',
            2, 'c',
            3, 'd',
            4, 'e',
            5, 'f',
            6, 'g',
            7, 'h');

    public Coordinate(int file, int rank) {
        if (!isValidDimension(file) || !isValidDimension(rank)) {
            throw new IllegalArgumentException();
        }
        this.file = file;
        this.rank = rank;
    }

    public int getFile() {
        return file;
    }

    public int getRank() {
        return rank;
    }

    public Coordinate sum(int file, int rank) {
        try {
            return new Coordinate(this.file + file, this.rank + rank);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    private boolean isValidDimension(int dimension) {
        return dimension >= 0 && dimension <= 7;
    }

    @Override
    public String toString() {
        return String.format("%c%d", fileChars.get(file), rank);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Coordinate)) {
            return false;
        }
        Coordinate other = (Coordinate) obj;
        return file == other.file && rank == other.rank;
    }

    @Override
    public int hashCode() {
        return file * 8 + rank;
    }
}
