package top.xjinfeng.lab01.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;


// https://docs.spring.io/spring-framework/docs/5.1.12.RELEASE/spring-framework-reference/core.html#aop

/**
 *
 * 切面需要定义为bean，才能生效
 * @author xu.jin.feng
 */
@Component
@Aspect
public class CheckAspect {

    @Pointcut("@annotation(top.xjinfeng.lab01.springaop.aspect.Check) && args(s)")
    public void pointcut(Object s){
    }

    @Before(value = "@annotation(top.xjinfeng.lab01.springaop.aspect.Check) && args(s)", argNames = "joinPoint,s")
    public void before(JoinPoint joinPoint, Object s){
        System.out.println("前置通知");
        System.out.println(s);
        //1
    }

    @Before(value = "execution(* top.xjinfeng.lab01.springaop.aspect.TargetClass.getIndex(..)) && target(bean) && args(s)", argNames = "joinPoint,bean,s")
    public void beforeWithAnnotation(JoinPoint joinPoint,Object bean, Object s){
        System.out.println("前置通知");
        System.out.println(s);
        //1
    }

    @Before(value = "top.xjinfeng.lab01.springaop.controller.DemoController.get() && args(s)", argNames = "joinPoint,s")
    public void beforeWithAnnotation(JoinPoint joinPoint, Object s){
        System.out.println("前置通知");
        System.out.println(s);
        //1
    }

    @Before(value = "top.xjinfeng.lab01.springaop.controller.DemoController.get() && args(java.lang.Object)", argNames = "joinPoint")
    public void beforeWithAnnotation(JoinPoint joinPoint){
        System.out.println("前置通知");
    }

    /**
     *  如果设置argNames 必须要pointcut表达式要有args(s)，argNames也要包含returning的sp El表达式，用逗号分割
     *  <code>@AfterReturning<code/> 和 <code>@AfterThrowing<code/> 同时只能触发一个
     * @param joinPoint
     * @param b
     * @param s
     */
    @AfterReturning(pointcut = "pointcut(s)", returning = "b",argNames = "joinPoint,b,s")
    public void afterReturning(JoinPoint joinPoint,Object b, Object s){
        System.out.println("后置返回通知");
        System.out.println(joinPoint);
        System.out.println(s);
        System.out.println(b);
        // 1
        // null
    }

    @AfterThrowing(value = "pointcut(s)",throwing = "t",argNames = "joinPoint,t,s")
    public void afterThrowing(JoinPoint joinPoint,Throwable t, Object s){
        System.out.println("后置异常通知");
        System.out.println(t);
        System.out.println(s);
        // java.lang.Exception
        // 2
    }

    /**
     * 最后执行，无论有没异常都会触发
     * @param joinPoint
     * @param s
     */
    @After(value = "pointcut(s)", argNames = "joinPoint,s")
    public void after(JoinPoint joinPoint, Object s){
        System.out.println("后置通知");
        System.out.println(s);
        // 1
    }

//     一旦定义了环绕通知，上面都通知都将无效

    /**
     * joinPoint必须作为第一个参数(The first parameter of the advice method must be of type ProceedingJoinPoint)
     * 否则参数绑定错误，joinPoint也被视为参数进行绑定
     * Expecting to find 2 arguments to bind by name in advice, but actually found 1 arguments.
     * type ProceedingJoinPoint 是@Around注解所特有的，仅限@Around注解使用
     * 此方法报红并不影响正常运行
     * @param joinPoint
     * @param s
     */
    @Around(value = "pointcut(s)", argNames = "s")
    public void around(ProceedingJoinPoint joinPoint, Object s){
        System.out.println("环绕通知");
        System.out.println(joinPoint);
        System.out.println(s);
    }

    //joinPoint可以省略

    /**
     * 定义多个@Around，只有第一个定义的才有效
     * @param joinPoint
     * @param s
     */
    @Around(value = "pointcut(s)", argNames = "joinPoint,s")
    public void aroundNotWorking(JoinPoint joinPoint, Object s){
        System.out.println(s);
    }
}

@Component
class TargetClass{

    @Check
    public void getIndex(@RequestParam("s") Integer s) throws Exception {
        if(s == 2){
            throw new Exception();
        }
        return ;
    }
}
