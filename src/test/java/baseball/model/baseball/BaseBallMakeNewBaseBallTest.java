package baseball.model.baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import baseball.model.BaseBall;

@Tag("BaseBall")
@DisplayName("BaseBall makeNewBaseBall 메서드 테스트")
public class BaseBallMakeNewBaseBallTest {
	private Method method;

	@BeforeEach
	void setUp() throws NoSuchMethodException {
		method = BaseBall.class.getDeclaredMethod("makeNewBaseBall");
		method.setAccessible(true);
	}

	@Test
	void 투구번호는_크기가_3_이여야_한다() throws InvocationTargetException, IllegalAccessException {
		// given
		// when
		final int[] baseBall = (int[])method.invoke(BaseBall.class);
		// then
		assertEquals(baseBall.length, 3);
	}

	@Test
	void 투구번호는_1에서_9까지수를포함해야한다() throws InvocationTargetException, IllegalAccessException {
		// given
		final int[] baseBall = (int[])method.invoke(BaseBall.class);
		assertAll(() -> {
			for (int j : baseBall) {
				// when
				final boolean condition = 1 <= j && j <= 9;
				// then
				assertTrue(condition);
			}
		});
	}

	@Test
	void 투구번호는_중복된_수가_없어야_한다() throws InvocationTargetException, IllegalAccessException {
		// given
		final int[] baseBall = (int[])method.invoke(BaseBall.class);
		// when
		final Set<Integer> numberSet = new HashSet<>();
		for (int j : baseBall) {
			numberSet.add(j);
		}
		// then
		assertEquals(numberSet.size(), 3);

	}
}
