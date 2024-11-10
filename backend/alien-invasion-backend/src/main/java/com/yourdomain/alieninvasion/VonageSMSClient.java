package com.yourdomain.alieninvasion;

import com.vonage.client.VonageClient;
import com.vonage.client.auth.ApiKeyAuthMethod;
import com.vonage.client.messaging.MessagingClient;
import com.vonage.client.messaging.messages.TextMessage;

public class VonageSMSClient {
    private VonageClient client;
    private MessagingClient messagingClient;

    public VonageSMSClient(String apiKey, String apiSecret) {
        client = VonageClient.builder()
                .apiKey(apiKey)
                .apiSecret(apiSecret)
                .build();
        messagingClient = client.getMessagingClient();
    }

    public void sendSMS(String fromNumber, String toNumber, String messageText) {
        TextMessage message = new TextMessage(fromNumber, toNumber, messageText);
        
        try {
            messagingClient.sendMessage(message);
            System.out.println("SMS sent successfully to " + toNumber);
        } catch (Exception e) {
            System.err.println("Error sending SMS: " + e.getMessage());
        }
    }
}
