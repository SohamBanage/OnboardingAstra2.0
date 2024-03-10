package com.tcil.in.astra20.onboarding.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcil.in.astra20.onboarding.entity.Password;

public interface ForgotPasswordRepo extends JpaRepository<Password, Long>{

	public Password findByEmail(String email);
	public Password findByToken(String token);
}
