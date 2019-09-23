import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 병합정렬 : Divide and conquer O[NlogN]
 */
public class Z31_MergeSort {
	public static void main(String[] args) {
		Integer[] arr = {6,4,8,5,7,2,9,3,0,1}; // 10개, 0~9
		List<Integer> list = new ArrayList<>(Arrays.asList(arr)); //배열의 원소를 추가하기
		System.out.println(mergeSort(list));	
	}
	/** 재귀적으로 반으로 쪼갠 후 합치는 메서드 */
	public static List<Integer> mergeSort(List<Integer> list) {
		if(list.size()<=1) { //종료파트
			return list;
		}else { //재귀 파트
			int mid = list.size()/2;			
			List<Integer> left = mergeSort(list.subList(0, mid));
			List<Integer> right = mergeSort(list.subList(mid, list.size()));
			
			return merge(left, right);
		}
	}
	/** 두 리스트를 정렬하여 병합하는 메서드 */
	public static List<Integer> merge(List<Integer> left, List<Integer> right){
		List<Integer> result = new ArrayList<Integer>(left.size()+right.size()); //결과 값
		int l = 0;
		int r = 0;
		while(l <left.size() && r<right.size()) {
			if(left.get(l)< right.get(r)) {
				result.add(left.get(l++));
			}else {
				result.add(right.get(r++));
			}
		}
		//둘 중 하나라도 먼저 끝나면 나머지는 결과값에 더해준다.
		while(l <left.size()) { //왼쪽만 남아있어!
			result.add(left.get(l++));
		}
		while(r <right.size()) { //오른쪽만 남아있어!
			result.add(right.get(r++));
		}
		return result;
	}
}
