package com.spring.service;

import com.dto.CompanyReadDto;
import com.listener.entity.AccessType;
import com.listener.entity.EntityEvent;
import com.spring.database.repository.CrudRepository;
import com.spring.entity.Company;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
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
