package com.zhanarbek.spring.service;

import com.zhanarbek.spring.database.repository.CrudRepository;
import com.zhanarbek.spring.dto.CompanyReadDto;
import com.zhanarbek.spring.entity.Company;
import com.zhanarbek.spring.listener.entity.AccessType;
import com.zhanarbek.spring.listener.entity.EntityEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {
    private final CrudRepository<Integer, Company> companyRepository;
    private final UserService userService;
    public final ApplicationEventPublisher eventPublisher;

    public CompanyService(CrudRepository<Integer, Company> companyRepository, UserService userService, ApplicationEventPublisher eventPublisher) {
        this.companyRepository = companyRepository;
        this.userService = userService;
        this.eventPublisher = eventPublisher;
    }

    public Optional<CompanyReadDto> findById(Integer id){
        return companyRepository.findById(id)
                .map(entity -> {
                    eventPublisher.publishEvent(
                            new EntityEvent(entity, AccessType.READ));
                    return new CompanyReadDto(entity.id());
                });
    }


}
