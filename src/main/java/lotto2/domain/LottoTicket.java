package lotto2.domain;

import lotto1.util.NumberConst;
import lotto2.util.MessageConst;

import java.util.List;
import java.util.stream.Collectors;

import static lotto2.util.MessageConst.*;

public class LottoTicket {
    private final List<Integer> numbers;

    public LottoTicket(final List<Integer> numbers) {
        validateLength(numbers);
        validateNumberDuplication(numbers);
        this.numbers = numbers;
    }

    private void validateLength(final List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_SIZE_EXCEPTION);
        }
    }

    private void validateNumberDuplication(final List<Integer> numbers) {
        if (numbers.stream().distinct().count() != NumberConst.LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(LOTTO_DUPLICATION_EXCEPTION);
        }
    }

    public LottoDrawingResult drawResult(final List<Integer> winningNumbers, final int bonusNumber) {
        final int winningNumbersCount = getWinningNumbersCount(winningNumbers);
        final boolean hasBonusNumber = hasBonusNumber(bonusNumber);
        return LottoDrawingResult.of(winningNumbersCount, hasBonusNumber);
    }

    private int getWinningNumbersCount(final List<Integer> winningNumbers) {
        return (int)winningNumbers.stream().filter(numbers::contains).count();
    }

    private boolean hasBonusNumber(final int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList())
                .toString();
    }
}
