package com.tcil.in.astra20.onboarding.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcil.in.astra20.onboarding.entity.Password;
import com.tcil.in.astra20.onboarding.repository.ForgotPasswordRepo;



@Service
public class ForgotPasswordService {

	private static final long EXPIRE_TOKEN=30;

    @Autowired
    private ForgotPasswordRepo forgotPasswordRepo;

    
    public String addPassword(Password password) {    	
    	forgotPasswordRepo.save(password);
    	return "Saved Successfully";
    }
    
    public List<Password>getall(){
    	return forgotPasswordRepo.findAll();
    }
    
    public String forgotPass(String email){
        Optional<Password> userOptional = Optional.ofNullable(forgotPasswordRepo.findByEmail(email));

        if(!userOptional.isPresent()){
            return "Invalid email id.";
        }

        Password user=userOptional.get();
        user.setToken(generateToken());
        user.setTokenCreationDate(LocalDateTime.now());

        user=forgotPasswordRepo.save(user);
        return user.getToken();
    }

    public String resetPass(String token, String password){
        Optional<Password> userOptional= Optional.ofNullable(forgotPasswordRepo.findByToken(token));

        if(!userOptional.isPresent()){
            return "Invalid token";
        }
        LocalDateTime tokenCreationDate = userOptional.get().getTokenCreationDate();

        if (isTokenExpired(tokenCreationDate)) {
            return "Token expired.";

        }

        Password user = userOptional.get();

        user.setPassword(password);
        user.setToken(null);
        user.setTokenCreationDate(null);

        forgotPasswordRepo.save(user);

        return "Your password successfully updated.";
    }

    private String generateToken() {
        StringBuilder token = new StringBuilder();

        return token.append(UUID.randomUUID().toString())
                .append(UUID.randomUUID().toString()).toString();
    }

    private boolean isTokenExpired(final LocalDateTime tokenCreationDate) {

        LocalDateTime now = LocalDateTime.now();
        Duration  diff = Duration.between(tokenCreationDate, now);

        return diff.toSeconds() >=EXPIRE_TOKEN;
    }

}
