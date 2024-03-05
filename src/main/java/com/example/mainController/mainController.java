package com.example.mainController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class mainController {
    private Game game;

    // 플레이어 수 입력을 위한 엔드포인트
    @PostMapping("/players")
    public ResponseEntity<String> setPlayerCount(@RequestParam int count) {
        if (count < 2 || count > 5) {
            return ResponseEntity.badRequest().body("플레이어 수는 2부터 5까지 입력하세요.");
        }

        game = new Game(count);
        return ResponseEntity.ok("플레이어 수가 설정되었습니다.");
    }

    // 게임 실행을 위한 엔드포인트
    @PostMapping("/play")
    public ResponseEntity<String> playGame() {
        if (game == null) {
            return ResponseEntity.badRequest().body("플레이어 수를 먼저 설정하세요.");
        }

        while (!game.isGameOver()) {
            game.playerTurnMethod();
            if (game.isGameOver()) {
                break;
            }
            game.opponentTurnMethod();
        }

        return ResponseEntity.ok("게임이 종료되었습니다.");
    }
}