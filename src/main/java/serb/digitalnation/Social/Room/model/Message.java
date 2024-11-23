package serb.digitalnation.Social.Room.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;

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

    public Message() {}

    public Message(String content, UUID senderId, LocalDateTime timestamp) {
        this.content = content;
        this.senderId = senderId;
        this.timestamp = timestamp;
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
