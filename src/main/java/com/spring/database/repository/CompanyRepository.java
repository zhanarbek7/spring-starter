package com.spring.database.repository;

import com.spring.bpp.InjectBean;
import com.spring.database.pool.ConnectionPool;

public class CompanyRepository {

    @InjectBean
    private ConnectionPool connectionPool;

}
