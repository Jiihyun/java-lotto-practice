package lotto4.Controller;

import lotto4.domain.*;
import lotto4.view.InputView;
import lotto4.view.OutputView;

public class LottoController {
    private final OutputView outputView;
    private final InputView inputView;
    private final LottoStore lottoStore;
    private final LottoDrawingMachine lottoDrawingMachine;

    public LottoController(OutputView outputView, InputView inputView, LottoStore lottoStore, LottoDrawingMachine lottoDrawingMachine) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.lottoStore = lottoStore;
        this.lottoDrawingMachine = lottoDrawingMachine;
    }

    public void start() {
        Money inputMoney = inputView.inputMoney();
        LottoTickets lottoTickets = lottoStore.buyMany(inputMoney);
        outputView.printLottoTickets(lottoTickets);
        Lotto winningNumbers = inputView.inputWinningNumbers();
        int bonusNumber = inputView.inputBonusNumber();
        lottoDrawingMachine.drawNumbers(winningNumbers, bonusNumber);
        LottoDrawingResults lottoDrawingResults = lottoDrawingMachine.compareResult(lottoTickets);
        outputView.printWinningStatistics(lottoDrawingResults);
    }
}
