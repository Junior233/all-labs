package top.xjinfeng.lab01.spring.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;




/**
 * 注册的beanName是全类名，即 com.example.demo.config.ConfigProps
 */
@EnableConfigurationProperties(value = {ConfigProps.class})
@Configuration
public class AnnotationTest  {

    /**
     * 将{@link ConfigProps} 注册成bean， beanName为 configProps
     * 这种方式注册bean 比<code>@EnableConfigurationProperties(value = {ConfigProps.class})</code> 优先
     * 因此<code>@ConditionalOnMissingBean</code>并不能阻止 <code>@EnableConfigurationProperties(value = {ConfigProps.class})</code>
     * 注册相同类型的bean
     * detail see {@link org.springframework.context.annotation.ConfigurationClassBeanDefinitionReader#loadBeanDefinitionsForConfigurationClass }
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    public ConfigProps configProps(){
        return new ConfigProps();
    }

}
