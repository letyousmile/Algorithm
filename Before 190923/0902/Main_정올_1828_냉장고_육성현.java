import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n;
	static class Temp implements Comparable<Temp>{
		int from;
		int to;
		public Temp(int from, int to) {
			super();
			this.from = from;
			this.to = to;
		}
		@Override
		public int compareTo(Temp o) {
			if(this.to==o.to) {
				return Integer.valueOf(this.from).compareTo(o.from);
			}
			return Integer.valueOf(this.to).compareTo(o.to);
		}
		@Override
		public String toString() {
			return from + " "+ to;
		}
		
	}
	static Temp[] temp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		temp = new Temp[n];
		for(int i=0;i<n;i++) {
			String[] input = br.readLine().split(" ");
			int from = Integer.parseInt(input[0]);
			int to = Integer.parseInt(input[1]);
			temp[i] = new Temp(from, to);
		}
		Arrays.sort(temp);
//		System.out.println(Arrays.toString(temp));
		int to = temp[0].to;
		int num = 1;
		for(int i=1;i<n;i++) {
			if(to>=temp[i].from) {
//				to = temp[i].from;
				continue;
			}else {
				to = temp[i].to;
				num++;
			}
		}
		System.out.println(num);
	}
}
