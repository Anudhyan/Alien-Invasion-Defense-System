// Base URL of your backend server
const BASE_URL = 'http://localhost:8080'; // Adjust based on your backend setup

// Function to send SMS Alert
async function sendSmsAlert() {
    const phoneNumber = document.getElementById('phoneNumber').value;
    const smsStatus = document.getElementById('smsStatus');
    smsStatus.textContent = 'Sending SMS...';

    try {
        const response = await fetch(`${BASE_URL}/send-sms`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ phoneNumber })
        });

        const result = await response.json();
        if (response.ok) {
            smsStatus.textContent = `SMS sent successfully to ${phoneNumber}`;
        } else {
            smsStatus.textContent = `Error sending SMS: ${result.message}`;
        }
    } catch (error) {
        console.error('Error:', error);
        smsStatus.textContent = 'Failed to send SMS. Please try again.';
    }
}

// Function to join Video Session
async function joinVideoSession() {
    const userName = document.getElementById('userName').value;
    const videoStatus = document.getElementById('videoStatus');
    const videoContainer = document.getElementById('videoContainer');
    const videoElement = document.getElementById('videoElement');

    videoStatus.textContent = 'Joining video session...';

    try {
        const response = await fetch(`${BASE_URL}/create-video-session`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ userName })
        });

        const result = await response.json();
        if (response.ok) {
            const { apiKey, sessionId, token } = result;
            
            const session = OT.initSession(apiKey, sessionId);

            // Create a publisher
            const publisher = OT.initPublisher(videoElement, {
                insertMode: 'append',
                width: '100%',
                height: '400px'
            });

            // Connect to the session
            session.connect(token, (error) => {
                if (error) {
                    videoStatus.textContent = `Connection error: ${error.message}`;
                } else {
                    videoStatus.textContent = 'Connected to video session!';
                    videoContainer.style.display = 'block';
                    session.publish(publisher);
                }
            });

            // Subscribe to a newly created stream
            session.on('streamCreated', (event) => {
                session.subscribe(event.stream, videoElement, {
                    insertMode: 'append',
                    width: '100%',
                    height: '400px'
                });
            });
        } else {
            videoStatus.textContent = `Error joining video session: ${result.message}`;
        }
    } catch (error) {
        console.error('Error:', error);
        videoStatus.textContent = 'Failed to join video session. Please try again.';
    }
}
