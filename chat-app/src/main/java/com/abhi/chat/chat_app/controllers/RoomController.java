package com.abhi.chat.chat_app.controllers;

import com.abhi.chat.chat_app.Repositories.RoomRepository;
import com.abhi.chat.chat_app.entities.Message;
import com.abhi.chat.chat_app.entities.Room;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
@CrossOrigin("http://localhost:5173")

public class RoomController {
    // it is for creating the room and join the room
    private RoomRepository roomRepository;
    public RoomController(RoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }
    // create room
    @PostMapping
    public ResponseEntity<?> createRoom(@RequestBody String roomId){
        if(roomRepository.findByRoomId(roomId) != null) {
            // room is already there
            return ResponseEntity.badRequest().body("Room already exists!");
        }
        // create new ROOM
        Room room = new Room();
        room.setRoomId((roomId));
        Room savedRooms = roomRepository.save(room);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRooms);
    }
    // get room
    @GetMapping("/{roomId}")
    public ResponseEntity<?> joinRoom(@PathVariable String roomId){
        Room room = roomRepository.findByRoomId(roomId);

        if(room == null){
            return ResponseEntity.badRequest().body("Room not found!!");
        }
        return ResponseEntity.ok(room);
    }

    // get messages of room
    @GetMapping("/{roomId}/Messages")
    public ResponseEntity<List<Message>> getMessages(
        @PathVariable String roomId,
        @RequestParam(value = "page",defaultValue = "0",required = false) int page,
        @RequestParam(value = "size", defaultValue = "20", required = false) int size
    ){
        Room room = roomRepository.findByRoomId(roomId);
        if(room == null){
            return ResponseEntity.badRequest().build();
        }
        // get messages
        // pagination
        List<Message> messages = room.getMessages();
        if(messages == null || messages.isEmpty()){
            return ResponseEntity.ok(new ArrayList<>());
        }
        int totalMessage = messages.size();
        int start = Math.max(0,totalMessage-(page+1)*size);
        int end = Math.min(totalMessage,start + size);
        if(start > totalMessage || start >= end){
            return ResponseEntity.ok(new ArrayList<>());
        }
        List<Message> paginatedMessages = messages.subList(start,end);
        return ResponseEntity.ok(paginatedMessages);
    }

}
