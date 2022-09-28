package controller;

import model.BaseballGame;

public class BaseballGameController implements GameController {

    private final BaseballGame baseballGame;

    public BaseballGameController(BaseballGame baseballGame) {
        this.baseballGame = baseballGame;
    }

    @Override
    public BaseballGame process(String playerInput) {
        return null;
    }
}
