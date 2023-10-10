package lotto5.domain;

import lotto4.domain.LottoDrawingResult;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoMachine {
    private final Lotto winningNumbers;
    private final int bonusNumber;
    private final List<Lotto> lottos;

    public LottoMachine(Lotto winningNumbers, int bonusNumber, List<Lotto> lottos) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.lottos = lottos;
    }


    public DrawingResults draw() {
        // 로또 리스트 순환하면서, 당첨 번호 얼마나 일치하는지 확인
        // 당첨 결과는 불변이기 때문에 enum 생성
        // 각 당첨 결과의 갯수는 변하기 때문에 DrawingResults에 Map 형태로 저장

        // 5개 번호 일치 시에만 보너스 번호 일치 확인
        // DrawingResult enum (format된거) 반환 (n개 일치하는지, 당첨 금액, 보너스 boolean 여부)
        List<DrawingResult> drawingResults = new ArrayList<>();
        for (Lotto lotto : lottos) {
            DrawingResult result = lotto.getResult(winningNumbers, bonusNumber);
            drawingResults.add(result);
        }
        return DrawingResults.of(drawingResults);
    }
}
