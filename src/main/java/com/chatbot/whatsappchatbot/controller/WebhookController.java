package com.chatbot.whatsappchatbot.controller;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/webhook")
public class WebhookController {

    @PostMapping
    public Map<String, Object> receiveMessage(@RequestBody Map<String, Object> request) {

        // 🔹 Log full incoming JSON
        System.out.println("Incoming request: " + request);

        // 🔹 Extract message safely
        String message = request.get("message") != null
                ? request.get("message").toString()
                : null;

        String reply;

        // 🔹 Business logic
        if (message == null || message.trim().isEmpty()) {
            reply = "Invalid message";
        } else if (message.equalsIgnoreCase("hi")) {
            reply = "Hello";
        } else if (message.equalsIgnoreCase("bye")) {
            reply = "Goodbye";
        } else {
            reply = "I don't understand";
        }

        // 🔹 Prepare response
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("reply", reply);

        // 🔹 Log outgoing response
        System.out.println("Response: " + response);

        return response;
    }
}