package hw.ch04.license;

import java.time.LocalDate;

import hw.ch04.framework.Factory;
import hw.ch04.framework.Product;

public class LicenseCardFactory extends Factory {
    // 면허번호는 100부터 시작
    private int licenseCounter = 100;

    //  발급 기준 날짜
    private String baseDate;

    //  생성자
    public LicenseCardFactory(String baseDate) {
        this.baseDate = baseDate;
    }

    @Override
    protected Product createProduct(String owner) {
        //  현재 번호를 사용하고 다음 번호로 증가
        int currentNumber = licenseCounter++;

        //  만료 날짜 계산
        String expiryDate = calculateExpiryDate(baseDate);

        //  LicenseCard 생성
        return new LicenseCard(owner, currentNumber, baseDate, expiryDate);
    }

    @Override
    protected void registerProduct(Product product) {
        //  등록 메시지 출력
        System.out.println(product + "을 등록했습니다.");
    }

    // 발급일 + 5년 - 1일
    private String calculateExpiryDate(String issuedDate) {
        return LocalDate.parse(issuedDate)
                .plusYears(5)
                .minusDays(1)
                .toString();
    }
}