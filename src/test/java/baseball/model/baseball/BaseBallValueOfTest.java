package baseball.model.baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import baseball.model.BaseBall;
import baseball.model.exception.IllegalBaseBallArgumentException;

@Tag("BaseBall")
@DisplayName("BaseBall valueOf 메서드 테스트")
public class BaseBallValueOfTest {

	@Test
	void 텍스트로부터_투구번호를_생성한다() throws IllegalBaseBallArgumentException {
		final String textBaseBall = "123";
		final BaseBall baseBall = BaseBall.valueOf(textBaseBall);

		assertAll(() -> {
			// 길이 확인
			assertEquals(baseBall.length(), textBaseBall.length());
			// 구성 확인
			assertEquals(baseBall.getAt(0), Character.getNumericValue(textBaseBall.charAt(0)));
			assertEquals(baseBall.getAt(1), Character.getNumericValue(textBaseBall.charAt(1)));
			assertEquals(baseBall.getAt(2), Character.getNumericValue(textBaseBall.charAt(2)));
			// 인덱스 확인
			assertEquals(0, baseBall.indexOf(1));
			assertEquals(1, baseBall.indexOf(2));
			assertEquals(2, baseBall.indexOf(3));
		});
	}
}
