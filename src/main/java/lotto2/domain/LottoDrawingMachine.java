package lotto2.domain;

import lotto2.util.MessageConst;

import java.util.ArrayList;
import java.util.List;

import static lotto2.util.MessageConst.*;

public class LottoDrawingMachine {
    //로또 추첨 기계
    private final RandomNumbersGenerator randomNumbersGenerator;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoDrawingMachine(RandomNumbersGenerator randomNumbersGenerator) {
        this.randomNumbersGenerator = randomNumbersGenerator;
    }

    public void drawAutomatically() {
        final List<Integer> winningNumbers = randomNumbersGenerator.generate(7);
        final Integer bonusNumber = winningNumbers.remove(0);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoDrawingResults getResults(final LottoTickets lottoTickets) {
        if (winningNumbers == null) {
            throw new IllegalArgumentException(LOTTO_RESULT_EXCEPTION);
        }
        return lottoTickets.drawResults(winningNumbers, bonusNumber);
    }

    public void drawManually(final List<Integer> winningNumbers, final int bonusNumber) {
        validateLength(winningNumbers);
        validateNumberDuplication(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateLength(final List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_SIZE_EXCEPTION);
        }
    }

    private void validateNumberDuplication(final List<Integer> numbers, final int bonusNumber) {
        final ArrayList<Integer> numbersWithBonusNumber = new ArrayList<>(numbers);
        numbersWithBonusNumber.add(bonusNumber);

        if (numbersWithBonusNumber.stream().distinct().count() != 7) {
            throw new IllegalArgumentException(LOTTO_DUPLICATION_EXCEPTION);
        }
    }
}
