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
@DisplayName("BaseBall addIfNotContains 메서드 테스트")
public class BaseBallAddIfNotContainsTest {
	private Method method;

	@BeforeEach
	void setUp() throws NoSuchMethodException {
		method = BaseBall.class.getDeclaredMethod("addIfNotContains", int[].class, int.class, int.class);
		method.setAccessible(true);
	}

	@ParameterizedTest(name = "같은_값이_포함되어_있지않다면_투구번호의_값을_추가할_수_있다")
	@ValueSource(ints = {3, 4, 5, 5, 6, 7, 8, 9, 10})
	void 같은_값이_포함되어_있지않다면_투구번호의_값을_추가할_수_있다(final int number) throws InvocationTargetException, IllegalAccessException {
		// given
		int[] baseBall = {1, 2, 0};
		int insertAt = 2;
		// when
		final int index = (int)method.invoke(BaseBall.class, baseBall, insertAt, number);
		// then
		assertAll(() -> {
			assertEquals(index, insertAt + 1);
			assertEquals(baseBall[insertAt], number);
		});
	}

	@ParameterizedTest(name = "같은_값이_포함되어_있다면_투구번호의_값을_추가할_수_없다")
	@ValueSource(ints = {1, 2})
	void 같은_값이_포함되어_있다면_투구번호의_값을_추가할_수_없다(final int number) throws InvocationTargetException, IllegalAccessException {
		// given
		int[] baseBall = {1, 2, 0};
		int insertAt = 2;
		// when
		final int index = (int)method.invoke(BaseBall.class, baseBall, insertAt, number);
		// then
		assertAll(() -> {
			assertEquals(index, insertAt);
			assertEquals(baseBall[insertAt], 0);
		});
	}
}
