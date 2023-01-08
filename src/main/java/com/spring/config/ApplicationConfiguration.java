package com.spring.config;
import com.spring.database.pool.ConnectionPool;
import com.spring.database.repository.CrudRepository;
import com.spring.database.repository.UserRepository;
import com.web.config.WebConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Component;

//@ImportResource("classpath:application.xml")
@Import(value = WebConfiguration.class)
@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(value = "com.spring",
        useDefaultFilters = false,
        includeFilters = {
                @Filter(type = FilterType.ANNOTATION, value = Component.class),
                @Filter(type = FilterType.ASSIGNABLE_TYPE, value = CrudRepository.class),
                @Filter(type = FilterType.REGEX, pattern = "com\\..+Repository")
        })
public class ApplicationConfiguration {
        @Bean("pool2")
        @Scope("singleton")
        public ConnectionPool pool2(@Value("${db.username}") String username){
                return new ConnectionPool(username,15);
        }

        @Bean
        @Scope("singleton")
        public ConnectionPool pool3(){
                return new ConnectionPool("test-pool",25);
        }
        @Bean
        @Profile("!prod")
        public UserRepository userRepository2(ConnectionPool pool2){
                return new UserRepository(pool2);
        }
        @Bean
        public UserRepository userRepository3(ConnectionPool pool2){
                var connectionPool1 = pool3();
                var connectionPool2 = pool3();
                var connectionPool3 = pool3();
                return new UserRepository(pool3());
        }

}
