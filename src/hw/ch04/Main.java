package hw.ch04;

import hw.ch04.framework.Factory;
import hw.ch04.framework.Product;
import hw.ch04.idcard.IDCardFactory;
import hw.ch04.license.LicenseCardFactory;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== Step 1: IDCard 테스트 =====");
        Factory factory = new IDCardFactory("2026-03-20");

        Product card1 = factory.create("Kim Youngjin");
        Product card2 = factory.create("Son Heungmin");
        System.out.println();

        card1.use();
        card2.use();

    
        System.out.println();

        System.out.println("===== Step 2: LicenseCard 테스트 =====");
        Factory factory2 = new LicenseCardFactory("2026-03-20");
        Product license1 = factory2.create("Park Jisung");
        Product license2 = factory2.create("Lee Min-jae");
        
        System.out.println();

        license1.use();
        license2.use();

    
    }
}
