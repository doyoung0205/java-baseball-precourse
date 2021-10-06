package baseball;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import nextstep.test.NSTest;
import nextstep.utils.Randoms;

public class ApplicationTest extends NSTest {
	@BeforeEach
	void beforeEach() {
		super.setUp();
	}

	@Test
	void 낫싱() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms
				.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(1, 3, 5);
			running("246");
			verify("낫싱");
		}
	}

	@Test
	void 스트라이크1() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms
				.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(5, 8, 9)
				.thenReturn(3, 5, 4)
				.thenReturn(9, 1, 4);
			running("482", "392", "963");
			verify("1스트라이크", "1스트라이크", "1스트라이크");
		}
	}

	@Test
	void 스트라이크1볼1() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms
				.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(1, 9, 5)
				.thenReturn(5, 4, 2)
				.thenReturn(3, 7, 4);
			running("139", "256", "471");
			verify("1스트라이크 1볼", "1스트라이크 1볼", "1스트라이크 1볼");
		}
	}

	@Test
	void 스트라이크1볼2() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms
				.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(5, 4, 2)
				.thenReturn(1, 8, 6)
				.thenReturn(4, 9, 5);
			running("452", "168", "594");
			verify("1스트라이크 2볼", "1스트라이크 2볼", "1스트라이크 2볼");
		}
	}

	@Test
	void 스트라이크2() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms
				.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(3, 2, 4)
				.thenReturn(2, 1, 4)
				.thenReturn(5, 8, 6);
			running("321", "514", "596");
			verify("2스트라이크", "2스트라이크", "2스트라이크");
		}
	}

	@Test
	void 스트라이크3() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms
				.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(1, 3, 5)
				.thenReturn(2, 4, 3)
				.thenReturn(8, 3, 7);
			running("135", "243", "837");
			verify("3스트라이크", "3스트라이크", "3스트라이크");
		}
	}

	@Test
	void 예상투구번호를_잘못입력했을때() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms
				.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(8, 3, 7);
			running("12jifjsad");
			verify("[ERROR] 1에서 9 까지의 수 3개를 입력해주세요. [12jifjsad]");
		}
	}

	@Test
	void 재시작을_잘못입력했을때() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms
				.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(8, 3, 7);
			running("837", "12jifjsad");
			verify("3스트라이크", "[ERROR] 잘못 입력하셨습니다. 1이나 2를 입력해주세요.");
		}
	}

	@Test
	void 게임종료_후_재시작() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(7, 1, 3)
				.thenReturn(5, 8, 9);
			run("713", "1", "597", "589", "2");
			verify("3스트라이크", "게임 끝", "1스트라이크 1볼");
		}
	}

	@Test
	void 게임종료_후_종료() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(7, 1, 3)
				.thenReturn(5, 8, 9);
			run("713", "1", "597", "589", "2");
			verify("3스트라이크", "게임 끝", "1스트라이크 1볼");
		}
	}

	@Test
	void 잘못입력후_3스트라이크_후_재시작_잘못입력_후_게임종료() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(7, 1, 3)
				.thenReturn(5, 8, 9);
			run("1sdkjai", "713", "1", "597", "589", "sdliajwlid", "2");
			verify("[ERROR] 1에서 9 까지의 수 3개를 입력해주세요. [1sdkjai]", "3스트라이크", "게임 끝", "1스트라이크 1볼",
				"[ERROR] 잘못 입력하셨습니다. 1이나 2를 입력해주세요.");
		}
	}

	@AfterEach
	void tearDown() {
		outputStandard();
	}

	@Override
	public void runMain() {
		Application.main(new String[] {});
	}
}
