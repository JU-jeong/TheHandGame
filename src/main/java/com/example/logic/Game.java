package com.example.logic;

public class Game {
    private final int playerCount;
    private final int gameCounter;

    public Game(int playerCount) {
        this.playerCount = playerCount;
        this.gameCounter = 0;
    }

    // 2-A의 메서드
    public void playerTurnMethod() {
        // Implement player's turn logic here
    }

    // 2-B의 메서드
    public void opponentTurnMethod() {
        // Implement opponent's turn logic here
    }

    // 게임 종료 여부 확인
    public boolean isGameOver() {
        return gameCounter == 1 || gameCounter == playerCount;
    }
}
