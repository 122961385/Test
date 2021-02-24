package cn.sw.demo1;

public class HelloServiceImpl implements HelloService {

    private String info;

    public void setInfo(String info) {
        this.info = info;
    }

    public void sayHello() {
        // TODO Auto-generated method stub
        System.out.println("Hello_Word..." + info);
    }

}
