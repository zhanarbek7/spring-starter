package com.spring.database.pool;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("pool1")
public class ConnectionPool {

    private final String username;
    private final Integer poolSize;

    public ConnectionPool(@Value("${db.username}") String username,
                          @Value("${db.pool.size}") Integer poolSize) {
        System.out.println("This is constructor");
        this.username = username;
        this.poolSize = poolSize;
    }

    @PostConstruct
    private void init() {
        System.out.println("Init connection pool");
    }

    @PreDestroy
    private void destroy() {
        System.out.println("Clean connection pool");
    }
}
