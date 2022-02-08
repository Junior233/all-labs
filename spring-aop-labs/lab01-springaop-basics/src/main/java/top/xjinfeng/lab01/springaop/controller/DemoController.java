package top.xjinfeng.lab01.springaop.controller;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.xjinfeng.lab01.springaop.aspect.Check;

/**
 * 描述:
 *
 * @author xu.jin.feng
 * @create 2022/2/8 17:05
 */
@RestController
public class DemoController {

    @GetMapping(value = "/getIndex")
    @Check
    public void getIndex(@RequestParam("s") Integer s) throws Exception {
        if(s == 2){
            throw new Exception();
        }
        return ;
    }

    @Pointcut(value = "@annotation(top.xjinfeng.lab01.springaop.aspect.Check)")
    public void get()  {
        return ;
    }

}
