package baseball;

import controller.BaseballGameController;
import model.BaseballGame;
import view.BaseballGameView;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = BaseballGame.newGame();

        while (baseballGame.isContinue()) {
            String keyInput = new BaseballGameView(baseballGame).askKeyInput(); // model에 따른 view 사용

            // controller에서 model 반환
            baseballGame = new BaseballGameController(baseballGame).process(keyInput);

            new BaseballGameView(baseballGame).printGameState(); // model에 따른 view 사용
        }
    }
}
