package model;

import java.util.List;
import java.util.Objects;

public class BaseballGame {
    public static final BaseballGame EMPTY = new BaseballGame();
    public static final int STRIKE_OUT = 3;

    private int strike;
    private int ball;

    private BaseballGame() {
        strike = 0;
        ball = 0;
    }

    public BaseballGame(List<Integer> answers, List<Integer> guesses) {
        for (int i = 0; i < answers.size(); i++) {
            updateGameState(answers.get(i), guesses.get(i));
        }
    }

    public boolean isOnGoing() {
        return !Objects.equals(strike, STRIKE_OUT);
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    private void updateGameState(Integer randomNumber, Integer playerNumber) {
        if (Objects.equals(randomNumber, playerNumber)) {
            strike++;
            return;
        }
        ball++;
    }
}
