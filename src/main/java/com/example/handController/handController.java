package com.example.handController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

@Controller
public class handController {

    private static final Logger logger = LoggerFactory.getLogger(handController.class);

    @PostMapping("/players")
    public String setPlayerCount(@RequestBody PlayerCountRequest request, Model model) {
        int count = request.getCount();
        logger.info("Received player count: " + count);
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
            handImages.add("hand_image_" + i + ".png");
        }
        return handImages;
    }

    // Assuming you have a PlayerCountRequest class that maps the JSON object
    public static class PlayerCountRequest {
        private int count;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}