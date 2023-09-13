package lotto2;

import lotto2.controller.LottoController;
import lotto2.domain.LottoDrawingMachine;
import lotto2.domain.LottoStore;
import lotto2.domain.RandomNumbersGenerator;
import lotto2.util.NumberConst;
import lotto2.view.InputView;
import lotto2.view.OutputView;

import static lotto2.util.NumberConst.*;

public class Application {
    public static void main(String[] args) {
        final RandomNumbersGenerator randomNumbersGenerator = new RandomNumbersGenerator(INCLUSIVE_NUM, EXCLUSIVE_NUM);
        final LottoStore lottoStore = new LottoStore(randomNumbersGenerator);
        final LottoDrawingMachine lottoDrawingMachine = new LottoDrawingMachine(randomNumbersGenerator);
        final OutputView outputView = new OutputView();
        final InputView inputView = new InputView(outputView);
        final LottoController lottoController = new LottoController(inputView, outputView, lottoStore, lottoDrawingMachine);

        //imp - test의 output이 standard output이므로 error 발생하면 standard error로 가는 걸 catch해줘서 standard output으로 넘겨줘야함
        try {
            lottoController.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
