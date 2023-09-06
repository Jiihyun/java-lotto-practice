package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public int readInputPrice() {
        String price = Console.readLine();
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
