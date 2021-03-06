package com.xiong.test;

import java.util.Random;

/**
 * 题目1：对数组中的最后一位进行加1的运算 [1,2,3,4]->[1,2,3,5]
 * 题目2：实现字符串的二进制加法  “111” + “11” = “1010”
 * @author 作者:XiaoXiong
 * @version 创建时间：2018年4月18日 下午10:26:19
 */
public class PlusOne {
	
	public static String binaryPlus(String a, String b) {
		int aLen = a.length()-1, bLen = b.length()-1;
		int cLen = aLen > bLen ? aLen : bLen;
		StringBuilder result = new StringBuilder();
		int[] array = new int[cLen+2];
		int arrayIndex = 0;
		int flag = 0;
		if (aLen >= 0 || bLen >= 0) {
			int aa = Integer.parseInt(String.valueOf(a.charAt(aLen)));
			int bb = Integer.parseInt(String.valueOf(b.charAt(bLen)));
			if (aLen < 0) {
				aa = 0;
			} else if (bLen < 0){
				bb = 0;
			}
			int index = aa ^ bb ^ flag;
			if(aa + bb + flag >= 2) flag = 1;
			array[arrayIndex] = index;
			arrayIndex++;
			if (flag == 1 && arrayIndex == array.length-1) array[array.length-1] = 1;
			aLen--;
			bLen--;
		}
		for (int i = 0; i < array.length; i++) {
			result.append(array[i]);
		}
		return result.reverse().toString();
	}
	
	public static int[] plusOne(int[] nums) {
		int index = nums.length-1;
		while(index >= 0) {
			int temp = nums[index];
			if (nums[index] != 9) {
				nums[index] = temp + 1;
				break;
			} else {
				nums[index] = 0;
				if (index == 0) {
					int[] array = new int[nums.length+1];
					array[0] = 1;
					return array;
				}
				index--;
			}
		}
		return nums;
	}
	
	public static void main(String[] args) {
		System.out.println(binaryPlus("111", "1"));
		int[] nums = {9,9,9};
		Utils.show(plusOne(nums));
		Random random = new Random();
		System.out.println(random.nextInt(10));
	}

}
