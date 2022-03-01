package top.xjinfeng.config;

import org.springframework.context.annotation.Bean;

/**
 * 描述:
 *
 * @author junior.xu
 * @create 2022/2/23 16:35
 */
public class CustomAutoEnableConfig {

    @Bean
    public void test(){
        System.out.println("auto config init");
    }

}
