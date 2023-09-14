package lotto4.view;

import lotto4.util.MessageConst;

public class OutputView {
    public void printInputMoneyMsg() {
        System.out.println(MessageConst.INPUT_MONEY_MSG);
    }

    public void printLottoTickets() {
        //TODO : LottoTickets 받아와서 구매한 로또 넘버들 출력
        System.out.println(+MessageConst.TICKET_AMOUNT_CONFIRM_MSG);
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
