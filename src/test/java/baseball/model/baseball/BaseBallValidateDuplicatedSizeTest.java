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
import baseball.model.exception.IllegalBaseBallArgumentException;

@Tag("BaseBall")
@DisplayName("BaseBall validateDuplicatedSize 메서드 테스트")
public class BaseBallValidateDuplicatedSizeTest {
	private Method method;

	@BeforeEach
	void setUp() throws NoSuchMethodException {
		method = BaseBall.class.getDeclaredMethod("validateDuplicatedSize", String.class);
		method.setAccessible(true);
	}

	@ParameterizedTest(name = "문자열_투구번호의_중복된_숫자가_있을_경우")
	@ValueSource(strings = {"112", "121", "344", "444", "181"})
	void 문자열_투구번호의_중복된_숫자가_있을_경우(final String testBaseBall) {
		// given
		// then
		assertThrows(IllegalBaseBallArgumentException.class, () -> {
			try {
				// when
				method.invoke(BaseBall.class, testBaseBall);
			} catch (InvocationTargetException e) {
				throw e.getCause();
			}
		});
	}

	@ParameterizedTest(name = "문자열_투구번호의_중복된_숫자가_없을_경우")
	@ValueSource(strings = {"123", "143", "654", "378", "837"})
	void 문자열_투구번호의_중복된_숫자가_없을_경우(final String testBaseBall) {
		// given
		// then
		assertDoesNotThrow(() -> {
			// when
			method.invoke(BaseBall.class, testBaseBall);
		});
	}
}
