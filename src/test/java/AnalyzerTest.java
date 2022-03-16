import net.bytebuddy.dynamic.DynamicType;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;


@ExtendWith(MockitoExtension.class)
public class AnalyzerTest {

    @Mock
    private Grid grid;



    @Test
    public void ShouldReturnOptionalOfRWhenRWins(){

        //giving
        // when(grid.getRows()).thenReturn("-------\n-------\n-------\n-------\n-------\n-BBRRRR");

         Analyzer analyze = new Analyzer(grid);

        //when

        //then
        Optional<Character> result = analyze.getWinner();
        assertEquals(Character.valueOf('R'),result.get());
    }



}
