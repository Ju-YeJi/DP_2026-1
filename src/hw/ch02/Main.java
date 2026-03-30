package hw.ch02;

public class Main {
    public static void main(String[] args) {
        // 기존 한국 콘센트 객체 생성
        KoreanOutlet koreanOutlet = new KoreanOutlet();

        // Adapter 생성
        Charger adapter = new KoreanOutletAdapter(koreanOutlet);

        // Smartphone은 Charger 인터페이스만 사용
        Smartphone smartphone = new Smartphone(adapter);

        // 충전 실행
        smartphone.charge();
    }
}