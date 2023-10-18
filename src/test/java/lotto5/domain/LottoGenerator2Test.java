package lotto5.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoGenerator2Test {
    @Test
    void generateLotto() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        FixedNumbersGenerator numbersGenerator = new FixedNumbersGenerator(lottoNumbers);

        LottoGenerator2 lottoGenerator = new LottoGenerator2(numbersGenerator);

        //when
        Lotto lotto = lottoGenerator.generateNumbers();
        String string = lotto.toString();

        Assertions.assertThat(string).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    //imp -랜덤부분을 인터페이스로 한 번 감싸고 실제 사용 시에는 랜덤 구현체를 사용하고
    // 테스트시 고정된 구현체로 테스트하기

    static class FixedNumbersGenerator implements NumbersGenerator {
        private final List<Integer> fixedNumbers;
//
        public FixedNumbersGenerator(List<Integer> fixedNumbers) {
            this.fixedNumbers = fixedNumbers;
        }

        @Override
        public List<Integer> gererate() {
            return fixedNumbers;
        }
    }
}