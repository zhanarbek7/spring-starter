import com.spring.database.pool.ConnectionPool;
import com.spring.database.repository.CompanyRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationRunner {

    public static void main(String[] args) {
        ConnectionPool connectionPool;
        CompanyRepository companyRepository;
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml")) {
            connectionPool = context.getBean("pool1", ConnectionPool.class);
            companyRepository = context.getBean("companyRepository", CompanyRepository.class);
            System.out.println(connectionPool);
            System.out.println(companyRepository);
        }

    }

}