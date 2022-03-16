import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;


@RunWith(MockitoJUnitRunner.class)
public class AnalyzerTest {

    @Mock
    private Grid grid;

    @InjectMocks
    Analyzer analyze;

    @Test
    public void ShouldReturnOptionalOfRWhenRWins(){

        //giving

        //when
        System.out.println(grid);
        when(grid.getRows()).thenReturn("-------\n-------\n-------\n-------\n-------\n-BBRRRR");
        when(grid.getColumns()).thenReturn("-------\n-------\n-------\n-------\n-------\n-BBRRRR");
        when(grid.getDiag()).thenReturn("-------\n-------\n-------\n-------\n-------\n-BBRRRR");

        Optional<Character> result = analyze.getWinner();

        //then
        assertEquals(Character.valueOf('R'),result.get());
    }

    @Test
    public void ShouldReturnOptionalOfBWhenRWins(){

        //giving

        //when
        System.out.println(grid);
        when(grid.getRows()).thenReturn("-------\n-------\n-------\n-------\n-------\nR-BBBB");
        when(grid.getColumns()).thenReturn("------\n------\n------\n------\n------\n------\nRBBBB");
        when(grid.getDiag()).thenReturn("-------\n-------\n-------\n-------\n-------\nR-BBBB");

        Optional<Character> result = analyze.getWinner();

        //then
        assertEquals(Character.valueOf('B'),result.get());
    }

    @Test
    public void ShouldReturnEmptyOptionalWhenRWins(){

        //giving

        //when
        System.out.println(grid);
        when(grid.getRows()).thenReturn("-------\n-------\n-------\n-------\n-------\nR-----");
        when(grid.getColumns()).thenReturn("------\n------\n------\n------\n------\n------\n-----");
        when(grid.getDiag()).thenReturn("-------\n-------\n-------\n-------\n-------\nR------");

        Optional<Character> result = analyze.getWinner();

        //then
        assertEquals(Optional.empty(),result);
    }



}
