package lotto1;

import lotto1.controller.GameController;
import lotto1.service.LottoService;
import lotto1.util.RandomNumberGenerator;
import lotto1.view.InputView;
import lotto1.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoService lottoService = new LottoService(new RandomNumberGenerator());
        GameController gameController = new GameController(inputView, outputView, lottoService);
        gameController.start();
    }
}
