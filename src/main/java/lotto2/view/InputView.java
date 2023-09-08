package lotto2.view;

import camp.nextstep.edu.missionutils.Console;
import lotto2.domain.Money;
import lotto2.util.MessageConst;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto2.util.MessageConst.*;

public class InputView {
    private final OutputView outputView;

    public InputView(OutputView outputView) {
        this.outputView = outputView;
    }

    public Money inputMoney() {
        outputView.printInputMoneyMessage();
        String price = readLine();
        if (price == null || price.isEmpty()) {
            throw new IllegalArgumentException(PRICE_EXCEPTION);
        }
        for (int i = 0; i < price.length(); i++) {
            if (!Character.isDigit(price.charAt(i))) {
                throw new IllegalArgumentException(PRICE_EXCEPTION);
            }
        }
        final int amount = Integer.parseInt(price);
        if ( amount % 1000 != 0) {
            throw new IllegalArgumentException(PRICE_EXCEPTION);
        }
        return Money.of(amount);
    }


    public List<Integer> inputWinningNumbers() {
        outputView.printInputWinningNumberMessage();

        return Arrays.stream(readLine().split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }

    public Integer inputBonusNumber() {
        outputView.printInputBonusNumberMsg();

        return Integer.parseInt(readLine());
    }

    private String readLine() {
        return Console.readLine().trim();
    }
}
