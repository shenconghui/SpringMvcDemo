package com.model;
public class UseSuper {
	public static void main(String[] args) {
		// 分别用不同的4种方法创建State类对象
		State sta1 = new State("张三", '男', 22, "中国");
		State sta2 = new State("琶拉?¤凡?¤连根", '女', 41, "印度");
		State sta3 = new State();
		State sta4 = new State(sta1);
		// 分别调用State类的属性和其父类Person的showMessage方法
		System.out.print("显示第一个人的基本信息：");
		sta1.showMessage();
		System.out.println("此人的国籍是:" + sta1.name);
		System.out.print("\n显示第二个人的基本信息：");
		sta2.showMessage();
		System.out.println("此人的国籍是:" + sta2.name);
		System.out.print("\n显示第三个人的基本信息：：");
		sta3.showMessage();
		System.out.println("此人的国籍是:" + sta3.name);
		System.out.print("\n显示第四个人的基本信息：");
		sta4.showMessage();
		System.out.println("此人的国籍是:" + sta4.name);
	}
}
class Person {
	public String name;	// 姓名
	public char sex;		// 性别
	public int age;		// 年龄
	// 设置默认值
	Person() {
		name = "尹继平";
		sex = '女';
		age = 26;
	}
	// 对象作为构造方法的参数
	Person(Person p) {
		name = p.name;
		sex = p.sex;
		age = p.age;
	}
	// 指定值初始化对象
	Person(String name, char sex, int age) {
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	// 输出person的基本信息
	public void showMessage() {
		System.out.println("姓名： " + name + "\n性别： " + sex + "\n年龄： " + age);
	}
}
// 实现所有超类的构造方法
class State extends Person {
	public String name;	// 国家的名字
	// 设置默认值
	State() {
		super();
		name = "中国";
	}
	// 对象作为构造方法的参数
	State(State ch) {
		super(ch);
		super.name = "罗卜特?¤波伊尔";
		this.name = "英国";
	}
	// 指定值初始化类Chinese的对象
	State(String n, char s, int a, String na) {
		super(n, s, a);
		name = na;
	}
}
