package lotto1.view;

import lotto1.model.Lotto;

import java.util.List;

import static lotto1.util.MessageConst.*;

public class OutputView {
    public void printInputPriceMsg() {
        System.out.println(INPUT_PRICE_MSG);
    }

    public void printInputPriceToCount(int lottoCount, List<Lotto> lottoLists) {
        System.out.printf("\n%d%s\n", lottoCount, LOTTO_COUNT_MSG);

        for (Lotto lotto : lottoLists) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printInputLottoNumberMsg() {
        System.out.println();
        System.out.println(INPUT_LOTTO_NUMBER_MSG);
    }

    public void printInputBonusNumberMsg() {

        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER_MSG);
    }

    public void printWinningStatisticsMsg(List<Integer> countList) {
        System.out.println();
        System.out.println(WINNING_STATISTICS_MSG);

        System.out.println(SAME_CONUT_OF_THREE + countList.get(0) + UNIT_OF_NUM);
        System.out.println(SAME_CONUT_OF_FOUR + countList.get(1) + UNIT_OF_NUM);
        System.out.println(SAME_CONUT_OF_FIVE + countList.get(2) + UNIT_OF_NUM);
        System.out.println(SAME_CONUT_OF_FIVE_AND_BONUN_NUM + countList.get(3) + UNIT_OF_NUM);
        System.out.println(SAME_CONUT_OF_SIX + countList.get(4) + UNIT_OF_NUM);
    }

    public void printRateOfReturn(float rateOfReturn) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", rateOfReturn);
    }
}
