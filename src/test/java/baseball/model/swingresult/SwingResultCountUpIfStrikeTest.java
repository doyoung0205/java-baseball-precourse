package baseball.model.swingresult;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import baseball.model.BaseBall;
import baseball.model.SwingResult;
import baseball.model.exception.IllegalBaseBallArgumentException;

@Tag("SwingResult")
@DisplayName("SwingResult countUpIfStrike 메서드 테스트")
public class SwingResultCountUpIfStrikeTest {
	private Method method;

	@BeforeEach
	void setUp() throws NoSuchMethodException {
		method = SwingResult.class.getDeclaredMethod("countUpIfStrike", BaseBall.class, int.class, int.class,
			int.class);
		method.setAccessible(true);
	}

	@ParameterizedTest(name = "스트라이크라면_스트라이크갯수를_증가한다")
	@CsvSource(value = {"123:1:0", "123:2:1", "123:3:2"}, delimiterString = ":")
	void 스트라이크라면_스트라이크갯수를_증가한다(final String textBaseBall, final int expectedNumber, final int bIndex) throws
		IllegalBaseBallArgumentException, InvocationTargetException, IllegalAccessException {
		final BaseBall baseBall = BaseBall.valueOf(textBaseBall);
		final int beforeStrikeCount = 0;
		final int afterStrikeCount = (int)method.invoke(BaseBall.class, baseBall, expectedNumber, bIndex,
			beforeStrikeCount);
		assertEquals(beforeStrikeCount + 1, afterStrikeCount);
	}

	@ParameterizedTest(name = "스트라이크가_아니라면_스트라이크갯수를_증가하지_않는다")
	@CsvSource(value = {"123:2:0", "123:3:1", "123:1:2"}, delimiterString = ":")
	void 스트라이크가_아니라면_스트라이크갯수를_증가한다(final String textBaseBall, final int expectedNumber, final int bIndex) throws
		IllegalBaseBallArgumentException, InvocationTargetException, IllegalAccessException {
		final BaseBall baseBall = BaseBall.valueOf(textBaseBall);
		final int beforeStrikeCount = 0;
		final int afterStrikeCount = (int)method.invoke(BaseBall.class, baseBall, expectedNumber, bIndex,
			beforeStrikeCount);
		assertEquals(beforeStrikeCount, afterStrikeCount);
	}

}
