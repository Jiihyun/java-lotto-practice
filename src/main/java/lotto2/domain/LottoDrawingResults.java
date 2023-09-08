package lotto2.domain;

import lotto2.util.MessageConst;

import java.util.List;
import java.util.Map;

import static lotto2.util.MessageConst.*;

public class LottoDrawingResults {
    private final List<LottoDrawingResult> results;

    private LottoDrawingResults(List<LottoDrawingResult> results) {
        this.results = results;
    }

    public static LottoDrawingResults of(List<LottoDrawingResult> lottoDrawingResults) {
        return new LottoDrawingResults(lottoDrawingResults);
    }

    private int countOf(final LottoDrawingResult variant) {
        return (int) results.stream()
                .filter(v -> v.equals(variant))
                .count();
    }

    private int getTotalSpent() {
        return LottoStore.TICKET_PRICE.getAmount() * results.size();
    }

    private int getTotalEarning() {
        int totalEarning = 0;

        for (LottoDrawingResult result : results) {
            totalEarning += result.getPrizeAmount();
        }
        return totalEarning;
    }

    private double getRateOfReturn() {
        final double totalEarning = getTotalEarning();
        final int totalSpent = getTotalSpent();

        final double rateOfReturn = totalEarning / totalSpent * 100.0;

        return Math.round(rateOfReturn * 10.0) / 10.0; //소수점 둘째 자리에서 반올림
    }

    @Override
    public String toString() {
        return String.format(
                WINNING_STATISTICS_MSG
                +SAME_CONUT_OF_THREE+"%d"+UNIT_OF_NUM+"\n"
                +SAME_CONUT_OF_FOUR+"%d"+UNIT_OF_NUM+"\n"
                +SAME_CONUT_OF_FIVE+"%d"+UNIT_OF_NUM+"\n"
                +SAME_CONUT_OF_FIVE_AND_BONUN_NUM+"%d"+UNIT_OF_NUM+"\n"
                +SAME_CONUT_OF_SIX+"%d"+UNIT_OF_NUM+"\n"
                + "총 수익률은 %.1f%%입니다.\n",
                countOf(LottoDrawingResult.FIFTH),
                countOf(LottoDrawingResult.FOURTH),
                countOf(LottoDrawingResult.THIRD),
                countOf(LottoDrawingResult.SECOND),
                countOf(LottoDrawingResult.FIRST),
                getRateOfReturn()

        );
    }
}
