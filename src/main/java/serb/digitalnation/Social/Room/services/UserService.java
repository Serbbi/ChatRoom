package serb.digitalnation.Social.Room.services;

import org.springframework.stereotype.Service;
import serb.digitalnation.Social.Room.model.User;
import serb.digitalnation.Social.Room.repositories.UserRepository;
import serb.digitalnation.Social.Room.requests.UserRequest;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserRequest userRequest) {
        User user = new User(userRequest.getName());
        System.out.println(user);
        return userRepository.save(user);
    }

    public User getUser(UUID id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
