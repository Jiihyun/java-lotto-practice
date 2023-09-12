package lotto3;

import lotto3.controller.LottoController;
import lotto3.domain.LottoDrawingMachine;
import lotto3.domain.LottoStore;
import lotto3.domain.RandomNumberGenerator;
import lotto3.view.InputView;
import lotto3.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator(1, 45);
        LottoDrawingMachine lottoDrawingMachine = new LottoDrawingMachine(randomNumberGenerator);
        LottoStore lottoStore = new LottoStore(randomNumberGenerator);
        OutputView outputView = new OutputView();
        InputView inputView = new InputView(outputView);
        LottoController lottoController = new LottoController(inputView, outputView, lottoStore, lottoDrawingMachine);

        lottoController.start();
    }
}
