package serb.digitalnation.Social.Room.model;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {
    private UUID id;
    private String content;
    private User sender;
    private LocalDateTime timestamp;

    public Message(String content, User sender, LocalDateTime timestamp) {
        this.id = UUID.randomUUID();
        this.content = content;
        this.sender = sender;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", sender=" + sender +
                ", timestamp=" + timestamp +
                '}';
    }
}
