package com.example.practice.service;

import com.example.practice.entity.JournalEntry;
import com.example.practice.entity.User;
import com.example.practice.repository.JournalEntryRepository;
import com.example.practice.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void saveEntry(User journalEntry){
        userRepository.save(journalEntry);
    }
    public List<User> getAll(){
        return userRepository.findAll();
    }
    public Optional<User> findById(ObjectId id){
        return userRepository.findById(id);
    }
    public void deleteById(ObjectId id){
        userRepository.deleteById(id);
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
