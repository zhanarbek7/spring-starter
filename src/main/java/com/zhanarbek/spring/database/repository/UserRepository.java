package com.zhanarbek.spring.database.repository;

import com.zhanarbek.spring.database.pool.ConnectionPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserRepository {
    private final ConnectionPool connectionPool;

    @Autowired
    public UserRepository(@Qualifier(value = "pool2") ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
}
