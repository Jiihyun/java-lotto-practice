package lotto5.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoNumbersGenerator implements NumbersGenerator {
    public List<Integer> gererate() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
