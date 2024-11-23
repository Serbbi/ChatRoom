package serb.digitalnation.Social.Room.controller;

import org.springframework.web.bind.annotation.*;
import serb.digitalnation.Social.Room.model.Message;
import serb.digitalnation.Social.Room.requests.MessageRequest;

import java.util.UUID;

@RestController
@RequestMapping("/message")
public class MessageController {
    private Message message;

    @PostMapping("/")
    public Message createMessage(@RequestBody MessageRequest messageRequest) {
        this.message = new Message(messageRequest.getContent(), messageRequest.getSender(), messageRequest.getTimestamp());
        return this.message;
    }

    @GetMapping("/{id}")
    public Message getMessage(@PathVariable UUID id) {
        return this.message.getId().equals(id) ? this.message : null;
    }
}
