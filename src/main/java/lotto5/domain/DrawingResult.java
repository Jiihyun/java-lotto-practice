package lotto5.domain;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public enum DrawingResult {
    //아래가 생성자 호출이라 볼 수 있음 (enum constant)
    FIRST(2_000_000_000, 6, false),
    SECOND(30_000_000, 5, true),
    THIRD(1_500_000, 5, false),
    FOURTH(50_000, 4, false),
    FIFTH(5_000, 3, false),
    NONE(0, 0, false);

    //필드
    private final int prize;
    private final int matchingNumberCount;
    private final boolean hasBonusNumber;

    // enum은 자바 프로그램이 실행될 때 미리 모든 필드들이 인스턴스로 다 만들어짐

    DrawingResult(int prize, int matchingNumberCount, boolean hasBonusNumber) {
        this.prize = prize;
        this.matchingNumberCount = matchingNumberCount;
        this.hasBonusNumber = hasBonusNumber;
    }

    private static final List<DrawingResult> drawingResults = List.of(FIRST, SECOND, THIRD, FOURTH, FIFTH, NONE);

    public static DrawingResult getResult(int matchingNumberCount, boolean hasBonusNumber) {
        Optional<DrawingResult> drawingResult = drawingResults.stream()
                .filter(r -> r.hasBonusNumber == hasBonusNumber)
                .filter(r -> r.matchingNumberCount == matchingNumberCount)
                .findFirst();
        if (drawingResult.isEmpty()) {
            return NONE;
        }
        return drawingResult.get();
    }

    public static DrawingResult getResultOld(int matchingNumberCount, boolean hasBonusNumber) {
        if (matchingNumberCount == 6) {
            return FIRST;
        }
        if (matchingNumberCount == 5) {
            if (hasBonusNumber) {
                return SECOND;
            }
            return THIRD;
        }
        if (matchingNumberCount == 4) {
            return FOURTH;
        }
        if (matchingNumberCount == 3) {
            return FIFTH;
        }
        return NONE;
    }

    public int getPrize() {
        return prize;
    }
}
