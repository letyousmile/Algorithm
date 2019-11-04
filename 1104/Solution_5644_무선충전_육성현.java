import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_5644_무선충전_육성현 {
	static class Charger implements Comparable<Charger>{
		int y;
		int x;
		int C;
		int P;
		public Charger(int y, int x, int C, int P) {
			super();
			this.y = y;
			this.x = x;
			this.C = C;
			this.P = P;
		}
		@Override
		public int compareTo(Charger o) {
			// TODO Auto-generated method stub
			return Integer.valueOf(this.P).compareTo(o.P);
		}
		
		
	}
	static int M;
	static int A;
	static int[] move1=new int[101];
	static int[] move2 = new int[101];
	static Charger[] charger;
	static int result;
	static int[] dy= {0,-1,0,1,0};
	static int[] dx = {0,0,1,0,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<T;i++) {
			String[] srr = br.readLine().split(" ");
			M = Integer.parseInt(srr[0]);
			A = Integer.parseInt(srr[1]);
			charger = new Charger[A];
			String[] user1 = br.readLine().split(" ");
			String[] user2 = br.readLine().split(" ");
			move1[0] = 0;
			move2[0] = 0;
			for(int j=1;j<=M;j++) {
				move1[j] = Integer.parseInt(user1[j-1]);
				move2[j] = Integer.parseInt(user2[j-1]);
			}
			for(int j=0;j<A;j++) {
				String[] input = br.readLine().split(" ");
				int x = Integer.parseInt(input[0]);
				int y = Integer.parseInt(input[1]);
				int C = Integer.parseInt(input[2]);
				int P = Integer.parseInt(input[3]);
				charger[j] = new Charger(y, x, C, P);
			}
			func();
			sb.append("#"+(i+1)+" "+result+"\n");
		}
		System.out.print(sb);
	}
	public static void func() {
		Arrays.sort(charger);
		result = 0;
		int y1=1;
		int x1=1;
		int y2=10;
		int x2=10;
		for(int i=0;i<=M;i++) {
			int d1=move1[i];
			int d2=move2[i];
			
			y1+=dy[d1];
			x1+=dx[d1];
			int p1=0;
			y2+=dy[d2];
			x2+=dx[d2];
			int p2=0;
			int num1=0;
			int num2=0;
			int temp1=0;
			int temp2=0;
			int x = 0;
			boolean vec=false;
			for(int j=0;j<A;j++) {
				Charger c = charger[j];
				x = 0;
				if(Math.abs(c.x-x1)+Math.abs(c.y-y1)<=c.C) {
					temp1=p1;
					p1=c.P;
					x++;
					num1++;
				}
				if(Math.abs(c.x-x2)+Math.abs(c.y-y2)<=c.C) {
					temp2=p2;
					p2=c.P;
					x++;
					num2++;
				}
				if(x==2&&p1==p2) {
					vec=true;
				}
				
			}
			if(p1==p2&&num1!=0&&num2!=0&&vec) {
				if(num1==1&&num2==1) {
					p2=0;					
				}else if(num1==1) {
					p2=temp2;
				}else if(num2==1) {
					p1=temp1;
				}else {
					if(temp1>temp2) {
						p1=temp1;
					}else {
						p2=temp2;
					}
				}
			}
			result+=p1+p2;
		}
	}
}
