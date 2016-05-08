package com.car;
public class AccessMethod {
	public static void main(String[] args) {
		// 先测试继承时变量的覆盖与隐藏问题
		System.out.println("在继承关系中，同名变量的覆盖与隐藏的执行内容如下：");
		ChildClass child = new ChildClass();
		System.out.println("创建了ChildClass对象，ChildClass的属性信息如下：");
		System.out.println("name: " + child.name + "; age: " + child.age
				+ "; kind: " + child.classvar);// 此时得到的都是ChildClass类的变量值
		// 将ChildClass类型转换成ParentClass对象，
		ParentClass parent = child;
		System.out.println("将创建的ChildClass对象赋值给ParentClass对象，其属性信息如下：");
		System.out.println("name: " + parent.name + "; age: " + parent.age
				+ "; kind: " + parent.classvar);// 此时得到的都是ParentClass类的变量值
		System.out.println("子类可以访问父类被隐藏的实例变量 name：" + child.getParentName());
		System.out.println("子类可以访问父类被隐藏的实例变量 age：" + child.getParentAge());
		System.out.println("子类可以访问父类被隐藏的静态变量 kind："
				+ ChildClass.getParentKind());
		System.out.println();
		// 再测试继承时方法的覆盖与隐藏问题
		System.out.println("在继承关系中，同名方法的覆盖与隐藏的执行内容如下：");
		child.getName();	// 实例方法
		child.getClassVar();	// 静态方法
		parent.getName();	// 实例方法
		parent.getClassVar();// 静态方法
	}
}
class ParentClass {
	public static String classvar = "Chapter09.Inheritance.ParentClass"; // 类变量，ParentClass的类别
	public static int age = 50; 			// 类变量，ParentClass的年龄
	public String name = "ParentClass"; // 实例变量，ParentClass的名字
	// 静态方法，获取ParentClass的类别 */
	public static String getClassVar() {
		// 静态方法中操作的只能是类变量
		System.out.println("ParentClass的getClassVar()方法被调用了！");
		return classvar;
	}
	// 静态方法，获取ParentClass的年龄 */
	public static int getAge() {
		System.out.println("ParentClass的getAge()方法被调用了！");
		return age;
	}
	// 实例方法，获取ParentClass的名字 */
	public String getName() {
		// 实例方法中操作的可以是实例变量，也可以是类变量
		System.out.println("ParentClass的getName()方法被调用了！");
		return this.name;
	}
	// final方法，将ParentClass的减1
	public final int getPreviousAage() {
		System.out.println("ParentClass的getPreviousAage()方法被调用了！");
		return --age;
	}
}
class ChildClass extends ParentClass {
	public static String classvar = "Chapter09.Inheritance.ChildClass"; // 类变量，Child的类别
	public int age = 25;// 实例变量，ChildClass的年龄，在ParentClass类中是static的。
	public String name = "ChildClass"; // 实例变量，ChildClass的名字
	// 静态方法，获取ChildClass的类别
	public static String getClassVar() {
		System.out.println("ChildClass的getClassVar()方法被调用了！");
		return classvar;
	}
	// 静态方法，获取父类的名字
	public static String getParentKind() {
		// 通过类名加"."访问父类中被隐藏的类变量
		return ParentClass.classvar;
	}
	// 实例方法，获取ChildClass的名字
	public String getName() {
		System.out.println("ChildClass的getName()方法被调用了！");
		return this.name;
	}
	// 实例方法，获取父类的名字
	public String getParentName() {
		// 通过super关键字父类中被隐藏的实例变量
		return super.name;
	}
	// 实例方法，获取父类的姓名
	public String getParentAge() {
		// 通过super关键字父类中被隐藏的实例变量
		return super.name;
	}
}
