package serb.digitalnation.Social.Room.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String content;
    private UUID senderId;
    private LocalDateTime timestamp;
    @ManyToOne
    @JsonBackReference
    private Chat chat;

    public Message() {}

    public Message(String content, UUID senderId, LocalDateTime timestamp, Chat chat) {
        this.content = content;
        this.senderId = senderId;
        this.timestamp = timestamp;
        this.chat = chat;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", sender=" + senderId +
                ", timestamp=" + timestamp +
                '}';
    }
}
