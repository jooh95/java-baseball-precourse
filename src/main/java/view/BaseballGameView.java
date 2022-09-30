package view;

import camp.nextstep.edu.missionutils.Console;
import model.BaseballGame;

public class BaseballGameView implements GameView {
    private BaseballGame baseballGame;

    public BaseballGameView(BaseballGame baseballGame) {
        this.baseballGame = baseballGame;
    }

    @Override
    public String askKeyInput() {
        printGameState();

        if (baseballGame.isOnGoing()) {
            return askKeyInputForOnGoing();
        }
        return askKeyInputForGameEnd();
    }

    private String askKeyInputForOnGoing() {
        System.out.println("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    private String askKeyInputForGameEnd() {
        System.out.printf("%s개의 숫자를 모두 맞히셨습니다! 게임종료%n", BaseballGame.STRIKE_OUT);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }

    private void printGameState() {
        StringBuilder gameStateStrBuilder = new StringBuilder();

        setBallMessage(gameStateStrBuilder);
        setStrikeMessage(gameStateStrBuilder);

        System.out.println(gameStateStrBuilder);
    }

    private void setBallMessage(StringBuilder gameStateStrBuilder) {
        if (baseballGame.getBall() > 0) {
            gameStateStrBuilder.append(String.format("%s볼 ", baseballGame.getBall()));
        }
    }

    private void setStrikeMessage(StringBuilder gameStateStrBuilder) {
        if (baseballGame.getStrike() > 0) {
            gameStateStrBuilder.append(String.format("%s스트라이크", baseballGame.getStrike()));
        }
    }
}
