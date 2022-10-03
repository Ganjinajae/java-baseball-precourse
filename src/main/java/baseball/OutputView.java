package baseball;

public class OutputView {

    private OutputView() {
        throw new IllegalStateException("생성자가 필요 없는 클래스입니다.");
    }

    static void show(PlayResult result) {
        if (result.getBall() > 0) {
            System.out.printf("%d볼 ", result.getBall());
        }
        if (result.getStrike() > 0) {
            System.out.printf("%d스트라이크", result.getStrike());
        }
        if (result.getStrike() == 0 && result.getBall() == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }
}
