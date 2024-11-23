package serb.digitalnation.Social.Room.services;

import org.springframework.stereotype.Service;
import serb.digitalnation.Social.Room.model.Chat;
import serb.digitalnation.Social.Room.repositories.ChatRepository;
import serb.digitalnation.Social.Room.requests.ChatRequest;

import java.util.List;
import java.util.UUID;

@Service
public class ChatService {
    private final ChatRepository chatRepository;

    public ChatService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
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

    public List<Chat> getChats() {
        return chatRepository.findAll();
    }

    public String deleteChat(UUID id) {
        chatRepository.deleteById(id);
        return "Chat deleted";
    }
}
