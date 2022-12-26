import com.spring.database.pool.ConnectionPool;
import com.spring.database.repository.CompanyRepository;
import com.spring.database.repository.UserRepository;
import com.spring.ioc.Container;
import com.spring.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationRunner {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        ConnectionPool pool = context.getBean("pool1", ConnectionPool.class);
        System.out.println(pool);
    }

}