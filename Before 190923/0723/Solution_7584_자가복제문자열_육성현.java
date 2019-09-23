package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_7584_자가복제문자열_육성현 {
	public static long K;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		long end = pow();
		for(int i=0;i<T;i++) {
			K = Integer.parseInt(br.readLine());
			
			System.out.println("#"+(i+1)+" "+find(1,end));
		}
	}
	public static int find(long start, long end) {
		long mid = (start+end)/2;
		int result = -1;
		while(true) {
			if(mid>K) {
				result = 0;
				end = mid - 1;
			}
			else if(mid<K) {
				result = 1;
				start = mid + 1;
			}
			else {
				return result;
			}
			mid = (start+end)/2;
		}
	}
	public static long pow() {
		long result = 1;
		for(int i=0;i<60;i++)
			result*=2;
		return result;
	}
}
