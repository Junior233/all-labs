package top.xjinfeng.lab01.springaop.aspect;

import java.lang.annotation.*;


/**
 * 描述:
 *
 * @author xu.jin.feng
 * @create 2022/2/8 17:05
 */
@Target(value = {ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Check {
}
