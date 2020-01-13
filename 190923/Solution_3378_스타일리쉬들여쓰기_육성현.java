import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution_3378_스타일리쉬들여쓰기_육성현 {
	static int N, M;
	static String[] input;
	static String[] output;
	static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String[] srr = br.readLine().split(" ");
			N = Integer.parseInt(srr[0]);
			M = Integer.parseInt(srr[1]);
			input = new String[N];
			output = new String[M];
			result = new int[M];
			for (int j = 0; j < N; j++) {
				input[j] = br.readLine();
			}
			for (int j = 0; j < M; j++) {
				output[j] = br.readLine();
			}
			func();
			System.out.print("#" + (i + 1) + " ");
			for (int j = 0; j < result.length; j++) {
				System.out.print(result[j] + " ");
			}
			System.out.println();
		}
	}

	public static void func() {
		List<Integer> R = new ArrayList<>();
		List<Integer> C = new ArrayList<>();
		List<Integer> S = new ArrayList<>();
		boolean[] possible = new boolean[8000];
		int pNum = 0;
		int[] a = new int[N + 1];
		int[] b = new int[N + 1];
		int[] c = new int[N + 1];
		int[] d = new int[N + 1];
		int[] e = new int[N + 1];
		int[] f = new int[N + 1];

		int[] space = new int[N];
		for (int i = 0; i < N; i++) {
			boolean vec = true;
			for (int j = 0; j < input[i].length(); j++) {
				if (input[i].charAt(j) == '(') {
					if (a[i + 1] == 0)
						a[i + 1] = a[i] + 1;
					else
						a[i + 1]++;
					vec = false;
				} else if (input[i].charAt(j) == ')') {
					if (b[i + 1] == 0)
						b[i + 1] = b[i] + 1;
					else
						b[i + 1]++;
					vec = false;
				} else if (input[i].charAt(j) == '{') {
					if (c[i + 1] == 0)
						c[i + 1] = c[i] + 1;
					else
						c[i + 1]++;
					vec = false;
				} else if (input[i].charAt(j) == '}') {
					if (d[i + 1] == 0)
						d[i + 1] = d[i] + 1;
					else
						d[i + 1]++;
					vec = false;
				} else if (input[i].charAt(j) == '[') {
					if (e[i + 1] == 0)
						e[i + 1] = e[i] + 1;
					else
						e[i + 1]++;
					vec = false;
				} else if (input[i].charAt(j) == ']') {
					if (f[i + 1] == 0)
						f[i + 1] = f[i] + 1;
					else
						f[i + 1]++;
					vec = false;
				} else if (vec && input[i].charAt(j) == '.') {
					space[i]++;
				} else {
					vec = false;
				}
				if (a[i + 1] == 0)
					a[i + 1] = a[i];
				if (b[i + 1] == 0)
					b[i + 1] = b[i];
				if (c[i + 1] == 0)
					c[i + 1] = c[i];
				if (d[i + 1] == 0)
					d[i + 1] = d[i];
				if (e[i + 1] == 0)
					e[i + 1] = e[i];
				if (f[i + 1] == 0)
					f[i + 1] = f[i];
			}
		}
//		System.out.println(space.length);
		int x1 = a[1] - b[1];
		int y1 = c[1] - d[1];
		int z1 = e[1] - f[1];
		for (int j = 1; j <= 20; j++) {
			for (int k = 1; k <= 20; k++) {
				for (int l = 1; l <= 20; l++) {
					if(N==1) {
						R.add(j);
						C.add(k);
						S.add(l);
						possible[pNum++] = true;
					}
					else if (j * x1 + k * y1 + l * z1 == space[1]) {
						R.add(j);
						C.add(k);
						S.add(l);
						possible[pNum++] = true;
					}
				}
			}
		}
//		System.out.println(space[1]);
//		System.out.println(R.size());
//		System.out.println(pNum);
		for (int i = 2; i < N; i++) {
			int x = a[i] - b[i];
			int y = c[i] - d[i];
			int z = e[i] - f[i];
//			System.out.println(x+" "+y+" "+z);
//			System.out.println(space[i]);
			for (int j = 0; j < R.size(); j++) {
				if (!possible[j])
					continue;
				if (((R.get(j) * x) + (C.get(j) * y) + (S.get(j) * z)) != space[i]) {
					possible[j] = false;
					pNum--;
					continue;
				}
			}
//			System.out.println(pNum);
		}
		int[] a1 = new int[M + 1];
		int[] b1 = new int[M + 1];
		int[] c1 = new int[M + 1];
		int[] d1 = new int[M + 1];
		int[] e1 = new int[M + 1];
		int[] f1 = new int[M + 1];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < output[i].length(); j++) {
				if (output[i].charAt(j) == '(') {
					if (a1[i + 1] == 0)
						a1[i + 1] = a1[i] + 1;
					else
						a1[i + 1]++;
				} else if (output[i].charAt(j) == ')') {
					if (b1[i + 1] == 0)
						b1[i + 1] = b1[i] + 1;
					else
						b1[i + 1]++;
				} else if (output[i].charAt(j) == '{') {
					if (c1[i + 1] == 0)
						c1[i + 1] = c1[i] + 1;
					else
						c1[i + 1]++;
				} else if (output[i].charAt(j) == '}') {
					if (d1[i + 1] == 0)
						d1[i + 1] = d1[i] + 1;
					else
						d1[i + 1]++;
				} else if (output[i].charAt(j) == '[') {
					if (e1[i + 1] == 0)
						e1[i + 1] = e1[i] + 1;
					else
						e1[i + 1]++;
				} else if (output[i].charAt(j) == ']') {
					if (f1[i + 1] == 0)
						f1[i + 1] = f1[i] + 1;
					else
						f1[i + 1]++;
				}
				if (a1[i + 1] == 0)
					a1[i + 1] = a1[i];
				if (b1[i + 1] == 0)
					b1[i + 1] = b1[i];
				if (c1[i + 1] == 0)
					c1[i + 1] = c1[i];
				if (d1[i + 1] == 0)
					d1[i + 1] = d1[i];
				if (e1[i + 1] == 0)
					e1[i + 1] = e1[i];
				if (f1[i + 1] == 0)
					f1[i + 1] = f1[i];
			}
		}
		result[0] = 0;
		if (pNum == 0) {
			for (int i = 1; i < M; i++) {
				result[i] = -1;
			}
		} else{
			int v = 0;
			for (int i = 0; i < R.size(); i++) {
				if (possible[i]) {
					v = i;
					break;
				}
			}
			int r = R.get(v);
			int c_1 = C.get(v);
			int s = S.get(v);
			for (int i = 1; i < M; i++) {
				int x = a1[i] - b1[i];
				int y = c1[i] - d1[i];
				int z = e1[i] - f1[i];
				result[i] = r * x + c_1 * y + s * z;
			}
		}
//		System.out.println(pNum);
		if(pNum>=2) {
			int v = 0;
			for (int i = 0; i < R.size(); i++) {
				if (possible[i]) {
					v = i;
//					System.out.println(R.get(v)+" "+C.get(v)+" "+S.get(v));
					int r = R.get(v);
					int c_1 = C.get(v);
					int s = S.get(v);
					for (int j = 1; j < M; j++) {
						int x = a1[j] - b1[j];
						int y = c1[j] - d1[j];
						int z = e1[j] - f1[j];
						int result2 = r * x + c_1 * y + s * z;
//						System.out.println(result2+" "+result[j]);
						if(result2!=result[j]) {
							result[j]=-1;
						}
					}
				}
			}
		}
	}
}
