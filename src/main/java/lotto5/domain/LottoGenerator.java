package lotto5.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private static final int LOTTO_PRICE = 1_000;

    //1. 랜덤 로또 생성 기능
    private static Lotto generateNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    //2. 돈을 넣은 만큼 로또 번호 생성 및 돈 감소
    public static List<Lotto> purchaseUntilOutOfMoney(final Money money) {
        List<Lotto> lottos = new ArrayList<>();
        // 돈이 충분한지 검사 (최소 금액 1000)
        // 돈 감소
        // 개수만큼 로또 구매
        while (money.isEqualOrMoreThan(LOTTO_PRICE)) {
            money.decrease(LOTTO_PRICE);
            Lotto lotto = generateNumbers();
            lottos.add(lotto);
        }
        return lottos;
    }
}
