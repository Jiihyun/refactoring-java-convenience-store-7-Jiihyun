# java-convenience-store-precourse

# 📝 java-convenience-store 기능 목록 📝

## 입력 기능

- [x] 상품 파일 불러오기
    - [x] 경로에 파일 없는 경우 예외 처리
- [x] 프로모션 파일 불러오기
    - [x] 경로에 파일 없는 경우 예외 처리
- [x] 구매할 상품과 수량 입력받기
    - [x] 빈 값을 입력하지 않았는지 검증
    - [x] `[상품,수량],[상품,수량]` 형식인지 검증
- [] 프로모션 적용 가능 상품에 대해 고객이 해당 수량보다 적게 가져온 경우, 추가 입력 받기
    - [] `현재{상품명}은(는) 1개를무료로더받을수있습니다. 추가하시겠습니까? (V/N)` 출력
    - [] Y / N 만 입력하였는지 검증
- [] 프로모션 재고가 부족하여 일부 수량을 프로모션 혜택 없이 결제해야 하는 경우, 일부 수량에 대해 정가로 결제할지 여부 입력 받기
    - [] `현재{상품명}{수량}개는프로모션할인이적용되지않습니다. 그래도구매하시겠습니까? (Y/N)` 출력
    - [] Y / N 만 입력하였는지 검증
- [] 멤버십 할인 적용 여부 입력 받기
    - [] `멤버십할인을받으시겠습니까? (Y/N)` 출력
    - [] Y / N 만 입력하였는지 검증
- [] 추가 구매 여부 입력 받기
    - [] `감사합니다. 구매하고싶은다른상품이있나요? (Y/N)` 출력
    - [] Y / N 만 입력하였는지 검증

## 핵심 기능

- [] 잘못된 입력 받을 시 IllegalArgumentException 을 발생시키고,
  "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
- 재고
    - [x] 파일 상품들 재고 등록
    - [x] 프로모션 상품은 파일에 있지만, 파일에 없는 프로모션 안하는 상품들 재고 등록
    - [x] 구매하려는 상품이 재고목록에 존재하는 않는 경우 예외 처리
    - [] 구매할 때 마다 구매한 수량만큼 재고 차감
        - [] 재고가 없는데 구매하려 하는 경우 예외 처리
- 프로모션
    - [x] 프로모션 정보 등록
    - [] 구매하려는 상품이 프로모션 기간인지 체크
    - [] 구매 상품의 프로모션이 존재하는 지 체크
    - [] 프로모션 적용 가능 상품에 대해 해당 수량보다 적게 가져온 경우 체크
    - [] 프로모션 재고가 구매 수량보다 적은지 체크
- 멤버십
    - [] 프로모션 미적용 금액의 30% 할인
    - [] 최대 8000원까지 할인 적용 가능
- 금액 계산
    - [] 구매한 상품마다 수량만큼의 가격 계산
    - [] 구매한 상품의 총 수량 및 총 금액 계산
    - [] 프로모션에 의해 할인된 금액 계산
    - [] 멤버십에 의해 추가로 할인된 금액 계산
    - [] 할인된 금액을 제외한 최종 결제 금액 계산
  
## 출력 기능

- [x] 인사 및 보유재고 출력하기
    - [x] 재고가 0이면 `재고 없음` 출력
- [] 구매 상품 내역, 증정 상품 내역, 금액 정보 출력

## ✅ 과제 제출 전 확인 사항 ✅

- [] 자바 21 버전 확인
- [] indent 최대 2까지인지 확인
- [] 3항 연산자 사용x
- [] 메서드 라인 최대 10라인
- [] if-else 사용x
- [] enum 활용하기
- [] camp.nextstep.edu.missionutils 에서 제공하는 DateTimes 및 Console API 사용하기
    - [] Random 값 추출은 camp.nextstep.edu.missionutils.DateTimes의 now()를 활용
    - [] 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console 의 readLine() 활용
