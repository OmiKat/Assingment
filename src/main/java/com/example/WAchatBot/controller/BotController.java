package com.example.WAchatBot.controller;

import com.example.WAchatBot.model.BotReply;
import com.example.WAchatBot.model.IncomingMessage;
import com.example.WAchatBot.service.ChatBotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BotController {

    private final ChatBotService chatBotService;

    @PostMapping("/webhook")
    public ResponseEntity<BotReply> receiveMessage(@RequestBody  IncomingMessage message){
        log.info(" [ INCOMING ]  message: from= '{}' , message= '{}' ", message.getFrom(), message.getBody());

        if(message.getBody().isBlank()){
            return new ResponseEntity<>(new BotReply("Message cannot be empty"),HttpStatus.BAD_REQUEST);
        }

        String reply = chatBotService.processMessage(message.getBody());
        log.info("[OUTGOING] to= '{}' | reply= '{}' ", message.getFrom(), reply);
        return ResponseEntity.ok(new BotReply(reply));
    }

}
