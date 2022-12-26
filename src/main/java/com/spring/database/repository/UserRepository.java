package com.spring.database.repository;

import com.spring.database.pool.ConnectionPool;

public class UserRepository {
    private final ConnectionPool connectionPool;

    public UserRepository(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
}
