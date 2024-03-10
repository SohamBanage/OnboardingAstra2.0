package com.tcil.in.astra20.onboarding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcil.in.astra20.onboarding.entity.Password;
import com.tcil.in.astra20.onboarding.entity.Policy;
import com.tcil.in.astra20.onboarding.service.PolicyService;

@RestController
public class PolicyController {

	@Autowired
	private PolicyService policyService;
	
	@PostMapping("/save-policy")
    public String addPassword(@RequestBody Policy policy) {
        return policyService.addpolicy(policy);
    } 
	
//	@GetMapping("/content/get-all-data")
//    public List<Policy> getAllPolicies(@RequestParam("mediaType") String mediaType) {
//        return policyService.getAll(mediaType);
//    }
	@GetMapping("/content/get-all-data")
    public List<Policy> getAllPolicies() {
        return policyService.getAll();
    }
}
