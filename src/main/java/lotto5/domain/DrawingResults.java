package lotto5.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class
DrawingResults {
    private Map<DrawingResult, Integer> resultCountMap;

    public DrawingResults() {
        this.resultCountMap = new LinkedHashMap<>();
        resultCountMap.put(DrawingResult.FIFTH, 0);
        resultCountMap.put(DrawingResult.FOURTH, 0);
        resultCountMap.put(DrawingResult.THIRD, 0);
        resultCountMap.put(DrawingResult.SECOND, 0);
        resultCountMap.put(DrawingResult.FIRST, 0);
    }

    public Map<DrawingResult, Integer> getResultCountMap() {
        return resultCountMap;
    }
}
