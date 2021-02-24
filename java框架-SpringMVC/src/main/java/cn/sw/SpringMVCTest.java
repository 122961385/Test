package cn.sw;

import cn.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/springmvc")
@Controller
public class SpringMVCTest {

    public static final String SUCCESS = "success";

    @RequestMapping(value = "/testRequestMapping", method = RequestMethod.POST)
    public String testRequestMapping() {
        System.out.println("testRequestMapping");
        return SUCCESS;
    }

    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") Integer id) {
        System.out.println(id);
        return SUCCESS;
    }

    @RequestMapping(value = "/testRequestParam")
    public String testRequestParam(@RequestParam(value = "username", required = true) String user, @RequestParam(value = "age", defaultValue = "") String age) {
        System.out.println("username:" + user + "age:" + age);
        return SUCCESS;
    }

    @RequestMapping(value = "/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String aa) {
        System.out.println("JSESSIONID:"+aa);
        return SUCCESS;
    }

    @RequestMapping(value = "/testPOJO")
    public String testPOJO(User user){
        System.out.println(user.getAddress()+":"+user.getUsername()+":"+user.getAddress().getProvince());
        return SUCCESS;
    }
}
