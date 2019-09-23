import java.util.Arrays;

class Solution {
    static double[] x;
	static class Order implements Comparable<Order>{
		int num;

		public Order(int num) {
			super();
			this.num = num;
		}

		@Override
		public int compareTo(Order o) {
			if(x[o.num]==x[this.num]) {
				return Integer.valueOf(this.num).compareTo(o.num);
			}
			else {
				return Double.valueOf(x[o.num]).compareTo(x[this.num]);
			}
		}
    }
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
		int[] num = new int[N];
		int[] fail = new int[N];
		for(int i=0;i<stages.length;i++) {
			for(int j=0;j<stages[i];j++) {
				if(j==N) continue;
				num[j]++;
			}
			if(stages[i]==N+1) continue;
			fail[stages[i]-1]++;
		}
		x = new double[N];
		for(int i=0;i<N;i++) {
            if(num[i]==0) {
                x[i] = 0;
                continue;
            }
			x[i] = (double)fail[i]/num[i];
			System.out.print(x[i]+" ");
		}
		Order[] order = new Order[N];
		for(int i=0;i<N;i++) {
			order[i] = new Order(i);
		}
		Arrays.sort(order);
		for(int i=0;i<N;i++) {
			answer[i] = order[i].num+1;
		}
//		System.out.println(Arrays.toString(order));
//		System.out.println();
		
		return answer;
    }
}