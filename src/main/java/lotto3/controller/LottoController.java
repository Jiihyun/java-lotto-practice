package lotto3.controller;

import lotto3.domain.*;
import lotto3.view.InputView;
import lotto3.view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    private final LottoStore lottoStore;

    private final LottoDrawingMachine lottoDrawingMachine;

    public LottoController(
            final InputView inputView,
            final OutputView outputView,
            final LottoStore lottoStore,
            final LottoDrawingMachine lottoDrawingMachine
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoStore = lottoStore;
        this.lottoDrawingMachine = lottoDrawingMachine;
    }

    public void start() {
        Money inputMoney = inputView.inputMoney();
        LottoTickets lottoTickets = lottoStore.buyMany(inputMoney);
        outputView.printPurchaseCompletionMessage(lottoTickets);
        List<Integer> winningNumbers = inputView.inputWinningNumbers();
        Integer bonusNumber = inputView.inputBonusNumber();
        lottoDrawingMachine.drawManually(winningNumbers, bonusNumber);
        LottoDrawingResults lottoDrawingResults = lottoDrawingMachine.getResults(lottoTickets);
        outputView.printLottoDrawingResults(lottoDrawingResults);
    }
}
