package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Balls {
    public List<Ball> ballList;
    private List<Integer> numberList = new ArrayList<>();

    public Balls() {
        this.makeNumbers();
        this.ballList = mapper(numberList);
        printNumbers();
        System.out.println(this);
    }

    public Balls(List<Integer> inputList) {
        this.ballList = this.mapper(inputList);
    }

    private List<Ball> mapper(List<Integer> inputList) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            balls.add(new Ball(i, inputList.get(i)));
        }
        return balls;
    }

    /**
     * 판단 기준으로 쓸 볼 리스트를 랜덤으로 만들어낸다.
     */
    private void makeNumbers() {
        while (numberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            addNumber(randomNumber);
        }
    }

    /**
     * 서로 다른 수인 경우 리스트에 추가
     *
     * @param randomNumber
     */
    private void addNumber(int randomNumber) {
        if (!numberList.contains(randomNumber)) {
            numberList.add(randomNumber);
        }
    }

    public String compare(String input) {
        int value = Integer.parseInt(input);
        int first = value / 100;
        int second = (value % 100) / 10;
        int third = value % 10;
        return compare(Arrays.asList(first, second, third));
    }

    private String compare(List<Integer> inputList) {
        Balls inputBalls = new Balls(inputList);
        int s = 0; // 임시
        int b = 0; // 임시
        for (Ball ball : ballList) {
            BallStatus ballStatus = inputBalls.compare(ball);
            if (ballStatus == BallStatus.STRIKE) {
                s++;
            }
            if (ballStatus == BallStatus.BALL) {
                b++;
            }
        }
        return new StringBuilder().append("스트라이크").append(s).append("볼").append(b).toString();
    }

    private BallStatus compare(Ball inputBall) {
        BallStatus ballStatus = BallStatus.NOTHING;
        int index = 0;
        while (ballStatus == BallStatus.NOTHING && index < 3) {
            ballStatus = ballList.get(index).compare(inputBall);
            index++;
        }
        return ballStatus;
    }

    private void printNumbers() {
        System.out.println(
                "("
                        + this.ballList.get(0)
                        + ", "
                        + this.ballList.get(1)
                        + ", "
                        + this.ballList.get(2)
                        + ")");
    }
}
