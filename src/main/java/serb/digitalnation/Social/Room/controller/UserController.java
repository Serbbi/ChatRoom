package serb.digitalnation.Social.Room.controller;

import org.springframework.web.bind.annotation.*;
import serb.digitalnation.Social.Room.model.User;
import serb.digitalnation.Social.Room.requests.UserRequest;
import serb.digitalnation.Social.Room.services.UserService;

import java.util.UUID;

@CrossOrigin
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public User createUser(@RequestBody UserRequest userRequest) {
        return userService.createUser(userRequest);
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable UUID id) {
        return userService.getUser(id);
    }

    @GetMapping("/users")
    public Iterable<User> getUsers() {
        return userService.getUsers();
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable UUID id) {
        return userService.deleteUser(id);
    }
}
