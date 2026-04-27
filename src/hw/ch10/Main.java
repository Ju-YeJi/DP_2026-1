package hw.ch10;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== RandomStrategy =====");
        Player player1 = new Player("Taro", new RandomStrategy(0));

        System.out.println("\n===== CyclicStrategy =====");
        Player player2 = new Player("Bob", new CyclicStrategy());

        // 바위 -> 가위 -> 보 순서로 반복되는지 확인하는 테스트
        System.out.println("===== CyclicStrategy 의 손가락 순환 =====");
        Strategy cyclic = new CyclicStrategy();

        for (int i = 0; i < 9; i++) {
            Hand hand = cyclic.nextHand();
            System.out.println((i + 1) + "번째: " + hand);

            // study 호출해도 영향이 없음
            cyclic.study(false);
        }

        System.out.println("\n===== 10번 게임 진행 결과 =====");

        // player1과 player2가 10번만 게임을 진행합니다.
        for (int i = 0; i < 10; i++) {
            Hand nextHand1 = player1.nextHand();
            Hand nextHand2 = player2.nextHand();

            System.out.println((i + 1) + "번째 게임: "
                    + player1 + " -> " + nextHand1 + ", "
                    + player2 + " -> " + nextHand2);

            if (nextHand1.isStrongerThan(nextHand2)) {
                System.out.println("Winner: " + player1);
                player1.win();
                player2.lose();
            } else if (nextHand2.isStrongerThan(nextHand1)) {
                System.out.println("Winner: " + player2);
                player1.lose();
                player2.win();
            } else {
                System.out.println("Even...");
                player1.even();
                player2.even();
            }
        }

        System.out.println("\nTotal result:");
        System.out.println(player1);
        System.out.println(player2);
    }
}