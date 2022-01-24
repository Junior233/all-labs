package top.xjinfeng.lab01.spring.autowire.comonent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 描述: 如果有多个@Autowired(required = false)，选择参数最多的。
 * 如果有多个构造函数参数一样多，则选择后面定义。
 *
 * @author xu.jin.feng
 * @create 2022/1/24 11:01
 */
@Component
@Slf4j
public class TargetBean7 {

    private PropsBean1 propsBean1;

    private PropsBean2 propsBean2;

    @Autowired(required = false)
    public TargetBean7(PropsBean1 propsBean1){
        this.propsBean1 = propsBean1;
        log.info("{}", "采用此处的构造函数");
    }

    // 不会选择这个，因为有些参数无法注入
    @Autowired(required = false)
    public TargetBean7(PropsBean2 propsBean2, String s){
        this.propsBean2 = propsBean2;
    }

    public TargetBean7(){
        System.out.println(0);
    }

}
