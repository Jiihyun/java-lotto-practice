package lotto4.domain;

import java.util.List;

import static lotto4.domain.LottoStore.TICKET_PRICE;
import static lotto4.util.MessageConst.*;

public class LottoDrawingResults {
    private final List<LottoDrawingResult> drawingResults;

    private LottoDrawingResults(final List<LottoDrawingResult> drawingResults) {
        this.drawingResults = drawingResults;
    }

    public static LottoDrawingResults of(final List<LottoDrawingResult> drawingResults) {
        return new LottoDrawingResults(drawingResults);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(THREE_MATCHES).append(getCount(LottoDrawingResult.FIFTH)).append(UNIT_OF_NUM).append("\n");
        sb.append(FOUR_MATCHES).append(getCount(LottoDrawingResult.FOURTH)).append(UNIT_OF_NUM).append("\n");
        sb.append(FIVE_MATCHES).append(getCount(LottoDrawingResult.THIRD)).append(UNIT_OF_NUM).append("\n");
        sb.append(FIVE_MATCHES_WITH_BONUS).append(getCount(LottoDrawingResult.SECOND)).append(UNIT_OF_NUM).append("\n");
        sb.append(SIX_MATCHES).append(getCount(LottoDrawingResult.FIRST)).append(UNIT_OF_NUM).append("\n");
        sb.append(String.format("총 수익률은 %.1f%%입니다.\n", rateOfReturn()));
        return sb.toString();
    }

    //당첨 금액 / 투입한 금액
    public double rateOfReturn() {
        double sum = getWinningAmount();
        System.out.println("sum = " + sum);
        double spentMoney = getSpentMoney();
        System.out.println("spentMoney = " + spentMoney);
        double rate =  sum / spentMoney * 100.0;
        return Math.round(rate * 10.0) / 10.0;

    }

    private int getWinningAmount() {
        int sum = 0;

        for (LottoDrawingResult drawingResult : drawingResults) {
            sum += drawingResult.getPrizeAmount();
        }
        return sum;
    }

    private int getSpentMoney() {
        return TICKET_PRICE.getAmount() * drawingResults.size();
    }

    private long getCount(LottoDrawingResult result) {
        return drawingResults.stream().filter(r -> r.equals(result)).count();
    }
}
