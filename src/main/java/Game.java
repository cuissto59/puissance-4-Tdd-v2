import java.util.Optional;

public class Game {

    private final Grid grid;
    private final Analyzer analyzer;
    private final Vue vue;
    private final Arbitre arbitre;


    public Game(Grid grid, Analyzer analyzer, Vue vue, Arbitre arbitre) {
        this.grid = grid;
        this.analyzer = analyzer;
        this.vue = vue;
        this.arbitre = arbitre;
    }

    public void run(){


        arbitre.init();
        while(true) {
            vue.write();
            int column = vue.read();
            grid.addToken(column, arbitre.getCurrentPlayer());
            Optional<Character> winner = analyzer.getWinner();
            boolean gameRunning = arbitre.switchPlayer();
            if(gameRunning==false || winner.isPresent()){
                break;
            }

        }
        vue.write();
        grid.emptyGrid();


    }
}
