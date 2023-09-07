package lotto1.model;

import lotto1.util.NumberConst;

import java.util.ArrayList;
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
        if (numbers.size() != NumberConst.LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException();
        }
        if (numbers.stream().distinct().count() != NumberConst.LOTTO_NUMBERS_SIZE) {
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
