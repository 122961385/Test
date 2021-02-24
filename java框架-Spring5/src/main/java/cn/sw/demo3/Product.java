package cn.sw.demo3;

public class Product {
	private String name;
	
	public void setName(String name) {
		System.out.println("2set方法执行...");
		this.name = name;
	}

	public void setup(){
		System.out.println("2初始化方法执行...");
	}
	
	public void teardown(){
		System.out.println("销毁的方法执行...");
	}

	@Override
	public String toString() {
		return "Product [name=" + name + "]";
	}
	
}
