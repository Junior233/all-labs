package top.xjinfeng.lab01.spring.autowire.comonent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 描述:
 *
 * @author xu.jin.feng
 * @create 2022/1/24 11:01
 */
@Component
@Slf4j
public class TargetBean1 {

    private PropsBean1 propsBean1;

    private PropsBean2 propsBean2;

    public TargetBean1(){
        log.info("{}", "采用此处的构造函数");
    }

    public TargetBean1(PropsBean1 propsBean1){
        this.propsBean1 = propsBean1;
    }

    public TargetBean1(PropsBean2 propsBean2){
        this.propsBean2 = propsBean2;
    }

    public TargetBean1(PropsBean1 propsBean1, PropsBean2 propsBean2){
        this.propsBean1 = propsBean1;
        this.propsBean2 = propsBean2;
    }

}
