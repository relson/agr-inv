package info.relson.lab.AgrInv.controller;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.relson.lab.AgrInv.dto.CreateUserDto;
import info.relson.lab.AgrInv.entity.User;
import info.relson.lab.AgrInv.service.UserService;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserDto createUserDto) {

        var userId = userService.createUser(createUserDto);

        var createdUrl = "/v1/users/" + userId.toString();

        return ResponseEntity
            .created(URI.create(createdUrl)).build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") String userId) {
        var user = userService.getUserById(UUID.fromString(userId));

        if (user != null) {
            return ResponseEntity
            .ok(user);    
        } else {
            return ResponseEntity
            .notFound().build();
        }

        
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getUsers() {

        var users = userService.listAll();

        return ResponseEntity.ok(users);
    }

}
