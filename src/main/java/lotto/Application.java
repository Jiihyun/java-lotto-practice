package lotto;

import lotto.controller.GameController;
import lotto.service.LottoService;
import lotto.util.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

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
