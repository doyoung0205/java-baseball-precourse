package baseball.model.swingresult;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import baseball.model.BaseBall;
import baseball.model.SwingResult;
import baseball.model.exception.IllegalBaseBallArgumentException;

@Tag("SwingResult")
@DisplayName("SwingResult valueOf 메서드 테스트")
public class SwingValueOfTest {

	@ParameterizedTest
	@CsvSource(value = {"175:249", "123:456", "749:153", "192:384"}, delimiterString = ":")
	void 스윙결과가_낫싱인_경우(final String textBaseBall, final String expectedTextBaseBall) throws
		IllegalBaseBallArgumentException {
		// given
		final BaseBall baseBall = BaseBall.valueOf(textBaseBall);
		final BaseBall expectedBaseBall = BaseBall.valueOf(expectedTextBaseBall);
		final SwingResult swingResult = SwingResult.valueOf(baseBall, expectedBaseBall);
		// when
		final int strikeCount = swingResult.getStrikeCount();
		final int ballCount = swingResult.getBallCount();
		// then
		assertAll(() -> {
			assertEquals(strikeCount, 0);
			assertEquals(ballCount, 0);
		});
	}

	// 1스트라이크
	@ParameterizedTest
	@CsvSource(value = {"175:123", "123:924", "749:159", "192:342"}, delimiterString = ":")
	void 스윙결과가_1스트라이크_인경우(final String textBaseBall, final String expectedTextBaseBall) throws
		IllegalBaseBallArgumentException {
		// given
		final BaseBall baseBall = BaseBall.valueOf(textBaseBall);
		final BaseBall expectedBaseBall = BaseBall.valueOf(expectedTextBaseBall);
		final SwingResult swingResult = SwingResult.valueOf(baseBall, expectedBaseBall);
		// when
		final int strikeCount = swingResult.getStrikeCount();
		final int ballCount = swingResult.getBallCount();
		// then
		assertAll(() -> {
			assertEquals(strikeCount, 1);
			assertEquals(ballCount, 0);
		});
	}

	// 1스트라이크 1볼
	@ParameterizedTest
	@CsvSource(value = {"175:574", "123:293", "749:419", "192:972"}, delimiterString = ":")
	void 스윙결과가_1스트라이크_1볼_인경우(final String textBaseBall, final String expectedTextBaseBall) throws
		IllegalBaseBallArgumentException {
		// given
		final BaseBall baseBall = BaseBall.valueOf(textBaseBall);
		final BaseBall expectedBaseBall = BaseBall.valueOf(expectedTextBaseBall);
		final SwingResult swingResult = SwingResult.valueOf(baseBall, expectedBaseBall);
		// when
		final int strikeCount = swingResult.getStrikeCount();
		final int ballCount = swingResult.getBallCount();
		// then
		assertAll(() -> {
			assertEquals(strikeCount, 1);
			assertEquals(ballCount, 1);
		});
	}

	// 1스트라이크 2볼
	@ParameterizedTest
	@CsvSource(value = {"175:157", "123:321", "749:794", "192:291"}, delimiterString = ":")
	void 스윙결과가_1스트라이크_2볼_인경우(final String textBaseBall, final String expectedTextBaseBall) throws
		IllegalBaseBallArgumentException {
		// given
		final BaseBall baseBall = BaseBall.valueOf(textBaseBall);
		final BaseBall expectedBaseBall = BaseBall.valueOf(expectedTextBaseBall);
		final SwingResult swingResult = SwingResult.valueOf(baseBall, expectedBaseBall);
		// when
		final int strikeCount = swingResult.getStrikeCount();
		final int ballCount = swingResult.getBallCount();
		// then
		assertAll(() -> {
			assertEquals(strikeCount, 1);
			assertEquals(ballCount, 2);
		});
	}

	// 2스트라이크
	@ParameterizedTest
	@CsvSource(value = {"175:173", "123:523", "749:789", "192:892"}, delimiterString = ":")
	void 스윙결과가_2스트라이크_인경우(final String textBaseBall, final String expectedTextBaseBall) throws
		IllegalBaseBallArgumentException {
		// given
		final BaseBall baseBall = BaseBall.valueOf(textBaseBall);
		final BaseBall expectedBaseBall = BaseBall.valueOf(expectedTextBaseBall);
		final SwingResult swingResult = SwingResult.valueOf(baseBall, expectedBaseBall);
		// when
		final int strikeCount = swingResult.getStrikeCount();
		final int ballCount = swingResult.getBallCount();
		// then
		assertAll(() -> {
			assertEquals(strikeCount, 2);
			assertEquals(ballCount, 0);
		});
	}

	// 3스트라이크
	@ParameterizedTest
	@CsvSource(value = {"175:175", "123:123", "749:749", "192:192"}, delimiterString = ":")
	void 스윙결과가_3스트라이크_인경우(final String textBaseBall, final String expectedTextBaseBall) throws
		IllegalBaseBallArgumentException {
		// given
		final BaseBall baseBall = BaseBall.valueOf(textBaseBall);
		final BaseBall expectedBaseBall = BaseBall.valueOf(expectedTextBaseBall);
		final SwingResult swingResult = SwingResult.valueOf(baseBall, expectedBaseBall);
		// when
		final int strikeCount = swingResult.getStrikeCount();
		final int ballCount = swingResult.getBallCount();
		// then
		assertAll(() -> {
			assertEquals(strikeCount, 3);
			assertEquals(ballCount, 0);
		});
	}

	// 3볼
	@ParameterizedTest
	@CsvSource(value = {"175:517", "123:312", "749:974", "192:219"}, delimiterString = ":")
	void 스윙결과가_3볼_인경우(final String textBaseBall, final String expectedTextBaseBall) throws
		IllegalBaseBallArgumentException {
		// given
		final BaseBall baseBall = BaseBall.valueOf(textBaseBall);
		final BaseBall expectedBaseBall = BaseBall.valueOf(expectedTextBaseBall);
		final SwingResult swingResult = SwingResult.valueOf(baseBall, expectedBaseBall);
		// when
		final int strikeCount = swingResult.getStrikeCount();
		final int ballCount = swingResult.getBallCount();
		// then
		assertAll(() -> {
			assertEquals(strikeCount, 0);
			assertEquals(ballCount, 3);
		});
	}

}
