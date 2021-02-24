package com.sw.zg.设计模式.模板设计模式;


/*
优缺点
优点：
（1）把不可改变的封装起来，把能够改变的扩展开来
（2）他把很多类的共同操作给封装了起来，利于维护
（3）其实我们发现，我们在定义行为时候都是由父类去定义，然后子类去实现即可。
缺点：
缺点很简单，我们发现虽然我们把一些类的共同操作封装了起来，但是当这些类比较多时，效果就不好了，因为有一个拓展子类都需要继承它，子类多了就不好了。
 */
//在接口中的变量都默认是public static final的全局常量，可以省略前述的修饰词，可以被实现了接口的类直接访问并调用。 int a = 0
public class Demo1_Template {
    /**
     * @param args
     */
    public static void main(String[] args) {
		/*long start = System.currentTimeMillis();
		for(int i = 0; i < 1000000; i++) {
			System.out.println("x");
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);*/
        Demo d = new Demo();
        System.out.println(d.getTime());
    }
}

abstract class GetTime {
    public final long getTime() {
        long start = System.currentTimeMillis();
        code();
        long end = System.currentTimeMillis();
        return (end - start)/1000;
    }

    public abstract void code();
}

class Demo extends GetTime {

    @Override
    public void code() {
        int i = 0;
        while (i < 100000) {
            System.out.println("x");
            i++;
        }
    }
}
