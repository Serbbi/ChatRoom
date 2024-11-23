package serb.digitalnation.Social.Room.controller;

import org.springframework.web.bind.annotation.*;
import serb.digitalnation.Social.Room.model.Chat;
import serb.digitalnation.Social.Room.model.User;
import serb.digitalnation.Social.Room.requests.ChatRequest;

import java.util.UUID;

@RestController
public class ChatController {
    Chat chat;
    @PostMapping("/chat")
    public Chat createChat(@RequestBody ChatRequest chatRequest) {
        this.chat = new Chat(new User(chatRequest.getUserName()), chatRequest.getChatName());
        System.out.println(this.chat.toString());
        return this.chat;
    }

    @GetMapping("/chat/{id}")
    public Chat getChat(@PathVariable UUID id) {
        return this.chat.getId().equals(id) ? this.chat : null;
    }

    @PutMapping("/chat/{id}/add/{userId}")
    public String addUserToChat(@PathVariable UUID id, @PathVariable UUID userId) {
        if (this.chat.getId().equals(id)) {
            this.chat.getUsers().add(new User("User" + userId));
            return "User added to chat";
        }
        return "Chat not found";
    }

    @DeleteMapping("/chat/{id}")
    public String deleteChat(@PathVariable UUID id) {
        if (this.chat.getId().equals(id)) {
            this.chat = null;
            return "Chat deleted";
        }
        return "Chat not found";
    }

    @DeleteMapping("/chat/{id}/remove/{userId}")
    public String removeUserFromChat(@PathVariable UUID id, @PathVariable UUID userId) {
        if (this.chat.getId().equals(id)) {
            this.chat.getUsers().removeIf(user -> user.getId().equals(userId));
            return "User removed from chat";
        }
        return "Chat not found";
    }
}
