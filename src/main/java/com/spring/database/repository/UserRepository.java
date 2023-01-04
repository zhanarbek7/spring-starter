package com.spring.database.repository;

import com.spring.database.pool.ConnectionPool;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserRepository {
    private final ConnectionPool connectionPool;

    public UserRepository(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
}
