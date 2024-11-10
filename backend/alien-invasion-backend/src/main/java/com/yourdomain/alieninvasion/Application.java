package com.yourdomain.alieninvasion;

import com.vonage.client.VonageClient;
import com.vonage.client.auth.ApiKeyAuthMethod;
import com.vonage.client.auth.AuthMethod;
import com.vonage.client.messaging.Message;
import com.vonage.client.messaging.messages.TextMessage;

public class Application {
    public static void main(String[] args) {
        // Replace with your actual Vonage API credentials from .env file
        String apiKey = System.getenv("07e043ec"); 
        String apiSecret = System.getenv("QNtF8MkL7rM4EDSe");

        AuthMethod auth = new ApiKeyAuthMethod(apiKey, apiSecret);
        VonageClient client = new VonageClient(auth);

        // Your message details
        String from = "VonageAPI";
        String to = "RecipientPhoneNumber"; // Replace with the phone number you want to send to
        String text = "Hello from Vonage!";

        try {
            Message response = client.getMessagingClient().sendMessage(new TextMessage(from, to, text));
            System.out.println("Message sent successfully: " + response.getStatus());
        } catch (Exception e) {
            System.err.println("Error sending message: " + e.getMessage());
        }
    }
}
