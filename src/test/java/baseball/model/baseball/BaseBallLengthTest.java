package baseball.model.baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import baseball.model.BaseBall;

@Tag("BaseBall")
@DisplayName("BaseBall length 메서드 테스트")
public class BaseBallLengthTest {

	@Test
	void 투구번호의_길이는_3이다() {
		// given
		final BaseBall baseBall = BaseBall.getInstance();
		// when
		final int length = baseBall.length();
		// then
		assertEquals(length, 3);
	}
}
