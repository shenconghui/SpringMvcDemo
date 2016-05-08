package com.car;
public class LoadClass {// 测试类
	public static void main(String[] args) {
		System.out.println("不创建对象直接访问静态方法时的输出：");
		Child.childMethod();
		System.out.println();
		System.out.println("通过new创建对象，访问非静态方法时的输出：");
		new Child("").display();
		// 通知虚拟机进行垃圾回收
		System.gc();
	}
}
class Parent {// 父类
	private int x = 15;
	private static int y = getValue(20);
	{
		System.out.println("执行Parent的初始化代码块");
		int x = 70;
		int y = getValue(30);
	}
	static {
		System.out.println("执行Parent的静态初始化代码块");
		int sx = 70;
		int sy = getValue(30);
	}
	public Parent() {
		System.out.println("Parent默认的构造方法被调用");
	}
	public void display() {
		System.out.println("Parent的display方法被调用");
		System.out.print("x=" + this.x);
		System.out.println("; y=" + y);
		parentMethod();
	}
	public static void parentMethod() {
		System.out.println("Parent的parentMethod()被调用");
	}
	public static int getValue(int num) {
		System.out.println("Parent的getValue(int num)被调用");
		return ++num;
	}
	// 当Java在进行垃圾回收时，会自动的调用对象的finalize方法
	protected void finalize() {
		System.out.println("Parent对象被垃圾收回器收回");
	}
}
class Child extends Parent {// 子类
	{
		System.out.println("执行Child的初始化代码块");
		int z = 30;
	}
	static {
		System.out.println("执行Child的静态初始化代码块");
	}
	public Child() {
		super();
		System.out.println("Child的构造方法被调用");
	}
	public Child(String str) {
		System.out.println("Child带参的构造方法被调用");
	}
	public static void childMethod() {
		System.out.println("Child的childMethod()被调用");
	}
	// 当Java在进行垃圾回收时，会自动的调用对象的finalize方法
	protected void finalize() {
		System.out.println("Child对象被垃圾收回器收回");
		super.finalize();
	}
}
