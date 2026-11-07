package org.example.aichatbot;


import org.example.aichatbot.aitools.CalculatorTool;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatService {
    private final ChatClient chatClient;
    private final CalculatorTool calculatorTool;
    private final List<Message> history =  new ArrayList<>();

    private static final String SYSTEM_PROMPT = """
            You are a helpful AI assistant with access to the external tools 
            Follow these rules:
            1. For arithmetic operations always use calculator tool
            2. After receiving the result explain it naturally.
            """;

    public ChatService(ChatClient.Builder builder,CalculatorTool calculatorTool) {
        this.chatClient = builder.build();
        this.calculatorTool = calculatorTool;
    }

    public String chat(String message) {
        history.add(new UserMessage(message));
        String response = chatClient.prompt()
                .system(SYSTEM_PROMPT)
                .messages(history)
                .tools(calculatorTool)
                .call().content();

        history.add(new AssistantMessage(response));
        return response;
    }
    public void clearHistory() {
        history.clear();
    }
}
