package lotto.view;

import lotto.model.Lotto;
import lotto.service.LottoService;

import java.util.List;

import static lotto.util.MessageConst.*;

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

    public void printWinningStatisticsMsg(LottoService lottoService, List<Integer> winningStatisticsList, List<Lotto> lottoLists, Lotto inputNum, int inputBonusNumber) {
        System.out.println();
        System.out.println(WINNING_STATISTICS_MSG);
        //TODO: 당첨자 통계
        System.out.println(SAME_CONUT_OF_THREE + lottoService.getCountOfThree(winningStatisticsList) + UNIT_OF_NUM);
        System.out.println(SAME_CONUT_OF_FOUR + lottoService.getCountOfFour(winningStatisticsList) + UNIT_OF_NUM);
        System.out.println(SAME_CONUT_OF_FIVE + lottoService.getCountOfFive(lottoLists, inputNum, inputBonusNumber) + UNIT_OF_NUM);
        System.out.println(SAME_CONUT_OF_FIVE_AND_BONUN_NUM + lottoService.getCountOfFiveWithBonus(lottoLists, inputNum, inputBonusNumber) + UNIT_OF_NUM);
        System.out.println(SAME_CONUT_OF_SIX + lottoService.getCountOfSix(winningStatisticsList) + UNIT_OF_NUM);
    }

    public void printRateOfReturn(LottoService lottoService, int inputPrice, List<Integer> winningStatisticsList, List<Lotto> lottoLists, Lotto inputLottoNums, int inputBonusNumber) {
        System.out.printf("총 수익률은 %s%%입니다.%n", String.format("%.1f", lottoService.getRateOfReturn(inputPrice, winningStatisticsList, lottoLists, inputLottoNums, inputBonusNumber)));
    }
}
