package top.xjinfeng.lab01.springmvc.annotation.controller;

import org.springframework.web.bind.annotation.*;
import top.xjinfeng.lab01.springmvc.annotation.model.Car;
import top.xjinfeng.lab01.springmvc.annotation.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述: @RequestParam和不带注解 主要能处理k-v类型的请求query参数（如 /test?name=gg）, get请求一般不带body参数, 因为很多http服务端都会忽略它
 *       get请求是支持传body参数的 {@link TestController#getRequestParam(String)}
 *       @RequestBody 用于处理json类型的请求参数 多用于post请求或其衍生请求（如put delete patch ） 一般作为body参数传递
 * 下面测试采用的请求方式跟java方法能处理的请求方式一一对应
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
     * http://localhost:8080/testRequestParamMore?user.name=45&user.age=33&car.name=45&car.cost=33
     * Request URL: http://localhost:8080/testRequestParam
     * Status Code: 400
     * There was an unexpected error (type=Bad Request, status=400).
     * Required request parameter 'user' for method parameter type User is not present
     *
     * http://localhost:8080/testRequestParamMore?user={name:45,age=33}&car={name:45,cost=33}
     * java.lang.IllegalArgumentException: Invalid character found in the request target
     * [/testRequestParam?user={name:45,age=33}&car={name:45,cost=33} ]. The valid characters are defined in RFC 7230 and RFC 3986
     *
     * http://localhost:8080/testRequestParamMore?user=
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
     * http://localhost:8080/testRequestParamCustom?name=1
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

    /**
     * http://localhost:8080/postRequestParam
     * body参数 name:bb
     * content-type 为 multipart/form-data 或 application/x-www-form-urlencoded
     * {
     * 	"name": "bb"
     * }
     *
     * 或
     * query参数 http://localhost:8080/postRequestParam?name=bb
     * {
     * 	"name": "bb"
     * }
     *
     * body参数和query参数 同时设置
     * {
     * 	"name": "bb,bb"
     * }
     *
     */
    @PostMapping("/postRequestParam")
    public Map<String, Object> postRequestParam(@RequestParam String name){
        Map<String, Object> map =  new HashMap<>(2);
        map.put("name", name);
        return map;
    }

    /**
     * http://localhost:8080/postRequestParam
     * body参数 name:bb
     * content-type 为 multipart/form-data
     * {
     * 	"name": "bb"
     * }
     * 为application/x-www-form-urlencoded
     * 	"status": 400,
     * 	"error": "Bad Request",Required request parameter 'name' for method parameter type String is not present
     *
     *
     * query参数 http://localhost:8080/postRequestParam?name=bb
     * {
     * 	"name": "bb"
     * }
     *
     * body参数和query参数 同时设置
     * 当为 multipart/form-data
     * {
     * 	"name": "bb,bb"
     * }
     *
     * 当为application/x-www-form-urlencoded
     * {
     * 	"name": "bb"
     * }
     */
    @GetMapping("/getRequestParam")
    public Map<String, Object> getRequestParam(@RequestParam String name){
        Map<String, Object> map =  new HashMap<>(2);
        map.put("name", name);
        return map;
    }
}
