package lotto5.domain;

import java.util.List;

public class LottoMachine {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final List<Lotto> lottos;

    public LottoMachine(List<Integer> winningNumbers, int bonusNumber, List<Lotto> lottos) {
        validateLottoNumbers(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.lottos = lottos;
    }

    private static void validateLottoNumbers(List<Integer> winningNumbers, int bonusNumber) {
        validateLottoNumber(bonusNumber);
        for (Integer winningNumber : winningNumbers) {
            validateLottoNumber(winningNumber);
        }
    }

    private static void validateLottoNumber(Integer lottoNumber) {
        if (lottoNumber < 1 || lottoNumber > 45) {
            throw new IllegalArgumentException("로또 번호는 1 - 45 사이여야 합니다.");
        }
    }

    public DrawingResults draw() {
        // 로또 리스트 순환하면서, 당첨 번호 얼마나 일치하는지 확인
        // 당첨 결과는 불변이기 때문에 enum 생성
        // 각 당첨 결과의 갯수는 변하기 때문에 DrawingResults에 Map 형태로 저장

        // 5개 번호 일치 시에만 보너스 번호 일치 확인
        // DrawingResult enum (format된거) 반환 (n개 일치하는지, 당첨 금액, 보너스 boolean 여부)
        return null;
    }
}
