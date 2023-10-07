package lotto5.view;

import camp.nextstep.edu.missionutils.Console;
import lotto5.domain.Money;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    //question : static vs 객체 생성(DI해주ㄱ기)
    public static Money inputPurchaseMoney() {
        OutputView.inputMoneyMsg();
        final String input = readLine();
        InputValidator.validateMoneyInput(input);

        final int amount = Integer.parseInt(input);
        return Money.of(amount);
    }

    public static List<Integer> inputWinningNumbers() {
        final String input = readLine();
        final List<String> chunks = Arrays.stream(input.split("")).collect(Collectors.toList());
        InputValidator.validateWinningNumbers(chunks);
        return chunks.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    public static int inputBonusNumber() {
        final String input = readLine();
        InputValidator.validateBonusNumberInput(input);

        return Integer.parseInt(input);
    }

    private static String readLine() {
        return Console.readLine().trim();
    }
}
