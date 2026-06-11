package com.abhi.chat.chat_app.controllers;

import com.abhi.chat.chat_app.Repositories.RoomRepository;
import com.abhi.chat.chat_app.entities.Message;
import com.abhi.chat.chat_app.entities.Room;
import com.abhi.chat.chat_app.playload.MessageRequest;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@Controller
@CrossOrigin(origins = {"https://real-time-chat-app-nine-tau.vercel.app"})
public class ChatController {
    // it is basically for handle the chats
    private RoomRepository roomRepository;

    public ChatController(RoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }

    // for sending and receiving messages
    @MessageMapping("/sendMessage/{roomId}")// /app/sendMessage/roomId
    @SendTo("/topic/room/{roomId}") // subscribe
    public Message sendMessage(
            @DestinationVariable String roomId,
            @RequestBody MessageRequest request
    ){
        Room room = roomRepository.findByRoomId(request.getRoomId());
        Message message = new Message();
        message.setContent(request.getContent());
        message.setSender(request.getSender());
        message.setTimeStamp(LocalDateTime.now());

        if(room!=null){
            room.getMessages().add(message);
            
            roomRepository.save(room);
        }
        else{
            throw new RuntimeException("room not found");
        }
        return message;
    }
}
