package hw.ch06;

import hw.ch06.framework.Product;

public class BorderLine implements Product {
    private char borderChar; 

    // 생성자: 경계 문자를 받아 저장
    public BorderLine(char borderChar) {
        this.borderChar = borderChar;
    }

    @Override
    public void use(String s) {
        // 위쪽 라인 출력
        for (int i = 0; i < s.length(); i++) {
            System.out.print(borderChar);
        }
        System.out.println();

        //  본문 출력
        System.out.println(s);

        //  아래쪽 라인 출력
        for (int i = 0; i < s.length(); i++) {
            System.out.print(borderChar);
        }
        System.out.println();
    }

    @Override
    public Product createCopy() {
        Product p = null;
        try {
            //  clone()을 이용한 복사
            p = (Product) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}