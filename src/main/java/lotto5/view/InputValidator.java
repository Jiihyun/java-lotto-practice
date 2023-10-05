package lotto5.view;

import lotto5.exceptions.BonusNumberInputException;

import java.util.List;

public class InputValidator {
    public static void validateMoneyInput(final String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("금액은 숫자로 입력해 주세요.");
        }
    }

    public static void validateBonusNumberInput(final String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new BonusNumberInputException();
        }
    }

    public static void validateWinningNumbers(List<String> chunks) {
        if (chunks.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");
        }
        try {
            for (String chunk : chunks) {
                Integer.parseInt(chunk);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("금액은 숫자로 입력해 주세요.");
        }
    }
}
