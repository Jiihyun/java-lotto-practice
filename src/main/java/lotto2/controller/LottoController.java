package lotto2.controller;

import lotto2.domain.*;
import lotto2.view.InputView;
import lotto2.view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    private final LottoStore lottoStore;

    private final LottoDrawingMachine lottoDrawingMachine;

    public LottoController(InputView inputView, OutputView outputView, LottoStore lottoStore, LottoDrawingMachine lottoDrawingMachine) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoStore = lottoStore;
        this.lottoDrawingMachine = lottoDrawingMachine;
    }

    public void start() {
        final Money money = inputView.inputMoney();

        final LottoTickets lottoTickets = lottoStore.buyMany(money);

        outputView.printLottoTicketsInfoMessage(lottoTickets);

        final List<Integer> winningNumbers = inputView.inputWinningNumbers();

        final Integer bonusNumber = inputView.inputBonusNumber();

        lottoDrawingMachine.drawManually(winningNumbers, bonusNumber);

        LottoDrawingResults lottoDrawingResults = lottoDrawingMachine.getResults(lottoTickets);

        outputView.printLottoDrawingResults(lottoDrawingResults);
    }
}
