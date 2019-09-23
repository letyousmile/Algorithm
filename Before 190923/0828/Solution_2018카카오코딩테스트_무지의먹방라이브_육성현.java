import java.util.HashSet;
import java.util.Set;

class Solution {
    static int n;
    static int[] list;
    static int N;
    static boolean[] bitmask;
    static String[][] input;
    static Set<Integer> keys = new HashSet<>();
    public int solution(String[][] relation) {
        input = relation;
        list = new int[relation[0].length];
        N =list.length;
        bitmask = new boolean[(int) Math.pow(2, N)];
        for(int i=0;i<list.length;i++) {
            make_comb(0,0,i+1,0);
        }
        int answer = n;
        System.out.println(answer);
        return answer;
    }
    public static void check_key(int len,int key) {
    	for(Integer k : keys) {
    		if((k&key)==k) {
    			return;
    		}
    	}
//    	for(int j=0;j<len;j++) {
//    		System.out.print(list[j]+" ");
//    		}
//    		System.out.println();
        Set<String> set = new HashSet<>();
        for(int i=0;i<input.length;i++) {
            StringBuilder s = new StringBuilder();
                for(int j=0;j<len;j++) {
                    s = s.append(input[i][list[j]]);
                }
        if(set.contains(s.toString())) return;
        else set.add(s.toString());
        }
//        System.out.println(key);
        keys.add(key);
        n++;
    }
    public static void make_comb(int num,int loc,int obj,int now) {
        if(num==obj) {
        	check_key(obj, now);
        }else {
            for(int i=loc;i<N;i++) {
                  list[num] = i;
                  make_comb(num+1,i+1,obj,now+(1<<i));
                }
            }
        }
}