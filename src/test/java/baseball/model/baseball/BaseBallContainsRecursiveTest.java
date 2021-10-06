package baseball.model.baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import baseball.model.BaseBall;

@Tag("BaseBall")
@DisplayName("BaseBall containsRecursive 메서드 테스트")
public class BaseBallContainsRecursiveTest {
	private Method method;

	@BeforeEach
	void setUp() throws NoSuchMethodException {
		method = BaseBall.class.getDeclaredMethod("containsRecursive", int[].class, int.class, int.class, int.class);
		method.setAccessible(true);
	}

	@ParameterizedTest(name = "인덱스를_알_수_있는_경우")
	@CsvSource(value = {"1:0", "2:1", "3:2"}, delimiter = ':')
	void 같은_값이_포함되어_있다면_투구번호의_인덱스를_알_수_있다(final int number, final int expectedIndex) throws
		InvocationTargetException,
		IllegalAccessException {
		// given
		int[] baseBall = {1, 2, 3};
		int start = 0;
		int end = baseBall.length - 1;
		// when
		final int index = (int)method.invoke(BaseBall.class, baseBall, number, start, end);
		// then
		assertEquals(index, expectedIndex);
	}

	@ParameterizedTest(name = "인덱스를_알_수_없는_경우")
	@CsvSource(value = {"5:-1", "6:-1", "7:-1", "8:-1", "9:-1"}, delimiter = ':')
	void 같은_값이_포함되어_있지_않다면_투구번호의_인덱스를_알_수_없다(final int number, final int expectedIndex) throws
		InvocationTargetException,
		IllegalAccessException {
		// given
		int[] baseBall = {1, 2, 3};
		int start = 0;
		int end = baseBall.length - 1;
		// when
		final int index = (int)method.invoke(BaseBall.class, baseBall, number, start, end);
		// then
		assertEquals(index, expectedIndex);
	}

	@ParameterizedTest(name = "포함여부_탐색시_시작범위가_마지막범위보다_일_경우_-1_반환")
	@CsvSource(value = {"5:-1", "2:1", "999:0"}, delimiter = ':')
	void 포함여부_탐색시_시작범위가_마지막범위보다_일_경우(final int start, final int end) throws
		InvocationTargetException,
		IllegalAccessException {
		// given
		int[] baseBall = {1, 2, 3};
		int number = 1;
		// when
		final int index = (int)method.invoke(BaseBall.class, baseBall, number, start, end);
		// then
		assertEquals(index, -1);
	}

	@ParameterizedTest(name = "포함여부_탐색시_탐생할_범위가_투구번호배열보다_큰_경우_예외발생")
	@CsvSource(value = {"1:4", "3:4"}, delimiter = ':')
	void 포함여부_탐색시_탐생할_범위가_투구번호배열보다_큰_경우_예외발생(final int start, final int end) throws
		InvocationTargetException,
		IllegalAccessException {
		// then
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			// given
			int[] baseBall = {1, 2, 3};
			int number = 1;
			try {
				// when
				method.invoke(BaseBall.class, baseBall, number, start, end);
			} catch (InvocationTargetException e) {
				throw e.getCause();
			}
		});
	}

}
