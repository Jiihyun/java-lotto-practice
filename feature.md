# 기능 목록

## Lotto
- 로또 넘버 6개 리스트 저장 [o]
- 넘버 6개 맞는 지 검증 [o]
- 넘버 중복 없는 지 검증 [o]

## RandomNumberGenerator
- 무작위로 range 1 ~45인 6개 번호 생성 (return Lotto) [o]

## LottoTickets
- LottoTicket 여러 개를 들고 있는 일급 컬렉션(LottoTicket 여러 장을 구매할 것이기 때문에 필요) [o]

## Money
- 자금 정보를 저장한다 [o]
- 자금 증감 연산을 지원한다 [o]

## LottoStore
- 로또 티켓 구매 (Money 인자, LottoTickets 리턴) [o]
- 1000원으로 안 나뉠시 예외처리 [o]

## LottoDrawingMachine
- inputview 받아와서 당첨 넘버 만들기 []
- 당첨 보너스 넘버 만들기 []
- LottoTicket을 받아 당첨 번호와 대조 후 결과 LottoDrawingResult로 반환 []

## LottoDrawingResult
- 한 개의 Lotto 결과 반환 [o]
- 
## LottoDrawingResults
- Lotto 결과 모음 반환 []
- 수익률 계산 []

