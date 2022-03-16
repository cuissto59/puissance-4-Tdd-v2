import java.util.Optional;

public class Analyzer {

    private final Grid grid;

    public Analyzer(Grid grid) {
        this.grid = grid;
    }

    public Optional<Character> getWinner(){

        if (grid.getRows().contains("RRRR") ||
                grid.getColumns().contains("RRRR") ||
                grid.getDiag().contains("RRRR"))
            return Optional.of('R');

        if (grid.getRows().contains("BBBB") ||
                grid.getColumns().contains("BBBB") ||
                grid.getDiag().contains("BBBB"))
            return Optional.of('B');

        return Optional.empty();
    }
}
