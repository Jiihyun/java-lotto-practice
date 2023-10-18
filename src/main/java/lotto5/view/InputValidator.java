package lotto5.view;

import lotto5.exceptions.BonusNumberInputException;

import java.util.List;

public class InputValidator {
    public static void validateMoneyInput(final String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR]금액은 숫자로 입력해 주세요.");
        }
    }

    public static void validateBonusNumberInput(final String input) {
        try {
            int num = Integer.parseInt(input);
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("[ERROR]로또 번호는 1 - 45 사이여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new BonusNumberInputException();
        }
    }

    public static void validateWinningNumbers(List<String> chunks) {
        if (chunks.size() != 6) {
            throw new IllegalArgumentException("[ERROR]당첨 번호는 6개여야 합니다.");
        }
        try {
            for (String chunk : chunks) {
                Integer.parseInt(chunk.trim()); //imp - trim()은 양 옆의 공백 제거해줌
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR]금액은 숫자로 입력해 주세요.");
        }
    }
}
