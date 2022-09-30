package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BaseballGameTest {
    @ParameterizedTest
    @CsvSource(value = {"123,321,TRUE", "123,123,FALSE"}, delimiter = ',')
    void 게임이_진행중인지_테스트(String answer, String guess, boolean expected) {
        // arrange
        List<Integer> answers = toList(answer);
        List<Integer> guesses = toList(guess);

        // act
        BaseballGame baseballGame = new BaseballGame(answers, guesses);

        // assert
        assertThat(baseballGame.isOnGoing()).isEqualTo(expected);
    }

    private List<Integer> toList(String str) {
        List<Integer> integers = new ArrayList<>();
        for (char c : str.toCharArray()) {
            integers.add(Character.getNumericValue(c));
        }
        return integers;
    }
}