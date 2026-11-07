package org.example.aichatbot;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class SummarizeService {

    public SummarizeService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    private final ChatClient chatClient;
    public String summarize(String ticket) {
        return chatClient.prompt()
                .system("You are a helpful support ticket assistant. " +
                        "Summarize support tickets clearly and concisely." +
                        "Include the problem and the requested action.")
                .user(ticket)
                .call().content();
    }

}
