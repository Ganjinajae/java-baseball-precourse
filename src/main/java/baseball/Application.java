package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static List<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) {
        new Application().makeNumbers();
        final String input = InputView.show();
        System.out.println(input);
    }

    private void makeNumbers() {
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            addNumber(randomNumber);
        }
    }

    /**
     * 서로 다른 수인 경우 List에 추가
     * @param randomNumber
     */
    private void addNumber(int randomNumber) {
        if (!numbers.contains(randomNumber)) {
            numbers.add(randomNumber);
        }
    }
}
