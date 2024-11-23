package serb.digitalnation.Social.Room.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class User {
    private UUID id;
    private String name;

    public User(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
