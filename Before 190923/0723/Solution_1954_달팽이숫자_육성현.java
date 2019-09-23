package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1954_달팽이숫자_육성현 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		System.out.println(reverseString("abc"));
		for(int i=0;i<T;i++) {
			long K = Long.parseLong(br.readLine());
			String P=makeP(59);
			System.out.println("#"+(i+1)+ " "+ P.charAt(K));
		}
	}
	public static String makeP(int n) {
		if(n==0) {
			return "0";
		}
		else if{
			return makeP(n-1)+"0"+func(makeP(n-1));
		}
	}
	public static String func(String input) {
		String ouput = reverseString(input);
	}
	public static String reverseString(String input) {
		String output = "";
		for(int i=input.length();i>=0;i++) {
			output = output +Character.toString(input.charAt(i));
		}
		return output;
	}
}
