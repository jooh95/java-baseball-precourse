package model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class BaseballGame {
    public static final BaseballGame END = new BaseballGame(
        Collections.emptyList(), Collections.emptyList());
    public static final int MAX_STRIKE_COUNT = 3;

    private int strike;
    private int ball;
    private final List<Integer> answers;
    private final List<Integer> guesses;

    private BaseballGame() {
        strike = 0;
        ball = 0;
        answers = pickNumbers();
        guesses = Collections.emptyList();
    }

    private BaseballGame(List<Integer> answers, List<Integer> guesses) {
        this.answers = answers;
        this.guesses = guesses;
        updateGameState();
    }

    public static BaseballGame newGame() {
        return new BaseballGame();
    }

    public static BaseballGame play(List<Integer> answers, List<Integer> guesses) {
        return new BaseballGame(answers, guesses);
    }

    public boolean isPlayerWin() {
        return Objects.equals(strike, MAX_STRIKE_COUNT);
    }

    public boolean isContinue() {
        return !answers.isEmpty();
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public List<Integer> getAnswers() {
        return answers;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0 && !guesses.isEmpty();
    }

    private List<Integer> pickNumbers() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < MAX_STRIKE_COUNT) {
            numbers.add(pickNumberInRange(1, 9));
        }
        return new ArrayList<>(numbers);
    }

    private void updateGameState() {
        for (int i = 0; i < answers.size(); i++) {
            int elementIndex = guesses.indexOf(answers.get(i));
            if (elementIndex == i) {
                strike++;
            } else if (elementIndex > -1) {
                ball++;
            }
        }
    }
}
