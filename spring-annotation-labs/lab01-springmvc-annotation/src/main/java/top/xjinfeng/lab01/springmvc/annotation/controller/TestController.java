package top.xjinfeng.lab01.springmvc.annotation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.xjinfeng.lab01.springmvc.annotation.model.Car;
import top.xjinfeng.lab01.springmvc.annotation.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 *
 * @author xu.jin.feng
 * @create 2022/1/27 14:57
 */
@RestController
public class TestController {

    /**
     * 没有注解
     *
     * Request URL: http://localhost:8080/test?name=gg
     * {"user":{"name":"gg","age":null},"car":{"name":"gg","cost":null}}
     *
     * Request URL: http://localhost:8080/test?age=&cost=
     * {"user":{"name":null,"age":null},"car":{"name":null,"cost":null}}
     *
     * Request URL: http://localhost:8080/test?age=&cost=dfg
     * Status Code: 400
     *
     * Request URL: http://localhost:8080/test
     * {"user":{"name":null,"age":null},"car":{"name":null,"cost":null}}
     */
    @GetMapping("/test")
    public Map<String, Object> test(User user, Car car){
        Map<String, Object> map =  new HashMap<>(2);
        map.put("user", user);
        map.put("car", car);
       return map;
    }

    /**
     * RequestParam注解
     *
     * http://localhost:8080/testRequestParam?user.name=45&user.age=33&car.name=45&car.cost=33
     * Request URL: http://localhost:8080/testRequestParam
     * Status Code: 400
     * There was an unexpected error (type=Bad Request, status=400).
     * Required request parameter 'user' for method parameter type User is not present
     *
     * http://localhost:8080/testRequestParam?user={name:45,age=33}&car={name:45,cost=33}
     * java.lang.IllegalArgumentException: Invalid character found in the request target
     * [/testRequestParam?user={name:45,age=33}&car={name:45,cost=33} ]. The valid characters are defined in RFC 7230 and RFC 3986
     *
     * http://localhost:8080/testRequestParam?user=
     * Status Code: 500
     * nested exception is java.lang.IllegalStateException: Cannot convert value of type 'java.lang.String' to required type
     *
     * 结论不能处理多个自定义对象参数，
     */
    @GetMapping("/testRequestParamMore")
    public Map<String, Object> testRequestParamMore(@RequestParam User user, @RequestParam Car car){
        Map<String, Object> map =  new HashMap<>(2);
        map.put("user", user);
        map.put("car", car);
        return map;
    }

    /**
     * Request URL: http://localhost:8080/testRequestParamSimple?name=43
     * {"user":"43"}
     *
     */
    @GetMapping("/testRequestParamSimple")
    public Map<String, Object> testRequestParamSimple(@RequestParam String name){
        Map<String, Object> map =  new HashMap<>(2);
        map.put("user", name);
        return map;
    }

    /**
     * 无法接收处理key 为 user, value为 User类型的参数对象
     * http://localhost:8080/testRequestParam?name=1
     * There was an unexpected error (type=Bad Request, status=400).
     * Required request parameter 'user' for method parameter type User is not present
     *
     * RequestParam注解只会处理 key为 user 的request parameter，而 value 不能是自定义复杂对象（如 User类型对象），能传数字或字符串
     *
     */
    @GetMapping("/testRequestParamCustom")
    public Map<String, Object> testRequestParamCustom(@RequestParam User user){
        Map<String, Object> map =  new HashMap<>(2);
        map.put("user", user);
        return map;
    }

    /**
     * Request URL: http://localhost:8080/testRequestParamMix?name=34
     * {"name":"34","user":{"name":"34","age":null}}
     *
     *
     */
    @GetMapping("/testRequestParamMix")
    public Map<String, Object> testRequestParamMix(@RequestParam String name, User user){
        Map<String, Object> map =  new HashMap<>(2);
        map.put("user", user);
        map.put("name", name);
        return map;
    }
}
