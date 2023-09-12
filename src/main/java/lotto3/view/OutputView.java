package lotto3.view;

import lotto3.domain.LottoDrawingResults;
import lotto3.domain.LottoTickets;

public final class OutputView {
    public void printInputMoneyMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printPurchaseCompletionMessage(final LottoTickets lottoTickets) {
        System.out.println(lottoTickets);
    }

    public void printInputWinningNumbersMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printInputBonusNumbersMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printLottoDrawingResults(final LottoDrawingResults lottoDrawingResults) {
        System.out.println(lottoDrawingResults);
    }
}
