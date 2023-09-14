package lotto4.domain;

import lotto4.util.NumberConst;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public enum LottoDrawingResult {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);
    private final int matchingNums;
    private final boolean hasBonusNum;
    private final int prizeAmount;

    LottoDrawingResult(int matchingNums, boolean hasBonusNum, int prizeAmount) {
        this.matchingNums = matchingNums;
        this.hasBonusNum = hasBonusNum;
        this.prizeAmount = prizeAmount;
    }

    private static final List<LottoDrawingResult> results = Arrays.stream(values()).collect(Collectors.toList());

    public LottoDrawingResult of(final int matchingNums, final boolean hasBonusNum) {
        if (matchingNums == 5 && hasBonusNum) {
            return SECOND;
        }
        Optional<LottoDrawingResult> result = results.stream().filter(r -> r.matchingNums == matchingNums)
                .filter(r -> !r.equals(SECOND))
                .findFirst();

        if (result.isPresent()){
            return result.get();
        }
        return NONE;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
}
