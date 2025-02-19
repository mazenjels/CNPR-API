package com.hoja.cnprapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hoja.cnprapi.models.CnprQuestion;
import com.hoja.cnprapi.models.CnprUser;
import com.hoja.cnprapi.repository.QuestionRepository;
import com.hoja.cnprapi.repository.UserRepository;



@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	 
	 public Optional<CnprUser>  getCnprUser(String username) {
	        Optional<CnprUser> customerOptional = userRepository.findCnprUserByUsername(username);
//	        if (customerOptional.isPresent()) {
////	            if (!customerOptional.get().getPassword().equals(password)) {
////	                throw new IllegalStateException("password is not correct for email: "+ email);
////	            }
//	        }else {
//	            throw new IllegalStateException("Identifiant: " + username + " is not present");
//	        }
	        return customerOptional;
	    }



	
}
