package top.xjinfeng.lab01.spring.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeanTest {

    @Bean
    @ConditionalOnMissingBean
    public ConfigProps configProps(){
        return new ConfigProps();
    }

}
