package hw.ch04.idcard;

import hw.ch04.framework.Product;

public class IDCard extends Product {
    private String owner;
    private int serial;
    private String issuedDate; // 발급 날짜 추가

    public IDCard(String owner) { // 부모의 인자없는 생성자를 호출
        // super(); // 부모의 생성자 호출 (생략 가능)
        // super("x", "y"); // 부모의 생성자 호출 (부모 클래스에 인자있는 생성자가 있다면 반드시 호출해야 함)
        System.out.println(owner + "의 카드를 만듭니다.");
        this.owner = owner;
    }

    //  생성자에 issuedDate 매개변수 추가
    IDCard(String owner, int serial, String issuedDate) {
        System.out.println(owner + "의 카드를 " + serial + "번으로 만듭니다.");
        this.owner = owner;
        this.serial = serial;

        // 발급 날짜 저장
        this.issuedDate = issuedDate;
    }


    @Override
    public void use() {
        System.out.println(this.toString() + "을 사용합니다."); // 자동으로 toString() 메소드가 호출됨
    }

    @Override
    // Object 클래스의 toString() 메소드 오버라이드
    public String toString() {
        // return "[IDCard:" + owner + "]";
         // 발급 날짜까지 출력
        return "[IDCard:" + owner + "(" + serial + ")] - 발급일: " + issuedDate;
    }

    public String getOwner() {
        return owner;
    }

        public int getSerial() {
        return serial;
    }

    // 발급 날짜 getter 추가
    public String getIssuedDate() {
        return issuedDate;
    }
}
