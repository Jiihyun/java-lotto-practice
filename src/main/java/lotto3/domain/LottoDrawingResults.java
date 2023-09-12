package lotto3.domain;

import java.util.List;

public class LottoDrawingResults {
    private final List<LottoDrawingResult> results;

    private LottoDrawingResults(List<LottoDrawingResult> results) {
        this.results = results;
    }

    public static LottoDrawingResults of(List<LottoDrawingResult> lottoDrawingResults) {
        return new LottoDrawingResults(lottoDrawingResults);
    }
}
