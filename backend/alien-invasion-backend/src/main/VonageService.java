package com.yourdomain.alieninvasion;

import com.vonage.client.VonageClient;
import com.vonage.client.auth.ClientCredential;
import io.github.cdimascio.dotenv.Dotenv;

public class VonageService {
    private VonageClient vonageClient;

    public VonageService() {
        // Load environment variables from .env file
        Dotenv dotenv = Dotenv.load();
        
        // Retrieve API credentials from environment variables
        String apiKey = dotenv.get("VONAGE_API_KEY");
        String apiSecret = dotenv.get("VONAGE_API_SECRET");

        // Initialize the VonageClient using the credentials
        ClientCredential credentials = new ClientCredential(apiKey, apiSecret);
        this.vonageClient = VonageClient.builder().authentication(credentials).build();
    }

    // Add methods to interact with the Vonage API
    public void sendSMS(String to, String from, String message) {
        // Implement Vonage SMS functionality here
    }

    // More methods to use other Vonage APIs like Voice, Verify, etc.
}
