# Alien Invasion Defense System

An application that uses Vonage APIs to detect and respond to real-time alien sightings with SMS and video alerts.

## Features

- **Real-time Alerts:** SMS and video notifications for sightings
- **Frontend Dashboard:** Monitor sightings and manage alerts
- **Backend APIs:** Manage sightings and alert statuses

## Tech Stack

- **Backend:** Java, Maven, Vonage APIs
- **Frontend:** HTML, JavaScript, Bootstrap
- **Database:** MongoDB

## Getting Started

1. **Clone Repository:**

   ```bash
   git clone https://github.com/your-username/Alien-Invasion-Defense-System.git
   cd Alien-Invasion-Defense-System
2. **Setup Backend:**

   - Navigate to the backend directory:
     ```bash
     cd backend/alien-invasion-backend
     ```
   - Build with Maven:
     ```bash
     mvn clean install
     ```
   - Configure environment variables in `.env`:
     ```plaintext
     VONAGE_API_KEY=your_api_key
     VONAGE_API_SECRET=your_api_secret
     ```

3. **Run Backend:**
   ```bash
   mvn exec:java -Dexec.mainClass="com.yourdomain.alieninvasion.Application"
