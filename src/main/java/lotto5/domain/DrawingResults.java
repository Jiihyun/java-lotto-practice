package lotto5.domain;

import lotto4.domain.Lotto;
import lotto4.domain.LottoDrawingResult;
import lotto4.domain.LottoDrawingResults;
import lotto4.domain.LottoTickets;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class
DrawingResults {
    private final List<DrawingResult> drawingResults;

    private DrawingResults(final List<DrawingResult> drawingResults) {
        this.drawingResults = drawingResults;
    }

    public static DrawingResults of(final List<DrawingResult> drawingResults) {
        return new DrawingResults(drawingResults);
    }
}
