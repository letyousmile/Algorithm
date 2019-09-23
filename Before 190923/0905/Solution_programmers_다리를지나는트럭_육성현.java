import java.util.LinkedList;
import java.util.List;

class Solution {
	class Truck {
		int weight;
		int time;

		public Truck(int weight, int time) {
			super();
			this.weight = weight;
			this.time = time;
		}
	}

	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 1;
		int total = 0;
		int num = 0;
		int len = truck_weights.length;
		List<Truck> q = new LinkedList<>();
		for (int i = 0; i < len; i++) {
			q.add(new Truck(truck_weights[i], 0));
		}
		while (!q.isEmpty()) {
			answer++;
			if (num < q.size() && total + q.get(num).weight <= weight) {
				total += q.get(num).weight;
				num++;
			}
			for (int i = 0; i < num; i++) {
				q.get(i).time++;
			}
			if (q.get(0).time == bridge_length) {
				total -= q.get(0).weight;
				q.remove(0);
				num--;
			}
		}
		return answer;
	}
}