package lotto4.view;

import lotto4.domain.LottoDrawingResults;
import lotto4.domain.LottoTickets;
import lotto4.util.MessageConst;

public class OutputView {
    public void printInputMoneyMsg() {
        System.out.println(MessageConst.INPUT_MONEY_MSG);
    }

    public void printLottoTickets(LottoTickets lottoTickets) {
        System.out.println();
        System.out.println(lottoTickets);
    }

    public void printInputWinningNumbers() {
        System.out.println(MessageConst.INPUT_WINNING_NUM_MSG);
    }

    public void printInputBonusNumber() {
        System.out.println();
        System.out.println(MessageConst.INPUT_BONUS_NUM_MSG);
    }

    public void printWinningStatistics(LottoDrawingResults lottoDrawingResults) {
        System.out.println();
        System.out.println(MessageConst.WINNING_STATISTICS_MSG);
        System.out.println(lottoDrawingResults);
        //TODO: LottoDrawingResults
    }
}
