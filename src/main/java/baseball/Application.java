package baseball;

import controller.BaseballGameController;
import controller.GameController;
import model.BaseballGame;
import view.BaseballGameView;
import view.GameView;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = BaseballGame.EMPTY;
        GameController gameController = new BaseballGameController(baseballGame);

        while (baseballGame.isOnGoing()) {
            GameView gameView = new BaseballGameView(baseballGame); // model에 따른 view 반환
            String keyInput = gameView.askKeyInput();

            baseballGame = gameController.process(keyInput); // controller에서 model 반환
        }
    }
}
