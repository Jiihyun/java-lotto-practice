package lotto4.domain;

import lotto4.util.MessageConst;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        List<Integer> sortedNumbers = numbers.stream().sorted().collect(Collectors.toList());
        this.numbers = sortedNumbers;
    }

    private void validateSize(final List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(MessageConst.NUM_SIZE_EXCEPTION);
        }
    }

    private void validateDuplication(final List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(MessageConst.NUM_DUPLICATION_EXCEPTION);
        }
    }

    public static Lotto of(final List<Integer> numbers) {
        return new Lotto(numbers);
    }
}
