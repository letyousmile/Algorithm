
public class Solution_이진검색_육성현 {
	public static void main(String[] args) {
		int[] a = {0,1,2,3,4,5,6,7,8,9};
		int key = 8;
		int low =0;
		int high = a.length-1;
		int mid=-1;
		boolean exist = false;
		int index = binarySearch(a,key,low,high);
		if(index==-1) System.out.println("키가 존재하지 않습니다");
		else System.out.println("키가 존재하고 index는 "+ index +" 입니다");
		
		//binary search by iterative way
		while(low<=high) {
			mid = (low+high)/2;
			//System.out.println(mid+", "+a[mid]+" ,"+low+ ", "+high);
			if(a[mid]>key)
				high=mid - 1;
			else if(a[mid]<key)
				low=mid+1;
			else {
				exist = true;
				break;
			}
		}
		
		if(exist)
			System.out.println("key가 존재하고 index는 "+mid+" 입니다");
		else
			System.out.println("key가 존재하지 않습니다");
	}//end of main
	
	//binarySearch by recursive way
	public static int binarySearch(int arr[],int key,int low, int high) {
		int mid = (low+high)/2;
		if(low>high) return -1;
		if(arr[mid]==key) return mid;
		else if(arr[mid]>key) return binarySearch(arr,key,low,mid-1);
		else return binarySearch(arr,key,mid+1,high);
	}
}//end of class
