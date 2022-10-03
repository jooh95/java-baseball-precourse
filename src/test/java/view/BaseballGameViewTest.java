package view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import model.BaseballGame;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import utils.TestUtils;

class BaseballGameViewTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @ParameterizedTest
    @CsvSource(value = {"123,321,2볼 1스트라이크", "123,123,3스트라이크"}, delimiter = ',')
    void 게임상태_정상출력_테스트(String answer, String guess, String expected) {
        // arrange
        BaseballGame baseballGame = arrangeBaseballGame(answer, guess);
        arrangeScannerInput();

        // act
        BaseballGameView baseballGameView = new BaseballGameView(baseballGame);
        baseballGameView.askKeyInput();

        // assert
        assertThat(outContent.toString()).contains(expected);
    }

    @Test
    void 전부_맞춘_경우_게임종료_메시지_정상출력_테스트() {
        // arrange
        BaseballGame baseballGame = arrangeBaseballGame("123", "123");
        arrangeScannerInput();

        // act
        BaseballGameView baseballGameView = new BaseballGameView(baseballGame);
        baseballGameView.askKeyInput();

        // assert
        assertThat(outContent.toString()).contains("게임종료");
    }

    private void arrangeScannerInput() {
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
    }

    private BaseballGame arrangeBaseballGame(String answer, String guess) {
        List<Integer> answers = TestUtils.toList(answer);
        List<Integer> guesses = TestUtils.toList(guess);
        return BaseballGame.play(answers, guesses);
    }
}
