package baseball.model.swingresult;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import baseball.model.BaseBall;
import baseball.model.SwingResult;

@Tag("SwingResult")
@DisplayName("SwingResult validate 메서드 테스트")
public class SwingValidateTest {
	private Method method;

	@BeforeEach
	void setUp() throws NoSuchMethodException {
		method = SwingResult.class.getDeclaredMethod("validate", BaseBall.class, BaseBall.class);
		method.setAccessible(true);
	}

	@Test
	void 투구번호와_예상투구번호가_NULL_인경우_예외_발생() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			try {
				// when
				method.invoke(SwingResult.class, null, null);
			} catch (InvocationTargetException e) {
				throw e.getCause();
			}
		});
	}

	@Test
	void 투구번호가_NULL_인경우_예외_발생() {
		final BaseBall expectedBaseBall = BaseBall.getInstance();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			try {
				// when
				method.invoke(SwingResult.class, null, expectedBaseBall);
			} catch (InvocationTargetException e) {
				throw e.getCause();
			}
		});
	}

	@Test
	void 예상투구번호가_NULL_인경우_예외_발생() {
		final BaseBall baseBall = BaseBall.getInstance();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			try {
				// when
				method.invoke(SwingResult.class, baseBall, null);
			} catch (InvocationTargetException e) {
				throw e.getCause();
			}
		});
	}

	@Test
	void 투구번호와_예상투구번호가_NULL이_아닌_경우_예외가_발생하지_않는다() {
		final BaseBall baseBall = BaseBall.getInstance();
		final BaseBall expectedBaseBall = BaseBall.getInstance();
		Assertions.assertDoesNotThrow(() -> {
			method.invoke(SwingResult.class, baseBall, expectedBaseBall);
		});
	}
}
