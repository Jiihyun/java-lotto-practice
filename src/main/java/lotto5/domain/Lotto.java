package lotto5.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public DrawingResult getResult(List<Integer> inputWinningNums, int bonusNum) {
        int matchingNums = (int)inputWinningNums.stream().filter(numbers::contains).count();
        boolean hasBonusNum = numbers.stream().anyMatch(num -> num.equals(bonusNum));
        return DrawingResult.getResult(matchingNums, hasBonusNum);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    // TODO: 추가 기능 구현
}
