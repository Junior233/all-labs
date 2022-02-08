package top.xjinfeng.lab01.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import top.xjinfeng.lab01.spring.config.ConfigProps;
import top.xjinfeng.lab01.spring.config.StandardBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class Lab01SpringConfigApplicationTests {

    @Autowired
    ApplicationContext context;

    @Autowired
    ConfigProps configProps;

//    @Autowired
//    ConfigProps c;

    @Test
    void contextLoads() {
        StandardBean bean = context.getBean(StandardBean.class);
        assertNotNull(bean);
    }

    @Test
    void testBean() {
        ConfigProps bean = context.getBean(ConfigProps.class);
        assertNotNull(bean);
    }

    @Test
    void testBeanByName() {
        ConfigProps bean = context.getBean("configProps", ConfigProps.class);
        assertNotNull(bean);
    }

    @Test
    void testBeanByFullName() {
        ConfigProps bean = context.getBean("com.example.demo.config.ConfigProps", ConfigProps.class);
        assertNotNull(bean);
    }

    @Test
    void  test(){
        ConfigProps bean = context.getBean("configProps", ConfigProps.class);
        assertNotNull(bean);
        bean = context.getBean("com.example.demo.config.ConfigProps", ConfigProps.class);
        assertNotNull(bean);
    }

    @Test
    void  testInnerBean(){
        Object bean = context.getBean("innerBeanTest.InnerBean");
        assertNotNull(bean);
    }

    /**
     * 下面单元测试全部测试通过， 采用junit5
     * details see {@link org.springframework.context.annotation.AnnotationBeanNameGenerator#buildDefaultBeanName(org.springframework.beans.factory.config.BeanDefinition)}
     */
    @Test
    void  testURLBean1(){
        Object urlBean = context.getBean("URLBean");
        assertNotNull(urlBean);
    }

    @Test
    void  testURLBean2(){
        //org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'uRLBean' available
        assertThrows(Exception.class, () -> {
            Object urlBean = context.getBean("uRLBean");
        });
    }

    @Test
    void  testUBean(){
        Object urlBean = context.getBean("UBean");
        assertNotNull(urlBean);
    }

    @Test
    void testConfigProps(){
        assertNotNull(configProps);
        assertTrue('a' < 'b');
    }

    @Test
    void testConfigPropsByType(){
        assertThrows(Exception.class, () -> {
            context.getBean(ConfigProps.class);
        });
    }

}
