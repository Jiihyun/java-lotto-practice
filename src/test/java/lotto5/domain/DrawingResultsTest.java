package lotto5.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class DrawingResultsTest {
    @DisplayName("수익률 계산 확인")
    @Test
    void checkGetProfit() {
        //given
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        Lotto winningNumbers = new Lotto(list);

        int bonusNumber = 7;
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 9, 11, 10));
        Lotto lotto2 = new Lotto(List.of(21, 22, 23, 24, 25, 27));
        Lotto lotto3 = new Lotto(List.of(12, 22, 23, 24, 25, 26));
        Lotto lotto4 = new Lotto(List.of(1, 2, 3, 4, 15,16));
        List<Lotto> lottos = List.of(lotto1, lotto2, lotto3, lotto4);
        LottoMachine lottoMachine = new LottoMachine(winningNumbers, bonusNumber, lottos);

        //when
        DrawingResults results = lottoMachine.draw();
        double rateOfReturn = results.rateOfReturn();
        //then
        double expected = 1375.0;
        assertThat(rateOfReturn).isEqualTo(expected);

    }

    @DisplayName("반올림")
    @Test
    void test() {
        //given
        double num1 = 80.23; // 80.2
        double num2 = 80.26; //80.3

        double v1 = Math.round(num1 * 10.0) / 10.0;
        double v2 = Math.round(num2 * 10.0) / 10.0;

        assertThat(v1).isEqualTo(80.2);
        assertThat(v2).isEqualTo(80.3);
    }
}