package top.xjinfeng.lab01.springaop.aspect;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 描述:
 *
 * @author xu.jin.feng
 * @create 2022/2/8 17:16
 */
@SpringBootTest
public class AspectTest {

    @Autowired
    TargetClass targetClass;

    // 存在环绕通知
    @Test
    void testWithAround() throws Exception {
        targetClass.getIndex(1);
//        环绕通知
//        execution(void com.example.demo.aspect.TargetClass.getIndex(Integer))
//        1
    }

    /**
     *  注意 下面的测试，注释掉{@link com.example.demo.aspect.CheckApsect}类中的@Around注解以及其修饰的方法
     *
     */

    // 不存在环绕通知
    @Test
    void testWithoutAround() throws Exception {
        targetClass.getIndex(1);
//        前置通知
//        1
//        后置返回通知
//        execution(void com.example.demo.aspect.TargetClass.getIndex(Integer))
//        1
//        null
//        后置通知
//        1
    }

    // 不存在环绕通知 并且抛出异常
    @Test
    void testThrowingWithoutAround() throws Exception {
        targetClass.getIndex(2);
//        前置通知
//        2
//        后置异常通知
//        java.lang.Exception
//        2
//        后置通知
//        2
    }

}

