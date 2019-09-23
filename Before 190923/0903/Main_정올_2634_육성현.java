import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	static class Animal implements Comparable<Animal>{
		int from;
		int to;
		public Animal(int from, int to) {
			super();
			this.from = from;
			this.to = to;
		}
		@Override
		public int compareTo(Animal o) {
			if(this.from==o.from) return Integer.valueOf(this.to).compareTo(o.to);
			return Integer.valueOf(this.from).compareTo(o.from);
		}
		@Override
		public String toString() {
			return from+" " +to;
		}
		
	}
	static List<Animal> list = new ArrayList<>();
	static int num;
	static int[][] map;
	static int M,L;
	static int[] gunner;
	static boolean[][] visited;
	static int max =Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] srr = br.readLine().split(" ");
		M = Integer.parseInt(srr[0]);
		gunner = new int[M];
		int N = Integer.parseInt(srr[1]);
		L = Integer.parseInt(srr[2]);
		String[] input = br.readLine().split(" ");
		for(int i=0;i<M;i++) {
			gunner[i] = Integer.parseInt(input[i]);
			if(gunner[i]>max) max = gunner[i];
			if(gunner[i]<min) min = gunner[i];
		}
		Arrays.sort(gunner);
		String[] srr2 = new String[2];
		int x;
		int y;
		int d = 0;
		for(int i=0;i<N;i++) {
			srr2 = br.readLine().split(" ");
			x = Integer.parseInt(srr2[0]);
			y = Integer.parseInt(srr2[1]);
			d = L-y;
			if(L<0) continue;
			int from = x-d;
			int to = x+d;
			if(from>max||to<min) continue;
			if(from<0) from = 0;
			if(to>1000000000) to = 1000000000;
			list.add(new Animal(from,to));
		}
		Collections.sort(list);
		hunt();
		System.out.println(num);
	}
	public static void hunt() {
		Animal a;
//		System.out.println(Arrays.toString(gunner));
//		for(int i=0;i<list.size();i++) {
//			System.out.println(list.get(i));
//		}
		int s = 0;
		for(int i=0;i<list.size();i++) {
			a=list.get(i);
			for(int j=s;j<M;j++) {
				if(gunner[j]>a.to) {
					s=j;
					break;
				}
				else if(gunner[j]>=a.from) {
					num++;
					s=j;
					break;
				}
			}
//			for(int j=0;j<M;j++) {
//				if(gunner[j]>a.to) break;
//				else if(gunner[j]>=a.from){
//					num++;
//					break;
//				}
//			}
		}
	}
}
