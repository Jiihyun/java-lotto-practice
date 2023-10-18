package lotto5.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator2 {

    private final NumbersGenerator numbersGenerator;

    public LottoGenerator2(NumbersGenerator numbersGenerator) {
        this.numbersGenerator = numbersGenerator;
    }

    public Lotto generateNumbers() {
        List<Integer> numbers = numbersGenerator.gererate();
        return new Lotto(numbers);
    }
}

