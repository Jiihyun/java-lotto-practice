package lotto.controller;

import lotto.model.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    InputView inputView;
    OutputView outputView;
    LottoService lottoService;

    public GameController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void start() {
        int inputPrice = inputPrice();
        int lottoCount = lottoService.lottoPriceToCount(inputPrice);
        List<Lotto> lottoLists = lottoService.createLottoLists(lottoCount);
        outputView.printInputPriceToCount(lottoCount, lottoLists);
        outputView.printInputLottoNumberMsg();
        List<Integer> lottoNumbers = inputView.readInputLottoNumbers();
        outputView.printInputBonusNumberMsg();
        Lotto inputLottoNums = lottoService.inputLottoNumber(lottoNumbers);
        int inputBonusNumber = inputView.readInputBonusNumbers();
        List<Integer> winningStatisticsList = lottoService.compareList(lottoLists, inputLottoNums);
        outputView.printWinningStatisticsMsg(lottoService, winningStatisticsList, lottoLists, inputLottoNums, inputBonusNumber);
        outputView.printRateOfReturn(lottoService, inputPrice, winningStatisticsList, lottoLists, inputLottoNums, inputBonusNumber);


    }

    private int inputPrice() {
        try {
            outputView.printInputPriceMsg();
            return inputView.readInputPrice(); //TODO 1000원 단위 아니면 예외처리
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
