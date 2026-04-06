package hw.ch04.idcard;

import hw.ch04.framework.Factory;
import hw.ch04.framework.Product;

public class IDCardFactory extends Factory {
    private int serial = 100;

     // 카드 발급 기준 날짜
    private String baseDate;

    // 생성자에서 발급 날짜를 받아 저장
    public IDCardFactory(String baseDate) {
        this.baseDate = baseDate;
    }
    @Override
    // 부모 타입은 자식 객체를 참조할 수 있다. 중요!! (다형성)
    // 부모 객체는 자식 타입이 참조할 수 없다.
    //protected IDCard createProduct(String owner) { // 실제 제품 생성 (부모타입 Product -> 자식타입 IDCard)
    //     return new IDCard(owner);
    protected synchronized Product createProduct(String owner) {
        // IDCard 생성 시 issuedDate도 함께 전달
        return new IDCard(owner, serial++, baseDate);
    }

    @Override
    protected void registerProduct(Product product) { // 제품 등록
        System.out.println(product + "을 등록했습니다.");
    }
}


