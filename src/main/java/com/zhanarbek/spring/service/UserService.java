package com.zhanarbek.spring.service;

import com.zhanarbek.spring.database.repository.CrudRepository;
import com.zhanarbek.spring.database.repository.UserRepository;
import com.zhanarbek.spring.entity.Company;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final CrudRepository<Integer, Company> companyRepository;


    public UserService(UserRepository userRepository, CrudRepository<Integer, Company> companyRepository) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }

}
