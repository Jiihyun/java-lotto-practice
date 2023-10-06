package lotto5.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrawingResultTest {
    @DisplayName("당첨갯수에 따른 등수")
    @Test
    void test() {
        //given
        DrawingResult result1 = DrawingResult.getResult(6, false);
        DrawingResult result2 = DrawingResult.getResult(5, true);
        DrawingResult result3 = DrawingResult.getResult(5, false);
        DrawingResult result4 = DrawingResult.getResult(4, false);
        DrawingResult result5 = DrawingResult.getResult(3, false);
        DrawingResult none1 = DrawingResult.getResult(2, false);
        DrawingResult none2 = DrawingResult.getResult(1, false);
        DrawingResult none3 = DrawingResult.getResult(0, false);
        //when+then
        Assertions.assertThat(result1).isEqualTo(DrawingResult.FIRST);
        Assertions.assertThat(result2).isEqualTo(DrawingResult.SECOND);
        Assertions.assertThat(result3).isEqualTo(DrawingResult.THIRD);
        Assertions.assertThat(result4).isEqualTo(DrawingResult.FOURTH);
        Assertions.assertThat(result5).isEqualTo(DrawingResult.FIFTH);
        Assertions.assertThat(none1).isEqualTo(DrawingResult.NONE);
        Assertions.assertThat(none2).isEqualTo(DrawingResult.NONE);
        Assertions.assertThat(none3).isEqualTo(DrawingResult.NONE);
    }
}