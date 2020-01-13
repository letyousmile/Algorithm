import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_정올_2247_도서관_육성현 {
	static class Student implements Comparable<Student>{
		int from;
		int to;
		public Student(int from, int to) {
			super();
			this.from = from;
			this.to = to;
		}
		@Override
		public int compareTo(Student o) {
			if(this.to==o.to) return Integer.valueOf(o.from).compareTo(this.from);
			else return Integer.valueOf(o.to).compareTo(this.to);
		}
		
	}
	
	static int N;
	static Student[] student;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		student = new Student[N];
		
		int from, to;
		for(int i=0;i<N;i++) {
			String[] input = br.readLine().split(" ");
			from = Integer.parseInt(input[0]);
			to = Integer.parseInt(input[1]);
			student[i] = new Student(from,to);
		}
		Arrays.sort(student);
//		for(int i=0;i<N;i++) {
//			System.out.println(student[i].to+" "+student[i].from);
//		}
		func();
	}
	public static void func() {
		int to = student[0].to;
		int from = student[0].from;
		int stay = 0;
		int empty = 0;
		for(int i=1;i<N;i++) {
//			System.out.println(to+" "+from);
			if(student[i].to>=from) {
				if(student[i].from<from) from = student[i].from;
			}else {
				if(to-from>stay) stay = to-from;
				to = student[i].to;
				if(from-to>empty) empty = from-to;
				from = student[i].from;
//				System.out.println(stay+" "+empty);
			}
		}
		if(to-from>stay) stay = to-from;
		System.out.println(stay+" "+empty);
	}
}
