package baseball.model;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("BaseBallConstants")
@DisplayName("BaseBallConstantsTest 상수값 테스트")
class BaseBallConstantsTest {

	@Test
	void 투구번호의_값중_최솟값은_1이다() throws NoSuchFieldException {
		// given
		Field reader = BaseBallConstants.class.getDeclaredField("MIN_NUMBER");
		reader.setAccessible(true);
		// when
		// then
		assertEquals(BaseBallConstants.MIN_NUMBER, 1);
	}

	@Test
	void 투구번호의_값중_최댓값은_9이다() throws NoSuchFieldException {
		// given
		Field reader = BaseBallConstants.class.getDeclaredField("MAX_NUMBER");
		reader.setAccessible(true);
		// when
		// then
		assertEquals(BaseBallConstants.MAX_NUMBER, 9);
	}

	@Test
	void 투구번호의_크기는_3이다() throws NoSuchFieldException {
		// given
		Field reader = BaseBallConstants.class.getDeclaredField("SIZE");
		reader.setAccessible(true);
		// when
		// then
		assertEquals(BaseBallConstants.SIZE, 3);
	}
}
