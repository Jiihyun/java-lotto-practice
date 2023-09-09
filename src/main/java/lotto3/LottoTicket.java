package lotto3;

import java.util.List;

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
}
