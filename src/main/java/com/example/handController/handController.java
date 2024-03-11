package com.example.handController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

@Controller
public class handController {

    @PostMapping("/players")
    public String setPlayerCount(@RequestParam int count, Model model) {
        model.addAttribute("playerCount", count);
        return "redirect:main2.html";
    }

    @GetMapping("/game")
    public String showGamePage(@ModelAttribute("playerCount") int playerCount, Model model) {
        model.addAttribute("handImages", generateHandImages(playerCount));
        return "game";
    }

    private List<String> generateHandImages(int playerCount) {
        List<String> handImages = new ArrayList<>();
        for (int i = 0; i < playerCount * 2; i++) {
            handImages.add("hand_image_" + i + ".png"); // 이미지 파일명은 hand_image_0.png, hand_image_1.png, ...
        }
        return handImages;
    }
}