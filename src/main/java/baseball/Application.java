package baseball;

import controller.BaseballGameController;
import controller.GameController;
import model.BaseballGame;
import view.BaseballGameView;
import view.GameView;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();

        while (baseballGame.isContinue()) {
            GameView gameView = new BaseballGameView(baseballGame); // model에 따른 view 반환
            String keyInput = gameView.askKeyInput();

            GameController gameController = new BaseballGameController(baseballGame);
            baseballGame = gameController.process(keyInput); // controller에서 model 반환

            gameView = new BaseballGameView(baseballGame); // model에 따른 view 반환
            gameView.printGameState();
        }
    }
}
