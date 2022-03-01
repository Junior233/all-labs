package top.xjinfeng.converter;

import org.springframework.core.convert.converter.Converter;

/**
 * 描述:
 *
 * @author junior.xu
 * @create 2022/2/22 17:28
 */
public class CustomConverter implements Converter<Long, Object> {

    static {
        System.out.println("converter init");
    }

    @Override
    public Object convert(Long s) {
        return null;
    }

}
