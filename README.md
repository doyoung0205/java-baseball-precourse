# 숫자 야구 게임

## 진행 방법

* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정

* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

---

## 기능 요구 사항

* 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.

* 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.

    * [예] 상대방(컴퓨터)의 수가 425일 때, 123을 제시한 경우: 1스트라이크, 456을 제시한 경우: 1스트라이크 1볼, 789를 제시한 경우: 낫싱

* 위 숫자 야구게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한
  결과를 출력한다.

* 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.

* 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다

## 용어 사전

| 한글명 | 영문명 | 설명 |
| ---------- | :--------- | :---------- |
| 게임 | game | 숫자 야구 게임 |
| 상대방 | pitcher | 플레이어에게 투구번호를 제시하는 게임 참여자  |
| 플레이어 | player | 상대방의 제시한 투구번호를 맞추는 게임 참여자 |
| 플레이 | play | 게임 을 시작하는 행위 |
| 투구번호 | baseBalls | 플레이어가 맞춰야 하는 1~9개의 임의의 숫자 3개 |
| 스윙 | swing | 플레이어가 1~9개의 임의의 숫자 3개를 이용해 투구번호를 맞추는 행위 |
| 스윙결과 | swingResult | 플레이어의 스윙 결과 <br/> [예] 상대방(컴퓨터)의 수가 425일 때<br/> 123을 제시한 경우: 1스트라이크<br/>  456을 제시한 경우: 1스트라이크 1볼<br/> 789를 제시한 경우: 낫싱 |
| 스트라이크 | strike | 투구번호와 같은 수가 같은 자리에 있는 경우 |
| 볼 | ball | 투구번호와 같은 수가 다른 자리에 있는 경우 |
| 낫싱 | nothing | 투구번호와 같은 수가 전혀 없는 경우 |

## 구현 할 기능 목록

- [ ] **상대방은 게임을 투구번호를 생성해 플레이 할 수 있다.**
    - [ ] 투구번호는 1~9개의 임의의 숫자 3개로 구성되어 있다.
- [ ] **플레이어는 Console 을 통해서 스윙을 할 수 있다.**
    - [ ] Console 에 "숫자를 입력해 주세요 : " 안내 메시지가 조회된다.
    - [ ] 예상 투구번호는 1~9개의 임의의 숫자 3개를 입력할 수 있다.
- [ ] **플레이어는 스윙결과를 Console 을 통해서 확인 할 수 있다.**
- [ ] **플레이어는 스윙 결과가 `3 스트라이크 ` 인 경우, 게임이 종료되며 플레이어는 게임을 시작 여부를 선택 할 수 있다.**
    - [ ] Console 에 다음 과 같은 메시지를 보여준다. <br>
      "3개의 숫자를 모두 맞히셨습니다! 게임끝 <br>
      게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
    - [ ] 1 을 입력 할 경우, 게임을 새로 시작한다. <br/>
    - [ ] 2 를 입력 할 경우, 게임이 완전히 종료 된다.
    - [ ] 그 외의 다른 내용을 입력을 할 경우, 다음과 같은 메시지를 보여준다. <br>
      "잘못 입력 하였습니다. <br>
      게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
- [ ] **플레이어는 스윙 결과가 3 스트라이크가 아닌 경우, 다시 스윙을 한다.**

