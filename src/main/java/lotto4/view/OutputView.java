package lotto4.view;

import lotto4.domain.LottoTickets;
import lotto4.util.MessageConst;

public class OutputView {
    public void printInputMoneyMsg() {
        System.out.println(MessageConst.INPUT_MONEY_MSG);
    }

    public void printLottoTickets(LottoTickets lottoTickets) {
        System.out.println(lottoTickets);
    }

    public void printInputWinningNumbers() {
        System.out.println(MessageConst.INPUT_WINNING_NUM_MSG);
    }

    public void printInputBonusNumber() {
        System.out.println(MessageConst.INPUT_BONUS_NUM_MSG);
    }

    public void printWinningStatistics() {
        System.out.println(MessageConst.WINNING_STATISTICS_MSG);
        //TODO: LottoDrawingResults
    }
}
