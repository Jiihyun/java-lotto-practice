package lotto5.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateLottoNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateLottoNumber(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("로또 번호는 1 - 45 사이여야 합니다.");
            }
        }
    }

    public DrawingResult getResult(Lotto inputWinningNums, int bonusNum) {
        int matchingNums = (int) inputWinningNums.numbers.stream().filter(numbers::contains).count();
        boolean hasBonusNum = numbers.stream().anyMatch(num -> num.equals(bonusNum));
        return DrawingResult.getResult(matchingNums, hasBonusNum);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    // TODO: 추가 기능 구현
}
