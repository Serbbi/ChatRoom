package serb.digitalnation.Social.Room.controller;

import org.springframework.web.bind.annotation.*;
import serb.digitalnation.Social.Room.model.Chat;
import serb.digitalnation.Social.Room.model.Message;
import serb.digitalnation.Social.Room.model.User;
import serb.digitalnation.Social.Room.requests.ChatRequest;
import serb.digitalnation.Social.Room.requests.MessageRequest;
import serb.digitalnation.Social.Room.services.ChatService;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
public class ChatController {
    ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/chat")
    public Chat createChat(@RequestBody ChatRequest chatRequest) {
        return this.chatService.createChat(chatRequest);
    }

    @GetMapping("/chat/{id}")
    public Chat getChat(@PathVariable UUID id) {
        return this.chatService.getChat(id);
    }

    @PutMapping("/chat/{id}")
    public Chat updateChat(@PathVariable UUID id, @RequestBody ChatRequest chatRequest) {
        return this.chatService.updateChat(id, chatRequest);
    }

//    @PutMapping("/chat/{id}/add/{userId}")
//    public String addUserToChat(@PathVariable UUID id, @PathVariable UUID userId) {
//        return chatService.addUserToChat(id, userId);
//    }

    @DeleteMapping("/chat/{id}")
    public String deleteChat(@PathVariable UUID id) {
        return chatService.deleteChat(id);
    }

//    @DeleteMapping("/chat/{id}/remove/{userId}")
//    public String removeUserFromChat(@PathVariable UUID id, @PathVariable UUID userId) {
//        return chatService.removeUserFromChat(id, userId);
//    }

    @GetMapping("/chats")
    public List<Chat> getChats() {
        return chatService.getChats();
    }

    @GetMapping("/chat/{id}/messages")
    public List<Message> getChatMessages(@PathVariable UUID id) {
        return chatService.getChatMessages(id);
    }

    @PostMapping("/chat/{id}/messages")
    public Message createMessage(@PathVariable UUID id, @RequestBody MessageRequest messageRequest) {
        return chatService.addMessage(id, messageRequest);
    }
}
