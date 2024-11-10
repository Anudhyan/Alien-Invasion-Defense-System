package com.yourdomain.alieninvasion;

import com.vonage.client.VonageClient;
import com.vonage.client.auth.ApiKeyAuthMethod;
import com.opentok.OpenTok;
import com.opentok.Session;
import com.opentok.SessionProperties;
import com.opentok.exception.OpenTokException;

public class VonageVideoClient {
    private OpenTok openTok;
    private Session session;

    public VonageVideoClient(int apiKey, String apiSecret) {
        openTok = new OpenTok(apiKey, apiSecret);
    }

    public String createSession() {
        try {
            session = openTok.createSession(new SessionProperties.Builder().build());
            System.out.println("Video session created successfully.");
            return session.getSessionId();
        } catch (OpenTokException e) {
            System.err.println("Error creating video session: " + e.getMessage());
            return null;
        }
    }

    public String generateToken() {
        try {
            if (session == null) {
                System.err.println("Session not created. Call createSession first.");
                return null;
            }
            String token = session.generateToken();
            System.out.println("Token generated successfully for video session.");
            return token;
        } catch (OpenTokException e) {
            System.err.println("Error generating token: " + e.getMessage());
            return null;
        }
    }
}
