package lotto3.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumberGenerator {
    private final int startInclusive;
    private final int endInclusive;

    public RandomNumberGenerator(final int startInclusive, final int endInclusive) {
        this.startInclusive = startInclusive;
        this.endInclusive = endInclusive;
    }

    public List<Integer> generate(final int count) {
    return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
  }
}
