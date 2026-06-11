# Real-Time Chat Application

```markdown

A modern, full-stack, real-time chat application featuring a fluid user interface built with **React** and **Tailwind CSS**, powered by a robust and scalable **Spring Boot** backend.

---

## 🚀 Features

- **Real-Time Messaging:** Instant message delivery and receipt utilizing WebSockets (STOMP/SockJS).
- **Dynamic Room Management:** Create, join, and fetch distinct chat rooms dynamically without service interruption.
- **Responsive Design:** A sleek, mobile-first UI constructed with Tailwind CSS, supporting seamless cross-device communication.
- **Robust Error Handling:** End-to-end exception handling mapping explicit HTTP status codes between layers.

---

## 🛠️ Tech Stack

### Frontend
- **Framework:** React.js (Hooks, Functional Components)
- **Styling:** Tailwind CSS (Utility-first, responsive layouts)
- **HTTP Client:** Axios (For REST API calls like creating/fetching rooms)
- **Real-Time Client:** `@stomp/stompjs` / `sockjs-client`

### Backend
- **Framework:** Spring Boot (Java)
- **Real-Time Layer:** Spring WebSockets (STOMP Messaging Broker)
- **Build Tool:** Maven / Gradle
- **Deployment Platform:** Render (Web Services)

---

## 📁 Project Architecture

```text
├── chatapp-frontend/      # React Client Application
│   ├── src/
│   │   ├── components/    # UI elements (ChatWindow, Sidebar, RoomManager)
│   │   ├── services/      # API and WebSocket communication logic
│   │   └── App.jsx        # Main application router and context provider
└── chatapp-backend/       # Spring Boot Backend Service
    ├── src/main/java/com/chatapp/
    │   ├── controller/    # REST Endpoints (e.g., /api/v1/rooms) & Message Mapping
    │   ├── model/         # Chat Models (Message, ChatRoom)
    │   └── config/        # WebSocket Broker & CORS Filter Security setups

## Appication Preview

```
![image alt](https://github.com/Abhinavkr004/RealTimeChatApp/blob/42db7c1317831af70b88b0edf9876ef013cf9113/Screenshot%202026-06-11%20215526.png)

![image alt](https://github.com/Abhinavkr004/RealTimeChatApp/blob/40e0194236360221b1169d2c4b6b1b1e4278c69a/Screenshot%202026-06-11%20215704.png)
