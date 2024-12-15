package serb.digitalnation.Social.Room.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import serb.digitalnation.Social.Room.model.Chat;
import serb.digitalnation.Social.Room.model.Message;
import serb.digitalnation.Social.Room.repositories.ChatRepository;
import serb.digitalnation.Social.Room.repositories.MessageRepository;
import serb.digitalnation.Social.Room.requests.ChatRequest;
import serb.digitalnation.Social.Room.requests.MessageRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ChatService {
    private final ChatRepository chatRepository;
    private final MessageRepository messageRepository;

    public ChatService(ChatRepository chatRepository, MessageRepository messageRepository) {
        this.chatRepository = chatRepository;
        this.messageRepository = messageRepository;
    }

    public Chat createChat(ChatRequest chatRequest) {
        Chat chat = new Chat(chatRequest.getChatName());
        System.out.println("Chat created: " + chat.toString());
        return chatRepository.save(chat);
    }

    public Chat getChat(UUID id) {
        return chatRepository.findById(id).orElse(null);
    }

    public String addUserToChat(UUID id, UUID userId) {
        Chat chat = chatRepository.findById(id).orElse(null);
        if (chat != null) {
            chat.getUserIds().add(userId);
            chatRepository.save(chat);
        }
        return "User added to chat";
    }

    public String removeUserFromChat(UUID id, UUID userId) {
        Chat chat = chatRepository.findById(id).orElse(null);
        if (chat != null) {
            chat.getUserIds().removeIf(user -> user.equals(userId));
            chatRepository.save(chat);
        }
        return "User removed from chat";
    }

    public Chat updateChat(UUID id, ChatRequest chatRequest) {
        Chat chat = chatRepository.findById(id).orElse(null);
        if (chat != null) {
            chat.setChatName(chatRequest.getChatName());
            chatRepository.save(chat);
        }
        return chat;
    }

    public List<Chat> getChats() {
        return chatRepository.findAll();
    }

    public String deleteChat(UUID id) {
        chatRepository.deleteById(id);
        return "Chat deleted";
    }

    public Message addMessage(UUID id, MessageRequest messageRequest) {
        Chat chat = chatRepository.findById(id).orElse(null);
        if(chat != null) {
            Message message = new Message(messageRequest.getContent(), messageRequest.getSenderId(), messageRequest.getTimestamp(), chat);
            this.messageRepository.save(message);
            System.out.println(message);
            chat.getMessages().add(message);
            return message;
        }
        return null;
    }

    public List<Message> getChatMessages(UUID id) {
        Chat chat = chatRepository.findById(id).orElse(null);
        if(chat != null) {
            return chat.getMessages();
        }
        return new ArrayList<>();
    }
}
