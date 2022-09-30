package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import utils.TestUtils;

class BaseballGameTest {
    @ParameterizedTest
    @CsvSource(value = {"123,321,TRUE", "123,123,FALSE"}, delimiter = ',')
    void 게임이_진행중인지_테스트(String answer, String guess, boolean expected) {
        // arrange
        List<Integer> answers = TestUtils.toList(answer);
        List<Integer> guesses = TestUtils.toList(guess);

        // act
        BaseballGame baseballGame = new BaseballGame(answers, guesses);

        // assert
        assertThat(baseballGame.isOnGoing()).isEqualTo(expected);
    }
}