package com.example.logic;

import java.util.Random;

public class Game {
    private final int playerCount;
    private int gameCounter;

    public Game(int playerCount) {
        this.playerCount = playerCount;
        this.gameCounter = 0;
    }

    // 본인 차례일 경우의 메서드
    public void playerTurnMethod() {
        // 2-A-1. 1에서 입력한 수에서 2를 곱한 수에서부터 0까지 내림차순으로 번호가 새겨진 자연수들의 버튼을 화면 중앙에 띄우고, 그것을 누르면 값이 결정된다.
        int value = playerCount * 2 - gameCounter;

        // 2-A-2. 2-A-1에서 입력한 값을 화면 위 중앙에 띄운 후, 0,1,2 3개의 숫자가 새겨진 버튼을 화면 중앙에 띄우고, 그것을 누르면 값이 결정된다.
        int selectedValue = getUserInput();

        // 2-A-3. 0,1,2의 숫자를 랜덤으로 호출하는 메서드를 1번에서 입력받은 플레이어의 수만큼 비동기적으로 실행하여 그 결과를 합산한다.
        int randomValue = getRandomValue(playerCount);

        // 2-A-4. 2-A-2에서 결정한 값과 2-A-3에서 합산된 값을 더해 나온 값이 2-A-1과 같다면, 게임 종료 카운터를 1 올린 후, 승리 메시지를 출력 후 게임을 종료한다.
        if (selectedValue + randomValue == value) {
            gameCounter++;
            System.out.println("You win!");
        }
    }

    // 상대 차례일 경우의 메서드
    public void opponentTurnMethod() {
        // 2-B-1. 1에서 입력한 수에서 2를 곱한 수에서부터 0까지 범위의 자연수 중 임의의 수를 화면 위 중앙에 띄운다.
        int value = getRandomValue(playerCount * 2);

        // 2-B-2. 0,1,2 3개의 숫자가 새겨진 버튼을 화면 중앙에 띄우고, 그것을 누르면 값이 결정된다.
        int selectedValue = getUserInput();

        // 2-B-3. 0,1,2의 숫자를 랜덤으로 호출하는 메서드를 1번에서 입력받은 플레이어의 수만큼 비동기적으로 실행하여 그 결과를 합산한다.
        int randomValue = getRandomValue(playerCount);

        // 2-B-4. 2-B-2에서 결정한 값과 2-B-3에서 합산된 값을 더해 나온 값이 2-B-1과 같다면, 게임 종료 카운터를 1 내리고 다음 메서드의 실행으로 넘어간다.
        if (selectedValue + randomValue == value) {
            gameCounter--;
        }

        // 1바퀴 순회 후 게임 종료 카운터가 0이 아니라면 다음 메서드의 순회에서 2-B의 실행횟수를 1 줄여서 같은 순번으로 실행한다.
        if (gameCounter != 0) {
            opponentTurnMethod();
        }
    }

    // 사용자 입력 받기 (임의로 구현)
    private int getUserInput() {
        Random random = new Random();
        return random.nextInt(3); // 0, 1, 2 중 하나 반환
    }

    // 임의의 값 반환하기 (임의로 구현)
    private int getRandomValue(int maxValue) {
        Random random = new Random();
        return random.nextInt(maxValue + 1); // 0부터 maxValue까지의 임의의 값 반환
    }

    public boolean isGameOver() {
        return false;
    }

    public int getGameCounter() {
        return 0;
    }
}