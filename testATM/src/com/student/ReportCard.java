package com.student;
public class ReportCard {
	public static void main(String[] args) {
		// 创建StudentAchievement对象
		StudentAchievement sa = new StudentAchievement("张三", "三年一班");
		sa.print();// 调用自身的print方法
		// 调用父类的Subject_Score方法
		sa.Subject_Score("代数", "英语", "语文", "政治");
		sa.Subject_Score(80.5, 78.5, 88, 91);
		// 调用父类的getRemark方法
		sa
				.getRemark("该生在学表现积极，能够认真对待老师分配的任务，积极配合老师的工作\n但是该生的基本知识不牢固，希望家长能多注意一下补习基本知识。");
		System.out.println("各科成绩如下：");
		// 调用父类的成员变量
		System.out.println(sa.sub1 + ":" + sa.s1 + "\n" + sa.sub2 + ":" + sa.s2
				+ "\n" + sa.sub3 + ":" + sa.s3 + "\n" + sa.sub4 + ":" + sa.s4);
		System.out.println("总成绩为：" + sa.getSum());		// 调用父类的getSum方法
		System.out.println("平均成绩为：" + sa.getAverage());	// 调用父类的getAverage方法
		System.out.println("老师的评语为：" + sa.review);		// 调用父类的review变量
	}
}
class Subject_Score {			// 父类
	String name;				// 姓名
	String classroom;			// 班级
	String sub1, sub2, sub3, sub4;	// 各学科的科目名称
	double s1, s2, s3, s4;		// 各学科的分数
	String review;				// 老师的评语
	Subject_Score(String name, String classroom) {// Subject_Score类的构造方法，为name和classroom赋值
		this.name = name;
		this.classroom = classroom;
	}
	void Subject_Score(String sub1, String sub2, String sub3, String sub4) {// Subject_Score方法为各学科的科目名称赋值
		this.sub3 = sub3;
		this.sub2 = sub2;
		this.sub1 = sub1;
		this.sub4 = sub4;
	}
	void Subject_Score(double s1, double s2, double s3, double s4) {// Subject_Score方法为各学科的分数赋值
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
		this.s4 = s4;
	}
	public double getSum() {				// 求总成绩
		double sum = this.s1 + this.s2 + this.s3 + this.s4;
		return Math.rint(sum);
	}
	public double getAverage() {			// 求平均成绩
		double sum = this.getSum();
		double avg = sum / 4;
		return Math.rint(avg);
	}
	public String getRemark(String review) {	// 设置评语
		this.review = review;
		return review;
	}
}
class StudentAchievement extends Subject_Score {			// 子类
	StudentAchievement(String name, String classroom) {	// 继承父类的构造方法
		super(name, classroom);
	}
	public void print() {								// 子类自定义方法
		System.out.println(name + "的期末考试成绩单如下：");
	}
}
