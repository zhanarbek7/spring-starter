package com.zhanarbek.spring.database.repository;

import org.springframework.stereotype.Repository;
import com.zhanarbek.spring.bpp.Auditing;
import com.zhanarbek.spring.bpp.Transaction;
import com.zhanarbek.spring.database.pool.ConnectionPool;
import com.zhanarbek.spring.entity.Company;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

import java.util.List;
import java.util.Optional;

@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Transaction
@Auditing
@Repository
public class CompanyRepository implements CrudRepository<Integer, Company>{

//    @Resource(name = "pool1")
//    @Autowired
//    @Qualifier(value = "pool1")
    private final ConnectionPool pool1;
    private final List<ConnectionPool> pools;
    private final Integer poolSize;

    public CompanyRepository(ConnectionPool pool1,
                             List<ConnectionPool> pools,
                             @Value("${db.pool.size}") Integer poolSize) {
        this.pool1 = pool1;
        this.pools = pools;
        this.poolSize = poolSize;
    }

    @PostConstruct
    private void init(){
        System.out.println("init company repository");
    }

    @Override
    public Optional<Company> findById(Integer id) {
        System.out.println("findById method...");
        return Optional.of(new Company(id));
    }

    @Override
    public void delete(Company entity) {
        System.out.println("delete method...");
    }
}
