package serb.digitalnation.Social.Room.controller;

import org.springframework.web.bind.annotation.*;
import serb.digitalnation.Social.Room.model.User;
import serb.digitalnation.Social.Room.requests.UserRequest;

@RestController
public class UserController {
    User user;
    @PostMapping("/user")
    public User createUser(@RequestBody UserRequest userRequest) {
        this.user = new User(userRequest.getName());
        System.out.println(this.user.toString());
        return this.user;
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable String id) {
        return this.user.getId().toString().equals(id) ? this.user : null;
    }
}
