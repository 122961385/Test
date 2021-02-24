package cn.sw.controller;
import cn.sw.entity.TcafeBase;
import cn.sw.service.TcafeBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloController {
    @Autowired
    private TcafeBaseService tcafeBaseService;
    @RequestMapping("/hello")
    public String hello() {
        return "hello world!";
    }
    @RequestMapping("/queryTcafeBaseById")
    public TcafeBase queryTcafeBaseById() {
        TcafeBase tcafeBase = tcafeBaseService.queryTcafeBaseById(237737);
        return tcafeBase;
    }
}
