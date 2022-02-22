package top.xjinfeng.lab01.springmvc.annotation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.xjinfeng.lab01.springmvc.annotation.model.SetWrapper;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 描述:
 *
 * @author junior.xu
 * @create 2022/2/22 10:08
 */
@RestController
public class TestSetController {

    /**
     * http://localhost:8081/testSet?1,2,3
     *
     * java.lang.IllegalStateException: No primary or single unique constructor found for interface java.util.Set
     * 	at org.springframework.beans.BeanUtils.getResolvableConstructor(BeanUtils.java:267) ~[spring-beans-5.3.15.jar:5.3.15]
     * 	at org.springframework.web.method.annotation.ModelAttributeMethodProcessor.createAttribute(ModelAttributeMethodProcessor.java:219) ~[spring-web-5.3.15.jar:5.3.15]
     * 	at org.springframework.web.servlet.mvc.method.annotation.ServletModelAttributeMethodProcessor.createAttribute(ServletModelAttributeMethodProcessor.java:85) ~[spring-webmvc-5.3.15.jar:5.3.15]
     * 	at org.springframework.web.method.annotation.ModelAttributeMethodProcessor.resolveArgument(ModelAttributeMethodProcessor.java:147) ~[spring-web-5.3.15.jar:5.3.15]
     * 	at org.springframework.web.method.support.HandlerMethodArgumentResolverComposite.resolveArgument(HandlerMethodArgumentResolverComposite.java:122) ~[spring-web-5.3.15.jar:5.3.15]
     * 	at org.springframework.web.method.support.InvocableHandlerMethod.getMethodArgumentValues(InvocableHandlerMethod.java:179) ~[spring-web-5.3.15.jar:5.3.15]
     * 	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:146) ~[spring-web-5.3.15.jar:5.3.15]
     * 	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:117) ~[spring-webmvc-5.3.15.jar:5.3.15]
     * 	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:895) ~[spring-webmvc-5.3.15.jar:5.3.15]
     * 	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:808) ~[spring-webmvc-5.3.15.jar:5.3.15]
     * 	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87) ~[spring-webmvc-5.3.15.jar:5.3.15]
     * 	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1067) ~[spring-webmvc-5.3.15.jar:5.3.15]
     * 	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:963) ~[spring-webmvc-5.3.15.jar:5.3.15]
     * 	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006) ~[spring-webmvc-5.3.15.jar:5.3.15]
     * 	at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:898) ~[spring-webmvc-5.3.15.jar:5.3.15]
     * 	at javax.servlet.http.HttpServlet.service(HttpServlet.java:655) ~[tomcat-embed-core-9.0.56.jar:4.0.FR]
     * 	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883) ~[spring-webmvc-5.3.15.jar:5.3.15]
     * 	at javax.servlet.http.HttpServlet.service(HttpServlet.java:764) ~[tomcat-embed-core-9.0.56.jar:4.0.FR]
     * 	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:227) ~[tomcat-embed-core-9.0.56.jar:9.0.56]
     * 	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-9.0.56.jar:9.0.56]
     * 	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53) ~[tomcat-embed-websocket-9.0.56.jar:9.0.56]
     * 	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189) ~[tomcat-embed-core-9.0.56.jar:9.0.56]
     * 	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-9.0.56.jar:9.0.56]
     * 	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100) ~[spring-web-5.3.15.jar:5.3.15]
     * 	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117) ~[spring-web-5.3.15.jar:5.3.15]
     * 	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189) ~[tomcat-embed-core-9.0.56.jar:9.0.56]
     * 	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-9.0.56.jar:9.0.56]
     * 	at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93) ~[spring-web-5.3.15.jar:5.3.15]
     * 	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117) ~[spring-web-5.3.15.jar:5.3.15]
     * 	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189) ~[tomcat-embed-core-9.0.56.jar:9.0.56]
     * 	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-9.0.56.jar:9.0.56]
     * 	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201) ~[spring-web-5.3.15.jar:5.3.15]
     * 	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:117) ~[spring-web-5.3.15.jar:5.3.15]
     * 	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189) ~[tomcat-embed-core-9.0.56.jar:9.0.56]
     * 	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-9.0.56.jar:9.0.56]
     * 	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:197) ~[tomcat-embed-core-9.0.56.jar:9.0.56]
     * 	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:97) [tomcat-embed-core-9.0.56.jar:9.0.56]
     * 	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:540) [tomcat-embed-core-9.0.56.jar:9.0.56]
     * 	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:135) [tomcat-embed-core-9.0.56.jar:9.0.56]
     * 	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92) [tomcat-embed-core-9.0.56.jar:9.0.56]
     * 	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:78) [tomcat-embed-core-9.0.56.jar:9.0.56]
     * 	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:357) [tomcat-embed-core-9.0.56.jar:9.0.56]
     * 	at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:382) [tomcat-embed-core-9.0.56.jar:9.0.56]
     * 	at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65) [tomcat-embed-core-9.0.56.jar:9.0.56]
     * 	at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:895) [tomcat-embed-core-9.0.56.jar:9.0.56]
     * 	at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1732) [tomcat-embed-core-9.0.56.jar:9.0.56]
     * 	at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49) [tomcat-embed-core-9.0.56.jar:9.0.56]
     * 	at org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1191) [tomcat-embed-core-9.0.56.jar:9.0.56]
     * 	at org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:659) [tomcat-embed-core-9.0.56.jar:9.0.56]
     * 	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61) [tomcat-embed-core-9.0.56.jar:9.0.56]
     * 	at java.lang.Thread.run(Thread.java:748) [na:1.8.0_311]
     *
     * @param set
     */
    @GetMapping("/testSet")
    public void testSet(Set<String> set){
        set.forEach(System.out::println);
    }

    /**
     * http://localhost:8081/testHashSet?set=f,h,s,v,b
     * f h s v b
     * @param set
     */
    @GetMapping("/testLinkedHashSet")
    public void testLinkedHashSet(@RequestParam("set") LinkedHashSet<String> set){
        set.forEach(System.out::printf);
    }

    /**
     * http://localhost:8081/testHashSet?set=f,h,s,v,b
     * b s f v h
     * @param set
     */
    @GetMapping("/testHashSet")
    public void testHashSet(@RequestParam("set") HashSet<String> set){
        set.forEach(System.out::printf);
    }

    /**
     * http://localhost:8081/testHashSet1?set=f,h,s,v,b
     * 没有任何输出
     * @param set
     */
    @GetMapping("/testHashSet1")
    public void testHashSet1(HashSet<String> set){
        set.forEach(System.out::printf);
    }

    /**
     * http://localhost:8081/testHashSet2?set=f,h,s,v,b
     * b s f v h
     * @param w
     */
    @GetMapping("/testHashSet2")
    public void testHashSet1(SetWrapper w){
        w.getSet().forEach(System.out::printf);
    }

}
