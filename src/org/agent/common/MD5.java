package org.agent.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;

public class MD5 {
	private String inStr;
	private MessageDigest md5;

	/* 下面是构造函数 */
	public MD5(String inStr) {
		this.inStr = inStr;
		try {
			this.md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}

	/* 下面是关键的md5算法 */
	public String compute() {

		char[] charArray = this.inStr.toCharArray();

		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++)
			byteArray[i] = (byte) charArray[i];

		byte[] md5Bytes = this.md5.digest(byteArray);

		StringBuffer hexValue = new StringBuffer();

		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16)
				hexValue.append("0");
			hexValue.append(Integer.toHexString(val));
		}

		return hexValue.toString();
	}

	/* 下面是主函数调用 */
	public static void main(String[] args) {
		String A = null;
		try {
			System.out.println("请输入你要加密的数据:");
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			A = br.readLine();
		} catch (IOException e) {
		}
		;
		MD5 md5 = new MD5(A);
		String postString = md5.compute();
		System.out.println("加密后的数据:" + postString);
	}
}
