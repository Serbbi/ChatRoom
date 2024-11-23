package serb.digitalnation.Social.Room.services;

import org.springframework.stereotype.Service;
import serb.digitalnation.Social.Room.model.Message;
import serb.digitalnation.Social.Room.repositories.MessageRepository;
import serb.digitalnation.Social.Room.requests.MessageRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
    public Message sendMessage(MessageRequest req) {
        Message message = new Message(req.getContent(), req.getSenderId(), req.getTimestamp());
        System.out.println("Message sent: " + message.toString());
        return messageRepository.save(message);
    }

    public List<Message> getMessages() {
        return new ArrayList<>(messageRepository.findAll());
    }

    public Message getMessage(UUID id) {
        return messageRepository.findById(id).orElse(null);
    }
}
