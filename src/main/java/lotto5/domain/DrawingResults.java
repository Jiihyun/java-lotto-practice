package lotto5.domain;

import java.util.List;

import static lotto4.util.MessageConst.*;
import static lotto4.util.MessageConst.UNIT_OF_NUM;

public class
DrawingResults {
    private final List<DrawingResult> drawingResults;

    private DrawingResults(final List<DrawingResult> drawingResults) {
        this.drawingResults = drawingResults;
    }

    public static DrawingResults of(final List<DrawingResult> drawingResults) {
        return new DrawingResults(drawingResults);
    }

    private long getCount(DrawingResult result) {
        return drawingResults.stream().filter(r -> r.equals(result)).count();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(THREE_MATCHES).append(getCount(DrawingResult.FIFTH)).append(UNIT_OF_NUM).append("\n");
        sb.append(FOUR_MATCHES).append(getCount(DrawingResult.FOURTH)).append(UNIT_OF_NUM).append("\n");
        sb.append(FIVE_MATCHES).append(getCount(DrawingResult.THIRD)).append(UNIT_OF_NUM).append("\n");
        sb.append(FIVE_MATCHES_WITH_BONUS).append(getCount(DrawingResult.SECOND)).append(UNIT_OF_NUM).append("\n");
        sb.append(SIX_MATCHES).append(getCount(DrawingResult.FIRST)).append(UNIT_OF_NUM).append("\n");
//        sb.append(String.format("총 수익률은 %.1f%%입니다.\n", rateOfReturn()));
        return sb.toString();
    }
}
