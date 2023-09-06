package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.NumberConst;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public int readInputPrice() {
            String price = Console.readLine();
        try {
            if (price == null || price.isEmpty() || Integer.parseInt(price) % NumberConst.UNIT_OF_AMOUNT != 0) {
                throw new IllegalArgumentException("[ERROR]: 가격 입력 오류");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] - 가격 입력 오류");
        }
        return Integer.parseInt(price);
    }

    public List<Integer> readInputLottoNumbers() {
         return Arrays
                .stream(Console.readLine()
                        .split(","))
                 .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int readInputBonusNumbers() {
        return Integer.parseInt(Console.readLine());
    }
}
