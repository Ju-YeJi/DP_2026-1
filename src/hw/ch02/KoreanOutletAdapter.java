package hw.ch02;

public class KoreanOutletAdapter implements Charger {
    private KoreanOutlet koreanOutlet;

    public KoreanOutletAdapter(KoreanOutlet koreanOutlet) {
        this.koreanOutlet = koreanOutlet;
    }

    @Override
    public int charge() {
        // KoreanOutlet의 provide()를 Charger의 charge()로 변환
        return koreanOutlet.provide();
    }
}

