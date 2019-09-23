package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_1209_SW문제해결기본2일차_Sum_육성현 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<10;i++) {
			int Tc = Integer.parseInt(br.readLine());
			int[][] arr = new int[100][100];
			String[] input;
			for(int j=0;j<100;j++) {
				input = br.readLine().split(" ");
				for(int k=0;k<100;k++) {
					arr[j][k]=Integer.parseInt(input[k]);
				}
			}
			int rowColMax = -1;
			int sumR = 0;
			int sumC = 0;
			int max = -1;
			for(int j=0;j<100;j++) {
				sumR = 0;
				sumC = 0;
				for(int k=0;k<100;k++) {
					sumR+=arr[j][k];
					sumC+=arr[k][j];
				}
				max = sumR> sumC ? sumR:sumC;
				if(max>rowColMax)
					rowColMax=max;
			}
			System.out.println(rowColMax);
			int side1 = 0;
			int side2 = 0;
			int sideMax = -1;
			for(int j=0;j<100;j++) {
				side1+=arr[j][j];
				side2+=arr[j][99-j];
			}
			sideMax = side1>side2? side1:side2;
			if(sideMax<rowColMax)
				sideMax = rowColMax;
			System.out.println("#"+Tc+" "+sideMax);
		}
	}
}
