import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.Silent.class)
public class GameTest {

    @Mock
    private Grid grid;
    @Mock
    private Arbitre arbitre;
    @Mock
    private Analyzer analyzer;
    @InjectMocks
    private Game game;
    @Mock
    private Vue vue;

    @Test
    public void WhenGameIsNotRepeated(){

        doNothing().when(arbitre).init();
        doNothing().when(vue).write();
        when(vue.read()).thenReturn(1);
        doNothing().when(grid).addToken(1, 'R');
        when(arbitre.getCurrentPlayer()).thenReturn('R');
        when(analyzer.getWinner()).thenReturn(Optional.of('R'));
        when(arbitre.switchPlayer()).thenReturn(true);
        doNothing().when(grid).emptyGrid();

        game.run();

        InOrder inOrder = inOrder(vue,grid, analyzer,arbitre);
        inOrder.verify(arbitre).init();
        inOrder.verify(vue).write();
        inOrder.verify(vue).read();
        inOrder.verify(grid).addToken(1,'R');
        inOrder.verify(analyzer).getWinner();
        inOrder.verify(arbitre).switchPlayer();
        inOrder.verify(vue).write();
        inOrder.verify(grid).emptyGrid();

    }

    @Test
    public void WhenGameIsRepeatedOneTime(){

        doNothing().when(arbitre).init();
        doNothing().when(vue).write();
        when(vue.read()).thenReturn(1);
        doNothing().when(grid).addToken(1, 'R');
        doNothing().when(grid).addToken(1, 'B');
        when(arbitre.getCurrentPlayer()).thenReturn('R').thenReturn('B');
        when(analyzer.getWinner()).thenReturn(Optional.empty()).thenReturn(Optional.of('R'));
        when(arbitre.switchPlayer()).thenReturn(true);
        doNothing().when(grid).emptyGrid();

        game.run();

        InOrder inOrder = inOrder(vue,grid, analyzer,arbitre);
        inOrder.verify(arbitre).init();
        inOrder.verify(vue).write();
        inOrder.verify(vue).read();
        inOrder.verify(grid).addToken(1,'R');
        inOrder.verify(analyzer).getWinner();
        inOrder.verify(arbitre).switchPlayer();
        inOrder.verify(vue).write();
        inOrder.verify(vue).read();
        inOrder.verify(grid).addToken(1,'B');
        inOrder.verify(analyzer).getWinner();
        inOrder.verify(arbitre).switchPlayer();
        inOrder.verify(vue).write();
        inOrder.verify(grid).emptyGrid();

    }

//    @Test
//    public void WhenGameIsEndWithDraw(){
//
//        doNothing().when(arbitre).init();
//        doNothing().when(vue).write();
//        when(vue.read()).thenReturn(1);
//        doNothing().when(grid).addToken(1, 'R');
//        doNothing().when(grid).addToken(1, 'B');
//        when(arbitre.getCurrentPlayer()).thenReturn('R').thenReturn('B');
//        when(analyzer.getWinner()).thenReturn(Optional.empty()).thenReturn(Optional.of('R'));
//        when(grid.isFull()).thenReturn(true);
//        when(arbitre.switchPlayer()).thenReturn(true);
//        doNothing().when(grid).emptyGrid();
//
//        game.run();
//
//        InOrder inOrder = inOrder(vue,grid, analyzer,arbitre);
//        inOrder.verify(arbitre).init();
//        inOrder.verify(vue).write();
//        inOrder.verify(vue).read();
//        inOrder.verify(grid).addToken(1,'R');
//        inOrder.verify(analyzer).getWinner();
//        inOrder.verify(arbitre).switchPlayer();
//        inOrder.verify(vue).write();
//        inOrder.verify(vue).read();
//        inOrder.verify(grid).addToken(1,'B');
//        inOrder.verify(analyzer).getWinner();
//        inOrder.verify(arbitre).switchPlayer();
//        inOrder.verify(vue).write();
//        inOrder.verify(grid).emptyGrid();
//
//    }



}
