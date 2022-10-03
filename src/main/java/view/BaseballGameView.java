package view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import model.BaseballGame;

public class BaseballGameView implements GameView {
    public static class Key {
        public static String NEW_GAME = "1";
        public static String GAME_STOP = "2";
    }

    private final BaseballGame baseballGame;

    public BaseballGameView(BaseballGame baseballGame) {
        this.baseballGame = baseballGame;
    }

    @Override
    public String askKeyInput() {
        if (baseballGame.isPlayerWin()) {
            return askKeyInputForGameEnd();
        }
        return askKeyInputForOnGoing();
    }

    @Override
    public void printGameState() {
        StringBuilder gameStateStrBuilder = new StringBuilder();
        setBallMessage(gameStateStrBuilder);
        setStrikeMessage(gameStateStrBuilder);
        setNothingMessage(gameStateStrBuilder);

        System.out.println(gameStateStrBuilder);
    }

    private String askKeyInputForOnGoing() {
        System.out.print("숫자를 입력해주세요 : ");
        return readLine();
    }

    private String askKeyInputForGameEnd() {
        System.out.printf("%s개의 숫자를 모두 맞히셨습니다! 게임 종료\n", BaseballGame.MAX_STRIKE_COUNT);
        System.out.printf("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.\n", Key.NEW_GAME, Key.GAME_STOP);

        return readLine();
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

    private void setNothingMessage(StringBuilder gameStateStrBuilder) {
        if (baseballGame.isNothing()) {
            gameStateStrBuilder.append("낫싱");
        }
    }
}
