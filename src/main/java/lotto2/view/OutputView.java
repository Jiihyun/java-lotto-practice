package lotto2.view;

import lotto2.domain.LottoDrawingResults;
import lotto2.domain.LottoTickets;
import lotto2.util.MessageConst;

import static lotto2.util.MessageConst.*;


public class OutputView {
    public void printInputMoneyMessage() {
        System.out.println(INPUT_PRICE_MSG);
    }

    public void printLottoTicketsInfoMessage(final LottoTickets lottoTickets) {
        System.out.println(lottoTickets);
    }

    public void printInputWinningNumberMessage() {
        System.out.println(INPUT_LOTTO_NUMBER_MSG);
    }

    public void printInputBonusNumberMsg() {
        System.out.println(INPUT_BONUS_NUMBER_MSG);
    }

    public void printLottoDrawingResults(final LottoDrawingResults lottoDrawingResults) {
        System.out.println(lottoDrawingResults);
    }
}
