import java.util.Optional;

public class Analyzer {

    private final Grid grid;

    public Analyzer(Grid grid) {
        this.grid = grid;
    }

    public Optional<Character> getWinner(){

        return Optional.of('R');
    }
}
