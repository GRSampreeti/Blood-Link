package com.example.MP1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createuser(String name, String age, String bloodgroup, String gender, String phone, String email, String state, String district, String address, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        User user = new User(name, age, bloodgroup, gender, phone, email, state, district, address, encodedPassword);
        return userRepository.save(user);
    }

    public User loginUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }
        return null;
    }
}
