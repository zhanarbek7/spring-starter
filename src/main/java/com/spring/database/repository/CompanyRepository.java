package com.spring.database.repository;

import com.spring.database.pool.ConnectionPool;

public class CompanyRepository {
    private final ConnectionPool connectionPool;
    private String name;

    public CompanyRepository(ConnectionPool connectionPool, String name) {
        this.connectionPool = connectionPool;
        this.name = name;
    }

    public static CompanyRepository of(ConnectionPool connectionPool, String name){
        System.out.println("This is factory method");
         return new CompanyRepository(connectionPool, name);
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CompanyRepository{" +
                "connectionPool=" + connectionPool +
                ", name='" + name + '\'' +
                '}';
    }
}
