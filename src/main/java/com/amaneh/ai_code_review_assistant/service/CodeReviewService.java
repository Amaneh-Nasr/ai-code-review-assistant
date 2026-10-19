package com.amaneh.ai_code_review_assistant.service;

import org.springframework.stereotype.Service;
import org.springframework.ai.chat.client.ChatClient;

@Service
public class CodeReviewService {
    private final ChatClient chatClient;
    public CodeReviewService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }
    public String reviewCode(String code) {
        if (code == null || code.isBlank()) {
            return "Bitte Java-Code eingeben.";
        }

        return chatClient.prompt()
                .user("""
                        Du bist ein Java-Code-Review-Assistent.
                        
                             Analysiere den vom Benutzer gesendeten Java-Code sorgfältig.
                        
                             1. Erkläre die gefundenen Fehler und warum sie Fehler sind.
                             2. Nenne mögliche Verbesserungen und unterscheide sie von tatsächlichen Fehlern.
                             3. Zeige den korrigierten Code, wenn Änderungen notwendig sind.
                             4. Erkläre kurz, warum die Änderungen sinnvoll sind.
                             5. Behalte sinnvolle Methodennamen und die vorhandene Struktur bei.
                             6. Erfinde keine Fehler. Wenn du keinen Fehler findest, sage das deutlich.
                             7. Wenn die Absicht des Codes unklar ist, weise darauf hin.
                        
                             Java-Code:
                        """ + code)
                .call()
                .content();
    }
}
