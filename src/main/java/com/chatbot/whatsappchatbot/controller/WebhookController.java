package com.chatbot.whatsappchatbot.controller;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/webhook")
public class WebhookController {

    @PostMapping
    public Map<String, String> receiveMessage(@RequestBody Map<String, String> request) {

        String message = request.get("message");
        String reply;

        if (message == null) {
            reply = "Invalid message";
        } else if (message.equalsIgnoreCase("hi")) {
            reply = "Hello";
        } else if (message.equalsIgnoreCase("bye")) {
            reply = "Goodbye";
        } else {
            reply = "I don't understand";
        }

        System.out.println("Incoming message: " + message);

        Map<String, String> response = new HashMap<>();
        response.put("reply", reply);

        return response;
    }
}