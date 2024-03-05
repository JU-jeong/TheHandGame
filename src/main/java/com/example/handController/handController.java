package com.example.handController;

@Controller
public class GameController {

    @PostMapping("/players")
    public String setPlayerCount(@RequestParam int count, Model model) {
        model.addAttribute("playerCount", count);
        return "redirect:/game";
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