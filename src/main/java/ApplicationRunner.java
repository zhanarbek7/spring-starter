import com.spring.database.pool.ConnectionPool;
import com.spring.database.repository.CompanyRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationRunner {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        ConnectionPool connectionPool = context.getBean("pool1", ConnectionPool.class);
        CompanyRepository companyRepository = context.getBean("companyRepository", CompanyRepository.class);
        System.out.println(companyRepository);
        companyRepository.setName("Altynbek");
        CompanyRepository companyRepository2 = context.getBean("companyRepository", CompanyRepository.class);
        System.out.println(companyRepository2);
        System.out.println(connectionPool);
    }

}