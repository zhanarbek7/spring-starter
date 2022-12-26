package com.spring.database.repository;

import com.spring.database.pool.ConnectionPool;

public class CompanyRepository {
    private final ConnectionPool connectionPool;

    public CompanyRepository(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public static CompanyRepository of(ConnectionPool connectionPool){
        System.out.println("This is factory method");
         return new CompanyRepository(connectionPool);
    }

    @Override
    public String toString() {
        return "CompanyRepository{" +
                "connectionPool=" + connectionPool +
                '}';
    }
}
