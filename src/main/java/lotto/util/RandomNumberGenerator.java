package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static lotto.util.NumberConst.*;

public class RandomNumberGenerator {
    public List<Integer> generateLottoNumberInAscending() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(INCLUSIVE_NUM, EXCLUSIVE_NUM, 6);
        return numbers;
    }
}
