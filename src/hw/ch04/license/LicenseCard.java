package hw.ch04.license;

import hw.ch04.framework.Product;

public class LicenseCard extends Product {
    // 운전자 이름
    private String holder;

    //  면허 번호
    private int licenseNumber;

    //  발급 날짜
    private String issuedDate;

    //  만료 날짜
    private String expiryDate;

    // 생성자에서 holder, licenseNumber, issuedDate, expiryDate를 받아 저장
    LicenseCard(String holder, int licenseNumber, String issuedDate, String expiryDate) {
        System.out.println(holder + "의 운전면허증을 " + licenseNumber + "번으로 만듭니다.");
        this.holder = holder;
        this.licenseNumber = licenseNumber;
        this.issuedDate = issuedDate;
        this.expiryDate = expiryDate;
    }

    @Override
    public void use() {
        System.out.println(this + "을 사용합니다.");
    }

    @Override
    public String toString() {
        // 출력
        return "[LicenseCard:" + holder + "(" + licenseNumber + ")] - 유효기간: "
                + issuedDate + " ~ " + expiryDate;
    }

    // getter 메소드 추가
    public String getHolder() {
        return holder;
    }

    public int getLicenseNumber() {
        return licenseNumber;
    }

    public String getIssuedDate() {
        return issuedDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }
}