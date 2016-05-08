package com.atm;
//Machine类本程序的测试类
public class Machine {
	static int end = 1;
	public static void main(String[] args) {
		Common_Card st[] = new Common_Card[4];// 创建一个有4个用户的数组
		// 创建2个普通用户
		st[0] = new Common_Card("未知", 999, 999, 0);
		st[1] = new Common_Card("聂庆亮", 200981501, 10010, 100000);
		// 创建2个VIP用户
		st[2] = new Vip_Card("乐乐", 200981511, 583911, 13000);
		st[3] = new Vip_Card("尹继平", 200981512, 1324114, 22000);
		while (true) {
			if (end == 0) {// 用于退卡操作
				System.out.println("谢谢您的使用，再见");
				return;
			}
			System.out.println("请输入帐户ID：［0:退出］");
			int id = EnterAmountOfMoney.scanInt();	// 获取从键盘上输入的数据
			if (id == 0)
				return;
			int i;
			for (i = 0; i < st.length; i++) {
				if (st[i].ID == id) {				// 如果用户帐户ID正确则输入密码
					System.out.println("请输入帐户密码：");
					if (st[i].checkpassword()) {		// 调用Common_Card类的checkpassword进行核查
						st[i].operating(st);		// 如果密码输入正确则调用
						break;
					}
				}
			}
			if (i == st.length) {
				System.out.println("［?á］：该用户不存在！");
			}
		}
	}
}
