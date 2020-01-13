import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_백준_2668_숫자고르기_육성현 {
	static int N;
	static boolean[] visited;
	static boolean[] list2;
	static int[] arr;
	static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N+1];
		list2 = new boolean[N+1];
		arr = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i]==i) {
				list.add(i);
				visited[i]=true;
			}
		}
		
		for(int i=1;i<=N;i++) {
			int start = i;
			if(visited[start]) continue;
			List<Integer> p = new ArrayList<>();
			p.add(start);
			visited[start]=true;
			int end = arr[start];
			while(true) {
//				System.out.println(start+" "+end);
				if(visited[end]) {
					for(int j=0;j<p.size();j++) {
						visited[p.get(j)]=false;
					}
					break;
				}
				p.add(end);
				visited[end]=true;
				end = arr[end];
				if(start==end) {
					visited[end]=true;
					for(int j=0;j<p.size();j++) {
						if(list2[p.get(j)]) break;
						list.add(p.get(j));
						list2[p.get(j)]=true;
					}
				}
			}
		}
		
		
		Collections.sort(list);
		System.out.println(list.size());
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
}
