package lotto.controller;

import lotto.model.Lotto;
import lotto.service.LottoService;
import lotto.util.NumberConst;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static lotto.util.NumberConst.*;

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
        int inputPrice = getInputPrice();
        int lottoCount = lottoService.lottoPriceToCount(inputPrice);
        List<Lotto> lottoLists = lottoService.createLottoLists(lottoCount);
        outputView.printInputPriceToCount(lottoCount, lottoLists);
        Lotto inputLottoNums = getInputLottoNums();
        int inputBonusNumber = getInputBonusNumber();
        List<Integer> countList = getWinningStatistics(lottoLists, inputLottoNums, inputBonusNumber);
        outputView.printWinningStatisticsMsg(countList);
        float rateOfReturn = getRateOfReturn(inputPrice, countList);
        outputView.printRateOfReturn(rateOfReturn);
    }

    private List<Integer> getWinningStatistics( List<Lotto> lottoLists, Lotto inputLottoNums, int inputBonusNumber) {
        List<Integer> countList = getCounts(lottoLists, inputLottoNums, inputBonusNumber);
        return countList;
    }

    public float getRateOfReturn(int inputPrice, List<Integer> countList) {
        int sum = countList.get(0) * PRICE_OF_COUNT_THREE
                + countList.get(1) * PRICE_OF_COUNT_FOUR
                + countList.get(2) * PRICE_OF_COUNT_FIVE
                + countList.get(3) * PRICE_OF_COUNT_FIVE_WITH_BONUS
                + countList.get(4) * PRICE_OF_COUNT_SIX;
        return (float) sum / inputPrice * 100 ;
    }

    private List<Integer> getCounts(List<Lotto> lottoLists, Lotto inputLottoNums, int inputBonusNumber) {
        ArrayList<Integer> countList = new ArrayList<>();
        List<Integer> winningStatisticsList = lottoService.compareList(lottoLists, inputLottoNums);
        countList.add(lottoService.getCountOfThree(winningStatisticsList));
        countList.add(lottoService.getCountOfFour(winningStatisticsList));
        countList.add(lottoService.getCountOfFive(lottoLists, inputLottoNums, inputBonusNumber));
        countList.add(lottoService.getCountOfFiveWithBonus(lottoLists, inputLottoNums, inputBonusNumber));
        countList.add(lottoService.getCountOfSix(winningStatisticsList));

        return countList;
    }

    private int getInputBonusNumber() {
        outputView.printInputBonusNumberMsg();
        return inputView.readInputBonusNumbers();
    }

    private Lotto getInputLottoNums() {
        outputView.printInputLottoNumberMsg();
        List<Integer> lottoNumbers = inputView.readInputLottoNumbers();
        return lottoService.toLotto(lottoNumbers);
    }

    private int getInputPrice() {
        try {
            outputView.printInputPriceMsg();
            return inputView.readInputPrice();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
