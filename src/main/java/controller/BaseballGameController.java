package controller;

import static model.BaseballGame.MAX_STRIKE_COUNT;
import static view.BaseballGameView.Key.GAME_STOP;
import static view.BaseballGameView.Key.NEW_GAME;

import java.util.ArrayList;
import java.util.List;
import model.BaseballGame;

public class BaseballGameController implements GameController {
    private final BaseballGame baseballGame;

    public BaseballGameController(BaseballGame baseballGame) {
        this.baseballGame = baseballGame;
    }

    @Override
    public BaseballGame process(String playerInput) {
        validateWrongInput(playerInput);

        if (baseballGame.isPlayerWin() && NEW_GAME.equals(playerInput)) {
            return BaseballGame.newGame();
        } else if (baseballGame.isPlayerWin() && GAME_STOP.equals(playerInput)) {
            return BaseballGame.END;
        }

        return BaseballGame.play(baseballGame.getAnswers(), toList(playerInput));
    }

    private void validateWrongInput(String input) {
        if (isLengthInRange(input) || isNotNumberic(input)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isLengthInRange(String input) {
        return input.length() > MAX_STRIKE_COUNT;
    }

    private static boolean isNotNumberic(String input) {
        return !input.matches("\\d+");
    }

    private List<Integer> toList(String str) {
        List<Integer> integers = new ArrayList<>();
        for (char c : str.toCharArray()) {
            integers.add(Character.getNumericValue(c));
        }
        return integers;
    }
}
