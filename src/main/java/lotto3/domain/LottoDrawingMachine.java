package lotto3.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoDrawingMachine {

    private final RandomNumberGenerator randomNumberGenerator;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoDrawingMachine(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void drawAutomatically() {
        //랜덤 6자리 + 랜덤 보너스 넘버 (사용자 input이 아님)
        final List<Integer> winningNumbers = randomNumberGenerator.generate(7);
        Integer bonusNumber = winningNumbers.remove(0);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void drawManually(final List<Integer> winningNumbers, final int bonusNumber) {
        validateLength(winningNumbers);
        validateNumbersDuplication(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateLength(final List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] - 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateNumbersDuplication(final List<Integer> winningNumbers, final int bonusNumber) {
        final List<Integer> numbersWithBonusNum = new ArrayList<>(winningNumbers);
        numbersWithBonusNum.add(bonusNumber);
        if (numbersWithBonusNum.stream().distinct().count() != 7) {
            throw new IllegalArgumentException("[ERROR] - 중복된 로또 번호가 존재합니다.");
        }
    }
}
