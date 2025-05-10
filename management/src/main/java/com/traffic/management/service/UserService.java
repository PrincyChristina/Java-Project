package com.traffic.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.traffic.management.entity.User;
import com.traffic.management.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    // This method will run after the bean is constructed and initialize our admin user
    @PostConstruct
    public void init() {
        // First check if admin user already exists
        if (!userRepository.findByUsername("admin").isPresent()) {
            User adminUser = new User();
            adminUser.setUsername("admin");
            adminUser.setPassword(passwordEncoder.encode("admin123"));
            userRepository.save(adminUser);
        }
    }
    
    public boolean authenticate(String username, String password) {
        // Only allow authentication with the admin account
        if (!"admin".equals(username)) {
            return false;
        }
        
        return userRepository.findByUsername(username)
                .map(user -> passwordEncoder.matches(password, user.getPassword()))
                .orElse(false);
    }
    
    // Keep other methods for management
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
    
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    
    // Only admin can use this method, so retain it for admin password updates
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
