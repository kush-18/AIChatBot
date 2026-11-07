package org.example.aichatbot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ChatController {

    private final ChatService summarizeService;
    @Autowired
    public ChatController(ChatService summarizeService) {
        this.summarizeService = summarizeService;
    }

    @PostMapping("/chat")
    public String summarize(@RequestBody String ticket) {
        return summarizeService.chat(ticket);
    }


}
