package com.atm;
//普通用户的功能实现
public class Common_Card {
	String name;	// 账户名
	int ID;		// 账户ID
	int password;	// 密码
	int money;		// 金额
	Common_Card(String name, int ID, int password, int money) {// 构造方法
		this.name = name;
		this.ID = ID;
		this.password = password;
		this.money = money;
	}
	boolean CheckMoney(int m) {// 取款操作
		System.out.println("正在操作，请稍候……！");
		if (m < 0) {
			if (saveMoney(-m)) {
				return true;
			}
			else
				return false;
		} else {
			if (m > money) {
				System.out.println("［?á］：该账户不可透支,本次操作中断！");
				return false;
			}
			this.money -= m;
			System.out.println("［√］：操作成功");
			return true;
		}
	}
	boolean saveMoney(int m) {// 存款操作
		System.out.println("正在验钞，请稍候……！");
		if (m < 0) {
			if (CheckMoney(-m))
				return true;
			else
				return false;
		} else {
			this.money += m;
			System.out.println("［√］：操作成功");
			return true;
		}
	}
	void search() {				// 显示余额操作
		System.out.println(name + "［ID:" + ID + "］ 余额:" + money + "元");
	}
	boolean checkpassword() {	// 检察密码操作
		int i;
		for (i = 0; i < 3; i++) {
			if (i > 0)
				System.out.println("［?á］：密码错误，请输入密码：");
			int pw = EnterAmountOfMoney.scanInt();
			if (pw == password)
				return true;
		}
		if (i == 3)
			System.out.println("［?á］：密码输入出错3次，操作中断！");
		return false;
	}
	void operating(Common_Card st[]) {// 正在执行所选择的项目
		while (true) {
			this.printReceipt();
			int cmd = EnterAmountOfMoney.scanInt();
			switch (cmd) {
				case 1: {
					System.out.println("请输入存款数：");
					int m = EnterAmountOfMoney.scanInt();
					saveMoney(m);
					break;
				}
				case 2: {
					System.out.println("请输入取款数：");
					int m = EnterAmountOfMoney.scanInt();
					CheckMoney(m);
					break;
				}
				case 3:
					search();
					break;
				case 0:
					Machine.end = 0;
					return;
			}
		}
	}
	static void printReceipt() {// 功能提示界面
		System.out.println("我爱我家自动提款机普通用户操作界面");
		System.out.println("——————");
		System.out.println("［存款——1］");
		System.out.println("［取款——2］");
		System.out.println("［余额——3］");
		System.out.println("［退卡——0］");
		System.out.println("——————");
	}
}
