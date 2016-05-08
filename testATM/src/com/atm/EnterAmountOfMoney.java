package com.atm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//EnterAmountOfMoney类的主要作用是录入数据。
public class EnterAmountOfMoney {
	public static String scan()// 可以从键盘上录入数据
	{
		String str = "";
		try {
			BufferedReader buf = new BufferedReader(new InputStreamReader(
					System.in));
			str = buf.readLine();
		} catch (Exception e) {
		}
		return str;
	}
	public static int scanInt()// 将从键盘上录入数据转换成int型数据
	{
		int temp = 0;
		try {
			temp = Integer.parseInt(scan());
		} catch (Exception e) {
			System.out.println("［?á］：输入不合法，请输入整数：");
		}
		return temp;
	}
}
