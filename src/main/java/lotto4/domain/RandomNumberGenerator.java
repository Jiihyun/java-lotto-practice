package lotto4.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto4.util.NumberConst;

import java.util.List;

import static lotto4.util.NumberConst.*;

public class RandomNumberGenerator {
    public Lotto generateNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_INCULSIVE, END_INCULSIVE, LOTTO_SIZE);
        return Lotto.of(numbers);
    }
}
