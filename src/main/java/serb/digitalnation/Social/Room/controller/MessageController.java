package serb.digitalnation.Social.Room.controller;

import org.springframework.web.bind.annotation.*;
import serb.digitalnation.Social.Room.model.Message;
import serb.digitalnation.Social.Room.requests.MessageRequest;
import serb.digitalnation.Social.Room.services.MessageService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

//    @PostMapping("/message")
//    public Message createMessage(@RequestBody MessageRequest messageRequest) {
//        return this.messageService.sendMessage(messageRequest);
//    }

    @GetMapping("/message/{id}")
    public Message getMessage(@PathVariable UUID id) {
        return this.messageService.getMessage(id);
    }

    @GetMapping("/messages")
    public List<Message> getMessages() {
        return this.messageService.getMessages();
    }
}
