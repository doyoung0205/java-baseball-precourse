package baseball.model.baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import baseball.model.BaseBall;

@Tag("BaseBall")
@DisplayName("BaseBall contains 메서드 테스트")
public class BaseBallContainsTest {
	private Method method;

	@BeforeEach
	void setUp() throws NoSuchMethodException {
		method = BaseBall.class.getDeclaredMethod("contains", int[].class, int.class, int.class);
		method.setAccessible(true);
	}

	@ParameterizedTest(name = "해당_투구번호의_값의_포함될_경우")
	@ValueSource(ints = {1, 3, 5})
	void 해당_투구번호의_값의_포함될_경우(final int number) throws InvocationTargetException, IllegalAccessException {
		// given
		final int[] baseBall = {1, 3, 5};
		final int range = baseBall.length - 1;
		// when
		final boolean result = (boolean)method.invoke(BaseBall.class, baseBall, number, range);
		// then
		assertTrue(result);
	}

	@ParameterizedTest(name = "해당_투구번호의_값의_포함되지 않을 경우")
	@ValueSource(ints = {4, 66, 6, -1, 99, 1000, 10000000})
	void 해당_투구번호의_값의_포함되지_않을_경우(final int number) throws InvocationTargetException, IllegalAccessException {
		// given
		final int[] baseBall = {2, 3, 1};
		final int range = baseBall.length - 1;
		// when
		final boolean result = (boolean)method.invoke(BaseBall.class, baseBall, number, range);
		// then
		assertFalse(result);
	}
}
