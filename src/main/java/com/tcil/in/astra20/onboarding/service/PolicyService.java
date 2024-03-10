package com.tcil.in.astra20.onboarding.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcil.in.astra20.onboarding.entity.Policy;
import com.tcil.in.astra20.onboarding.repository.PolicyRepository;

@Service
public class PolicyService {

	@Autowired
	private PolicyRepository policyRepository;
	
	public List<Policy>getAll(){
		return policyRepository.findAll();
	}
	 public String addpolicy(Policy policy) {    	
		 policyRepository.save(policy);
	    	return "Saved Successfully";
	    }
}
