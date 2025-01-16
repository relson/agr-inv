package info.relson.lab.AgrInv.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import info.relson.lab.AgrInv.dto.CreateUserDto;
import info.relson.lab.AgrInv.entity.User;
import info.relson.lab.AgrInv.repository.UserRepository;
@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UUID createUser(CreateUserDto createUserDto) {

        var entity = new User(
            null, 
            createUserDto.username(),
            createUserDto.email(),
            createUserDto.password(), 
            null,
            null);

        var saved = userRepository.save(entity);

        return saved.getUserId();
    }

    public User getUserById(UUID userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public List<User> listAll() {
        return userRepository.findAll();
    }
}
