package top.xjinfeng.lab01.springmvc.annotation.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 描述:
 *
 * @author xu.jin.feng
 * @create 2022/1/27 14:59
 */

@Data
public class Car {

    private String name;

    private BigDecimal cost;
}
