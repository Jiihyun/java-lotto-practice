package lotto1.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumberGenerator {
    public List<Integer> generateLottoNumberInAscending() {
        return Randoms.pickUniqueNumbersInRange(NumberConst.INCLUSIVE_NUM, NumberConst.EXCLUSIVE_NUM, NumberConst.LOTTO_NUMBERS_SIZE);
    }
}
