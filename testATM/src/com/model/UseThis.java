package com.model;
public class UseThis {
	public static void main(String[] args) {
		Film f = new Film();
		System.out.println("欢迎收看\"佳片有约\"栏目,今天为您推荐的影片如下：");
		// 获取Film类中的所有属性值
		System.out.println("片名：" + f.title);
		System.out.println("导演：" + f.director);
		System.out.println("主演：" + f.star);
		System.out.println("上映日期：" + f.showDate);
	}
}
class Film {
	String title;		// 片名
	String director;		// 导演
	String star;		// 主演
	String showDate;	// 上映的时间
	// 以下实现了该类的构造方法的重写
	Film() {
		this("2009年6月26日");// 调用本身
	}
	Film(String showDate) {
		this("《变形金刚2：卷土重来》", "迈克尔.贝", "希亚.拉博夫");
		this.showDate = showDate;
	}
	Film(String title, String director) {
		this.title = title;
		this.director = director;
	}
	Film(String title, String director, String star) {
		this(title, director);
		this.star = star;
	}
}
