package com.example.BookMyShow.Service;

import com.example.BookMyShow.Models.User;
import com.example.BookMyShow.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User Signup(String email, String password){
        //check if user is present
        System.out.println(userRepository.findAllByEmail(email));
        Optional<User> useroptional =userRepository.findAllByEmail(email);
        if(useroptional.isPresent()){
            throw  new RuntimeException("user already present");
        }

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setBookings(new ArrayList<>());

        User saveduser=userRepository.save(user);
        return saveduser;
    }
}
