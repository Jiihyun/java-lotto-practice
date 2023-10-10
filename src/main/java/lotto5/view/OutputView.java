package lotto5.view;

import lotto5.domain.DrawingResults;
import lotto5.domain.Lotto;

import java.util.List;

public class OutputView {
    public static void printLottos(List<Lotto> lottos) {
        System.out.printf("\n%d개를 구매했습니다.\n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
//        StringBuilder sb = new StringBuilder();
//        sb.append(lottos.size())
//                .append("개를 구매했습니다.\n")
//                .append(lottos);
//        String string = sb.toString();
//        System.out.println(string);
    }

    public static void printDrawingResult(DrawingResults result) {
        System.out.println(result);
    }

    public static void inputMoneyMsg() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void inputWinningNumberMsg() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void inputBonusNumberMsg() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}
