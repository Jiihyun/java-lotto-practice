package lotto4.view;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto4.domain.Lotto;
import lotto4.domain.Money;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private final OutputView outputView;

    public InputView(OutputView outputView) {
        this.outputView = outputView;
    }

    public Money inputMoney() {
        outputView.printInputMoneyMsg();
        int receivedMoney = Integer.parseInt(Console.readLine());
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
}
