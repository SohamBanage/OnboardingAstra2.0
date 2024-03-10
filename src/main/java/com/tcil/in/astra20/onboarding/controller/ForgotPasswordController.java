package com.tcil.in.astra20.onboarding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcil.in.astra20.onboarding.entity.Password;
import com.tcil.in.astra20.onboarding.service.ForgotPasswordService;

@RestController
public class ForgotPasswordController {
    @Autowired
    private ForgotPasswordService forgotPasswordService;

//    
//    @GetMapping("/forgot-password")
//    public String showForgotPasswordForm() {
//        return "login"; // This will render the forgot-password.html template
//    }
////    @GetMapping("/forgot-password")
//    public String resetPasswordForm() {
//        return "resetpassword"; // This will render the forgot-password.html template
//    }
  
    
    @PostMapping("/save-password")
    public String addPassword(@RequestBody Password password) {
        return forgotPasswordService.addPassword(password);
    } 
    
    @GetMapping("/get-all")
    public List<Password>getall(){
    	return forgotPasswordService.getall();
    }
    
    @PostMapping("/forgot-password")
    public String forgotPass(@RequestParam String email){
        String response = forgotPasswordService.forgotPass(email);

        if(!response.startsWith("Invalid")){
            response= "http://localhost:8080/reset-password?token=" + response;
        }
        return response;
    }

    @PutMapping("/reset-password")
    public String resetPass(@RequestParam String token, @RequestParam String password){
        return forgotPasswordService.resetPass(token,password);
    }

}