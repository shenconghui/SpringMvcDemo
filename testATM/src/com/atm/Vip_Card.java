package com.atm;

import com.atm.Common_Card;

//vip用户的功能实现
// vip用户继承了普通用户，普通用户所拥有的功能vip用户全部有
public class Vip_Card extends Common_Card {
	Vip_Card(String name, int ID, int password, int money) {// 构造方法
		super(name, ID, password, money);
	}
	boolean CheckMoney(int m)// 不仅具有存取款的功能还具有可以透支的功能
	{
		System.out.println("正在操作，请稍候……！");
		if (m < 0) {
			if (saveMoney(-m)) {
				return true;
			} else
				return false;
		} else {
			if (m - 5000 > money) {
				System.out.println("［?á］：该账户透支不可超过5000元,本次操作中断！");
				return false;
			}
			this.money -= m;
			System.out.println("［√］：操作成功!");
			return true;
		}
	}
	void TransferMoney(Common_Card st[])// 转账的功能
	{
		System.out.println("请输入目标帐户ID:");
		int id = EnterAmountOfMoney.scanInt();
		int i;
		for (i = 0; i < st.length; i++) {
			if (st[i].ID == id) {
				System.out.println("请输入转账金额：");
				int m = EnterAmountOfMoney.scanInt();
				if (m < 0) {
					System.out.println("请输入目标帐户密码：");
					if (st[i].checkpassword() == false)
						return;
				}
				if (this.CheckMoney(m)) {
					st[i].saveMoney(m);
					System.out.println("［√］：转账成功!");
				} else {
					System.out.println("［?á］:转账失败!");
				}
				break;
			}
		}
		if (i == st.length)
			System.out.println("［?á］:用户不存在!");
	}
	void operating(Common_Card st[])// 正在操作
	{
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
				case 4:
					TransferMoney(st);
					break;
				case 0:
					Machine.end = 0;
					return;
			}
		}
	}
	static void printReceipt() {// Vip用户功能提示操作界面
		System.out.println("我爱我家自动提款机-Vip用户操作界面");
		System.out.println("——————");
		System.out.println("［存款——1］");
		System.out.println("［取款——2］");
		System.out.println("［余额——3］");
		System.out.println("［转账——4］");
		System.out.println("［退卡——0］");
		System.out.println("——————");
	}
}
