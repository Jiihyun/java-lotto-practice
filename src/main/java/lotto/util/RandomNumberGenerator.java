package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.util.NumberConst.*;

public class RandomNumberGenerator {
    public List<Integer> generateLottoNumberInAscending() {
        return Randoms.pickUniqueNumbersInRange(INCLUSIVE_NUM, EXCLUSIVE_NUM, 6);
    }
}
