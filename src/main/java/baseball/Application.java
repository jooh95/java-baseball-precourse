package baseball;

import camp.nextstep.edu.missionutils.Console;
import controller.BaseballGameController;
import controller.GameController;
import model.BaseballGame;
import view.BaseballGameUI;
import view.GameUI;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        GameController gameController = new BaseballGameController(baseballGame);

        while (baseballGame.isOnGoing()) {
            GameUI gameUI = new BaseballGameUI(baseballGame); // model에 따른 view 반환
            gameUI.show();

            String playerInput = Console.readLine();
            baseballGame = gameController.process(playerInput); // controller에서 model 반환
        }
    }
}
