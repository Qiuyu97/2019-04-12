package com.day.io;

import java.io.*;

public class Remove {
	/*
	 * io流实现把D盘下的a.txt文件移动到E盘下
	 */
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		// 创建file对象
		File file = new File("D:/a.txt");
		if (file.exists()) {
			FileInputStream fis = new FileInputStream(file);
			while (true) {
				int x = fis.read();
				if (x == -1) {
					break;
				}
				sb.append((char) x);
			}
			fis.close();
		}
		file.delete();
		// 先保证路径及文件夹【根目录，没有路径，不进行操作】
		// 创建File对象
		File f = new File("E:/a.txt");
		// 判断有没有，没有创建好
		if (!f.exists()) {
		   f.createNewFile();	
		}
		// 创建输出流对象，基于指定的File对象
		FileOutputStream fos = new FileOutputStream(f);

		// 循环字符串提取字符，获得char
		for (int i = 0; i < sb.length(); i++) {
			char c = sb.charAt(i);
			fos.write(c);

		}
		System.out.println("移动成功！！");
		fos.close();

	}
}
