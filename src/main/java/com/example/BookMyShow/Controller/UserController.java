package com.example.BookMyShow.Controller;

import com.example.BookMyShow.DTOs.ResponseStatus;
import com.example.BookMyShow.DTOs.SignupReqDTO;
import com.example.BookMyShow.DTOs.SignupResDTO;
import com.example.BookMyShow.Models.User;
import com.example.BookMyShow.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;
    @Autowired
    UserController(UserService userService){
        this.userService=userService;}

    public SignupResDTO signup(SignupReqDTO signupReqDTO){
    SignupResDTO response = new SignupResDTO();
    try{
        User user =userService.Signup(
                    signupReqDTO.getEmail(),
                    signupReqDTO.getPasoword()
            );
            response.setUserid(user.getId());
            response.setResponseStatus(ResponseStatus.SUCCESS);
    }catch(Exception e){
        response.setResponseStatus(ResponseStatus.FAILURE);
    }
        return response;
    }
}
