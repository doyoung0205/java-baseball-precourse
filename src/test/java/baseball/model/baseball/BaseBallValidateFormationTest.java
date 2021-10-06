package baseball.model.baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import baseball.model.BaseBall;
import baseball.model.exception.IllegalBaseBallArgumentException;

@Tag("BaseBall")
@DisplayName("BaseBall validateFormation 메서드 테스트")
public class BaseBallValidateFormationTest {
	private Method method;

	@BeforeEach
	void setUp() throws NoSuchMethodException {
		method = BaseBall.class.getDeclaredMethod("validateFormation", String.class);
		method.setAccessible(true);
	}

	@ParameterizedTest(name = "문자열_투구번호가_1에서_9까지의_숫자3개로_이루어진_경우")
	@ValueSource(strings = {"123", "143", "654", "378", "837"})
	void 문자열_투구번호가_1에서_9까지의_숫자로_이루어진_경우(final String testBaseBall) {
		// given
		// when
		// then
		assertDoesNotThrow(() -> {
			method.invoke(BaseBall.class, testBaseBall);
		});
	}

	@ParameterizedTest(name = "문자열_투구번호가_1에서_9까지의_숫자로_이루어지지_않은_경우")
	@ValueSource(strings = {"000", "020", "033", "300", "330"})
	void 문자열_투구번호가_1에서_9까지의_숫자로_이루어지지_않은_경우(final String testBaseBall) {
		// given
		// then
		Assertions.assertThrows(IllegalBaseBallArgumentException.class, () -> {
			try {
				// when
				method.invoke(BaseBall.class, testBaseBall);
			} catch (InvocationTargetException e) {
				throw e.getCause();
			}
		});
	}

	@ParameterizedTest(name = "문자열_투구번호의_크기가_3보다_작은경우")
	@ValueSource(strings = {"12", "13", "65", "26", "92"})
	void 문자열_투구번호의_크기가_3보다_작은경우(final String testBaseBall) {
		// given
		// then
		Assertions.assertThrows(IllegalBaseBallArgumentException.class, () -> {
			try {
				// when
				method.invoke(BaseBall.class, testBaseBall);
			} catch (InvocationTargetException e) {
				throw e.getCause();
			}
		});
	}

	@ParameterizedTest(name = "문자열_투구번호의_크기가_3보다_큰경우")
	@ValueSource(strings = {"2563", "3851", "4739", "2815", "4932"})
	void 문자열_투구번호의_크기가_3보다_큰경우(final String testBaseBall) {
		// given
		// then
		Assertions.assertThrows(IllegalBaseBallArgumentException.class, () -> {
			try {
				// when
				method.invoke(BaseBall.class, testBaseBall);
			} catch (InvocationTargetException e) {
				throw e.getCause();
			}
		});
	}

	@ParameterizedTest(name = "문자열_투구번호의_구성이_숫자가_아닌경우")
	@ValueSource(strings = {"asdhfh212", "efsdf12", "12a", "49o", "391f", "ashdkjahsdkwd", "a", "가나다", "ßßß"})
	void 문자열_투구번호의_구성이_숫자가_아닌경우(final String testBaseBall) {
		// given
		// then
		Assertions.assertThrows(IllegalBaseBallArgumentException.class, () -> {
			try {
				// when
				method.invoke(BaseBall.class, testBaseBall);
			} catch (InvocationTargetException e) {
				throw e.getCause();
			}
		});
	}
}
