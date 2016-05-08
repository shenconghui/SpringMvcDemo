package com.car;
public class CarTest {
	public static void main(String[] args) {
		Car1 c = new Car1();// 利用无参构造方法创建第一个Car1对象
		System.out.println("第一辆车的详细信息如下:");
		System.out.println("生产厂家：" + c.produce);// 调用Car1的produce属性
		c.showColor();		// 调用其父类Car的showColor方法
		c.showModel();		// 调用其父类Car的showModel方法
		Car1 c1 = new Car1("银白色");
		System.out.println("\n第二辆车的详细信息如下:");
		System.out.println("生产厂家：" + c1.produce);
		c1.showColor();
		c1.showModel();
		Car1 c2 = new Car1("蓝色", "卡车", "天津一汽");
		System.out.println("\n第三辆车的详细信息如下:");
		System.out.println("生产厂家：" + c2.produce);
		c2.showColor();
		c2.showModel();
	}
}
class Car {// 父类
	String color;	// 颜色属性
	String model;	// 车的类型
	public Car() {	// 无参构造方法，为其两个属性赋值
		this.color = "红色";
		this.model = "轿车";
	}
	public Car(String color, String model) {// 带有两个参数的构造方法
		this.color = color;
		this.model = model;
	}
	public void showColor() {// 显示车的颜色
		System.out.println("车的颜色：" + this.color);
	}
	public void showModel() {// 显示车的类型
		System.out.println("车的类型：" + this.model);
	}
}
class Car1 extends Car {		// 子类继承父类
	String produce;			// 生产厂家
	Car1(String color, String model, String produce) {// 带有三个参数的构造方法
		super(color, model);// 调用父类的构造方法
		this.produce = produce;
	}
	Car1(String color) {		// 带有一个参数的构造方法
		this.color = color;
		this.produce = "广洲本田";
	}
	Car1() {				// 无参构造方法
		this("黑色");
	}
}
