package lotto3.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
    private final List<Integer> numbers;

    public LottoTicket(final List<Integer> numbers) {
        validateLength(numbers);
        validateNumbersDuplication(numbers);
        this.numbers = numbers;
    }


    private void validateLength(final List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateNumbersDuplication(final List<Integer> numbers) {
        for (final Integer number : numbers) {

            final long numberCount = numbers.stream().filter(n -> n.equals(number)).count();

            if (numberCount > 1) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되면 안 됩니다.");
            }
        }
    }

    public LottoDrawingResult drawResult(final List<Integer> winningNumbers, final int bonusNumber) {
        final int matchingNumbersCount = getWinningNumbersCount(winningNumbers);
        final boolean hasBonusNumber = hasBonusNumber(bonusNumber);
        return LottoDrawingResult.of(matchingNumbersCount, hasBonusNumber);
    }

    public int getWinningNumbersCount(final List<Integer> winningNumbers) {
        return (int)winningNumbers.stream().filter(numbers::contains).count();
    }

    public boolean hasBonusNumber(final int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    //imp - List는 toString 을 호출하기만 해도 [elem1, elem2, ...] 형태의 문자열로 변환됨
    @Override
    public String toString() {
        return numbers.stream().sorted().collect(Collectors.toList()).toString();
    }
}
