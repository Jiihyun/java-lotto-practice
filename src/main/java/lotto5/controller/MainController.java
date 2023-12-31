package lotto5.controller;

import lotto5.domain.*;
import lotto5.view.InputView;
import lotto5.view.OutputView;

import java.util.List;

public class MainController {
    public static void start() {
        //1. 입력 ✅
        final LottoMachine machine = createLottoMachine();
        //2. 실행
        DrawingResults result = machine.draw();
        //3. 출력
        OutputView.printDrawingResult(result);
    }

    private static LottoMachine createLottoMachine() {
        //1. 구입 금액 입력 받기 ✅
        final Money purchaseMoney = InputView.inputPurchaseMoney();
        //2. 구입 금액만큼 로또 구매하기 ✅
        final List<Lotto> lottos = LottoGenerator.purchaseUntilOutOfMoney(purchaseMoney);
        //3. 구매한 로또 출력하기 ✅
        OutputView.printLottos(lottos);
        //4. 당첨 번호 입력하기 ✅
        Lotto winningNumbers = InputView.inputWinningNumbers();
        //5. 보너스 번호 입력받기 ✅
        int bonusNumber = InputView.inputBonusNumber();

        return new LottoMachine(winningNumbers, bonusNumber, lottos);
    }
}
