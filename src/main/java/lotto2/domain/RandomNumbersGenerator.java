package lotto2.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto2.util.NumberConst.*;

public final class RandomNumbersGenerator {
//    이미 6자리 숫자로 LottoTicket 까지 완성해서 반환하기 때문에 랜덤 숫자가 아닌, LottoTicket 생성에 특화되어 버렸기 때문이다.
//이렇게 한가지에 너무 강하게 결합되면 재사용성이 떨어진다.
    private final int startInclusive;
    private final int endInclusive;

    //<아래로 갈 수록 재사용성이 늘어남>
    //필드 내에 값으로 박아주면 값을 못 바꿈
    //생성자로 넣으면 생성할 떄마다 값을 바꿔줄 수 있음
    //메서드로 넣으면 메서드 호출시다마다 값을 바꿔줄 수 있음

    public RandomNumbersGenerator(final int startInclusive, final int endInclusive) {
        this.startInclusive = startInclusive;
        this.endInclusive = endInclusive;
    }

    public List<Integer> generate(final int count) {
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
        //만약 위 값들이(특히 count) 고정되어 있었다면, 다른 랜덤넘버를 넣지 못하고
        //오직 로또 넘버만 넣을 때 돌아가므로 // 범용성이 떨어짐
    }
}
