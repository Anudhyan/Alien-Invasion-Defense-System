// src/main/java/com/yourdomain/alieninvasion/VonageClient.java

package com.yourdomain.alieninvasion;

import io.github.cdimascio.dotenv.Dotenv;
import com.vonage.client.VonageClient;
import com.vonage.client.auth.ApiKeyCredentials;
import com.vonage.client.message.sms.SmsRequest;
import com.vonage.client.message.sms.SmsResponse;

public class VonageClient {
    public static void main(String[] args) {
        // Load environment variables from .env file
        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("07e043ec");
        String apiSecret = dotenv.get("QNtF8MkL7rM4EDSe");

        // Create a Vonage client with credentials
        VonageClient client = VonageClient.builder()
                .apiKey(apiKey)
                .apiSecret(apiSecret)
                .build();

        // Send an SMS as an example
        SmsRequest smsRequest = new SmsRequest("to_phone_number", "from_phone_number", "Hello from Vonage!");
        SmsResponse response = client.smsClient().sendMessage(smsRequest);

        // Print the response status
        System.out.println("SMS sent status: " + response.getStatus());
    }
}
