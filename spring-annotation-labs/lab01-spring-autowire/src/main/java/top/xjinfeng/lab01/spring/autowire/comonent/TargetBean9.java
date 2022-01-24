package top.xjinfeng.lab01.spring.autowire.comonent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 描述: 不能这样使用
 *
 * @author xu.jin.feng
 * @create 2022/1/24 11:01
 */
@Component
@Slf4j
public class TargetBean9 {

    private PropsBean1 propsBean1;

    private PropsBean2 propsBean2;

    public TargetBean9(){
        log.info("{}", "采用此处的构造函数");
    }

    public TargetBean9(PropsBean1 propsBean1){
        this.propsBean1 = propsBean1;
    }

    // 不能同时有多个@Autowired， 否则会报下面的异常
//    @Autowired
    public TargetBean9(PropsBean2 propsBean2){
        this.propsBean2 = propsBean2;
    }

    @Autowired
    public TargetBean9(PropsBean1 propsBean1, PropsBean2 propsBean2){
        this.propsBean1 = propsBean1;
        this.propsBean2 = propsBean2;
    }

//    Error starting ApplicationContext. To display the conditions report re-run your application with 'debug' enabled.
//2022-01-24 11:29:35.013 ERROR 18248 --- [  restartedMain] o.s.boot.SpringApplication               : Application run failed
//
//    org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'targetBean9': Invalid autowire-marked constructor: public top.xjinfeng.lab01.spring.autowire.comonent.TargetBean9(top.xjinfeng.lab01.spring.autowire.comonent.PropsBean2). Found constructor with 'required' Autowired annotation already: public top.xjinfeng.lab01.spring.autowire.comonent.TargetBean9(top.xjinfeng.lab01.spring.autowire.comonent.PropsBean1,top.xjinfeng.lab01.spring.autowire.comonent.PropsBean2)
//    at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.determineCandidateConstructors(AutowiredAnnotationBeanPostProcessor.java:339) ~[spring-beans-5.3.15.jar:5.3.15]
//    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.determineConstructorsFromBeanPostProcessors(AbstractAutowireCapableBeanFactory.java:1302) ~[spring-beans-5.3.15.jar:5.3.15]
//    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1219) ~[spring-beans-5.3.15.jar:5.3.15]
//    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:582) ~[spring-beans-5.3.15.jar:5.3.15]
//    at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542) ~[spring-beans-5.3.15.jar:5.3.15]
//    at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335) ~[spring-beans-5.3.15.jar:5.3.15]
//    at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[spring-beans-5.3.15.jar:5.3.15]
//    at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333) ~[spring-beans-5.3.15.jar:5.3.15]
//    at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208) ~[spring-beans-5.3.15.jar:5.3.15]
//    at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:953) ~[spring-beans-5.3.15.jar:5.3.15]
//    at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:918) ~[spring-context-5.3.15.jar:5.3.15]
//    at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583) ~[spring-context-5.3.15.jar:5.3.15]
//    at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:145) ~[spring-boot-2.6.3.jar:2.6.3]
//    at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:732) [spring-boot-2.6.3.jar:2.6.3]
//    at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:414) [spring-boot-2.6.3.jar:2.6.3]
//    at org.springframework.boot.SpringApplication.run(SpringApplication.java:302) [spring-boot-2.6.3.jar:2.6.3]
//    at org.springframework.boot.SpringApplication.run(SpringApplication.java:1303) [spring-boot-2.6.3.jar:2.6.3]
//    at org.springframework.boot.SpringApplication.run(SpringApplication.java:1292) [spring-boot-2.6.3.jar:2.6.3]
//    at top.xjinfeng.lab01.spring.autowire.Lab01SpringAutowireApplication.main(Lab01SpringAutowireApplication.java:10) [classes/:na]
//    at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:1.8.0_311]
//    at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:1.8.0_311]
//    at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:1.8.0_311]
//    at java.lang.reflect.Method.invoke(Method.java:498) ~[na:1.8.0_311]
//    at org.springframework.boot.devtools.restart.RestartLauncher.run(RestartLauncher.java:49) [spring-boot-devtools-2.6.3.jar:2.6.3]

}
