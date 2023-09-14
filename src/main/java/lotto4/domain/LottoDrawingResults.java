package lotto4.domain;

import java.util.List;

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
        return sb.toString();
    }

    private long getCount(LottoDrawingResult result) {
        return drawingResults.stream().filter(r -> r.equals(result)).count();
    }
}
