package top.xjinfeng.lab01.spring.condition;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.xjinfeng.lab01.spring.condition.Father;

/**
 * 描述:
 *
 * @author junior.xu
 * @create 2022/2/23 15:38
 */
@Configuration
public class ConditionMissBeanTest {

    /**
     * 包括Father的所有实现类都不能已经被注册成bean,否则下面的逻辑不执行
     */
    @Bean
    @ConditionalOnMissingBean(Father.class)
    public void test(){
        System.out.println("test");
    }


}
