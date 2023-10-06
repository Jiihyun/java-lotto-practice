package lotto5.view;

import lotto5.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    @DisplayName("")
    @Test
    void test() {
        //given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(3, 4, 5, 6, 7, 8));
        List<Lotto> lottos = List.of(lotto1, lotto2);
        //when
        assertThat(lotto1.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
        assertThat(lotto2.toString()).isEqualTo("[1, 3, 5, 4, 6, 7]");
    }

    @DisplayName("")
    @Test
    void test2() {
// given
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(3, 4, 5, 6, 7, 8));
        List<Lotto> lottos = List.of(lotto1, lotto2);
        OutputView.printLottos(lottos);

// when
// then
        assertThat(out.toString()).isEqualTo("2개를 구매했습니다.\n[1, 2, 3, 4, 5, 6]\n[3, 4, 5, 6, 7, 8]\n");
    }
}