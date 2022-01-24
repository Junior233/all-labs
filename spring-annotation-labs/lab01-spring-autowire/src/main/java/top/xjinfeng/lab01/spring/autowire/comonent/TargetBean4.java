package top.xjinfeng.lab01.spring.autowire.comonent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 描述:
 *
 * @author xu.jin.feng
 * @create 2022/1/24 11:01
 */
@Component
@Slf4j
public class TargetBean4 {

    private PropsBean1 propsBean1;

    private PropsBean2 propsBean2;

    public TargetBean4(){
    }

    @Autowired(required = false)
    public TargetBean4(PropsBean1 propsBean1){
        this.propsBean1 = propsBean1;
    }

    @Autowired(required = false)
    public TargetBean4(PropsBean2 propsBean2){
        this.propsBean2 = propsBean2;
    }

    @Autowired(required = false)
    public TargetBean4(PropsBean1 propsBean1, PropsBean2 propsBean2){
        log.info("{}", "采用此处的构造函数");
        this.propsBean1 = propsBean1;
        this.propsBean2 = propsBean2;
    }

}
