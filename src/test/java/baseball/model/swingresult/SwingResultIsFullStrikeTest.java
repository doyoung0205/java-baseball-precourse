package baseball.model.swingresult;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import baseball.model.BaseBall;
import baseball.model.SwingResult;
import baseball.model.exception.IllegalBaseBallArgumentException;

@Tag("SwingResult")
@DisplayName("SwingResult isFullStrike 메서드 테스트")
public class SwingResultIsFullStrikeTest {

	@Test
	void 전부스트라이크_라면_TRUE_를_반환합니다() throws IllegalBaseBallArgumentException {
		// given
		final BaseBall baseBall = BaseBall.valueOf("123");
		final BaseBall expectedBaseBall = BaseBall.valueOf("123");
		final SwingResult swingResult = SwingResult.valueOf(baseBall, expectedBaseBall);
		// when
		final boolean fullStrike = swingResult.isFullStrike();
		// then
		assertTrue(fullStrike);
	}

	@ParameterizedTest
	@CsvSource(value = {"123:213", "123:356", "123:329", "123:128"}, delimiterString = ":")
	void 전부스트라이크_아니라면_FLASE_를_반환합니다(final String textBaseBall, final String expectedTextBaseBall) throws
		IllegalBaseBallArgumentException {
		// given
		final BaseBall baseBall = BaseBall.valueOf(textBaseBall);
		final BaseBall expectedBaseBall = BaseBall.valueOf(expectedTextBaseBall);
		final SwingResult swingResult = SwingResult.valueOf(baseBall, expectedBaseBall);
		// when
		final boolean fullStrike = swingResult.isFullStrike();
		// then
		assertFalse(fullStrike);
	}
}
