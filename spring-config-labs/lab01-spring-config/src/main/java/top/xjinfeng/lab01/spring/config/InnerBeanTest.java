package top.xjinfeng.lab01.spring.config;

import org.springframework.stereotype.Component;


@Component
public class InnerBeanTest {

    @Component
    public static class InnerBean {

    }

}
