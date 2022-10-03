package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import utils.TestUtils;

class BaseballGameTest {
    @DisplayName("사용자가_모든_숫자를_다_찾았는지_테스트")
    @ParameterizedTest
    @CsvSource(value = {"123,321,FALSE", "123,123,TRUE"}, delimiter = ',')
    void isPlayerWin(String answer, String guess, boolean expected) {
        // arrange
        List<Integer> answers = TestUtils.toList(answer);
        List<Integer> guesses = TestUtils.toList(guess);

        // act
        BaseballGame baseballGame = BaseballGame.play(answers, guesses);

        // assert
        assertThat(baseballGame.isPlayerWin()).isEqualTo(expected);
    }

    @DisplayName("숫자를_하나도_못맞춘_경우_테스트")
    @ParameterizedTest
    @CsvSource(value = {"123,456,TRUE", "456,451,FALSE", "987,987,FALSE"}, delimiter = ',')
    void isNothing(String answer, String guess, boolean expected) {
        // arrange
        List<Integer> answers = TestUtils.toList(answer);
        List<Integer> guesses = TestUtils.toList(guess);

        // act
        BaseballGame baseballGame = BaseballGame.play(answers, guesses);

        // assert
        assertThat(baseballGame.isNothing()).isEqualTo(expected);
    }

    @DisplayName("새로운_게임을_시작한경우_테스트")
    @Test
    void newGame() {
        // act
        BaseballGame baseballGame = BaseballGame.newGame();

        // assert
        assertThat(baseballGame.getStrike()).isEqualTo(0);
        assertThat(baseballGame.getBall()).isEqualTo(0);
    }

    @DisplayName("게임이_종료된_경우_테스트")
    @Test
    void isContinue() {
        // act
        BaseballGame baseballGame = BaseballGame.END;

        // assert
        assertThat(baseballGame.isContinue()).isEqualTo(false);
    }

    @DisplayName("볼_스트라이크_낫싱_로직_테스트")
    @ParameterizedTest
    @CsvSource(value = {"123,456,0,0", "456,461,1,1", "456,451,2,0", "987,987,3,0"},
        delimiter = ',')
    void newGame(String answer, String guess, int strike, int ball) {
        // arrange
        List<Integer> answers = TestUtils.toList(answer);
        List<Integer> guesses = TestUtils.toList(guess);

        // act
        BaseballGame baseballGame = BaseballGame.play(answers, guesses);

        // assert
        assertThat(baseballGame.getStrike()).isEqualTo(strike);
        assertThat(baseballGame.getBall()).isEqualTo(ball);
    }
}