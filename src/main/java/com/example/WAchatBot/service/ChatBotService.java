package com.example.WAchatBot.service;

import org.springframework.stereotype.Service;

@Service
public class ChatBotService {

    public String processMessage(String incomingMessage) {

        String lowerCaseMessage = incomingMessage.toLowerCase().trim();

        if ("hi".equalsIgnoreCase(lowerCaseMessage) || "hello".equalsIgnoreCase(lowerCaseMessage)) {
            return "Hello! How can I help you today?";
        }
        else if ("bye".equalsIgnoreCase(lowerCaseMessage) || "goodbye".equalsIgnoreCase(lowerCaseMessage)) {
            return "Goodbye! Have a great day!";
        }
        else {
            return "Sorry, I didn't understand that. Can you please rephrase?";
        }
    }

}
