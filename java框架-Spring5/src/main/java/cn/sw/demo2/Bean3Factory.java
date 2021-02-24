package cn.sw.demo2;


public class Bean3Factory {

	public Bean3 getBean3(){
		System.out.println("Bean3实例工厂的getBean3方法...");
		return new Bean3();
	}
}
