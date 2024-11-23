package serb.digitalnation.Social.Room.requests;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class MessageRequest {
    private String content;
    private UUID senderId;
    private LocalDateTime timestamp;
}
