package serb.digitalnation.Social.Room.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @OneToMany
    private List<Message> messages;
    @ElementCollection
    private List<UUID> userIds;
    private String chatName;

    public Chat() {
        this.messages = new ArrayList<>();
        this.userIds = new ArrayList<>();
    }

    public Chat(String chatName) {
        this();
        this.chatName = chatName;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", messages=" + messages +
                ", users=" + userIds +
                ", chatName='" + chatName + '\'' +
                '}';
    }
}
