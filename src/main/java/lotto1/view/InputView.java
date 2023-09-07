package lotto1.view;

import camp.nextstep.edu.missionutils.Console;
import lotto1.util.NumberConst;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto1.util.MessageConst.*;

public class InputView {
    public int readInputPrice() {
            String price = Console.readLine();
        try {
            if (price == null || price.isEmpty() || Integer.parseInt(price) % NumberConst.UNIT_OF_AMOUNT != 0) {
                throw new IllegalArgumentException(PRICE_EXCEPTION);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PRICE_EXCEPTION);
        }
        return Integer.parseInt(price);
    }

    public List<Integer> readInputLottoNumbers() {
        List<Integer> inputLottoList = Arrays
                .stream(Console.readLine()
                        .split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return inputLottoList;
    }

    public int readInputBonusNumbers() {
        return Integer.parseInt(Console.readLine());
    }
}
