package lotto4.view;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto4.domain.Lotto;
import lotto4.domain.Money;
import lotto4.util.MessageConst;
import lotto4.util.NumberConst;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto2.util.MessageConst.PRICE_EXCEPTION;
import static lotto4.util.MessageConst.*;

public class InputView {
    private final OutputView outputView;

    public InputView(OutputView outputView) {
        this.outputView = outputView;
    }

    public Money inputMoney() {
        outputView.printInputMoneyMsg();
        String price = Console.readLine();
        for (int i = 0; i < price.length(); i++) {
            if (!Character.isDigit(price.charAt(i))) {
                throw new IllegalArgumentException(MONEY_INPUT_EXCEPTION);
            }
        }
        int receivedMoney = Integer.parseInt(price);
        return Money.of(receivedMoney);
    }

    public Lotto inputWinningNumbers() {
        outputView.printInputWinningNumbers();
        List<Integer> winningNumsList = Arrays.stream(Console.readLine()
                .split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return Lotto.of(winningNumsList);
    }

    public int inputBonusNumber() {
        outputView.printInputBonusNumber();
        return Integer.parseInt(Console.readLine());
    }
}
