package serb.digitalnation.Social.Room.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.UUID;

@Getter
@Setter
public class Chat {
    private UUID id;
    private ArrayList<Message> messages;
    private ArrayList<User> users;
    private User owner;
    private String chatName;

    public Chat(User user, String chatName) {
        this.id = UUID.randomUUID();
        this.messages = new ArrayList<>();
        this.users = new ArrayList<>();
        this.owner = user;
        this.chatName = chatName;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", messages=" + messages +
                ", users=" + users +
                ", owner=" + owner +
                ", chatName='" + chatName + '\'' +
                '}';
    }
}
