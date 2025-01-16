package info.relson.lab.AgrInv.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import info.relson.lab.AgrInv.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>{
    
}
