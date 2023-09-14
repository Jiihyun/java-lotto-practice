package lotto4;

import lotto4.Controller.LottoController;
import lotto4.domain.LottoDrawingMachine;
import lotto4.domain.LottoStore;
import lotto4.domain.RandomNumberGenerator;
import lotto4.view.InputView;
import lotto4.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        OutputView outputView = new OutputView();
        InputView inputView = new InputView(outputView);
        LottoStore lottoStore = new LottoStore(randomNumberGenerator);
        LottoDrawingMachine lottoDrawingMachine = new LottoDrawingMachine();
        LottoController lottoController = new LottoController(outputView, inputView, lottoStore, lottoDrawingMachine);
        try {
            lottoController.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
