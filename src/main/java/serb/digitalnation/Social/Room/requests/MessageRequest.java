package serb.digitalnation.Social.Room.requests;

import lombok.Getter;
import serb.digitalnation.Social.Room.model.User;

import java.time.LocalDateTime;

@Getter
public class MessageRequest {
    private String content;
    private User sender;
    private LocalDateTime timestamp;
}
