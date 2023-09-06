package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> mutableNumbers = new ArrayList<>(numbers);
        mutableNumbers.sort(Comparator.naturalOrder());
        this.numbers = mutableNumbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int compareNumber(Lotto inputNum) {
        int sameNumberCount = 0;
        for (Integer number : numbers) {
            if (inputNum.numbers.contains(number)) {
                sameNumberCount++;
            }
        }
        return sameNumberCount;
    }

    public boolean compareBonusNum(int inputBonusNumber) {
        for (Integer number : numbers) {
            if (number == inputBonusNumber) {
                return true;
            }
        }
        return false;
    }
}
